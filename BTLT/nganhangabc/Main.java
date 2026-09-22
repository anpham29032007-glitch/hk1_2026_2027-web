package nganhangabc;

public class Main {
	public static void main(String []args) {
		Account tk1 = new Account(123456789L, "Nguyen Van A", 1_000_000);	
		Account tk2 = new Account(987654321L, "Tran Thi B");
		
		System.out.println("\n===BAN DAU ===\n");
		System.out.println("TK1: " + tk1);
		System.out.println("TK2: " + tk2);
		
		System.out.println("\n===Nap Tien===\n");
		tk1.napTien(5000000);
		System.out.println(tk1);
		
        System.out.println("\n=== RUT TIEN ===");
        tk1.rutTien(200_000, 5_000);   
        System.out.println(tk1);
        
//        System.out.println("\n=== RUT QUA SO DU===");
//        tk1.rutTien(10_000_000, 0); 
        
        System.out.println("\n=== ĐAO HAN ===");
        tk1.daoHan();
        System.out.println(tk1);
        
        System.out.println("\n=== CHUYEN KHOAN ===");
        tk1.chuyenKhoan(tk2, 300_000);
        System.out.println("TK1: " + tk1);
        System.out.println("TK2: " + tk2);
	} 
}
