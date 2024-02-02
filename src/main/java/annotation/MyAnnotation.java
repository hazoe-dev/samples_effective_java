package annotation;

import java.io.ObjectOutputStream;

public class MyAnnotation extends MySuper{
    public void sayHi(MyAnnotation o){
        System.out.println("Hi");
    }
    public void say2(MyAnnotation o){
        System.out.println("2a "+o);
    }
    public static void main(String[] args) {
        MyAnnotation m = new MyAnnotation();
        m.say2(m);
        ObjectOutputStream a;
    }
}
