package project;

/*
Driver for gcd method
 */

import project.MathOps;

public class GCDDriver {

    public static void main(String[] args) {
        if (args.length < 2 || args.length > 2) {
            System.out.println("Error");
        } else {
            try {
                int num1 = Integer.parseInt(args[0]);
                int num2 = Integer.parseInt(args[1]);
                System.out.println(MathOps.gcd(num1, num2));
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}
