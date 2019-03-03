package ms225hk_assign1.Ex06;


import static java.lang.StrictMath.cos;

import java.util.ArrayList;
import java.util.List;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;


public class SinMain {

    public static void main(String[] args) {
        List xData = new ArrayList();
        List yData = new ArrayList();

        double x = 0;
        while (x < 2 * Math.PI) {
            xData.add(x);
            yData.add((1 + x / Math.PI) * cos(x) * cos(40 * x));
            x += 0.01f;
        }

        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);
        new SwingWrapper(chart).displayChart();
    }
}




