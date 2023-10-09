// Movie Recommendation System
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class MovieRecommendationApplication {


    public static void main(String[] args) {
        MovieRecommendationSystem recommendationSystem = new MovieRecommendationSystem();


        // Movies in all genres
        recommendationSystem.addMovie("Avatar", Arrays.asList("Action"));
        recommendationSystem.addMovie("Old", Arrays.asList("Horror"));
        recommendationSystem.addMovie("OMG2 ", Arrays.asList("Comedy"));
        recommendationSystem.addMovie("SpiderMan", Arrays.asList("Action"));
        recommendationSystem.addMovie("RiverWild ", Arrays.asList("Thriller"));
        recommendationSystem.addMovie("Nun", Arrays.asList("Horror"));
        recommendationSystem.addMovie("GrandMasti", Arrays.asList("Romance"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username : ");
        String username = scanner.nextLine();
        scanner.nextLine();


        while (true) {
            System.out.println("******************************");
            System.out.println("|       Movie Section        |");
            System.out.println("******************************");
            System.out.println("*  1. Search Movies by genre *");
            System.out.println("*  2. Get recommended Movies *");
            System.out.println("*  3. Rate a movie           *");
            System.out.println("*  4. Exit                   *");
            System.out.println("******************************");

            System.out.println("Enter your choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the genre name you want to search : ");
                    String genre = scanner.nextLine();
                    List<Movie> genreMovies = recommendationSystem.searchMoviesByGenre(genre);
                    System.out.println("Movies in " + genre + " genre :");
                    System.out.println();
                    for (Movie movie : genreMovies) {
                        System.out.println("**" + movie.title + "**");
                    }
                    System.out.println();
                    break;
                case 2:
                    List<Movie> recommendedMovies = recommendationSystem.getRecommendedMovies(username);
                    System.out.println("Recommended Movies :");
                    for (Movie movie : recommendedMovies) {
                        System.out.println(movie.title + " (Average Rating : " + movie.getAverageRating());
                    }
                    break;
                case 3:
                    System.out.println("Enter the movie title you want to rate : ");
                    String movieTitle = scanner.nextLine();
                    System.out.println("Enter your rating (0.0 to 5.0)");
                    double rating = scanner.nextDouble();
                    recommendationSystem.rateMovie(username, movieTitle, rating);
                    System.out.println(" Movie rated Successfully");
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Exit..");
                    return;

                default:
                    System.out.println("Invalid choice .Please try again");
            }
        }
    }
}
