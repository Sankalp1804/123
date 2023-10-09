
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Movie {
    String title;
    List<String> genres;
    Map<String, Double> numRatings;

    public Movie(String title, List<String> genres, Map<String, Double> ratings) {
        this.title = title;
        this.genres = genres;
        this.numRatings = new HashMap<>();
    }

    public double getAverageRating() {
        double sum = 0.0;
        for (double rating : numRatings.values()) {
            sum += rating;
        }
        return sum / numRatings.size();
    }

    public void addRating(String username, double rating) {
        numRatings.put(username, rating);
    }
}

// class Moie ends