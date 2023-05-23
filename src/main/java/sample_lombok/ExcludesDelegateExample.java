package sample_lombok;

import lombok.experimental.Delegate;

import java.util.ArrayList;
import java.util.Collection;

public class ExcludesDelegateExample {
    long counter = 0l;
    private interface Add{
        boolean add(String x);
        boolean addAll(Collection<? extends String> x);
    }

    @Delegate(excludes = Add.class)
    private final Collection<String> collection = new ArrayList<>();

    public boolean add(String item){
        counter++;
        return collection.add(item);
    }

    public boolean addAll(Collection<String> col){
        counter+=col.size();
        return collection.addAll(col);
    }
}
