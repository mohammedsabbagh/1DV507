package ms225hk_assign1.Ex06;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.knowm.xchart.*;

public class Histogram {


    public static void main(String[] args) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(args[0]));
        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
            System.err.println("failed to load file: " + e.getMessage());
            return;
        }
        Integer[] numbers ={0,0,0,0,0,0,0,0,0,0};
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number >= 1 && number < 10) {
                ++numbers[0];
            } else if (number >= 11 && number < 20) {
                ++numbers[1];
            } else if (number >= 21 && number < 30) {
                ++numbers[2];
            } else if (number >= 31 && number < 40) {
                ++numbers[3];
            } else if (number >= 41 && number < 50) {
                ++numbers[4];
            } else if (number >= 51 && number < 60) {
                ++numbers[5];
            } else if (number >= 61 && number < 70) {
                ++numbers[6];
            } else if (number >= 71 && number < 80) {
                ++numbers[7];
            } else if (number >= 81 && number < 90) {
                ++numbers[8];
            } else if (number >= 91 && number < 100) {
                ++numbers[9];
            }
        }
        List<String> base = new ArrayList<>();
        base.add("1-10");
        base.add("11-20");
        base.add("21-30");
        base.add("31-40");
        base.add("41-50");
        base.add("51-60");
        base.add("61-70");
        base.add("71-80");
        base.add("81-90");
        base.add("91-100");



        // Create pie Chart
        PieChart pieChart = new PieChartBuilder().width(800).height(600).title("Pie chart").build();
        for (int i = 0; i < numbers.length ; ++i) {
            pieChart.addSeries(base.get(i), numbers[i]);
        }
        new SwingWrapper<>(pieChart).displayChart();

        // Create bar Chart
        CategoryChart categoryChart = new CategoryChartBuilder().width(800).height(600).title("Histogram").xAxisTitle("Score").yAxisTitle("Number").build();
        categoryChart.addSeries("Bar chart", base, Arrays.asList(numbers));
        new SwingWrapper<>(categoryChart).displayChart();

    }


}
