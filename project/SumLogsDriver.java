package project;

/*
Driver for sumLogs method
 */
 import java.util.List;

public class SumLogsDriver {

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 1) {
            System.out.println(TestingConstants.ERROR_MESSAGE);
        } else {
            try {
				List<Double> entries = TestingMethods.parseDoubleList(args[0]);
                System.out.println(MathOps.sumLogs(entries));
            } catch (Exception e) {
                System.out.println(TestingConstants.ERROR_MESSAGE);
            }
        }
    }
}
