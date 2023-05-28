package sample_lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelegationExampleTest {
    private DelegationExample delegationExample;
    @Test
    public void add_whenEmptyCollection_returnTrue(){
        //arrange
        delegationExample = new DelegationExample();
        //act
        boolean actual = delegationExample.add("Hi");
        //assert
        Assertions.assertEquals(true, actual);
        Assertions.assertEquals(1, delegationExample.getCollection().size());
    }

    @Test
    public void remove_whenCollectionHasOneItem_returnTrue(){
        //arrange
        delegationExample = new DelegationExample();
        delegationExample.add("Hi");
        //act
        boolean actual = delegationExample.remove("Hi");
        //assert
        Assertions.assertEquals(true, actual);
        Assertions.assertEquals(0, delegationExample.getCollection().size());
    }
}