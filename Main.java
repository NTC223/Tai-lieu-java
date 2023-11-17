import java.security.KeyStore;
import java.util.Scanner;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        SanPham[] sanphams = new SanPham[1000];

        while (true) {
            System.out.print("Tên dang nhap: ");
            String tenDangNhap = sc.next();
            System.out.println();

            if (tenDangNhap.equals("admin")) {

                System.out.print("Mat khau: ");
                String matKhau = sc.next();
                System.out.println();

                if (matKhau.equals("admin")){
                    //admin
                    Admin admin = new Admin();
                    admin.chucNang(sanphams);
                }

                else {
                    System.out.println("Thong tin tai khoan khong chinh xac");
                    System.out.print("Quay tro lai dang nhap an phim 1, thoat an phim 0: ");
                    String check = sc.next();
                    Clrscr.clrscr();
                    if (check.equals("0")) return;
                }
            }

            else if (tenDangNhap.equals("khach")) {
                Khach khach = new Khach();
                khach.khach(sanphams);
            }

            else {
                System.out.println("Thong tin tai khoan khong chinh xac");
                System.out.print("Quay tro lai dang nhap an phim 1, thoat an phim 0: ");
                String check = sc.next();
                Clrscr.clrscr();
                if (check.equals("0")) return;
            }
        }
    }
}