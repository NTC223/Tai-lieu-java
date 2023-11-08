# **Buổi 3**

## **I. Cách Java lưu trữ dữ liệu.** 

khi một chương trình java được thực thi, nó sẽ yêu cầu hệ điều hành cấp phát một không gian trên bộ nhớ để lưu trữ toàn bộ dữ liệu và thông tin của nó.

Sau đó, nó sẽ chia vùng không gian đó thành 4 vùng nhớ (memory segment) để lưu trữ.

![Alt text](image-1.png)

- Vùng nhớ code (code segment), theo như tên gọi của nó, tất cả mã chương trình (machine code) được lưu ở đây khi chương trình được thực thi.

- Vùng nhớ data (data segment), đây là nơi lưu trữ những dữ liệu chung của chương trình như các biến static, constant,… những biến dữ liệu mà được sinh ra khi chương trình bắt đầu thực thi và chỉ được giải phóng khi chương trình kết thúc.
 
- Vùng nhớ stack (stack segment), đây sẽ là nơi lưu trữ các biến thuộc nhóm kiểu dữ liệu cơ sở (primitive data type như là boolean, int, char,…) và địa chỉ của ô nhớ (memory address).

Gọi là vùng nhớ stack vì dữ liệu ở đây chia theo các nhóm gọi là stack frame, và mỗi stack frame sẽ được lưu vào vùng nhớ stack theo cơ chế Last-in-first-out (LIFO) như một stack.

Stack frame là nơi lưu trữu toàn bộ các biến của một phương thức (method), mỗi phương thức được thực thi sẽ tạo ra một SF.

![Alt text](image-2.png)

Với phương thức main() ta có biến c = 30 nên giá trị 30 này sẽ được lưu trữ ở SF main, và biến c cũng chỉ có phạm vi sử dụng trong phương thức main() thôi.

khi methodA được thực thi xong, SF methodA sẽ được pop ra khỏi stack, biến a đồng thời cũng được giải phóng, sau đó là SF methodB sẽ được pop, biến b được giải phóng và cuối cùng tới SF main và biến c.

- Vùng nhớ heap (heap segment), đây là nơi lưu trữ tất cả các đối tượng (object) được sinh ra trong thời gian thực thi chương trình (run time).

Với vùng nhớ code và data, khi chương trình thực thi sẽ cấp phát một không gian có kích thước không đổi.

Còn với vùng nhớ Stack và Heap, kích thước của nó sẽ thay đổi (mở rộng khi tạo thêm biến hoặc đối tượng, hoặc thu hẹp khi một biến hoặc đối tượng được giải phóng) và nếu cần mở rộng thêm nó sẽ lấy không gian từ Free memory.

Ngoài ra, trong bộ nhớ máy tính, mỗi ô nhớ sẽ được đánh địa chỉ để xác định chính xác vị trí của nó trong bộ nhớ. vì vậy, trong mỗi ô nhớ sẽ bao gồm 2 thành phần là Value và Adress.

### **1. Kiểu dữ liệu nguyên thủy.**

Tất cả các biến thuộc kiểu dữ liệu nguyên thủy đều được lưu trữ trên vùng nhớ stack.

VD: 
```java
    int a = 10;
```

Ở đây int a là cấp phát một ô nhớ 4 byte trê vùng nhớ stack. Ô nhớ gồm có Value và địa chỉ.

a = 10 gán value cho ô nhớ là 10.

### **2. Kiểu dữ liệu tham chiếu.**

Những biến thuộc kiểu dữ liệu tham chiếu (hay biến tham chiếu) sẽ được lưu tại vùng nhớ stack và đối tượng sinh ra (sau toán tử new) sẽ được lưu tại vùng nhớ heap. Giá trị của biến tham chiếu chính là địa chỉ của đối tượng được sinh ra đó. (biến được lưu tại vùng nhớ stack, giá trị là địa chỉ của một đối tượng được lưu tại vùng nhớ heap).

vd:
```java
    String a = newString("Java");
```

- Đầu tiên String a: cấp phát một ô nhớ trên vùng nhớ stack, ô nhớ này chính là biến tham chiếu a.

- newString(): Cấp phát một ô nhớ trên vùng nhớ heap, ô nhớ này là một đối tượng kiểu String, việc cấp ô nhớ này do toán tử new thực hiện.

- String("Java"): gán giá trị "Java" cho ô nhớ trên vùng heap.

- a = newString("Java"): gán địa chỉ của đối tượng trên vùng nhớ heap cho value của ô nhớ trên vùng nhớ stack (biến tham chiếu a).

Ta thấy biến tham chiếu a tương tư như con trỏ được lưu tại vùng nhớ stack và tham chiếu đến địa chỉ của một đối tượng được tạo ra trên vùng nhớ heap.

### **3. Class object.**

Class Object là class gốc cho tất cả các Class khác. Mọi Class trong Java ngầm kế thừa từ Class Object. Class object cung cấp 1 số phương thức cơ bản mà mọi đối tượng Java có sẵn như equals(), hashcode(), ...

Class Object không được lưu trữ trong bất kỳ vùng nhớ nào. Class Object là một class trong thư viện chuẩn của java và được tạo ra trong quá trình chạy.

### **4. Wrapper.**

Wrapper class cung cấp cơ chế để chuyển đổi kiểu dữ liệu nguyên thủy thành kiểu đối tượng và từ đối tượng thành kiểu dữ liệu nguyên thủy.

Các wrappr class tương ứng với các kiểu dữ liệu nguyên thủy, ngoài việc sử dụng giá trị để tính toán, chúng ta sẽ có thêm các phương thức khác được cài sẵn trong class, giúp việc xử lý các dữ liệu này trong Java trở nên linh hoạt hơn.

VD: với kiểu int, sau khi tạo ra đối tượng của wrapper class ứng với kiểu int, chúng ta có thể ngay lập tức sử dụng 1 phương thức chuyển số thành chuối ký tự trong Java

Có 8 kiểu wrapper class ứng với 8 kiểu dữ liệu nguyên thủy trong Java như sau:

![Alt text](image-3.png)

Cách khai báo:

```java
    WrapperClassName name = WrapperClassName.valueOf(value);
```

Để tạo ra đối tượng từ Wrapper class trong Java, chúng ta sử dụng tới phương thức thành viên valueOf()

```java

    Integer i = Integer.valueOf(9);

    Long l = Long.valueOf(9L);

    Double d = Double.valueOf(9.9);

    Float f = Float.valueOf(9.9F);

```

Để lấy giá trị ta sử dụng phương thức intValue()

```java

    int a = i.intvalue(); // a = 9;

    int b = d.intvalue(); // b = 9.0;

    int c = d.doublevalue(); // c = 9.9;

```

### **5. Boxing.**

Boxing là quá trình chuyển đổi giữa kiểu dữ liệu nguyên thủy và kiểu dữ liệu tham chiếu bằng cách tạo ra một đối tượng wrapper class thủ công

```java

    int primitiveInt = 42;
    
    Integer boxedInt = new Integer(primitiveInt);

    // boxing chuyển đổi kiểu kiểu dữ liệu int thành kiểu dữ liệu Integer thủ công

```

Autoboxing là một tính năng trong Java mà tư động thực hiện boxing khi cần thiết. Điều này có nghĩa rằng bạn có thể gán giá trị kiểu dữ liệu nguyên thủy cho một biến kiểu dữ liệu tham chiếu mà không cần tạo đối tượng wrapper class thủ công.

```java

    int primitiveInt = 90;

    Integer boxedInt1 = primitiveInt;

    Integer boxedInt2 = 90;

    //Autoboxing tự động chuyển kiểu dữ liệu int thành kiểu dữ liệu Integer

```

### **6. Unboxing.**

Unboxing là quá trình chuyển đổi giữa kiểu dữ liệu tham chiếu (wrapper class) thành kiểu dữ liệu cơ bản (primitive type) trong java. 

```java

    Integer boxedInt = 90;

    int primitiveInt = boxedInt;

    //unboxing chuyển đổi từ kiểu dữ liệu Integer thành kiểu dữ liệu int

```

## **II. Các phương thức khởi tạo trong java.**

### **1. Khởi tạo bằng Constructor**

Constructor là một phương thức đặc biệt có cùng tên với lớp và được sử dụng để khởi tạo đối tượng

```java

    MyClass obj1 = MyClass(); // Sử dụng constructor mặc định

    MyClass obj2 = MyClass(parameter 1, parameter 2); // Sử dụng Constructor tùy chỉnh  

```

### **2. Khởi tạo bằng gán giá trị**

Gán giá trị cho các thuộc tính của đối tượng bằng setter

```java

    MyClass obj = new MyClass();

    obj.setField1(value1);

    obj.setFeild2(value2);
```

### **3. Khởi tạo bằng Factory Method**

Sử dụng các phương thức tạo đối tượng (Factory Method) để trả về đối tượng đã được khởi tạo

```java
public class AnimalFactory
{
    public static IAnimal createAnimal (AnimalType type)
    {
        IAnimal animal = null;
        switch (type)
        {
            case AnimalType.Cat:
                animal = new Cat();
                break;
            case AnimalType.Dog:
                animal = new Dog();
                break;
            case AnimalType.Duck:
                animal = new Duck();
                break;
        }
        return animal;
    }
}
```

```java
public class Main
{
    public static void main(String[] agrs)
    {
        AnimalFactory factory = new AnimalFactory();

        IAnimal cat = factory.createAnimal(AnimalType.Cat);

        IAnimal dog = factory.createAnimal(AnimalType.Dog);
    }
}
```
AnimalFactory là Factory Method. nó cung cấp cách để tạo các đối tượng IAnimal mà không cần biết cụ thể cách chúng được tạo ra. Sử dụng Factory Method cho phép tách biệt việc tạo đối tượng và sử dụng đối tượng, giúp mã nguồn trở nên linh hoạt và dễ quản lý.

### **4. Khởi tạo bằng biểu thức lamda**

### **5. Khởi tạo bằng Single Pattern**

### **6. Từ khóa this**

Từ khóa this trong Java là một biến tham chiếu được sử dụng để tham chiếu tới đối tượng của lớp hiện tại

Từ khóa this có 6 cách sử dụng:

- Tham chiếu đến biến instance của lớp hiện tại.
- Gọi phương thức của lớp hiện tại.
- Gọi hàm dựng (Constructor) của lớp hiện tại.
- Trả về instance của lớp hiện tại.
- Được truyền như một tham số trong phương thức (method).
- Được truyền như một tham số trong hàm dựng (constructor).

### **7. Từ khóa super**

Từ khóa super trong Java là một biến tham chiếu được sử dụng để tham chiếu trực tiếp đến đối tượng của lớp cha gần nhất.

Bất cứ khi nào bạn tạo ra instance của lớp con, một instance của lớp cha được tạo ra ngầm định nghĩa là được tham chiếu bởi super

Từ khóa super có 3 cách sử dụng:

- Gọi trực tiếp hàm dựng (Constructor) của lớp cha gần nhất.
- Gọi trục tiếp thuộc tính (field) của lớp cha gần nhất.
- gọi trực tiếp phương thức (method) của lớp cha gần nhất.

## **III. Garbage Collector trong java.**

Rác (garbage) có nghĩa là một đối tượng không được tham chiếu đến nữa và bộ thu gom rác (Garbage collector) có nhiệm vụ hủy các đối tượng đó để giải phóng bộ nhớ. Quá trình này giúp Java quản lý bộ nhớ một cách tự động, loại bỏ đối tượng không còn được sử dụng để tránh lãng phí bộ nhớ và nguy cơ xảy ra lỗi "memory leak".

Một số khía cạnh quan trọng về garbage collector:

  - Sự tự động: quá trình thu gom rác trong Java là tự động và không yêu cầu sự can thiệp của lập trình viên. Máy ảo Java (JVM) quản lý quá trình này.
  - Quy trình thu gom rác: thu gom rác bao gồm quét và xác định các đối tượng không còn được tham chiếu từ chương trình. Sau đó, các đối tượng không còn được tham chiếu sẽ bị xóa và bộ nhớ được giải phóng.
  - Các cơ chế tham chiếu: Java sử dụng các cơ chế tham chiếu để quản lý việc đối tượng nào còn tham chiếu và đối tượng nào đã trở thành rác. Các loại cơ chế tham chiếu bao gồm: tham chiếu mạnh (Strong reference), tham chiếu yếu (weak reference), tham chiếu mềm (soft reference), tham chiếu phiên bản (phantom reference).
  - xảy ra không đồng bộ: Thu gom rác có thể xảy ra không đồng bộ với chương trình chính, điều này có nghĩa là bạn không thể kiểm soát chính xác khi nó xảy ra.

## **IV. Pass by value trong java là gì?**

Trong Java, khi truyền một tham số cho một phương thức, thì tham số đó sẽ được truyền theo kiểu "pass by value", nghĩa là một bản sao của giá trị tham số được tạo và sử dụng trong phương thức.

Như vậy khi bạn thay đổi giá trị của tham số bên trong phương thức, thay đổi này chỉ ảnh hưởng đến bản sao của tham số và không làm thay đổi biến gốc được truyền vào phương thức.
