package nganhangabc;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
	private long soTaiKhoan;
	private String tenTaiKhoan;
	private double soTien;
	
	public static final double LAISUAT = 0.035;

	/**
	 * @param soTaiKhoan
	 * @param tenTaiKhoan
	 * @param soTien
	 */
	public Account() {
		this.soTaiKhoan = 0;
		this.tenTaiKhoan = "";
		this.soTien = 0.0;
	}
	   public Account(long soTaiKhoan, String tenTaiKhoan) {
	        this.soTaiKhoan = soTaiKhoan;
	        this.tenTaiKhoan = tenTaiKhoan;
	        this.soTien = 50;   
	    }
	/**
	 * @param soTaiKhoan
	 * @param tenTaiKhoan
	 * @param soTien
	 */
	public Account(long soTaiKhoan, String tenTaiKhoan, double soTien) {
		if (soTaiKhoan <=0) {
			throw new IllegalArgumentException("So TaiKhoan phai > 0");
		}
		if (soTien < 0) {
			throw new IllegalArgumentException("So tien khong duoc am !"); 
		}
		this.soTaiKhoan = soTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.soTien = soTien;
	}

	/**
	 * @return the soTaiKhoan
	 */
	public long getSoTaiKhoan() {
		return soTaiKhoan;
	}

	/**
	 * @param soTaiKhoan the soTaiKhoan to set
	 */
	public void setSoTaiKhoan(long soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}

	/**
	 * @return the tenTaiKhoan
	 */
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	/**
	 * @param tenTaiKhoan the tenTaiKhoan to set
	 */
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	/**
	 * @return the soTien
	 */
	public double getSoTien() {
		return soTien;
	}

	/**
	 * @param soTien the soTien to set
	 */
	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}

	@Override
	public String toString() {
		NumberFormat dinhDang = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		return  "soTaiKhoan: " + soTaiKhoan
				+ " | tenTaiKhoan: " + tenTaiKhoan
				+ " | soTien: " + dinhDang.format(soTien);
	}
	public void napTien(double soTienNap) {
		if(soTienNap <= 0) {
			throw new IllegalArgumentException("So tien nap phai > 0");
		}
		this.soTien += soTienNap;
		System.out.println("So tien nap da thanh cong " + soTienNap);
		
	}
	public void rutTien(double soTienRut, double phiRut) {
		double tongRut = soTienRut + phiRut;
		if (soTienRut<=0) {
			throw new IllegalArgumentException("So tien rut phai > 0");
			
		}
		if(tongRut > this.soTien) {
			throw new IllegalArgumentException("Tong Rut phai nho hoac bang hon soTien");
		}
		this.soTien -= tongRut;
		System.out.println("Tien duoc rut thanh cong: " + soTienRut + "(" + "Phi: "+ phiRut + ")");
	}
	public void daoHan() {
		double tienLai =  this.soTien * LAISUAT;
		this.soTien += tienLai;
		System.out.println("Dao han thanh cong: "+ tienLai + "->" + "So du moi: "+ soTien);
		
	}

	public void chuyenKhoan(Account taiKhoanNhan, double soTienChuyen) {
		if (soTienChuyen <= 0) {
			throw new IllegalArgumentException("So tien chuyen phai > 0");
		}
		if (soTienChuyen > this.soTien) {
			throw new IllegalArgumentException("So tien chuyen khong duoc lon hon so Tien dang co");
		}
		    this.soTien -= soTienChuyen;
	        taiKhoanNhan.soTien += soTienChuyen;
	        
	        System.out.println("Chuyen " + soTienChuyen 
	            + " tu TK " + this.soTaiKhoan 
	            + " sang TK " + taiKhoanNhan.soTaiKhoan);
	   }
	
}
