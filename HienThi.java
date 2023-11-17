public class HienThi {
    QuanLySanPham quanLySanPham = new QuanLySanPham();
    public void xemBang(SanPham[] sanPhams, String tuKhoa){
        System.out.println("                                       Danh sach tim kiem                                       ");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("| ID |      Ten san pham      |  Gia ban  |     Thuong hieu     |        Thong tin them        |");
        System.out.println("------------------------------------------------------------------------------------------------");

        for (int i=1;i<=SanPham.soLuong;i++) {
            if (quanLySanPham.giong(tuKhoa,sanPhams[i].getTenSanPham())==1){
                System.out.print(sanPhams[i]);
                System.out.println("------------------------------------------------------------------------------------------------");
                continue;
            }
            if (quanLySanPham.giong(tuKhoa,sanPhams[i].getGiaBan())==1){
                System.out.print(sanPhams[i]);
                System.out.println("------------------------------------------------------------------------------------------------");
                continue;
            }
            if (quanLySanPham.giong(tuKhoa,sanPhams[i].getThuongHieu())==1){
                System.out.print(sanPhams[i]);
                System.out.println("------------------------------------------------------------------------------------------------");
                continue;
            }
            int n = sanPhams[i].getSoThongTin();
            Pair<String, String>[] thongTin = sanPhams[i].getThongTinThem();
            for (int j=1;j<=n;j++) {
                if (quanLySanPham.giong(tuKhoa,thongTin[j].getSecond())==1){
                    System.out.print(sanPhams[i]);
                    System.out.println("------------------------------------------------------------------------------------------------");
                    break;
                }
            }
        }
    }

    public void xemDanhSach(SanPham[] sanPhams, String tuKhoa){
        System.out.println("Danh sach san pham tim kiem duoc:");
        System.out.println("------");

        for (int i=1;i<=SanPham.soLuong;i++) {
            if (quanLySanPham.giong(tuKhoa,sanPhams[i].getTenSanPham())==1){
                sanPhams[i].print();
                continue;
            }
            if (quanLySanPham.giong(tuKhoa,sanPhams[i].getGiaBan())==1){
                sanPhams[i].print();
                continue;
            }
            if (quanLySanPham.giong(tuKhoa,sanPhams[i].getThuongHieu())==1){
                sanPhams[i].print();
                continue;
            }
            int n = sanPhams[i].getSoThongTin();
            Pair<String, String>[] thongTin = sanPhams[i].getThongTinThem();
            for (int j=1;j<=n;j++) {
                if (quanLySanPham.giong(tuKhoa,thongTin[j].getSecond())==1){
                    sanPhams[i].print();
                    break;
                }
            }
        }
    }
}
