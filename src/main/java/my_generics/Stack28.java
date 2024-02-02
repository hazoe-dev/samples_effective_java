package my_generics;

public class Stack28<E> {
    public Stack28(){};
    public void push(E e){};
    public E pop(){
        return null;
    };
    public boolean isEmpty(){
        return false;
    };

    // pushAll method without wildcard type - deficient!
    public void pushAll(Iterable<E> src) {
        for (E e : src)
            push(e);
    }
}