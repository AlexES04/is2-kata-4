package software.ulpgc;

import software.ulpgc.kata3.clean.control.ToggleChartCommand;
import software.ulpgc.kata3.clean.io.MoviesBarchartLoader;
import software.ulpgc.kata3.clean.model.MapBarchartElementBuilder;
import software.ulpgc.kata3.clean.model.Movie;
import software.ulpgc.kata3.dirty.MainFrame;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        ImportCommand command = new ImportCommand();
        command.execute();

        List<Movie> movies = new DatabaseMovieReader(new File("C:\\Users\\Alejandro\\Desktop\\movies.db")).read();

        HashMap<Integer, Integer> moviesPerYear = new HashMap<>();
        HashMap<Integer, Integer> isAdultMovies = new HashMap<>();

        for (Movie movie : movies) {
            moviesPerYear.put(movie.year(), moviesPerYear.getOrDefault(movie.year(), 0) + 1);
            isAdultMovies.put(movie.isAdult(), isAdultMovies.getOrDefault(movie.isAdult(), 0) + 1);
        }

        MainFrame mainFrame = new MainFrame();
        MoviesBarchartLoader loader = new MoviesBarchartLoader(new MapBarchartElementBuilder<>(moviesPerYear).build(),
                new MapBarchartElementBuilder<>(isAdultMovies).build());
        mainFrame.put("Toggle", new ToggleChartCommand(loader, mainFrame.getDisplay()));
        mainFrame.getDisplay().display(loader.load(0));
        mainFrame.setVisible(true);
    }
}
