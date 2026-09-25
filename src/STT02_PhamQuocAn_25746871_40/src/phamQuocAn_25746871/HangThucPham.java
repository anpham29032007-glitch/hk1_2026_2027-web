package phamQuocAn_25746871;

import java.time.LocalDate;

public class HangThucPham implements Comparable<HangThucPham> { // Sửa 3: Thêm implements
    private int id;
    private final String maHang;
    private String tenHang;
    private LocalDate ngaySX;
    private LocalDate ngayHH;
    private float gia;
    private static int demSoLuong = 0;

    public HangThucPham() {
        this.id = ++demSoLuong;
        this.maHang = "MAC_DINH";
        this.tenHang = "Hang_mac_dinh";
        this.ngaySX = LocalDate.now();
        this.ngayHH = LocalDate.now().plusDays(7); // Sửa 5: Cộng thêm 7 ngày
        this.gia = 1.0f;
    }

    public HangThucPham(String maHang, String tenHang, LocalDate ngaySX,
                        LocalDate ngayHH, float gia) {
        this.id = ++demSoLuong;
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma hang khong duoc de trong");
        }
        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Ten hang khong duoc de trong");
        }
        if (gia <= 0) {
            throw new IllegalArgumentException("Gia phai lon hon 0");
        }
        if (!kiemTraNgaySanXuat(ngaySX)) { // Sửa 1: Hàm kiểm tra đã đúng logic
            throw new IllegalArgumentException("Ngay san xuat khong duoc la tuong lai");
        }
        if (!kiemTraNgayHetHan(ngaySX, ngayHH)) {
            throw new IllegalArgumentException("Ngay het han phai sau ngay San xuat");
        }
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.ngaySX = ngaySX;
        this.ngayHH = ngayHH;
        this.gia = gia;
    }

    // Sửa 1: Đổi logic trả về true nếu hợp lệ (không phải tương lai)
    private boolean kiemTraNgaySanXuat(LocalDate ngaySX) {
        return ngaySX != null && !ngaySX.isAfter(LocalDate.now());
    }

    private boolean kiemTraNgayHetHan(LocalDate ngaySX, LocalDate ngayHH) {
        return ngaySX != null && ngayHH != null && ngayHH.isAfter(ngaySX);
    }

    public int getId() { return id; }
    public String getMaHang() { return maHang; }
    public String getTenHang() { return tenHang; }
    public LocalDate getNgaySanXuat() { return ngaySX; }
    public LocalDate getNgayHetHan() { return ngayHH; }
    public float getGia() { return gia; }

    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên hàng không được rỗng!");
        }
        this.tenHang = tenHang;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        if (!kiemTraNgaySanXuat(ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày SX không được tương lai!");
        }
        if (this.ngayHH != null && !kiemTraNgayHetHan(ngaySanXuat, this.ngayHH)) {
            throw new IllegalArgumentException("Ngày SX phải trước ngày HH!");
        }
        this.ngaySX = ngaySanXuat;
    }

    // Sửa 2: Sửa lỗi logic và gán biến
    public void setNgayHetHan(LocalDate ngayHetHan) {
        if (this.ngaySX == null) {
            throw new IllegalArgumentException("Chưa có ngày SX!");
        }
        if (!kiemTraNgayHetHan(this.ngaySX, ngayHetHan)) {
            throw new IllegalArgumentException("Ngày HH phải sau ngày SX!");
        }
        this.ngayHH = ngayHetHan;
    }

    public void setGia(float gia) {
        if (gia <= 0) {
            throw new IllegalArgumentException("Giá phải lớn hơn 0!");
        }
        this.gia = gia;
    }

    public boolean kiemTraHetHan() {
        return LocalDate.now().isAfter(this.ngayHH);
    }

    // Sửa 4: Thêm khoảng trắng
    public String trangThaiChiTiet() {
        LocalDate homNay = LocalDate.now();
        if (homNay.isBefore(ngaySX)) return "Chua san xuat";
        if (homNay.isAfter(ngayHH)) return "Het Han";
        if (homNay.isEqual(ngayHH)) return "Het han hom nay";
        long con = ngayHH.toEpochDay() - homNay.toEpochDay();
        return "Con " + con + " Ngay";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Khong the sao chep bai hang thuc pham!!");
    }

    @Override // Sửa 3: Thêm @Override cho chuẩn
    public int compareTo(HangThucPham o) {
        return Integer.compare(this.id, o.id);
    }

    @Override // Thêm @Override cho toString
    public String toString() {
        return String.format("| %-4d | %-10s | %-18s | %-12s | %-12s | %-10.0f",
                id, maHang, tenHang, ngaySX, ngayHH, gia);
    }
}