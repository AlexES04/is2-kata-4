package software.ulpgc;

import software.ulpgc.kata3.clean.model.Movie;

import java.io.IOException;
import java.util.List;

public interface MoviesReader extends AutoCloseable {
    List<Movie> read() throws IOException;
}
