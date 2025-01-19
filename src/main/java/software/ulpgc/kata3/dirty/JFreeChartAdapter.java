package software.ulpgc.kata3.dirty;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.kata3.clean.model.Barchart;
import software.ulpgc.kata3.clean.model.BarchartElement;

public class JFreeChartAdapter {
    public static JFreeChart adapt(Barchart barchart) {
        JFreeChart chart = ChartFactory.createBarChart(barchart.getMovie(), barchart.getxAxis(), barchart.getyAxis(), datasetOf(barchart));
        buildChart(chart);
        return chart;
    }

    private static void buildChart(JFreeChart chart) {
        chart.getCategoryPlot().getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_90);
    }

    private static CategoryDataset datasetOf(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (BarchartElement barchartElement : barchart) {
            dataset.addValue(barchartElement.getValue(), "", barchartElement.getField());
        }
        return dataset;
    }
}
