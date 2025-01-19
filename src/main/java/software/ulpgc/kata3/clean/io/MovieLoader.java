package software.ulpgc.kata3.clean.io;

import software.ulpgc.kata3.clean.model.Movie;

import java.io.IOException;
import java.util.List;

public interface MovieLoader {
    List<Movie> load() throws IOException;
}
