package ptithcm.entity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="NHANVIEN")
public class NHANVIEN {
	@Id
	@Column(name = "MANV")
	private String manv;
	@Column(name = "HOTEN")
	private String hoten;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "LUONG")
	private String luong;
	@Column(name = "TENDN")
	private String tendn;
	@Column(name = "MATKHAU")
	private String matkhau;
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLuong() {
		return luong;
	}
	public void setLuong(String luong) {
		this.luong = luong;
	}
	public String getTendn() {
		return tendn;
	}
	public void setTendn(String tendn) {
		this.tendn = tendn;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public NHANVIEN(String manv, String hoten, String email, String luong, String tendn, String matkhau) {
		super();
		this.manv = manv;
		this.hoten = hoten;
		this.email = email;
		this.luong = luong;
		this.tendn = tendn;
		this.matkhau = matkhau;
	}
	public NHANVIEN() {
		super();
	}
	
}
