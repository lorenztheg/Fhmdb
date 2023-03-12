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

    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        if (object == this){
            return true;
        }
        if(!(object instanceof Movie other)){
            return false;
        }
        return this.title.equals(other.title) && this.description.equals(other.description) && this.genres.equals(other.genres);
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();

        List<Genre> darkKnightGenres = Arrays.asList(Genre.ACTION, Genre.CRIME, Genre.DRAMA);
        List<Genre> fightClubGenres = Arrays.asList(Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER);
        List<Genre> djangoUnchainedGenres = Arrays.asList(Genre.ACTION, Genre.DRAMA, Genre.WESTERN);
        List<Genre> deadpoolGenres = Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.COMEDY);
        List<Genre> suicideSquadGenres = Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY);
        List<Genre> backToTheFutureGenres = Arrays.asList(Genre.ADVENTURE, Genre.COMEDY, Genre.SCIENCE_FICTION);
        List<Genre> shiningGenres = Arrays.asList(Genre.HORROR, Genre.THRILLER, Genre.MYSTERY);
        List<Genre> willywonkaGenres = Arrays.asList(Genre.FAMILY, Genre.MUSICAL, Genre.ADVENTURE);
        List<Genre> michaeljacksonGenres = Arrays.asList(Genre.DOCUMENTARY, Genre.BIOGRAPHY, Genre.MUSICAL);
        List<Genre> allquietGenres = Arrays.asList(Genre.HISTORY, Genre.WAR, Genre.THRILLER);
        List<Genre> toystoryGenres = Arrays.asList(Genre.FAMILY, Genre.ANIMATION);
        List<Genre> rushGenres = Arrays.asList(Genre.DOCUMENTARY, Genre.SPORT, Genre.DRAMA);
        List<Genre> titanicGenres = Arrays.asList(Genre.DRAMA, Genre.ROMANCE);

        movies.add(new Movie("The Dark Knight","A superhero battles a criminal mastermind.", darkKnightGenres));
        movies.add(new Movie("Fight Club", "An office worker starts a fight club.", fightClubGenres));
        movies.add(new Movie("Django Unchained", "A slave-turned-bounty-hunter seeks to rescue his wife.", djangoUnchainedGenres));
        movies.add(new Movie("Deadpool", "A former special forces operative seeks revenge.", deadpoolGenres));
        movies.add(new Movie("Suicide Squad", "A team of super-villains are sent on a dangerous mission.", suicideSquadGenres));
        movies.add(new Movie("Back to the Future", "A high school student travels back in time.", backToTheFutureGenres));
        movies.add(new Movie("Shining", "An isolated hotel becomes a haunting prison for a family.", shiningGenres));
        movies.add(new Movie("Willy Wonka & the Chocolate Factory", "A poor boy wins a golden ticket to tour a magical chocolate factory run by a candy maker", willywonkaGenres));
        movies.add(new Movie("Michael Jacksons's This Is It", "BTS footage of Michael Jackson's preparation for his planned concert series before his untimely death", michaeljacksonGenres));
        movies.add(new Movie("All Quiet on the Western Front","A group of young german soldiers experience the horrors and disillusionment of World War I", allquietGenres));
        movies.add(new Movie("Toy Story 3","Join Woody, Buzz and their friends as they embark on a daring adventure to escape a daycare center and reunite with their owner", toystoryGenres));
        movies.add(new Movie("Rush", "Two fierce Formula One drivers battle for the world championship in the biographical sports drama", rushGenres));
        movies.add(new Movie("Titanic", "A wealthy woman and a poor artist fall in love on the voyage of the Titanic", titanicGenres));

        return movies;
    }
}
