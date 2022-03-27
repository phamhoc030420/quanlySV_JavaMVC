package ptithcm.admin;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

import ptithcm.connect.Connect;
import ptithcm.controller.welcomController;
import ptithcm.entity.NHANVIEN;

@Transactional
@Controller
public class nhanVien {
	@Autowired

	SessionFactory factory;
	Connect con = new Connect();
	
	@RequestMapping(value = "nv", method = RequestMethod.GET)
	public String indexGet(ModelMap model, @ModelAttribute("nhanvien") NHANVIEN nhanvien) {
		welcomController w=new welcomController();
		String ma=w.macuanv();
		System.out.println(ma);
		
		model.addAttribute("maso",ma);
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("anhanvien", this.getNhanVien());
		return "admin/activity";
	}

	@RequestMapping(value = "nv", method = RequestMethod.POST)
	public String indexPost(ModelMap model) {
		
		System.out.println("vo");
		return "admin/activity";
	}
	
	@RequestMapping(value = "nv", params = "btnAdd")
	public String addNhanVien(ModelMap model, @ModelAttribute("nhanvien") NHANVIEN nhanvien) {
		ResultSet rs = con.Query("EXEC SP_INS_NHANVIEN '" + nhanvien.getManv() + "','" + nhanvien.getHoten() + "','"
				+ nhanvien.getEmail() + "'," + nhanvien.getLuong() + ",'" + nhanvien.getTendn() + "','"
				+ nhanvien.getMatkhau() + "'");
		
		model.addAttribute("anhanvien", this.getNhanVien());
		welcomController w=new welcomController();
		String ma=w.macuanv();
		System.out.println(ma);
		
		model.addAttribute("maso",ma);
		return "admin/activity";
	}
	
	@RequestMapping(value = "nv", params = "btnEdit")
	public String edit_Ve(ModelMap model, @ModelAttribute("nhanvien") NHANVIEN nhanvien) {
		welcomController w=new welcomController();
		String ma=w.macuanv();
		model.addAttribute("maso",ma);
		System.out.println("cho sai "+nhanvien.getEmail());
		  ResultSet rs1=con.Query("EXEC UpdateNhanVien '"+nhanvien.getManv()+"',N'"+nhanvien.getHoten()+"','"+ nhanvien.getEmail()+"',"+nhanvien.getLuong()+",N'"+nhanvien.getTendn()+"','"+nhanvien.getMatkhau()+"' ");
		  model.addAttribute("anhanvien", this.getNhanVien());
		  return "redirect:/nv.htm";
	}

	@RequestMapping(value = "/nv/{manv}-{hoten}-{email}.htm", params = "linkEdit")
	public String editVe(ModelMap model, @ModelAttribute("nhanvien") NHANVIEN nhanvien, @PathVariable("manv") String manv,@PathVariable("hoten") String hoten,@PathVariable("email") String email) {
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("anhanvien", this.getNhanVien(manv));
		model.addAttribute("anhanvien", this.getNhanVien());
		welcomController w=new welcomController();
		String ma=w.macuanv();
		model.addAttribute("maso",ma);

		return "admin/activity";
	}
	
	/*
	 * ResultSet
	 * rs=con.Query("EXEC UpdateNhanVien '"+manv+"',N'"+nhanvien.getHoten()+"','"+
	 * nhanvien.getEmail()+"',"+nhanvien.getLuong()+",N'"+nhanvien.getTendn()+"',"+
	 * nhanvien.getMatkhau()+"");
	 */
	@RequestMapping(value = "/nv/{manv}.htm", params = "linkDelete")
	public String deleteNhanVien(ModelMap model, @ModelAttribute("nhanvien") NHANVIEN nhanvien,
			@PathVariable("manv") String manv) {
		ResultSet rs = con.Query("delete from NHANVIEN where MANV='" + manv + "'");
		 model.addAttribute("anhanvien", this.getNhanVien());
		 return "redirect:/nv.htm";

	}
	
	
	

	
	/* return "redirect:/test1.htm"; */
	public List<NHANVIEN> getNhanVien() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NHANVIEN";
		Query query = session.createQuery(hql);
		List<NHANVIEN> list = query.list();
		return list;
	}
	public Integer insertNhanVien(NHANVIEN nhanvien) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(nhanvien);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	public Integer deleteChuyen(NHANVIEN nhavien) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(nhavien);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;

	}
	public NHANVIEN getNhanVien(String manv) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NHANVIEN where manv = :manv";
		Query query = session.createQuery(hql);
		query.setParameter("manv", manv);
		NHANVIEN list = (NHANVIEN) query.list().get(0);

		return list;
	}
	public Integer updateNhanVien(NHANVIEN nhanvien) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(nhanvien);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

}
