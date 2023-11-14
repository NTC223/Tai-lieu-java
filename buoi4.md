# **[JAVA] - Buổi 4 Mọi thứ đều là đối tượng**

## **1. Tính đóng gói**

Tính đóng gói là việc kết hợp dữ liệu và các phương thức liên quan và một đối tượng duy nhất.

Tính đóng gói nhằm bảo vệ đối tượng không bị truy cậptừ code bên ngoài vào để thay đổi giá trị các thuộc tính hay có thể truy cập trực tiếp. Việc cho phép truy cập các giá trị của đối tượng tùy theo sự đồng ý của người viết ra lớp của đối tượng đó. Tính chất này đảm bảo sự bảo mật, toàn vẹn của đối tượng trong Java.

Tính chất này được thể hiện qua các loại phạm vi truy cập (Access modifier) Và setter, getter.

```java

    public class Meo{
        private String ten;
        private String mau;
        private int tuoi;

        public void setTen (String ten)
        {
            this.ten = ten;
        }
        public String getTen()
        {
            return this.ten;
        }
        public void setMau (String mau)
        {
            this.mau = mau;
        }
        public String getMau()
        {
            return this.mau;
        }
        public void setTuoi (int tuoi)
        {
            if (tuoi >= 0 && tuoi <= 100)
            {
                this.tuoi = tuoi;
            }
        }
        public int getTuoi()
        {
            return this.tuoi;
        }
    }

```

```java

    public class Main()
    {
        public static void main(String[] args){
            Meo meocon = new Meo();

            meocon.setTen("Cam");
            System.out.println(meocon.getTen());
            
            meocon.setMau("Cam");
            System.out.println(meocon.getMau());
            
            meocon.getTuoi(3);
            System.out.println(meocon.getTuoi());

            meocon.setTuoi(-5);
            System.out.println(meocon.getTuoi());
        }
    }

```

```output

    cam
    cam
    3
    3

```

## **2. Tính kế thừa**

Tính kế thừa cho phép chúng ta cải tiến chương trình bằng cách kế thừa lại lớp cũ và phát triển những tính năng mới. Lớp con sẽ kế thừa tất cả những thành phần của lớp cha, nhờ có sự chia sẻ này mới có thể mở rộng những đặc tính sẵn có mà không cần phải định nghĩa lại.

```java

    public class DongVat{
        public void an(){
            System.out.println("mam mam");
        }
        public void ngu(){
            System.out.println("kho kho");
        }
    }

```

```java

    public class Meo extends DongVat{
        public String ten;
        public String mau;
        public int tuoi;

        public void keu()
        {
            System.out.println("meo meo");
        }
    }

```

```java

    public class Cun extends Dongvat{
        public String ten;
        public String mau;
        public int tuoi;

        public void keu(){
            System.out.println("gau gau");
        }
    }

```

```java

    public class Main{
        public static void main(String[] args){
            Meo meocon = new Meo();
            Cun cuncon = new Cun();

            cuncon.keu();
            meocon.keu();

            cuncon.an();

            meocon.ngu();
        }
    }

```

```output

    gau gau
    meo meo
    mam mam
    kho kho

```

Vì cả lớp Mèo lớp Cún đều kế thừa lớp động vật nên lớp mèo và lớp cún đều được kế thừa phương thức ăn và ngủ ở lớp động vật

## **3. Tính đa hình**

Tính đa hình có thể nói luôn tồn tại song song với tính kế thừa. Khi có nhiều lớp con kế thừa lớp cha nhưng có những tính chất khác nhau cũng gọi là đa hình, hoặc những tác vụ trong cùng một đối tượng được thể hiện nhiều cách khác nhau cũng gọi là đa hình. Tính đa hình là kết quả tất yếu khi ta phát triển khả năng kế thừa và nâng cấp chương trình

Ví dụ: trong hình học tứ giác, hình thang có 3 lớp con là hình thang cân, hình thang vuông và hình bình hành. vì 3 hình này có tính chất riêng biệt nên có thể gọi là tính đa hình.

Chúng ta có thể đạt được tính đa hình bằng 2 cách

### **a. Nạp chồng phương thức (method overloading)**

Nạp chồng phương thức có nghĩa là nhiều hàm phương thức có cùng tên nhưng các thông số của hàm khác nhau (những tác vụ trong cùng một đối tượng được thể hiện nhiều cách khác nhau).

```java

    public class Meo{
        public String ten;
        public String mau;
        public int tuoi;

        public void keu(){
            System.out.println("meo meo");
        }

        public void keu(String tiengnguoi){
            System.out.println(tiengnguoi);
        }
    }

```

```java

    public class Main{
        public static void main(String[] args)
        {
            Meo meocon = new Meo();
            meocon.keu();
            meocon.keu("doi");
        }
    }

```

```output

    meo meo
    doi

```
### **b. Ghi đè phương thức (method overriding)**
(Khi có nhiều lớp con kế thừa lớp cha nhưng có những tính chất khác nhau)

```java

    public class DongVat{
        public void an(){
            System.out.println("mam mam");
        }
        public void ngu(){
            System.out.println("kho kho");
        }
    }

```

```java

    public class Meo extends DongVat{
        public String ten;
        public String mau;
        public int tuoi;

        public void an(){
            System.out.println("an ca");
        }
    }

```

```java

    public class Cun extends DongVat{
        public String ten;
        public String mau;
        public int tuoi;

        public void an(){
            System.out.println("an xuong");
        }
    }

```

```java

    public class Main{
        public static void main(String[] args){
            Meo meocon = new Meo();
            Cun cuncon = new Cun();

            meocon.an();
            cuncon.an();
        }
    }

```

```output

    an ca
    an xuong;

```


