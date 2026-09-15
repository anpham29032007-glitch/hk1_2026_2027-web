/**
 * 
 */
package Baitaptoado;

/**
 * 
 */
public class ToaDo {

	/**
	 * @param args
	 */
	private double x;
	private double y;
	private String ten;
	
	


	/**
	 * @param x
	 * @param y
	 * @param ten
	 */
	
	public ToaDo() {
		
		this.x = 0.0;
		this.y = 0.0;
		this.ten = "";
	}


	/**
	 * @param x
	 * @param y
	 * @param ten
	 */
	public ToaDo(double x, double y, String ten) {
		this.x = x;
		this.y = y;
		this.ten = ten;
	}


	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}


	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}


	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}


	/**
	 * @return the ten
	 */
	public String getTen() {
		return ten;
	}


	/**
	 * @param ten the ten to set
	 */
	public void setTen(String ten) {
		this.ten = ten;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 	ten + "(" + x + "," + y + ")";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=============KIEM TRA CONSTRUCTOR MAC DINH ==============");
		ToaDo td1 = new ToaDo();
		td1.setTen("A");
		td1.setX(3.5);
		td1.setY(2.5);
		
		System.out.println("Toa do 1: " + td1.toString());
		System.out.println("Ten: " + td1.getTen());
		System.out.println("x = " + td1.getX());
		System.out.println("y = " + td1.getY());
		
		System.out.println("\n======KIEM TRA CONSTRUCTOR VOI DAY DU THAM SO=======\n");
		ToaDo td2 = new ToaDo(5.0, 6.5, "B");
		System.out.println("Toa do 2: " + td2.toString());
		
		System.out.println("\n=== Kiểm tra thay đổi thông tin ===");
		System.out.println("Toa do 2 truoc khi thay doi: " + td2.toString());
		td2.setTen("C");
		td2.setX(9);
		td2.setY(6);
		System.out.println("Toa do 2 sau khi thay doi: " + td2.toString());
		
		System.out.println("\n======Tao nhieu toa do khac nhau=======\n");
		ToaDo td3 = new ToaDo(-1.5, 4, "D");
		ToaDo td4 = new ToaDo(-3.9, 6.7, "E");
		ToaDo td5 = new ToaDo(-7.5, 4.8, "F");
		System.out.println("Toa do 3: " + td3.toString());
		System.out.println("Toa do 4: " + td4.toString());
		System.out.println("Toa do 5: " + td5.toString());
		
		System.out.println("\n=======Tinh khoang cach tu 2 diem========\n");
		ToaDo p1 = new ToaDo(4.7, 8.3, "J");
		ToaDo p2 = new ToaDo(7.0, 9.0, "K");
		double khoangCach = tinh_KhoangCach(p1, p2);
		System.out.println("Khoan cach tu " + p1.toString()+ "den " + p2.toString());
		System.out.println("= " + String.format("%.2f", khoangCach));
		
	}
	public static double tinh_KhoangCach(ToaDo td1, ToaDo td2) {
		double dx = td2.getX() - td1.getX();
		double dy = td2.getY() - td1.getY();
		return Math.sqrt(dx*dx + dy*dy);
	}

}
