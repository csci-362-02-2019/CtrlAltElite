package CtrlAltElite.testCaseExecutables;
import CtrlAltElite.project.MathOps;

/*
Driver for gcd method
*/

public class ApproxEqualDriver {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(TestingConstants.ERROR_MESSAGE);
        } else {
            try {
                double num1 = Double.parseDouble(args[0]);
                double num2 = Double.parseDouble(args[1]);
                System.out.println(MathOps.approxEqual(num1, num2));
            } catch (Exception e) {
                System.out.println(TestingConstants.ERROR_MESSAGE);
            }
        }
    }
}
