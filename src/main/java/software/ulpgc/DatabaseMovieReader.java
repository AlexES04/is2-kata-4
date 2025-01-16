package software.ulpgc;

import software.ulpgc.kata3.clean.model.Movie;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.List;

import static software.ulpgc.DatabaseMovieWriter.connectionFor;

public class DatabaseMovieReader implements MoviesReader {
    private final Connection connection;
    private final PreparedStatement readStatement;
    private static final String getMoviesStatement = """
            SELECT *
            FROM movies
            """;

    public DatabaseMovieReader(File file) throws SQLException {
        this(connectionFor(file));
    }

    public DatabaseMovieReader(String connection) throws SQLException {
        this.connection = DriverManager.getConnection(connection);
        this.readStatement = this.connection.prepareStatement(getMoviesStatement);
    }

    @Override
    public List<Movie> read() throws IOException {
        try {
            ResultSet resultSet = this.readStatement.executeQuery();
            List<Movie> movies = ListConverter.resultSetToList(resultSet);
            this.connection.close();
            return movies;
        } catch (SQLException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
    }
}
