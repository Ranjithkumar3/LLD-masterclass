package oops.polymorphism;

public class Dog implements Animal {
    @Override
    public String speak() {
        return "Wow...Wow!";
    }

    @Override
    public void move() {
        System.out.println("Dog is moving!");
    }
}
