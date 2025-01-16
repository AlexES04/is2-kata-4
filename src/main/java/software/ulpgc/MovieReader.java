package software.ulpgc;

import software.ulpgc.kata3.clean.model.Movie;

import java.io.IOException;

public interface MovieReader extends AutoCloseable {
    Movie read() throws IOException;
}
