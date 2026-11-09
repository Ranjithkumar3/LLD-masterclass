package oops.polymorphism.sorting;

public class SortingUtility {
    public static void sort(int[] arr, Comparator comparator) {
        for (int i=0; i<arr.length; i++) {
            int j = i;
            while(j>0 && !comparator.compare(arr[j-1], arr[j])) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }

    //Method Overloading
    public static void printData(int num) {
        System.out.println("Number: " + num);
    }

    public static void printData(char c) {
        System.out.println("Char: " + c);
    }

    public static void getMax(int a, int b) {
        System.out.println("Max of 2 ints: "+Math.max(a, b));
    }

    public static void getMax(long a, long b) {
        System.out.println("Max of 2 longs: "+Math.max(a, b));
    }

    public static void main(String[] args) {
        getMax(1,2);
        getMax(1, 2L); //1 gets promoted to long
    }
}
