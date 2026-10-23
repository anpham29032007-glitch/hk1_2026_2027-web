package qLSV;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TestSinhVien {
	public static void main (String[] args) {
		System.out.println("====DANH SACH MON HOC (ENUM)====");
		for(MonHoc mh : MonHoc.values()) {
			System.out.println("  +" + mh);
		}
		System.out.println();
		
		ListSinhVien ql = new ListSinhVien();
        // --- Sinh viên chính quy ---
        ql.them(new SinhVienChinhQui("SV01", "Nguyễn Văn An", LocalDate.of(2003, 5, 10),
                "21DTH01", 3, MonHoc.LAP_TRINH_JAVA, "Cơ sở 1"));
        ql.them(new SinhVienChinhQui("SV02", "Trần Thị Bình", LocalDate.of(2003, 8, 20),
                "21DTH01", 4, MonHoc.CO_SO_DU_LIEU, "Cơ sở 2"));
        ql.them(new SinhVienChinhQui("SV03", "Lê Hoàng Cường", LocalDate.of(2003, 5, 10),
                "21DTH02", 3, MonHoc.LAP_TRINH_JAVA, "Cơ sở 3"));

        // --- Sinh viên từ xa ---
        ql.them(new SinhVienTuXa("SV04", "Phạm Thu Duyên", LocalDate.of(2004, 1, 15),
                "21DTH02", 2, MonHoc.TOAN_ROI_RAC, "Zoom"));
        ql.them(new SinhVienTuXa("SV05", "Hoàng Văn Em", LocalDate.of(2003, 8, 20),
                "21DTH01", 3, MonHoc.LAP_TRINH_JAVA, "Microsoft Teams"));
        ql.them(new SinhVienTuXa("SV06", "Lý Minh Quân", LocalDate.of(2003, 3, 5),
                "21DTH02", 3, MonHoc.MANG_MAY_TINH, "Google Meet"));

        // --- Sinh viên thường ---
        ql.them(new SinhVien("SV07", "Đỗ Thu Hà", LocalDate.of(2004, 7, 12),
                "21DTH01", 3, MonHoc.TRI_TUE_NHAN_TAO));

        // ===== 1. IN DANH SÁCH SINH VIÊN =====
        System.out.println("===== DANH SÁCH SINH VIÊN (ĐA HÌNH) =====");
        ql.layTatCa().forEach(System.out::println);

        // ===== 2. DEMO ĐA HÌNH =====
        System.out.println("\n===== DEMO ĐA HÌNH (POLYMORPHISM) =====");
        ql.layTatCa().forEach(sv ->
            System.out.printf("%-8s | Loại: %-10s | Thành tiền: %, .0f VNĐ | %s%n",
                sv.getMaSV(), sv.getLoai(), sv.thanhTien(), sv.getThongTinRieng()));
        
        //3. GOM NHOM THEO LOP
        System.out.println("\n=====Gom nhom theo lop =====\n");
        Map<String, List<SinhVien>> theoLop = ql.nhomTheo(SinhVien::getLop);
        theoLop.forEach((lop, ds)->{
        	System.out.println("Lop " + lop + " (" + ds.size() + "SV) ");
        	ds.forEach(sv-> System.out.println("->  "+ sv.getHoTen()));
        });
        //4.GOM NHOM THEO NHIEU LOAI 
        System.out.println("\n=====GOM NHOM THEO NHIEU LOAI=====\n");
        Map<String, List<SinhVien>> theoLoai = ql.nhomTheo(SinhVien::getLoai);
        theoLoai.forEach((loai, ds)->{
        	System.out.println("Loai: "+ loai + " (" + ds.size() + " SV)");
        	ds.forEach(sv->System.out.println("-> " + sv.getHoTen()));
        });
        // ======Tong thanh tien theo lop
        System.out.println("\n=====3. TONG THANH TIEN THEO LOP======\n");
        Map<String, Double> sumLop = ql.tongTheoNhom(SinhVien::getLop, SinhVien::thanhTien);
        sumLop.forEach((lop, sum)->System.out.printf("Lop %-10s : Tong = %,.0f VND%n", lop, sum));
        
        System.out.println("\n=====4.Tong Thanh tien theo mon======\n");
        Map<MonHoc, Double> sumMon = ql.tongTheoNhom(SinhVien::getMonHoc, SinhVien::thanhTien);
        sumMon.forEach((mon, sum) -> System.out.printf("%-25s : %,.0f VND%n ", mon.getTenMon(), sum));
        
        System.out.println("\n=====5.TONG THANH TIEN THEO LOAI======\n");
        Map<String, Double> sumLoai = ql.tongTheoNhom(SinhVien::getLoai, SinhVien::thanhTien);
        sumLoai.forEach((loai, sum)->System.out.printf("Loai %-12s : %,.0f%n", loai, sum));
        
        System.out.println("\n=====DEM SO LUOT THEO MON======\n");
        Map<MonHoc, Integer> demMon = ql.demTheoNhom(SinhVien::getMonHoc);
        demMon.forEach((mon, count)-> System.out.printf("%-25s -> %d sinh vien %n", mon.getTenMon(), count));
        
        System.out.println("\n======LOC SINH VIEN CHINH QUI======\n");
        List<SinhVien> dsChinhQui = ql.tim(sv-> sv instanceof SinhVienChinhQui);
        dsChinhQui.forEach(sv->System.out.println(" " + sv));
        
        System.out.println("\n======LOC SINH VIEN TU XA======\n");
        List<SinhVien> dsTuXa = ql.tim(sv->sv instanceof SinhVienTuXa);
        dsTuXa.forEach(sv->System.out.println(" " + sv));
        
        
       System.out.println("\n=======SAP XEP THEO THANH VIEN GIAM DAN=======\n");
       ql.sapXepGiamDan(Comparator.comparingDouble(SinhVien::thanhTien));
       ql.layTatCa().forEach(sv ->System.out.println(" "+ sv));
       
       
       System.out.println("\n=======TIM MON HOC THEO TEN=======\n");
       MonHoc timThay = MonHoc.fronMonHoc("Mạng máy tính");
       if(timThay != null) {
    	   System.out.println("Da tim thay "+ timThay);
       }
       else {
    	   System.out.println("Khong tim thay mon hoc nay!!!");
    	   
       }
       System.out.println("\n=======11.HAVING: TONG THEO LOP >= 1500000======");
       Map<String, Double> havingLop = ql.tongTheoNhom_Having(
    		   SinhVien::getLop, SinhVien::thanhTien, 1500000);
       if(havingLop.isEmpty()) {
    	   System.out.println("Khong co nhom nao thoa");
       }else {
    	   havingLop.forEach((lop, sum)->System.out.printf("Lop %-10s: %,.0f VND%n", lop, sum));
       }
       System.out.println("\n======12.HAVING: MON CO >= 2 SV======");
       Map<MonHoc, Integer>havingDemMon = ql.demTheoNhom_Having(SinhVien::getMonHoc, 2);
       if(havingDemMon.isEmpty()) {
    	   System.out.println("Khong co nhom nao thoa");
    	   
       }else {
    	   havingDemMon.forEach((mon, dem)-> System.out.printf(" %-25s : %d SV%n", mon.getTenMon(), dem ));

       }
       
	}
}
