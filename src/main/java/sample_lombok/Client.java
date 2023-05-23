package sample_lombok;

import java.util.Collection;

public class Client {

    public static void main(String[] args) {
        DelegationExample delegationExample = new DelegationExample();
        delegationExample.add("ha");
        delegationExample.add("hai");
        delegationExample.remove("hai");

        ExcludesDelegateExample excludesDelegateExample = new ExcludesDelegateExample();
        excludesDelegateExample.add("HA");
        excludesDelegateExample.add("HAI");


        Collection<String> collection = delegationExample.getCollection();
        excludesDelegateExample.addAll(collection);

        excludesDelegateExample.remove("hai");

        DefaultDelegationExample defaultDelegationExample = new DefaultDelegationExample();
        defaultDelegationExample.add("ha");
        defaultDelegationExample.add("hi");
        defaultDelegationExample.remove("hi");

    }
}
