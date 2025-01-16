package software.ulpgc;

import software.ulpgc.kata3.clean.control.Command;
import software.ulpgc.kata3.clean.io.TsvMovieDeserializer;
import software.ulpgc.kata3.clean.model.Movie;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class ImportCommand implements Command {
    public ImportCommand() {}

    @Override
    public void execute() {
        try {
            File input = getInputFile();
            File output = getOutputFile();
            doExecute(input, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doExecute(File input, File output) throws Exception {
        try (MovieReader reader = createMovieReader(input); MovieWriter writer = createMovieWriter(output)) {
            while(true) {
                Movie movie = reader.read();
                if (movie == null) break;
                writer.write(movie);
            }
        }
    }

    private DatabaseMovieWriter createMovieWriter(File file) throws SQLException {
        return new DatabaseMovieWriter(deleteIfExists(file));
    }

    private File deleteIfExists(File file) {
        if (file.exists()) file.delete();
        return file;
    }

    private FileMovieReader createMovieReader(File file) throws IOException {
        return new FileMovieReader(file, new TsvMovieDeserializer());
    }

    private File getOutputFile() {
        return new File("C:\\Users\\Alejandro\\Desktop\\movies.db");
    }

    private File getInputFile() {
        return new File("C:\\Users\\Alejandro\\Desktop\\title.basics.tsv.gz");
    }
}
