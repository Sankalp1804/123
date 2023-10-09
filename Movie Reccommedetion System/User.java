import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


class User {
    String username;
    Map<String, Double> preferences;
    Map<String, Double> numRatings;

    public User(String username) {
        this.username = username;
        this.preferences = new HashMap<>();
        this.numRatings = new HashMap<>();
    }

    public void updatePreferences(String genre, double weight) {
        preferences.put(genre, weight);
    }

    public void rateMovie(String movieTitle, double rating) {
        numRatings.put(movieTitle, rating);
    }

    public User get(String key) {
        return null;
    }
}
// class User ends
