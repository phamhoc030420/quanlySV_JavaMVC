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
@Table(name="LOP")
public class LOP {
	@Id
	@Column(name = "MALOP")
	private String malop;
	@Column(name = "TENLOP")
	private String tenlop;
	@ManyToOne
	@JoinColumn(name = "MANV")
	private NHANVIEN nhanvien;
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public String getTenlop() {
		return tenlop;
	}
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	public NHANVIEN getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NHANVIEN nhanvien) {
		this.nhanvien = nhanvien;
	}
	public LOP(String malop, String tenlop, NHANVIEN nhanvien) {
		super();
		this.malop = malop;
		this.tenlop = tenlop;
		this.nhanvien = nhanvien;
	}
	public LOP() {
		super();
	}
	
}
