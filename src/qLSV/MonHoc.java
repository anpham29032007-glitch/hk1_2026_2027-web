package qLSV;

public enum MonHoc {
	LAP_TRINH_JAVA("Lap Trinh Java", 450_000),
	CO_SO_DU_LIEU("Co So Du Lieu", 450_000),
	TOAN_ROI_RAC("Toan Roi Rac", 400_000),
	MANG_MAY_TINH("Mang May Tinh", 500_000),
	TRI_TUE_NHAN_TAO("Tri Tue Nhan Tao", 600_000),
	KI_THUAT_PHAN_MEM("Ki Thuat Phan Mem", 480_000),
	LAP_TRINH_WEB("Lap Trinh Web", 500_000),
	HE_DIEU_HANH("He Dieu Hanh", 420_000);
	
	private final String tenMon;
	private final float donGia;
	
	MonHoc(String tenMon, float donGia){
		this.tenMon = tenMon;
		this.donGia = donGia;
	}

	public String getTenMon() {
		return tenMon;
	}

	public float getDonGia() {
		return donGia;
	}
	public static MonHoc fronMonHoc(String tenMon) {
		for(MonHoc mh : values()) {
			if(mh.tenMon.equalsIgnoreCase(tenMon)) {
				return mh;
			}
		}
		return null;
	}
	@Override
	public String toString() {
		return String.format("%s (%.0f VND/tin chi)", tenMon, donGia);
	}
}
