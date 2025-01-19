package software.ulpgc.kata3.clean.io;

import software.ulpgc.kata3.clean.model.Movie;

public interface MovieDeserializer {
    Movie deserialize(String line);
}
