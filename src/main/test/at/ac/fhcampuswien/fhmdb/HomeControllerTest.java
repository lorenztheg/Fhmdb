package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.SortState;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    private static HomeController homeController;

    @BeforeAll
    static void init(){homeController = new HomeController();}

    @Test
    void movies_and_observableMovies_are_equal(){
        //GIVEN
        homeController.initializeState();

        //WHEN & THEN
        assertEquals(homeController.allMovies, homeController.observableMovies);
    }

    @Test
    void movies_are_sorted_correctly(){
        //GIVEN
        homeController.initializeState();
        homeController.sortState = SortState.NONE;
        List<Movie> expected = new ArrayList<>(homeController.allMovies);
        Collections.sort(expected, Comparator.comparing(Movie::getTitle));

        //WHEN
        homeController.sortMovies();

        //THEN
        List<Movie> actual = new ArrayList<>(homeController.observableMovies);
        assertEquals(expected,actual);
    }

    @Test
    public void test_search_by_title(){
        homeController.initializeState();

        // Search for a title that exists
        homeController.searchField.setText("Django");
        homeController.searchBtn.fire();
        assertEquals(1, homeController.observableMovies.size());
        assertEquals("Django Unchained", homeController.observableMovies.get(0).getTitle());

        // Search for a title that doesn't exist
        homeController.searchField.setText("random title lol xD");
        homeController.searchBtn.fire();
        assertEquals(0, homeController.observableMovies.size());
    }

    @Test
    public void test_filter_by_genre(){
        homeController.genreComboBox.getSelectionModel().select(Genre.WAR);
        homeController.searchBtn.fire();

        int expectedNumofMovies = 1;
        List<Movie> expectedMovie = Arrays.asList(new Movie("All Quiet on the Western Front","A group of young german soldiers experience the horrors and disillusionment of World War I", Arrays.asList(Genre.HISTORY, Genre.WAR, Genre.THRILLER)));

        assertEquals(expectedNumofMovies, homeController.observableMovies.size());
        assertTrue(homeController.observableMovies.containsAll(expectedMovie));

    }




}