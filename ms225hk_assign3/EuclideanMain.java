package ms225hk_assign3;

import java.util.Scanner;

public class EuclideanMain {

    // recursive implementation
    private static int gcd(int m, int n) {
        if (n == 0) return m;
        else return gcd(n, m % n);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] numbers = new int[2];
        System.out.println("Please input two integers: ");
        for (int i = 0; i < numbers.length; i++) {
            boolean vaild = false;   //use it to check if it is an integer
            while (!vaild) {
                try {
                    System.out.printf("%d : ", i + 1);
                    numbers[i] = scn.nextInt();
                    vaild = true;              //if it is something not an integer number will return with exaction
                } catch (Exception e) {
                    scn.next(); // run input again
                    System.out.println("It has to be an integer, please try again.");
                }
            }
        }

        scn.close();
        System.out.printf("\nThe greatest common divisor of %d and %d is %d.", numbers[0], numbers[1], gcd(numbers[0], numbers[1]));
    }
}