/**
 * 
 */
package tuan2.SinhVien;
import java.util.Scanner;

/**
 * 
 */
public class SinhVien {

	/**
	 * @param args
	 */
	private int  maSv;
	private String  hoTen;
	private double diemLT;
	private double diemTH;
	/**
	 * @return the maSv
	 */
	public int getMaSv() {
		return maSv;
	}


	/**
	 * @param maSv the maSv to set
	 * @throws Exception 
	 */
	public void setMaSv(int ma) throws Exception {
		if (ma > 0) {
			this.maSv = ma;
		} else {
			throw new Exception("LOI: ma > 0");
		}
		
	}


	/**
	 * @return the hoTen
	 */
	public String getHoTen() {
		return hoTen;
	}


	/**
	 * @param hoTen the hoTen to set
	 */
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	/**
	 * @return the diemLT
	 */
	public double getDiemLT() {
		return diemLT;
	}


	/**
	 * @param diemLT the diemLT to set
	 */
	public void setDiemLT(double diemLT) {
		this.diemLT = diemLT;
	}


	/**
	 * @return the diemTH
	 */
	public double getDiemTH() {
		return diemTH;
	}


	/**
	 * @param diemTH the diemTH to set
	 */
	public void setDiemTH(double diemTH) {
		this.diemTH = diemTH;
	}
	
	
	/**
	 * @param maSv
	 * @param hoTen
	 * @param diemLT
	 * @param diemTH
	 */
	public SinhVien() {
		this.maSv = 1;
		this.hoTen = "Chua co ten";
		this.diemLT = 0.0f;
		this.diemTH = 0.0f;
	}
	public SinhVien(int ma, String hoTen, double diemLT, double diemTH) throws Exception {
		if (ma > 0) {
			this.maSv = ma;
		} else {
			throw new Exception("LOI: ma");
		}
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}
	public double getDiemTB() {
		return (getDiemLT()+getDiemTH())/2;
	}
	public static final void tieuDe() {
		for(int i=0;i<60;i++) {
			System.out.print("-");
		}
		System.out.println();
		String s="";
		s=s+s.format("|%10s|%-10s|%-10s|%-10s|%-10s|", "Ma sinh vien", "Ho ten", "Diem LT", "Diem TH", "Diem TB");
		System.out.println(s);
		for(int i=0;i<60;i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s="";
		s=s+s.format("|%10s|%-10s|%10s|%10s|%10s|", getMaSv(), getHoTen(), getDiemLT(), getDiemTH(), getDiemTB());
		return s;
	}
	
	public static SinhVien nhap() throws Exception {
		Scanner sc = new Scanner(System.in);
		int maSv;
		String hoTen;
		float diemLT;
		float diemTH;
		System.out.println("Nhap ma Sinh Vien: ");
		maSv = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap ho ten: ");
		hoTen = sc.nextLine();
		System.out.println("Nhap diem LT: ");
		diemLT = sc.nextFloat();
		System.out.println("Nhap diem TH: ");
		diemTH = sc.nextFloat();
		
		SinhVien s = new SinhVien(maSv,hoTen,diemLT, diemTH);
		return s;
	}
	public static void xuat(SinhVien s) {
		System.out.println(s.toString());
	}
	public static void main(String []args) throws Exception {
		tieuDe();
		SinhVien s1 = new SinhVien(2,"Ninh kieu Quynh Nhu", 7, 9);
		System.out.println(s1.toString());
		System.out.println("Nhap tu ban phim: ");
		try {
			nhap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tieuDe();
		xuat(nhap());
	}


	
}


