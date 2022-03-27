package ptithcm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.*;
import javax.xml.bind.DatatypeConverter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

import ptithcm.connect.Connect;
import ptithcm.connect.SQLServer_Connection;
import ptithcm.entity.*;
import ptithcm.reCapCha.RecapchaVerification;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.sql.*;
import java.util.Random;

@Transactional
@Controller
@Component("mailer")
public class welcomController {
	@Autowired
	SessionFactory factory;
	Connection conn;
	SQLServer_Connection sql;
	Connect con = new Connect();
	private String gmail;
	static String email;
	static String manhanvien;

	public String sha1(String input) {
		String sha1 = null;
		try {
			MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
			msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
			sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {

		}
		return sha1;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("Trong Controller");
		model.put("nhanvien", new NHANVIEN());
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login1(ModelMap model, @ModelAttribute(value = "nhanvien") NHANVIEN nhanvien, HttpSession session, HttpServletRequest request) throws IOException {
		String gRecaptchaRespone=request.getParameter("g-recaptcha-response");
		boolean verify=RecapchaVerification.verify(gRecaptchaRespone);
		
		String pass = "0x";
		pass += sha1(nhanvien.getMatkhau());
//		if (nhanvien.getTendn().contains("'") || nhanvien.getTendn().contains("--")
//				|| nhanvien.getTendn().contains(";")) {
//			model.addAttribute("message", "Tên tài khoản hoặc mật khẩu sai");
//			return "login";}
		if(!verify) {
			model.addAttribute("message","Vui lòng nhập Captra");
			return "login";
		}
		else {
			ResultSet rs = con
					.Query("Select *from NHANVIEN where TENDN=N'" + nhanvien.getTendn() + "' and MATKHAU=" + pass + "");
			try {
				if (rs.next()) {
					
					manhanvien = rs.getString("MANV");
					email = rs.getString("EMAIL");
					System.out.println(manhanvien);
					return "checkmail";
				} else {
					model.addAttribute("message", "Tên tài khoản hoặc mật khẩu không chính xác");
					return "login";
				}

			} catch (SQLException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "login";
		}
	}
	 

	/*
	 * @RequestMapping(value = "login", method = RequestMethod.POST) public String
	 * login1(ModelMap model, @ModelAttribute(value = "nhanvien") NHANVIEN nhanvien,
	 * HttpSession session) throws SQLException { String pass = "0x"; pass +=
	 * sha1(nhanvien.getMatkhau()); String URL =
	 * "jdbc:sqlserver://localhost:1433;Database=QLSV;user=sa;password=030420";
	 * Connection con1 = DriverManager.getConnection(URL); String sql =
	 * "Select *from NHANVIEN where TENDN=? and MATKHAU=?";
	 * 
	 * // Generate a prepared statement with the placeholder parameter.
	 * PreparedStatement stmt = con1.prepareStatement(sql);
	 * 
	 * ResultSet rs = con .Query("Select *from NHANVIEN where TENDN=N'" +
	 * nhanvien.getTendn() + "' and MATKHAU=" + pass + "");
	 * 
	 * stmt.setString(1, nhanvien.getTendn()); stmt.setString(2, pass);
	 * 
	 * // Run the query... ResultSet rs = stmt.executeQuery(sql); try { while
	 * (rs.next()) { manhanvien = rs.getString("MANV"); email =
	 * rs.getString("EMAIL"); System.out.println(manhanvien); return "checkmail"; }
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return "login";
	 * 
	 * }
	 */

	public String getGmail() {
		return email;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public static String diachi() {
		return email;
	}

	public static String macuanv() {
		return manhanvien;
	}

}
