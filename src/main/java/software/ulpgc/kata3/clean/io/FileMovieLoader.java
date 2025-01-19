package software.ulpgc.kata3.clean.io;

import software.ulpgc.kata3.clean.model.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMovieLoader implements MovieLoader {
    private final File file;
    private final MovieDeserializer deserializer;

    public FileMovieLoader(File file, MovieDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public List<Movie> load() throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                movies.add(deserializer.deserialize(line));
            }
        } return movies;
    }
}
