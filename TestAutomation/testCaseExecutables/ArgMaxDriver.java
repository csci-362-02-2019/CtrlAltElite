package TestAutomation.testCaseExecutables;
import TestAutomation.project.MathOps;

/*
Driver for argMin method
 */
import java.util.List;


public class ArgMaxDriver {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(TestingConstants.ERROR_MESSAGE);
        } else {
            try {
                double[] entries = TestingMethods.parseDoubleArray(args[0]);
                List<Integer> indices = TestingMethods.parseIntList(args[1]);
                System.out.println(MathOps.argMaxDouble(entries, indices));
            } catch (Exception e) {
                System.out.println(TestingConstants.ERROR_MESSAGE);
            }
        }
    }
}
