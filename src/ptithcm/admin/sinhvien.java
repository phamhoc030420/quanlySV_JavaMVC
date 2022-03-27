package ptithcm.admin;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

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
public class sinhvien {
	@Autowired

	SessionFactory factory;
	Connect con = new Connect();

	public String md5(String password) {
		MessageDigest md;
		String myHash = "0x";
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			myHash += DatatypeConverter.printHexBinary(digest).toUpperCase();
			return myHash;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myHash;
	}

	@RequestMapping(value = "sinhvien", method = RequestMethod.GET)
	public String indexGet(ModelMap model, @ModelAttribute("sinhvien") SINHVIEN sinhvien) {
		welcomController w = new welcomController();
		String ma = w.macuanv();
		model.addAttribute("maso", ma);
		model.addAttribute("btnStatus", "btnAdd");
		// model.addAttribute("alop", this.getLop());
		model.addAttribute("asinhvien", this.getSinhVien());
		int dem = 0;
		List<String> listLop = new ArrayList<String>();
		ResultSet rs1 = con.Query("Select MALOP from LOP WHERE MANV='" + ma + "'");
		try {
			while (true) {
				if (rs1.next()) {
					dem++;
					listLop.add(rs1.getString("MALOP"));
				} else {
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("list1", listLop);
		int n = 0;
		while (n < dem) {
			System.out.println(listLop.get(n));
			n++;
		}

		return "admin/task";
	}

	@RequestMapping(value = "sinhvien", method = RequestMethod.POST)
	public String indexPost(ModelMap model) {
		System.out.println("vo ham post");
		return "admin/task";
	}

	/* ,@RequestParam("ngay") @DateTimeFormat(pattern = "YYYY-MM-DD") Date date */
	
	

	/*
	 * @RequestMapping(value = "sinhvien.htm", params = "btnAdd") public String
	 * addSinhVien(ModelMap model, @ModelAttribute("sinhvien") SINHVIEN sinhvien,
	 * 
	 * @RequestParam("ngay") String abc) {
	 * 
	 * String mat = md5(sinhvien.getMatkhau());
	 * 
	 * System.out.println(abc); ResultSet rs =
	 * con.Query("insert into SINHVIEN values(N'" + sinhvien.getMasv() + "',N'" +
	 * sinhvien.getHoten() + "','" + abc + "',N'" + sinhvien.getDiachi() + "','" +
	 * sinhvien.getLop().getMalop() + "',N'" + sinhvien.getTendn() + "'," + mat +
	 * ")");
	 * 
	 * model.addAttribute("asinhvien", this.getSinhVien()); welcomController w = new
	 * welcomController(); String ma = w.macuanv(); System.out.println("sinh vien "
	 * + ma);
	 * 
	 * model.addAttribute("maso", ma);
	 * 
	 * List<String> listLop = new ArrayList<String>(); ResultSet rs1 =
	 * con.Query("Select MALOP from LOP WHERE MANV='" + ma + "'"); try { while
	 * (true) { if (rs1.next()) { listLop.add(rs1.getString("MALOP")); } else {
	 * break; } } } catch (SQLException e) { e.printStackTrace(); }
	 * model.addAttribute("list1", listLop);
	 * 
	 * System.out.println("vo ham add"); return "admin/task"; }
	 */
	 
	
	@RequestMapping(value = "sinhvien.htm", params = "btnAdd")
	public String addSinhVien(ModelMap model, @ModelAttribute("sinhvien") SINHVIEN sinhvien,

			@RequestParam("ngay") String abc) {

		String mat = md5(sinhvien.getMatkhau());

		System.out.println(abc);
		ResultSet rs = con.Query("insert into SINHVIEN values(N'" + sinhvien.getMasv() + "',N'" + sinhvien.getHoten()
				+ "','" + abc + "',N'" + sinhvien.getDiachi() + "','" + sinhvien.getLop().getMalop() + "',N'"
				+ sinhvien.getTendn() + "'," + mat + ")");

		model.addAttribute("asinhvien", this.getSinhVien());
		welcomController w = new welcomController();
		String ma = w.macuanv();
		System.out.println("sinh vien " + ma);

		model.addAttribute("maso", ma);

		List<String> listLop = new ArrayList<String>();
		ResultSet rs1 = con.Query("Select MALOP from LOP WHERE MANV='" + ma + "'");
		try {
			while (true) {
				if (rs1.next()) {
					listLop.add(rs1.getString("MALOP"));
				} else {
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("list1", listLop);

		System.out.println("vo ham add");
		return "admin/task";
	}
	
	
	String mathaydoi;

	@RequestMapping(value = "/sinhvien/{masv}-{hoten}-{diachi}-{lop.malop}.htm", params = "linkEdit")
	public String editSinhVien(ModelMap model, @ModelAttribute("sinhvien") SINHVIEN sinhvien,
			@PathVariable("masv") String masv) {
		mathaydoi=masv;
		System.out.println("VO dây"+masv);
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("asinhvien", this.getSINHVIEN(masv));
		model.addAttribute("asinhvien", this.getSinhVien());
		welcomController w = new welcomController();
		String ma = w.macuanv();
		List<String> listLop = new ArrayList<String>();
		ResultSet rs1 = con.Query("Select MALOP from LOP WHERE MANV='" + ma + "'");
		try {
			while (true) {
				if (rs1.next()) {
					listLop.add(rs1.getString("MALOP"));
				} else {
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("list1", listLop);
		return "admin/task";
	}

	@RequestMapping(value = "sinhvien", params = "btnEdit")
	public String edit_SinhVien(ModelMap model, @ModelAttribute("sinhvien") SINHVIEN sinhvien,
			@RequestParam("ngaymoi") String le) {

		String matk = md5(sinhvien.getMatkhau());
		System.out.println(le);
		System.out.println(matk);
		System.out.println(sinhvien.getLop().getMalop());
		
		ResultSet rs1 = con.Query("Update SINHVIEN SET MASV=N'" +sinhvien.getMasv()+ "',HOTEN=N'"+sinhvien.getHoten()+"',NGAYSINH='"+le+"',DIACHI=N'"+sinhvien.getDiachi()+"',MALOP='"+sinhvien.getLop().getMalop()+"',TENDN=N'"+sinhvien.getTendn()+"',MATKHAU="+matk+" where MASV=N'"+mathaydoi+"'");
		 
		 
		model.addAttribute("asinhvien", this.getSinhVien());
		return "redirect:/sinhvien.htm";
	}

	@RequestMapping(value = "/sinhvien/{masv}.htm", params = "linkDelete")
	public String deleteNhanVien(ModelMap model, @ModelAttribute("sinhvien") SINHVIEN sinhvien,

			@PathVariable("masv") String masv) {
		ResultSet rs = con.Query("delete from SINHVIEN where MASV='" + masv + "'");
		model.addAttribute("asinhvien", this.getSinhVien());
		return "redirect:/sinhvien.htm";

	}

	public List<SINHVIEN> getSinhVien1() {
		Session session = factory.getCurrentSession();
		String hql = "FROM SINHVIEN";
		Query query = session.createQuery(hql);
		List<SINHVIEN> list = query.list();
		return list;
	}

	public List<SINHVIEN> getSinhVien() {

		int dem = 0;
		welcomController w = new welcomController();
		String ma = w.macuanv();
		List<String> listLop = new ArrayList<String>();
		ResultSet rs1 = con.Query("Select MALOP from LOP WHERE MANV='" + ma + "'");
		try {
			while (true) {
				if (rs1.next()) {
					dem++;
					listLop.add(rs1.getString("MALOP"));
				} else {
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int n = 0;
		List<SINHVIEN> list = new ArrayList<SINHVIEN>();
		while (n < dem) {

			ResultSet aa = con.Query("Select * from SINHVIEN WHERE MALOP='" + listLop.get(n) + "'");

			try {
				while (true) {
					if (aa.next()) {
						SINHVIEN sinh = new SINHVIEN();
						LOP lop=new LOP();
						sinh.setMasv(aa.getString("MASV"));
						sinh.setHoten(aa.getString("HOTEN"));
						sinh.setNgaysinh(aa.getDate("NGAYSINH"));
						sinh.setDiachi(aa.getString("DIACHI"));
						lop.setMalop(aa.getString("MALOP"));
						sinh.setLop(lop);
						sinh.setTendn(aa.getString("TENDN"));
						sinh.setMatkhau(aa.getString("MATKHAU"));
						list.add(sinh);

					} else {
						break;
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			n++;
		}

		return list;
	}

	public List<LOP> getLop() {
		Session session = factory.getCurrentSession();
		String hql = "FROM LOP";
		Query query = session.createQuery(hql);
		List<LOP> list = query.list();
		return list;
	}

	public SINHVIEN getSINHVIEN(String masv) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SINHVIEN where masv = :masv";
		Query query = session.createQuery(hql);
		query.setParameter("masv", masv);
		SINHVIEN list = (SINHVIEN) query.list().get(0);

		return list;
	}

}
