package common_method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ClassBoneTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testAddAnimal_whenAdd1BoneAnimal() {
        ClassBone bone = new ClassBone("monkey", true, false);

        Map<Animal,String> list = new HashMap<>();
        list.put(bone,bone.getName());

        assertTrue(list.containsKey(bone));
    }

    @Test
    void testAddAnimal_whenAdd2BoneAnimal() {
        ClassBone bone = new ClassBone("monkey", true, false);
        ClassBone bone1 = new ClassBone("cat", true, false);

        Map<Animal,String> list = new HashMap<>();
        list.put(bone,bone.getName());
        list.put(bone1,bone1.getName());
        int actual = list.keySet().size();
        assertEquals(2, actual);
    }

    @Test
    void testAddAnimalReturnMap_whenAdd1BoneAnimal() {
        ClassBone bone = new ClassBone("monkey", true, false);
        Map<Animal,String> list = new HashMap<>();
        bone.addAnimal(list,bone);

        assertTrue(list.containsKey(bone));
    }

    @Test
    void testAddAnimalReturnMap_whenAdd2BoneAnimal() {
        ClassBone bone = new ClassBone("monkey", true, false);
        ClassBone bone1 = new ClassBone("cat", true, false);

        Map<Animal,String> list = new HashMap<>();
        bone.addAnimal(list,bone);
        bone1.addAnimal(list,bone1);

        int actual = list.keySet().size();
        assertEquals(2, actual);
    }

    @Test
    void testAddAnimalReturnMap_whenAdd2BoneAnimal_Same() {
        ClassBone bone = new ClassBone("monkey", true, false);
        ClassBone bone1 = new ClassBone("monkey", true, false);

        Map<Animal,String> list = new HashMap<>();
        bone.addAnimal(list,bone);
        bone1.addAnimal(list,bone1);

        int actual = list.keySet().size();
        assertEquals(1, actual);
    }

    @Test
    void testAddAnimalReturnMap_whenAdd2BoneAnimal_Same_listFish() {
        ClassBone bone = new ClassBone("monkey", true, false);
        ClassBone bone1 = new ClassBone("monkey", true, false);
        ClassFish fish = new ClassFish("wheel", true, true);

        Map<Animal,String> list = new HashMap<>();
        bone1.addAnimal(list,fish);
        System.out.println(list.keySet().size());
        //because the first time add value it not hash table to compare -> not compare hash -> not compare equal -> add OK

        int actual = list.keySet().size();
        assertEquals(1, actual);
    }
}