package static_factory_method;

public class Person {
    public static final Person getInstance(){
        return new Person();
    }
    private Person(){}
}
class Student {

}
