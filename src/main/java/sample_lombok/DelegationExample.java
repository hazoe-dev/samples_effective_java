package sample_lombok;

import lombok.Getter;
import lombok.experimental.Delegate;

import java.util.ArrayList;
import java.util.Collection;

public class DelegationExample {
    private interface SimpleCollection {
        boolean add(String item);

        boolean remove(Object item);
    }

    @Getter
    @Delegate(types = SimpleCollection.class)
    private final Collection<String> collection = new ArrayList<>();

}
