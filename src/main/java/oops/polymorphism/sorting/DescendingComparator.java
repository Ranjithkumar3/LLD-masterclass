package oops.polymorphism.sorting;

public class DescendingComparator implements Comparator{
    @Override
    public boolean compare(int a, int b) {
        return a > b;
    }
}
