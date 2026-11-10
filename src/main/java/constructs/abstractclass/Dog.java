package constructs.abstractclass;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("Wow...wow");
    }

    @Override
    public void move() {
        System.out.println("Dog is moving!");
    }
}
