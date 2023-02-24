package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    //Instanzvariablen
    private String title;
    private String description;
    private List<Genre> genres;


    //Movie Constructor
    public Movie(String title, String description, List<Genre> genres) {
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

    public List<Genre> getGenres(){
        return genres;
    }


    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();

        List<Genre> darkKnightGenres = Arrays.asList(Genre.ACTION, Genre.CRIME, Genre.DRAMA);
        List<Genre> fightClubGenres = Arrays.asList(Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER);
        List<Genre> djangoUnchainedGenres = Arrays.asList(Genre.ACTION, Genre.DRAMA, Genre.WESTERN);
        List<Genre> deadpoolGenres = Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.COMEDY);
        List<Genre> suicideSquadGenres = Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY);
        List<Genre> backToTheFutureGenres = Arrays.asList(Genre.ADVENTURE, Genre.COMEDY, Genre.SCIENCE_FICTION);

        movies.add(new Movie("The Dark Knight","A superhero battles a criminal mastermind.", darkKnightGenres));
        movies.add(new Movie("Fight Club", "An office worker starts a fight club.", fightClubGenres));
        movies.add(new Movie("Django Unchained", "A slave-turned-bounty-hunter seeks to rescue his wife.", djangoUnchainedGenres));
        movies.add(new Movie("Deadpool", "A former special forces operative seeks revenge.", deadpoolGenres));
        movies.add(new Movie("Suicide Squad", "A team of super-villains are sent on a dangerous mission.", suicideSquadGenres));
        movies.add(new Movie("Back to the Future", "A high school student travels back in time.", backToTheFutureGenres));

        return movies;
    }
}
