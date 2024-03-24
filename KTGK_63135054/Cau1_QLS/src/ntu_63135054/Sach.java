package ntu_63135054;

public class Sach {
	private static int idDem = 0;

    private int id;
    private String ten;
    private String tacGia;
    private String namXuatBan;
    private String theLoai;

    public Sach(String ten, String tacGia, String namXuatBan, String theLoai) {
        this.id = ++idDem;
        this.ten = ten;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.theLoai = theLoai;
    }

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

	public String getTheLoai() {
		return theLoai;
	}    
    
}
