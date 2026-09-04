/**
 * 
 */
package Tuan3;

import java.awt.geom.GeneralPath;
import java.time.LocalDate;
import java.util.UUID;

import javax.annotation.processing.Generated;

/**
 * 
 */
public class HangThucPham {


		private String maHang;
	    private String tenHang;
	    private double donGia;
	    private LocalDate ngaySanXuat;
	    private LocalDate ngayHetHan;
	    

	    private static final String TEN_HANG_DEFAULT = "xxx";
	    private static final LocalDate NGAY_SAN_XUAT_DEFAULT = LocalDate.now();

	/**
		 * @param maHang
		 * @param tenHang
		 * @param donGia
		 * @param ngaySanXuat
		 * @param ngayHetHan
		 */
		public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
			setMaHang(maHang);
			setTenHang(tenHang);
			setDonGia(donGia);
			setNgaySanXuat(ngaySanXuat);
			setNgayHetHan(ngayHetHan);
		}
	    

	/**
	 * @param maHang
	 * @param tenHang
	 * @param donGia
	 * @param ngaySanXuat
	 * @param ngayHetHan
	 */
	public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
		this.maHang = generatemaHang();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHan = ngayHetHan;
	}


	private String generatemaHang() {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		return uuid.toString().substring(0, 8).toUpperCase();
	}


	/**
	 * @return the maHang
	 */
	public String getMaHang() {
		return maHang;
	}

	/**
	 * @param maHang the maHang to set
	 */
	public void setMaHang(String maHang) {
		
		if (maHang != null && !maHang.trim().isEmpty() ) {
			this.maHang = maHang;
		} else {

			
		}
		
	}

	/**
	 * @return the tenHang
	 */
	public String getTenHang() {
		return tenHang;
	}

	/**
	 * @param tenHang the tenHang to set
	 */
	public void setTenHang(String tenHang) {
		if (tenHang != null && !tenHang.trim().isEmpty()) {
			this.tenHang = tenHang;
		} else {
			this.tenHang = TEN_HANG_DEFAULT;
		}
		
	}

	/**
	 * @return the donGia
	 */
	public double getDonGia() {
		return donGia;
	}

	/**
	 * @param donGia the donGia to set
	 */
	public void setDonGia(double donGia) {
		if (donGia>0) {
			this.donGia = donGia;
		} else {
			donGia = 1.0;
		}
		
	}

	/**
	 * @return the ngaySanXuat
	 */
	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	/**
	 * @param ngaySanXuat the ngaySanXuat to set
	 */
	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	/**
	 * @return the ngayHetHan
	 */
	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	/**
	 * @param ngayHetHan the ngayHetHan to set
	 */
	public void setNgayHetHan(LocalDate ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
