package software.ulpgc;

import software.ulpgc.kata3.clean.model.Movie;

import java.io.IOException;

public interface MovieWriter extends AutoCloseable {
    void write(Movie movie) throws IOException;
}
