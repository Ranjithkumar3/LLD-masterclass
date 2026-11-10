package constructs.abstractclass;

public abstract class Animal {
    private final String name;

    protected Animal(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println("Name: "+name);
    }

    public abstract void speak();

    public abstract void move();
}
