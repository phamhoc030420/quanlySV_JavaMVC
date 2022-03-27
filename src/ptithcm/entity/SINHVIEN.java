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
@Table(name="SINHVIEN")
public class SINHVIEN {
	@Id
	@Column(name = "MASV")
	private String masv;
	@Column(name = "HOTEN")
	private String hoten;
	@Column(name = "NGAYSINH")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "DD/MM/YYYY")
	private Date ngaysinh;
	@Column(name = "DIACHI")
	private String diachi;
	@ManyToOne
	@JoinColumn(name = "MALOP")
	private LOP lop;
	@Column(name = "TENDN")
	private String tendn;
	@Column(name = "MATKHAU")
	private String matkhau;
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public LOP getLop() {
		return lop;
	}
	public void setLop(LOP lop) {
		this.lop = lop;
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
	public SINHVIEN(String masv, String hoten, Date ngaysinh, String diachi, LOP lop, String tendn, String matkhau) {
		super();
		this.masv = masv;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
		this.lop = lop;
		this.tendn = tendn;
		this.matkhau = matkhau;
	}
	
	public SINHVIEN() {
		super();
	}
	

}
