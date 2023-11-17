import java.util.Scanner;

public class QuanLySanPham {
    Scanner sc = new Scanner(System.in);

    public int giong(String a, String b) {
        for (int i=0;i<a.length();i++) {
            int check = 0;
            for (int j=0;j<b.length();j++){
                if (a.charAt(i)==b.charAt(j)){
                    check = 1;
                    break;
                }
            }
            if (check == 0) return check;
        }
        return 1;
    }

    public int timKiem(SanPham[] sanPhams) {

        System.out.print("Nhap tu khoa: ");

        String tuKhoa = sc.nextLine();

        int check = 0;

        for (int i=1;i<=SanPham.soLuong;i++) {
            if (giong(tuKhoa,sanPhams[i].getTenSanPham())==1){
                check = 1;
                break;
            }
            if (giong(tuKhoa,sanPhams[i].getGiaBan())==1){
                check = 1;
                break;
            }
            if (giong(tuKhoa,sanPhams[i].getThuongHieu())==1){
                check = 1;
                break;
            }
            int n = sanPhams[i].getSoThongTin();
            Pair<String, String>[] thongTin = sanPhams[i].getThongTinThem();
            for (int j=1;j<=n;j++) {
                if (giong(tuKhoa,thongTin[j].getSecond())==1){
                    check = 1;
                    break;
                }
            }
        }

        if (check == 0){
            Clrscr.clrscr();
            System.out.println("Khong tim thay ket qua trung khop");
            return 0;
        }
        Clrscr.clrscr();
        System.out.print("Hien thi theo dang bang an 1, theo danh sach an 2: ");
        String Check = sc.nextLine();
        HienThi hienThi = new HienThi();
        if (Check.equals("1")){
            hienThi.xemBang(sanPhams,tuKhoa);
        }
        else {
            hienThi.xemDanhSach(sanPhams,tuKhoa);
        }
        return 1;
    }

    public void them(SanPham[] sanPhams)
    {
        SanPham.soLuong++;
        sanPhams[SanPham.soLuong] = new SanPham();

        sanPhams[SanPham.soLuong].setId(SanPham.soLuong);

        System.out.print("Loai san pham muon them (vo ghi, but chi, but muc, sach): ");
        String loaiSanPham = sc. nextLine();
        sanPhams[SanPham.soLuong].setLoaiSanPham(loaiSanPham);

        if (loaiSanPham.equals("vo ghi")==false&&loaiSanPham.equals("but chi")==false&&loaiSanPham.equals("but muc")==false&&loaiSanPham.equals("sach")==false) {
            System.out.println("Vui long nhap dung loai san pham");
            return;
        }

        System.out.print("Ten san pham: ");
        String tenSanPham = sc.nextLine();
        sanPhams[SanPham.soLuong].setTenSanPham(tenSanPham);

        System.out.print("Gia ban: ");
        String giaBan = sc.nextLine();
        sanPhams[SanPham.soLuong].setGiaBan(giaBan);

        System.out.print("Thuong hieu: ");
        String thuongHieu = sc.nextLine();
        sanPhams[SanPham.soLuong].setThuongHieu(thuongHieu);

        if (loaiSanPham.equals("vo ghi")){
            sanPhams[SanPham.soLuong].setSoThongTin(5);

            Pair<String,String>[] thongTin=new Pair[6];
            thongTin[1] = new Pair<>();
            thongTin[2] = new Pair<>();
            thongTin[3] = new Pair<>();
            thongTin[4] = new Pair<>();
            thongTin[5] = new Pair<>();

            System.out.print("So trang: ");
            thongTin[1].setFirst("So trang");
            String soTrang = sc.nextLine();
            thongTin[1].setSecond(soTrang);

            System.out.print("Loai vo: ");
            thongTin[2].setFirst("Loai vo");
            String loaiVo = sc.nextLine();
            thongTin[2].setSecond(loaiVo);

            System.out.print("Mau Sac bia: ");
            thongTin[3].setFirst("Mau sac bia");
            String mauSacBia = sc.nextLine();
            thongTin[3].setSecond(mauSacBia);

            System.out.print("Chat lieu giay: ");
            thongTin[4].setFirst("Chat lieu giay");
            String chatLieuGiay = sc.nextLine();
            thongTin[4].setSecond(chatLieuGiay);

            System.out.print("Kich thuoc: ");
            thongTin[5].setFirst("Kich thuoc");
            String kichThuoc = sc.nextLine();
            thongTin[5].setSecond(kichThuoc);

            sanPhams[SanPham.soLuong].setThongTinThem(thongTin);
        }
        else if (loaiSanPham.equals("but chi")){
            sanPhams[SanPham.soLuong].setSoThongTin(3);

            Pair<String,String>[] thongTin=new Pair[4];

            thongTin[1] = new Pair<>();
            thongTin[2] = new Pair<>();
            thongTin[3] = new Pair<>();

            System.out.print("Mau sac: ");
            thongTin[1].setFirst("Mau sac");
            String mauSac = sc.nextLine();
            thongTin[1].setSecond(mauSac);

            System.out.print("Chat lieu: ");
            thongTin[2].setFirst("Chat lieu");
            String chatLieu = sc.nextLine();
            thongTin[2].setSecond(chatLieu);

            System.out.print("Do cung: ");
            thongTin[3].setFirst("Do cung");
            String doCung = sc.nextLine();
            thongTin[3].setSecond(doCung);

            sanPhams[SanPham.soLuong].setThongTinThem(thongTin);
        }
        else if (loaiSanPham.equals("but muc")){
            sanPhams[SanPham.soLuong].setSoThongTin(4);

            Pair<String,String>[] thongTin=new Pair[5];

            thongTin[1] = new Pair<>();
            thongTin[2] = new Pair<>();
            thongTin[3] = new Pair<>();
            thongTin[4] = new Pair<>();

            System.out.print("Mau sac: ");
            thongTin[1].setFirst("Mau sac");
            String mauSac = sc.nextLine();
            thongTin[1].setSecond(mauSac);

            System.out.print("Chat lieu: ");
            thongTin[2].setFirst("Chat lieu");
            String chatLieu = sc.nextLine();
            thongTin[2].setSecond(chatLieu);

            System.out.print("Loai muc: ");
            thongTin[3].setFirst("Loai muc");
            String loaiMuc = sc.nextLine();
            thongTin[3].setSecond(loaiMuc);

            System.out.print("Do min: ");
            thongTin[4].setFirst("Do min");
            String doMin = sc.nextLine();
            thongTin[4].setSecond(doMin);

            sanPhams[SanPham.soLuong].setThongTinThem(thongTin);
        }
        else if (loaiSanPham.equals("sach")){
            sanPhams[SanPham.soLuong].setSoThongTin(5);

            Pair<String,String>[] thongTin=new Pair[6];

            thongTin[1] = new Pair<>();
            thongTin[2] = new Pair<>();
            thongTin[3] = new Pair<>();
            thongTin[4] = new Pair<>();
            thongTin[5] = new Pair<>();

            System.out.print("The loai: ");
            thongTin[1].setFirst("The Loai");
            String theLoai = sc.nextLine();
            thongTin[1].setSecond(theLoai);

            System.out.print("Tac gia: ");
            thongTin[2].setFirst("Tac gia");
            String tacGia = sc.nextLine();
            thongTin[2].setSecond(tacGia);

            System.out.print("Nha xuat ban: ");
            thongTin[3].setFirst("Nha xuat ban");
            String nhaXuatBan = sc.nextLine();
            thongTin[3].setSecond(nhaXuatBan);

            System.out.print("Nam xuat ban: ");
            thongTin[4].setFirst("Nam xuat ban");
            String namXuatBan = sc.nextLine();
            thongTin[4].setSecond(namXuatBan);

            System.out.print("Ngon ngu: ");
            thongTin[5].setFirst("Ngon ngu");
            String ngonNgu = sc.nextLine();
            thongTin[5].setSecond(ngonNgu);

            sanPhams[SanPham.soLuong].setThongTinThem(thongTin);
        }
        Clrscr.clrscr();
        System.out.println("Them san pham thanh cong");
    }

    public void xoa(SanPham[] sanPhams)
    {
        int id = sc.nextInt();
        sc.nextLine();

        if (id==0) {

        }
        else{
            System.out.println("Ban co chac chan muon xoa (1: Yes, 2: No): ");

            int check = sc.nextInt();

            if (check == 0) {
                Clrscr.clrscr();
                System.out.println("Xoa that bai");
                return;
            }

            for (int i=id;i<SanPham.soLuong;i++){
                sanPhams[i].setId(i);
                sanPhams[i].setTenSanPham(sanPhams[i+1].getTenSanPham());
                sanPhams[i].setThuongHieu(sanPhams[i+1].getThuongHieu());
                sanPhams[i].setGiaBan(sanPhams[i+1].getGiaBan());
                sanPhams[i].setThongTinThem(sanPhams[i+1].getThongTinThem());
                sanPhams[i].setSoThongTin(sanPhams[i+1].getSoThongTin());
            }
            SanPham.soLuong--;
            Clrscr.clrscr();
            System.out.println("Xoa thanh cong");
        }
    }

    public void sua(SanPham[] sanPhams)
    {
        int id = sc.nextInt();
        sc.nextLine();
        if (id == 0){

        }
        else {
            System.out.println("Sua thanh: ");
            System.out.print("Ten san pham: ");
            String tenSanPham = sc.nextLine();
            System.out.print("Gia ban: ");
            String giaBan = sc.nextLine();
            System.out.print("Thuong hieu: ");
            String thuongHieu = sc.nextLine();

            Pair<String, String>[] thongTin = new Pair[sanPhams[id].getSoThongTin()+1];

            if (sanPhams[id].getLoaiSanPham().equals("vo ghi")){
                sanPhams[SanPham.soLuong].setSoThongTin(5);

                thongTin[1] = new Pair<>();
                thongTin[2] = new Pair<>();
                thongTin[3] = new Pair<>();
                thongTin[4] = new Pair<>();
                thongTin[5] = new Pair<>();

                System.out.print("So trang: ");
                thongTin[1].setFirst("So trang");
                String soTrang = sc.nextLine();
                thongTin[1].setSecond(soTrang);

                System.out.print("Loai vo: ");
                thongTin[2].setFirst("Loai vo");
                String loaiVo = sc.nextLine();
                thongTin[2].setSecond(loaiVo);

                System.out.print("Mau Sac bia: ");
                thongTin[3].setFirst("Mau sac bia");
                String mauSacBia = sc.nextLine();
                thongTin[3].setSecond(mauSacBia);

                System.out.print("Chat lieu giay: ");
                thongTin[4].setFirst("Chat lieu giay");
                String chatLieuGiay = sc.nextLine();
                thongTin[4].setSecond(chatLieuGiay);

                System.out.print("Kich thuoc: ");
                thongTin[5].setFirst("Kich thuoc");
                String kichThuoc = sc.nextLine();
                thongTin[5].setSecond(kichThuoc);
            }
            else if (sanPhams[id].getLoaiSanPham().equals("but chi")){
                sanPhams[SanPham.soLuong].setSoThongTin(3);

                thongTin[1] = new Pair<>();
                thongTin[2] = new Pair<>();
                thongTin[3] = new Pair<>();

                System.out.print("Mau sac: ");
                thongTin[1].setFirst("Mau sac");
                String mauSac = sc.nextLine();
                thongTin[1].setSecond(mauSac);

                System.out.print("Chat lieu: ");
                thongTin[2].setFirst("Chat lieu");
                String chatLieu = sc.nextLine();
                thongTin[2].setSecond(chatLieu);

                System.out.print("Do cung: ");
                thongTin[3].setFirst("Do cung");
                String doCung = sc.nextLine();
                thongTin[3].setSecond(doCung);
            }
            else if (sanPhams[id].getLoaiSanPham().equals("but muc")){
                sanPhams[SanPham.soLuong].setSoThongTin(4);

                thongTin[1] = new Pair<>();
                thongTin[2] = new Pair<>();
                thongTin[3] = new Pair<>();
                thongTin[4] = new Pair<>();

                System.out.print("Mau sac: ");
                thongTin[1].setFirst("Mau sac");
                String mauSac = sc.nextLine();
                thongTin[1].setSecond(mauSac);

                System.out.print("Chat lieu: ");
                thongTin[2].setFirst("Chat lieu");
                String chatLieu = sc.nextLine();
                thongTin[2].setSecond(chatLieu);

                System.out.print("Loai muc: ");
                thongTin[3].setFirst("Loai muc");
                String loaiMuc = sc.nextLine();
                thongTin[3].setSecond(loaiMuc);

                System.out.print("Do min: ");
                thongTin[4].setFirst("Do min");
                String doMin = sc.nextLine();
                thongTin[4].setSecond(doMin);
            }
            else if (sanPhams[id].getLoaiSanPham().equals("sach")){
                sanPhams[SanPham.soLuong].setSoThongTin(5);

                thongTin[1] = new Pair<>();
                thongTin[2] = new Pair<>();
                thongTin[3] = new Pair<>();
                thongTin[4] = new Pair<>();
                thongTin[5] = new Pair<>();

                System.out.print("The loai: ");
                thongTin[1].setFirst("The Loai");
                String theLoai = sc.nextLine();
                thongTin[1].setSecond(theLoai);

                System.out.print("Tac gia: ");
                thongTin[2].setFirst("Tac gia");
                String tacGia = sc.nextLine();
                thongTin[2].setSecond(tacGia);

                System.out.print("Nha xuat ban: ");
                thongTin[3].setFirst("Nha xuat ban");
                String nhaXuatBan = sc.nextLine();
                thongTin[3].setSecond(nhaXuatBan);

                System.out.print("Nam xuat ban: ");
                thongTin[4].setFirst("Nam xuat ban");
                String namXuatBan = sc.nextLine();
                thongTin[4].setSecond(namXuatBan);

                System.out.print("Ngon ngu: ");
                thongTin[5].setFirst("Ngon ngu");
                String ngonNgu = sc.nextLine();
                thongTin[5].setSecond(ngonNgu);

            }

            System.out.println("Ban co chac chan muon sua (1: Yes, 2: No): ");

            String check = sc.nextLine();

            if (check.equals("0")) {
                Clrscr.clrscr();
                System.out.println("Sua that bai");
                return;
            }
            sanPhams[id].setTenSanPham(tenSanPham);
            sanPhams[id].setThuongHieu(thuongHieu);
            sanPhams[id].setGiaBan(giaBan);
            sanPhams[id].setThongTinThem(thongTin);

            Clrscr.clrscr();
            System.out.println("sua thanh cong");
        }
    }
}
