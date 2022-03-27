package ptithcm.admin;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import ptithcm.entity.*;

@Transactional
@Controller
public class lop {
	@Autowired

	SessionFactory factory;
	Connect con = new Connect();

	
	
	@RequestMapping(value = "lop", params = "btnAdd")
	public String addNhanVien(ModelMap model, @ModelAttribute("lop") LOP lop) {
		
		ResultSet rs = con.Query("insert into LOP values('"+lop.getMalop()+"',N'"+lop.getTenlop()+"','"+lop.getNhanvien().getManv()+"')");

		model.addAttribute("alop", this.getLop());
		welcomController w=new welcomController();
		String ma=w.macuanv();
		System.out.println(ma);
		
		model.addAttribute("maso",ma);
		
		List<String> listNhanVien = new ArrayList<String>();
		ResultSet rs1 = con.Query("Select MANV from NHANVIEN");
		try {
			while(true) {
			if(rs1.next()) {
				listNhanVien.add(rs1.getString("MANV"));
			}
			else {
				break;
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("list", listNhanVien);
		return "admin/message";
	}
	 
	
	String mathaydoi;
	@RequestMapping(value = "/lop/{malop}-{tenlop}-{nhanvien.id}.htm", params = "linkEdit")
	public String editVe(ModelMap model, @ModelAttribute("lop") LOP lop, @PathVariable("malop") String malop) {
		System.out.println("VO dây");
		mathaydoi=malop;
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("alop", this.getLOP(malop));
		model.addAttribute("alop", this.getLop());
		welcomController w=new welcomController();
		String ma=w.macuanv();
		System.out.println(ma);
		List<String> listNhanVien = new ArrayList<String>();
		ResultSet rs1 = con.Query("Select MANV from NHANVIEN");
		try {
			while(true) {
			if(rs1.next()) {
				listNhanVien.add(rs1.getString("MANV"));
			}
			else {
				break;
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("list", listNhanVien);
		
		model.addAttribute("maso",ma);
		return "admin/message";
	}
	
	@RequestMapping(value = "lop", params = "btnEdit")
	public String edit_Ve(ModelMap model, @ModelAttribute("lop") LOP lop) {
		
		welcomController w=new welcomController();
		String ma=w.macuanv();
		model.addAttribute("maso",ma);
		System.out.println("aaaaa");
		  ResultSet rs1=con.Query("Update LOP SET MALOP='"+lop.getMalop()+"',TENLOP='"+lop.getTenlop()+"',MANV='"+lop.getNhanvien().getManv()+"' where MALOP='"+mathaydoi+"'");
		  model.addAttribute("alop",  this.getLop());
		  return "redirect:/lop.htm";
	}
	@RequestMapping(value = "/lop/{malop}.htm", params = "linkDelete")
	public String deleteNhanVien(ModelMap model, @ModelAttribute("lop") LOP lop,
			@PathVariable("malop") String malop) {
		ResultSet rs = con.Query("delete from LOP where MALOP='" + malop + "'");
		 model.addAttribute("alop", this.getLop());
		 return "redirect:/lop.htm";

	}
	@RequestMapping(value = "lop", method = RequestMethod.GET)
	public String indexGet(ModelMap model, @ModelAttribute("lop") LOP lop) {
		welcomController w=new welcomController();
		String ma=w.macuanv();
		System.out.println(ma);
		model.addAttribute("maso",ma);
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("alop", this.getLop());
		model.addAttribute("nhanvien", this.getNhanVien());
		List<String> listNhanVien = new ArrayList<String>();
		ResultSet rs = con.Query("Select MANV from NHANVIEN");
		try {
			while(true) {
			if(rs.next()) {
				listNhanVien.add(rs.getString("MANV"));
			}
			else {
				break;
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("list", listNhanVien);
		return "admin/message";
	}

	@RequestMapping(value = "lop", method = RequestMethod.POST)
	public String indexPost(ModelMap model) {
		/*
		 * List<String> listNhanVien = new ArrayList<String>(); ResultSet rs =
		 * con.Query("Select MANV from NHANVIEN"); try { while(true) { if(rs.next()) {
		 * listNhanVien.add(rs.getString("MANV")); } else { break; } } } catch
		 * (SQLException e) { e.printStackTrace(); } model.addAttribute("list",
		 * listNhanVien);
		 */
		return "admin/message";
	}
	

	public List<NHANVIEN> getNhanVien() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NHANVIEN";
		Query query = session.createQuery(hql);
		List<NHANVIEN> list = query.list();
		return list;
	}
	
	/* return "redirect:/test1.htm"; */
	public List<LOP> getLop() {
		Session session = factory.getCurrentSession();
		String hql = "FROM LOP";
		Query query = session.createQuery(hql);
		List<LOP> list = query.list();
		return list;
	}

	public LOP getLOP(String malop) {
		Session session = factory.getCurrentSession();
		String hql = "FROM LOP where malop = :malop";
		Query query = session.createQuery(hql);
		query.setParameter("malop", malop);
		LOP list = (LOP) query.list().get(0);

		return list;
	}
	

}
