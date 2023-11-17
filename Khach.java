import java.util.Queue;
import java.util.Scanner;

public class Khach {

    Scanner sc = new Scanner(System.in);
    public void huongDan(){
        System.out.println("De xem huong dan an 0.");
        System.out.println("De tim kiem san pham an 1.");
        System.out.println("De xem danh san pham an 2.");
        System.out.println("De thoat an 3.");
        System.out.println();
    }

    public void chucNang (SanPham[] sanPhams){

        QuanLySanPham quanLySanPham = new QuanLySanPham();

        while (true) {
            System.out.print("Chon chuc nang: ");

            String chucNang = sc.nextLine();

            if (chucNang.equals("3")) {
                Clrscr.clrscr();
                System.out.println("Xin chao va hen gap lai");
                break;
                //return;
            }

            else if (chucNang.equals("1")){
                //tim kiem sach
                quanLySanPham.timKiem(sanPhams);
            }

            else if (chucNang.equals("2")){
                // xem danh sach
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

            else if (chucNang.equals("0")) {
                huongDan();
            }

            else{
                System.out.println("Vui long chon dung chuc nang");
            }
        }
    }

    public void khach (SanPham[] sanPhams){
        // khach
        System.out.println("BAN DA DANG NHAP VOI TU CACH LA KHACH");
        System.out.println();
        System.out.print("xem huong dan an 1, da biet an 0: ");
        String huongDan = sc.nextLine();
        System.out.println();
        if (huongDan.equals("1")) {
            huongDan();
        }

        chucNang(sanPhams);
    }
}
