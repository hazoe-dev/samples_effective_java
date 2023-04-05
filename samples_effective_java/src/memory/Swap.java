package memory;

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

    public static void main(String[] args) {
        Swap s = new Swap(2,3);

        s.swap();
        System.out.println(a+" "+b);
    }
}
