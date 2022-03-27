package ptithcm.controller;

import java.lang.ProcessBuilder.Redirect;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ptithcm.connect.Connect;
import ptithcm.controller.welcomController;

@Controller

public class MailerController {
	Connect con = new Connect();
	@RequestMapping("login")
	public String index() {
		return "checkmail";
	}

	@Autowired
	JavaMailSender mailer;
	String ma;
	@RequestMapping("send")
	public String send(ModelMap model) {
		try {
			welcomController w = new welcomController();
			String abc = w.diachi();
			String from = "ctyhoc@gamil.com";
			System.out.println(abc);
			String to = "n18dcat026@student.ptithcm.edu.vn";
			String subject = "Mã Xác Nhận";
			int code = (int) Math.floor(((Math.random() * 899999) + 100000));
			ma = Integer.toString(code);
			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom(from, from);
			helper.setTo(abc);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(ma, true);

			mailer.send(mail);
			model.addAttribute("message", "Gửi Mail Thành Công!");

		} catch (Exception ex) {
			model.addAttribute("message", "Gửi Mail Thất Bại");

			// TODO: handle exception
		}
		return "checkmail";
	}
	int dem=1;
	@RequestMapping("maxacnhan")
	public String maxn(ModelMap model, @RequestParam("maxacnhan") String maxacnhan,HttpSession session) {
		System.out.println(ma+"------"+maxacnhan);
		if(dem==4) {
			dem=1;
			return "redirect:/login.htm";
		}
		if(maxacnhan.equals(ma)) {
			session.setAttribute("user", "admin");
			return "redirect:/test.htm";
		}
		else {
			dem++;
			model.addAttribute("message", "Sai Mã Xác Nhận!");
			return "checkmail";
		}
		
	}
	@RequestMapping("reset")
	public String lai() {
		return "resetpass";
	}
	String mailreset;
	String mareset1;
	@RequestMapping("resetpass")
	public String resetpass(ModelMap model,@RequestParam("reset") String str) {
		ResultSet rs = con.Query("Select *from NHANVIEN where EMAIL='"+str+"'");
		try {
			if(rs.next()) {
			mailreset=str;
			String from = "ctyhoc@gamil.com";
			String subject = "Reset Password";
			int code = (int) Math.floor(((Math.random() * 899999) + 100000));
			mareset1 = Integer.toString(code);
			MimeMessage mail1 = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail1);
			helper.setFrom(from, from);
			helper.setTo(str);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(mareset1, true);

			mailer.send(mail1);
			model.addAttribute("message", "Gửi Mail Thành Công!");
			return "change";
			}
			else {
				return "redirect:/login.htm";
			}
		} catch (Exception ex) {
			model.addAttribute("message", "Gửi Mail Thất Bại");

			// TODO: handle exception
		}
		return "resetpass";
	}
	@RequestMapping("changepass")
	public String doimk(ModelMap model, @RequestParam("mxn") String mxn,@RequestParam("new") String moi,@RequestParam("old") String cu) {
	
		if(!mxn.equals(mareset1)) {
			model.addAttribute("message", "Sai Mã Xác Nhận!");
			return "change";
		}
		else if(!moi.equals(cu)){
			model.addAttribute("message", "Mật Khẩu Nhập Không Trùng!");
			return "change";
		}
		else {
			Connect con=new Connect();
			ResultSet rs=con.Query("EXEC dbo.ChangePassWord '"+mailreset+"','"+moi+"'");
			 return "redirect:/login.htm";
		}
		
	}
	@RequestMapping("change")
	public String thaydoi() {
		return "change";
	}
	

}
