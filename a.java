class SanPham{
    private String maSP;
    private String tenSP;
    private double donGia;
    private int soLuongTon;
    public SanPham(String maSP,String tenSP){
        this.maSP = maSP;
        this.tenSP = tenSP;
    }
    public SanPham(String maSP,String tenSP, double donGia, int soLuongTon){
        this(maSP,tenSP);
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
    }
    public String getMaSP(){
        return maSP;
    }
    public void setMaSP(String maSP){
        this.maSP = maSP;
    }
    public String getTenSP(){
        return tenSP;
    }
    public void setTenSP(String tenSP){
        this.tenSP = tenSP;
    }
    public double getDonGia(){
        return donGia;
    }
    public void setDonGia(double donGia){
        this.donGia = donGia;
    }
    public int getSoLuongTon(){
        return soLuongTon;
    }
    public void setSoLuongTon(int soLuongTon){
        this.soLuongTon = soLuongTon;
    }
    public void hienThi(){
        System.out.printf("%-6s %-20s %10.0f   tồn %d%n",maSP, tenSP, donGia, soLuongTon);
    }
}
class DonHang{
    private String tenKhach;
    private SanPham sanPham;
    private int soLuong;
    public DonHang(String tenKhach, SanPham sanPham, int soLuong){
        this.tenKhach = tenKhach;
        this.sanPham = sanPham;
        if (soLuong < 1){
            soLuong = 1;
        }
        this.soLuong = soLuong;
    }
    public double tinhThanhTien(){
        double thanhTien = sanPham.getDonGia() * soLuong;
        if (soLuong >= 5) {
            thanhTien = thanhTien * 0.9;
        }
        return thanhTien;
    }
    public void inDonHang(){
        System.out.printf("%-10s %-20s %2d %12.0f%n",tenKhach,sanPham.getTenSP(),soLuong,tinhThanhTien());
        if (soLuong >= 5){
            System.out.println("            (đã giảm 10%)");
        }
    }
}

public class a{
    public static void main(String[] args){
        SanPham banPhim = new SanPham("SP01","Ban phim co",450.000,20);
        SanPham chuotKhongDay = new SanPham("SP02","Chuot khong day");
        chuotKhongDay.setDonGia(200.000);
        chuotKhongDay.setSoLuongTon(50);
        SanPham taiNghe = new SanPham("SP03","Tai nghe",350.000,10);
        System.out.println("===== DANH SÁCH SẢN PHẨM =====");
        banPhim.hienThi();
        chuotKhongDay.hienThi();
        taiNghe.hienThi();
        DonHang don1 = new DonHang("An",banPhim,2);
        DonHang don2 = new DonHang("Binh",chuotKhongDay,5);
        DonHang don3 = new DonHang("Chi",taiNghe,1);
        System.out.println();
        System.out.println("===== DANH SÁCH ĐƠN HÀNG =====");

        System.out.printf("%-10s %-20s %2s %12s%n",
                "Khách", "Sản phẩm", "SL", "Thành tiền");
        don1.inDonHang();
        don2.inDonHang();
        don3.inDonHang();
    }
}
