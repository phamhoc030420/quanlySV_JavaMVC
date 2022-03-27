package ptithcm.admin;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;*/

import ptithcm.connect.Connect;
import ptithcm.controller.welcomController;
import ptithcm.entity.NHANVIEN;

@Transactional
@Controller
public class info {
	@Autowired

	SessionFactory factory;
	Connect con = new Connect();
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String indexGet(ModelMap model, @ModelAttribute("nhanvien") NHANVIEN nhanvien) {
		welcomController w=new welcomController();
		String ma=w.macuanv();
		
		String h = null,em = null,l = "",t = null;
		model.addAttribute("anhanvien", this.getNhanVien());
		ResultSet rs=con.Query("EXEC SP_SEL_NHANVIEN");
		try {
			while(true) {
			if (rs.next()) {
				t = rs.getString("MANV");
				if (t.equals(ma)) {
					h = rs.getString("HOTEN");
					em = rs.getString("EMAIL");
					l += rs.getString("LUONGCB");
					break;
				}

			}
			else {
				break;
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("maso",ma);
		model.addAttribute("hoten", h);
		model.addAttribute("email", em);
		model.addAttribute("luong", l);
		System.out.println(ma+" "+h+" "+em+" "+l);
		return "admin/index";
	}

	@RequestMapping(value = "test", method = RequestMethod.POST)
	public String indexPost(ModelMap model) {
		
		System.out.println("vo");
		return "admin/index";
	}
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(HttpSession ss) {
		
		ss.removeAttribute("user");
		return "redirect:/login.htm";
	}
	public List<NHANVIEN> getNhanVien() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NHANVIEN";
		Query query = session.createQuery(hql);
		List<NHANVIEN> list = query.list();
		return list;
	}
	
	public NHANVIEN getNhanVien(String manv) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NHANVIEN where manv = :manv";
		Query query = session.createQuery(hql);
		query.setParameter("manv", manv);
		NHANVIEN list = (NHANVIEN) query.list().get(0);

		return list;
	}
}
