import java.awt.event.KeyAdapter;
import java.util.Scanner;

public class Admin {

    public  void huongDan(){
        System.out.println("De xem huong dan an 0.");
        System.out.println("De them san pham moi an 1.");
        System.out.println("De xoa san pham an 2.");
        System.out.println("De sua san pham an 3.");
        System.out.println("De test cac chuc nang cho khach an 4.");
        System.out.println("De xem danh sach san pham an 5.");
        System.out.println("De thoat tai khoan admin an 6.");
        System.out.println();
    }
    public void chucNang(SanPham[] sanPhams){
        Scanner sc = new Scanner(System.in);

        System.out.println("BAN DA DANG NHAP VOI TU CACH ADMIN");
        System.out.println();
        System.out.print("xem huong dan an 1, da biet an 0: ");
        String huongDan = sc.nextLine();

        QuanLySanPham quanLySanPham = new QuanLySanPham();
        System.out.println();

        if (huongDan.equals("1")) {
            huongDan();
        }

        while (true) {
            System.out.print("Chon chuc nang: ");
            String chucNang = sc.nextLine();

            if (chucNang.equals("0")){
                huongDan();
            }

            else if (chucNang.equals("1")) {
                quanLySanPham.them(sanPhams);
            }

            else if (chucNang.equals("2")) {
                int check = quanLySanPham.timKiem(sanPhams);

                if (check == 1) {
                    System.out.print("Nhap ID can xoa: ");

                    quanLySanPham.xoa(sanPhams);
                }
            }

            else if (chucNang.equals("3")) {
                int check = quanLySanPham.timKiem(sanPhams);

                if (check == 1) {
                    System.out.print("Nhap ID can sua: ");

                    quanLySanPham.sua(sanPhams);
                }
            }

            else if (chucNang.equals("4")) {
                System.out.println("Cac chuc nang cua khach de test");
                System.out.println("Ban dang co vai tro la  khach");
                Khach khach = new Khach();
                khach.chucNang(sanPhams);
                System.out.println("Ban dang co vai tro la admin");
            }

            else if (chucNang.equals("5"))
            {
                System.out.print("Hien thi theo dang bang an 1, theo danh sach an 2: ");
                String check = sc.nextLine();
                HienThi hienThi = new HienThi();
                if (check.equals("1")){
                    hienThi.xemBang(sanPhams,"");
                }
                else {
                    hienThi.xemDanhSach(sanPhams,"");
                }
            }

            else if (chucNang.equals("6")){
                Clrscr.clrscr();
                System.out.println("Da tro ve dang nhap");
                break;
            }
            else
            {
                System.out.println("Vui long chon dung chuc nang");
            }
            //Clrscr.clrscr();
        }
    }
}
