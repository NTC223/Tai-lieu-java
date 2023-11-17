public class SanPham {
    private String tenSanPham;
    private String giaBan;
    private String thuongHieu;
    private int soThongTin;
    private int id;
    private String loaiSanPham;
    private Pair<String,String>[] thongTinThem = new Pair[10];
    public static int soLuong;

    public int getId(){
            return this.id;
    }
    public void setId(int id){
            this.id = id;
        }

    public int getSoThongTin(){
            return this.soThongTin;
        }
    public void setSoThongTin(int soThongTin){
            this.soThongTin = soThongTin;
        }

    public String getTenSanPham(){
            return this.tenSanPham;
        }
    public void setTenSanPham(String tenSanPham){
            this.tenSanPham = tenSanPham;
        }

    public String getGiaBan(){
            return this.giaBan;
        }
    public void setGiaBan(String giaBan){
            this.giaBan = giaBan;
        }

    public String getThuongHieu(){
            return this.thuongHieu;
        }
    public void setThuongHieu(String thuongHieu){
            this.thuongHieu = thuongHieu;
        }

    public String getLoaiSanPham(){
        return this.loaiSanPham;
    }
    public void setLoaiSanPham(String loaiSanPham){
        this.loaiSanPham = loaiSanPham;
    }
    public Pair<String,String>[] getThongTinThem(){
            return this.thongTinThem;
        }
    public void setThongTinThem(Pair<String,String>[] thongTinThem){
            this.thongTinThem = thongTinThem;
        }
    @Override
    public String toString (){

        String thongTin = "-"+thongTinThem[1].getFirst()+": "+thongTinThem[1].getSecond();
        String ans = String.format("|%-4s|%-24s|%-11s|%-21s|%-30s|\n",id,tenSanPham,giaBan,thuongHieu,thongTin);

        for (int i=2;i<=soThongTin;i++)
        {
            thongTin = "-"+thongTinThem[i].getFirst()+": "+thongTinThem[i].getSecond();
            String s = String.format("|%-4s|%-24s|%-11s|%-21s|%-30s|\n","","","","",thongTin);
            ans=ans+s;
        }
        return ans;
    }
    public void print(){
        System.out.println("Ten san pham: " + tenSanPham);
        System.out.println("Gia ban: " + giaBan);
        System.out.println("Thuong hieu: " + thuongHieu);
        for (int i=1;i<=soThongTin;i++)
        {
            System.out.println(thongTinThem[i].getFirst() + ": " + thongTinThem[i].getSecond());
        }
        System.out.println("------");
    }
}
