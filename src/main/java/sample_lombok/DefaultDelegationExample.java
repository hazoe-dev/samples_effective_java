package sample_lombok;

import lombok.Getter;
import lombok.experimental.Delegate;

import java.util.ArrayList;
import java.util.Collection;

public class DefaultDelegationExample {
    @Getter
    @Delegate
    private final Collection<String> collection = new ArrayList<>();

}
