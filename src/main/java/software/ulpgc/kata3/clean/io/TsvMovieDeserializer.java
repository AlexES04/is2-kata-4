package software.ulpgc.kata3.clean.io;

import software.ulpgc.kata3.clean.model.Movie;

public class TsvMovieDeserializer implements MovieDeserializer {
    @Override
    public Movie deserialize(String line) {
        return deserialize(line.split("\t"));
    }

    private Movie deserialize(String[] split) {return new Movie(split[0], split[3], toInt(split[5]), toInt(split[7]), toInt(split[4]));}

    private int toInt(String value) {
        if (value.equals("\\N")) return 0;
        return Integer.parseInt(value);
    }
}
