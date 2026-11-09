package oops.polymorphism.animal;

public class Giraffe implements Animal {
    @Override
    public String speak() {
        return "Gee...gee!";
    }

    @Override
    public void move() {
        System.out.println("Giraffe is moving!!");
    }
}
