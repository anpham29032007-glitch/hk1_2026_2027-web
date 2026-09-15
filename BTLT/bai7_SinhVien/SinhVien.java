package bai7_SinhVien;

public class SinhVien {
	private int maSV;
	private String hoTen;
	private String diaChi;
	private String sdt;
	
	
	/**
	 * @param maSV
	 * @param hoTen
	 * @param diaChi
	 * @param sdt
	 */
	public SinhVien() {

	}
	
	/**
	 * @param maSV
	 * @param hoTen
	 * @param diaChi
	 * @param sdt
	 */
	public SinhVien(int maSV, String hoTen, String diaChi, String sdt) {

		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	/**
	 * @return the maSV
	 */
	public int getMaSV() {
		return maSV;
	}
	/**
	 * @param maSV the maSV to set
	 */
	public void setMaSV(int maSV) {
		this.maSV = maSV;
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
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}
	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	/**
	 * @return the sdt
	 */
	public String getSdt() {
		return sdt;
	}
	/**
	 * @param sdt the sdt to set
	 */
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	@Override
	public String toString() {
		return "Ma SV:" + maSV + "| Ho Ten: " + hoTen + "| Dia Chi: " + diaChi + "| sdt: " + sdt;
	}
	
	
	
}
