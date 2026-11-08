import oops.polymorphism.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
}
