package memory;
/*
Tham trị (pass by value) Tham chiếu (pass by reference)
Tham số (parameter)
 là biến được khai báo trong signature phương thức. VD:

public void  say(String message){
     System.out.println(message); // in message ra màn hình
}
Tham trị (Agrument): là giá trị khi truyền vào tham số của phương thức khi được gọi. VD:

String message = "Hello";
say(message);
 */
public class Swap {
    static int a;
    static int b;
    Swap(int a, int b){
        this.a =a;
        this.b=b;
    }

    public static void swap(){
        int temp =a;
        a= b;
        b=temp;
    }
    public static void swap(int x, int y){
        int temp =x;
        x= y;
        y=temp;
    }

    public static void main(String[] args) {
        Swap s = new Swap(2,3);
        s.swap(s.a, s.b);
        System.out.println(a+" "+b);

        s.swap();
        System.out.println(a+" "+b);
    }
}
