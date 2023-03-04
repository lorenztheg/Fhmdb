package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.SortState;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    void movies_are_sorted_correctly_with_current_sortState_none_then_descending(){
        //GIVEN
        homeController.initializeState();
        homeController.sortState = SortState.NONE;


        //WHEN
        homeController.sortMovies();

        //THEN
        List<Movie> expected = Arrays.asList(

        );
        //assertEquals();
    }
    @Test
    void movies_are_sorted_correctly_with_current_sortState_descending_then_ascending() {
            //GIVEN
            homeController.initializeState();
            homeController.sortState = SortState.DESCENDING;


            //WHEN
            homeController.sortMovies();

            //THEN
            List<Movie> expected = Arrays.asList(

            );
    }
    @Test
    void movies_are_sorted_correctly_with_current_sortState_ascending_then_descending() {
        //GIVEN
        homeController.initializeState();
        homeController.sortState = SortState.ASCENDING;


        //WHEN
        homeController.sortMovies();

        //THEN
        List<Movie> expected = Arrays.asList(

        );
    }

    @Test
    void movies_search_for_title_and_description(){

    }

    @Test
    void movies_search_for_title_and_description_ignore_case(){

    }

    @Test
    void movies_filter_by_title_description_and_genre(){

    }

    @Test
    void movies_filter_by_title_description_and_genre_with_no_matches(){

    }
}