package software.ulpgc.kata3.clean.io;

import software.ulpgc.kata3.clean.model.Barchart;
import software.ulpgc.kata3.clean.model.BarchartElement;

import java.util.List;

public class MoviesBarchartLoader implements BarchartLoader {
    private final List<BarchartElement> moviesPerYear;
    private final List<BarchartElement> isAdultMovies;

    public MoviesBarchartLoader(List<BarchartElement> moviesPerYear, List<BarchartElement> isAdultMovies) {
        this.moviesPerYear = moviesPerYear;
        this.isAdultMovies = isAdultMovies;
    }

    @Override
    public Barchart load(int id) {
        return id % 2 == 0 ?
                loadBarchart("Number of movies each year", "Year", "Number of movies", moviesPerYear) :
                loadBarchart("+18 movies", "Is Adult", "Number of movies", isAdultMovies);
    }

    private Barchart loadBarchart(String movies, String xAxis, String yAxis, List<BarchartElement> barchartElements) {
        return new Barchart(movies, xAxis, yAxis, barchartElements);
    }
}
