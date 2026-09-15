
package Tuan3;


import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


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
	public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan)
			throws Exception {
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
	public HangThucPham(String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
		this.maHang = generatemaHang();
	    setTenHang(tenHang);          
	    setDonGia(donGia);           
	    setNgaySanXuat(ngaySanXuat);  
	    setNgayHetHan(ngayHetHan);
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
	public void setMaHang(String maHang) throws Exception {

		if (maHang != null && !maHang.trim().isEmpty()) {
			this.maHang = maHang;
		} else {
			throw new Exception("Loi khong co ma don hang !!");

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
		if (donGia > 0) {
			this.donGia = donGia;
		} else {
			this.donGia = 1.0;
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
		if (ngaySanXuat != null && ngaySanXuat.isBefore(LocalDate.now())) {
			this.ngaySanXuat = ngaySanXuat;
		} else {
			this.ngaySanXuat = NGAY_SAN_XUAT_DEFAULT;
		}
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
		if (ngayHetHan != null && ngayHetHan.isAfter(ngaySanXuat)) {
			this.ngayHetHan = ngayHetHan;
		} else {
			this.ngayHetHan = this.ngaySanXuat;
		}
	}
	public boolean kiemTraHetHan() {
		if(ngayHetHan == null) {
			return false;
		}
		return LocalDate.now().isAfter(ngayHetHan) || LocalDate.now().isEqual(getNgayHetHan());
	}


	


	@Override
	public String toString() {
		DecimalFormat dfDonGia = new DecimalFormat("###,###.00");
		DateTimeFormatter dfNgay =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String trangThai = kiemTraHetHan() ? "Hang het han" : "Hang con han";
		return String.format("| %-10s | %-10s | %15s |  %12s | %11s | %-15s |", maHang, tenHang, dfDonGia.format(donGia), dfNgay.format(ngaySanXuat), dfNgay.format(ngayHetHan), trangThai);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        try {
		            // Tạo 3 đối tượng với UUID tự động
		            HangThucPham hang1 = new HangThucPham("Gạo", 100000.0, 
		                    LocalDate.of(2018, 7, 10), LocalDate.of(2018, 3, 1));
		            
		            HangThucPham hang2 = new HangThucPham("Đường", 25000.0, 
		                    LocalDate.of(2024, 1, 15), LocalDate.of(2025, 1, 15));
		            
		            HangThucPham hang3 = new HangThucPham("Sữa", 45000.0, 
		                    LocalDate.of(2024, 8, 1), LocalDate.of(2024, 9, 1));
		            
		            // Hoặc tạo với mã hàng cụ thể
		            // HangThucPham hang4 = new HangThucPham("001", "Gạo", 100000.0, 
		            //         LocalDate.of(2018, 7, 10), LocalDate.of(2018, 3, 1));
		            
		            // Xuất bảng thông tin
		            System.out.println("====================================================================================================");
		            System.out.printf("| %-10s | %-10s | %-15s | %-12s | %-12s | %-15s |\n", 
		                    "Mã", "Hàng", "Đơn Giá", "Ngày SX", "Ngày HH", "Ghi Chú");
		            System.out.println("----------------------------------------------------------------------------------------------------");
		            System.out.println(hang1);
		            System.out.println(hang2);
		            System.out.println(hang3);
		            System.out.println("====================================================================================================");
		            
		            // Kiểm thử các ràng buộc
		            System.out.println("\n=== KIỂM THỬ CÁC RÀNG BUỘC ===");
		            
		            // 1. Kiểm tra mã hàng rỗng
		            try {
		                HangThucPham hang4 = new HangThucPham("", "Test", 1000.0, 
		                        LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
		                System.out.println("Test mã rỗng: Không ném ngoại lệ (Sai!)");
		            } catch (Exception e) {
		                System.out.println("Test mã rỗng: " + e.getMessage() + " (Đúng!)");
		            }
		            
		            // 2. Kiểm tra tên hàng rỗng -> sẽ gán mặc định
		            HangThucPham hang5 = new HangThucPham("004", "", 1000.0, 
		                    LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
		            System.out.println("Test tên rỗng: Tên được gán mặc định = '" + hang5.getTenHang() + "'");
		            
		            // 3. Kiểm tra đơn giá <= 0 -> sẽ gán mặc định 1.0
		            HangThucPham hang6 = new HangThucPham("005", "Test", -1000.0, 
		                    LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
		            System.out.println("Test đơn giá <= 0: Đơn giá được gán mặc định = " + hang6.getDonGia());
		            
		            // 4. Kiểm tra ngày sản xuất sau ngày hiện tại -> gán mặc định là ngày hiện tại
		            HangThucPham hang7 = new HangThucPham("006", "Test", 1000.0, 
		                    LocalDate.now().plusDays(1), LocalDate.now().plusDays(5));
		            System.out.println("Test ngày SX sau ngày hiện tại: Ngày SX = " + hang7.getNgaySanXuat());
		            
		            // 5. Kiểm tra ngày hết hạn trước ngày sản xuất -> gán bằng ngày sản xuất
		            HangThucPham hang8 = new HangThucPham("007", "Test", 1000.0, 
		                    LocalDate.now().minusDays(1), LocalDate.now().minusDays(10));
		            System.out.println("Test ngày HH trước ngày SX: Ngày HH = " + hang8.getNgayHetHan());
		            
		            System.out.println("\n=== KẾT THÚC KIỂM THỬ ===");
		            
		        } catch (Exception e) {
		            System.out.println("Lỗi: " + e.getMessage());
		        }

	}

}

