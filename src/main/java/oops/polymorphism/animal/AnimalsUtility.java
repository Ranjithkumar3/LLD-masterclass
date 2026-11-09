package oops.polymorphism.animal;

import java.util.List;

public class AnimalsUtility {
    public void makeAnimalsSpeak(List<Animal> animals) {
        for(Animal animal : animals) {
            System.out.println(animal.speak());
        }
    }
}
