package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.SortState;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView<Movie> movieListView;

    @FXML
    public JFXComboBox<Genre> genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    public final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    public SortState sortState = SortState.NONE;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data
        genreComboBox.getItems();


        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.setPromptText("Filter by Genre");
            genreComboBox.getItems().addAll(Genre.values());

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here
        searchField.textProperty().addListener((observable, oldField, newField) -> {
            observableMovies.clear();

            for(Movie movie : allMovies){
                if(movie.getTitle().toLowerCase(Locale.ROOT).contains(newField.toLowerCase(Locale.ROOT)) ||
                        movie.getDescription().toLowerCase(Locale.ROOT).contains(newField.toLowerCase(Locale.ROOT))){
                    observableMovies.add(movie);
                }
            }
        });

        searchBtn.setOnAction(actionEvent -> {
            Genre selectedGenre = genreComboBox.getSelectionModel().getSelectedItem();
            if (selectedGenre != null && selectedGenre != Genre.NO_GENRE ) {
                observableMovies.clear();
                for (Movie movie : allMovies) {
                    if (movie.getGenres().contains(selectedGenre)) {
                        observableMovies.add(movie);
                    }
                }
            } else {
                observableMovies.setAll(allMovies);
            }
        });

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if(sortBtn.getText().equals("Sort (asc)")) {
                // TODO sort observableMovies ascending
                sortBtn.setText("Sort (desc)");
                observableMovies.sort(Comparator.comparing(Movie::getTitle));
            } else {
                // TODO sort observableMovies descending
                sortBtn.setText("Sort (asc)");
                observableMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
            }
        });

    }

    public void initializeState() {
        observableMovies.clear();
        observableMovies.addAll(allMovies);
    }

    public void sortMovies(){
        observableMovies.sort(Comparator.comparing(Movie::getTitle));
        sortState = SortState.ASCENDING;
    }
}