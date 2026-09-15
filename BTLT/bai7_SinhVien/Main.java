package bai7_SinhVien;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so luong sinh vien N: ");
		int n = scanner.nextInt();
		scanner.nextLine();
		
		SinhVien[] danhSachSV = new SinhVien[n];
		for(int i=0;i<n;i++) {
			System.out.println("\n----Nhap so luong sinh vien thu " +(i+1)+"----");
			System.out.print("Ma sinh vien: ");
			int ma = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Nhap ho ten: ");
			String ten = scanner.nextLine();
			
			System.out.println("Nhap dia chi: ");
			String diaChi = scanner.nextLine();
			
			System.out.println("Nhap so dien thoai ");
			String sdt = scanner.nextLine();
			
			
			danhSachSV[i] = new SinhVien(ma, ten, diaChi, sdt);
			
			
		}
		Arrays.sort(danhSachSV, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien sv1, SinhVien sv2) {
				return Integer.compare(sv1.getMaSV(), sv2.getMaSV());
			}
		} ); 
	    System.out.println("\n================ DANH SACH SINH VIEN (TANG DAN THEO MA SV) ================");
        for (SinhVien sv : danhSachSV) {
            System.out.println(sv.toString());
        }
        scanner.close();
	}
}
