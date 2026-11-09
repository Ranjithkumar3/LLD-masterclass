import oops.polymorphism.animal.*;
import oops.polymorphism.sorting.AscendingComparator;
import oops.polymorphism.sorting.DescendingComparator;
import oops.polymorphism.sorting.SortingUtility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolymorphismTest {
    AnimalsUtility animalsUtility = new AnimalsUtility();

    @Test
    void animalsTest() {
        Animal dog = new Dog();
        Animal cat = new Cat();

        List<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);
        Animal giraffe = new Giraffe();
        animals.add(giraffe);

        animalsUtility.makeAnimalsSpeak(animals);
    }

    @Test
    void sortTest() {
        int[] arr = {3,5,1,2,4,6};
        SortingUtility.sort(arr, new DescendingComparator());
        for(int i : arr) System.out.println(i);
    }
}
