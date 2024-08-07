package lab7a;

public class HelloWord {
    public static void main(String[] args) {

        if( args != null) {

        }
    }

    private static void printHelloWorld(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 5 == 0) {
                System.out.println("Hello");
            }
            if (numbers[i] % 7 == 0) {
                System.out.println("World");
            }
            if (numbers[i] % 5 == 0 && numbers[i] % 7 == 0) {
                System.out.println("Hello World");
            }
        }
    }

    private static void findSecondBiggest(int[] numbers) {
        int biggest = Integer.MAX_VALUE;
        int secondBiggest = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > biggest) {
                biggest = numbers[i];
            }
        }
    }
}
