package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    //Instanzvariablen
    private String title;
    private String description;
    private List<String> genres;


    //Movie Constructor
    public Movie(String title, String description, List<String> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getGenres(){
        return genres;
    }




    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();

        List<String> darkKnightGenres = Arrays.asList("ACTION", "CRIME", "DRAMA");
        List<String> fightClubGenres = Arrays.asList("DRAMA", "MYSTERY", "THRILLER");
        List<String> djangoGenres = Arrays.asList("DRAMA", "WESTERN", "ACTION");
        List<String> deadpoolGenres = Arrays.asList("ACTION", "ADVENTURE", "COMEDY");
        List<String> suicideSquadGenres = Arrays.asList("ACTION", "ADVENTURE", "FANTASY");
        List<String> backToTheFutureGenres = Arrays.asList("ADVENTURE", "COMEDY", "SCI-FI");

        movies.add(new Movie("The Dark Knight","A superhero battles a criminal mastermind.", darkKnightGenres));
        movies.add(new Movie("Fight Club", "An office worker starts a fight club.",fightClubGenres));
        movies.add(new Movie("Django Unchained", "A slave-turned-bounty-hunter seeks to rescue his wife.",djangoGenres));
        movies.add(new Movie("Deadpool", "A former special forces operative seeks revenge.",deadpoolGenres));
        movies.add(new Movie("Suicide Squad", "A team of super-villains are sent on a dangerous mission.",suicideSquadGenres));
        movies.add(new Movie("Back to the Future", "A high school student travels back in time.",backToTheFutureGenres));


        return movies;
    }
}
