package CtrlAltElite.testCaseExecutables;

import java.util.ArrayList;
import java.util.List;

public class TestingMethods {

    public static List<Integer> parseIntList(String input) {
        String[] strings = parseStringsInArrayForm(input);
        List<Integer> entries = new ArrayList<>(strings.length);
        for (String string : strings) {
            entries.add(Integer.parseInt(string));
        }

        return entries;
    }
	
	public static List<Double> parseDoubleList(String input) {
        String[] strings = parseStringsInArrayForm(input);
        List<Double> entries = new ArrayList<>(strings.length);
        for (String string : strings) {
            entries.add(Double.parseDouble(string));
        }

        return entries;
    }

    public static double[] parseDoubleArray(String input) {
        String[] strings = parseStringsInArrayForm(input);
        double[] entries = new double[strings.length];
        for (int i = 0; i < strings.length; i++) { 
            String string = strings[i];
            entries[i] = Double.parseDouble(string);
        }
        return entries;
    }

    private static String[] parseStringsInArrayForm(String input) {
        input = input.replaceAll("\\[|\\]", "").trim();
        input = input.replaceAll("\\s\\s", "\\s");
        return input.split("\\s");
    }
}
