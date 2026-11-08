package oops.polymorphism;

public class Cat implements Animal {
    @Override
    public String speak() {
        return "Meow...meow!";
    }

    @Override
    public void move() {
        System.out.println("Cat is moving!");
    }
}
