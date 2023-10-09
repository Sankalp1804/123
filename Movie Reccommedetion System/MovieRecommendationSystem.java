import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// class MovieRecommendationSystem start

class MovieRecommendationSystem {
    List<Movie> movies;
    Map<String, User> users;

    public MovieRecommendationSystem() {
        this.movies = new ArrayList<>();
        this.users = new HashMap<>();
    }

    public void registerUser(String username) {
        users.put(username, new User(username));
    }

    public void addMovie(String title, List<String> genres) {
        movies.add(new Movie(title, genres, null));
    }

    public void rateMovie(String username, String movieTitle, double rating) {
        User user = users.get(username);
        if (user != null) {
            user.rateMovie(movieTitle, rating);
        }
    }

    public List<Movie> searchMoviesByGenre(String genre) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.genres.contains(genre)) {
                result.add(movie);
            }
        }
        return result;
    }

    public List<Movie> getRecommendedMovies(String username) {
        User user = users.get(username);
        if (user == null) {
            return new ArrayList<>();
        }

        Map<Movie, Double> movieScores = new HashMap<>();
        for (Movie movie : movies) {
            double score = 0.0;
            int count = 0;
            for (Map.Entry<String, Double> entry : movie.numRatings.entrySet()) {
                User otherUser = user.get(entry.getKey());
                if (otherUser != null) {
                    Double otherRating = otherUser.numRatings.get(movie.title);
                    if (otherRating != null) {
                        score += entry.getValue() * otherRating;
                        count++;
                    }
                }
            }

            if (count > 0) {
                movieScores.put(movie, score / count);
            }
        }

        List<Movie> recommendedMovies = new ArrayList<>();
        movieScores.entrySet().stream().sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()))
                .limit(5).forEach(entry -> recommendedMovies.add(entry.getKey()));

        return recommendedMovies;
    }
}

// class MovieRecommendationSystem ends