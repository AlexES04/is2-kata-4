package software.ulpgc;

import software.ulpgc.kata3.clean.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListConverter {
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String YEAR = "year";
    private static final String DURATION = "duration";
    private static final String ISADULT = "isAdult";

    public static List<Movie> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        while(resultSet.next()) {
            movies.add(new Movie(
                    getString(resultSet, ID),
                    getString(resultSet, TITLE),
                    getInt(resultSet, YEAR),
                    getInt(resultSet, DURATION),
                    getInt(resultSet, ISADULT)
            ));
        } return movies;
    }

    private static int getInt(ResultSet resultSet, String field) throws SQLException {
        return resultSet.getInt(field);
    }

    private static String getString(ResultSet resultSet, String field) throws SQLException {
        return resultSet.getString(field);
    }
}
