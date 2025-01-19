package software.ulpgc.kata3.clean.model;

import java.util.Iterator;
import java.util.List;

public class Barchart implements Iterable<BarchartElement> {
    private final String movie;
    private final String xAxis;
    private final String yAxis;
    private final List<BarchartElement> barchartElements;

    public Barchart(String movie, String xAxis, String yAxis, List<BarchartElement> barchartElements) {
        this.movie = movie;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.barchartElements = barchartElements;
    }

    public String getMovie() {
        return movie;
    }

    public String getxAxis() {
        return xAxis;
    }

    public String getyAxis() {
        return yAxis;
    }

    public Iterator<BarchartElement> iterator() {
        return barchartElements.iterator();
    }
}
