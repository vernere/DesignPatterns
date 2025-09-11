package com.assignment11;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the history view that displays a list of application states.
 * Implements the Memento pattern to show and restore previous application states.
 */
public class HistoryController implements Initializable {

    /**
     * ListView component that displays the history of application states
     */
    @FXML
    private ListView<Memento> historyListView;

    /**
     * Observable list that holds the history items (Mementos)
     */
    private ObservableList<Memento> historyItems;
    
    /**
     * Reference to the primary controller to enable state restoration
     */
    private PrimaryController primaryController;

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     * 
     * @param location The location used to resolve relative paths for the root object
     * @param resources The resources used to localize the root object
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the observable list for history items
        historyItems = FXCollections.observableArrayList();
        
        // Set a custom cell factory to display the memento description with visual indicators
        historyListView.setCellFactory(lv -> new javafx.scene.control.ListCell<Memento>() {
            @Override
            protected void updateItem(Memento memento, boolean empty) {
                super.updateItem(memento, empty);
                if (empty || memento == null) {
                    // If the cell is empty, clear it
                    setText(null);
                    setGraphic(null);
                } else {
                    // Create a detailed description with timestamp
                    String description = memento.getDesc();
                    String timeInfo = String.format("[%tH:%tM:%tS] ", memento.timeStamp, memento.timeStamp, memento.timeStamp);
                    
                    // Set text with timestamp
                    setText(timeInfo + description);
                    
                    // Create a visual representation based on the type of state change
                    if (description.contains("rectangle 1")) {
                        // Show color of rectangle 1
                        setGraphic(new javafx.scene.shape.Rectangle(15, 15, memento.rec1color));
                    } else if (description.contains("rectangle 2")) {
                        // Show color of rectangle 2
                        setGraphic(new javafx.scene.shape.Rectangle(15, 15, memento.rec2color));
                    } else if (description.contains("rectangle 3")) {
                        // Show color of rectangle 3
                        setGraphic(new javafx.scene.shape.Rectangle(15, 15, memento.rec3color));
                    } else if (description.contains("Animation toggle")) {
                        // Show checkbox status for animation toggle
                        javafx.scene.control.CheckBox checkBox = new javafx.scene.control.CheckBox();
                        checkBox.setSelected(memento.checkboxStatus);
                        checkBox.setDisable(true);  // Make it non-interactive
                        setGraphic(checkBox);
                    } else if (description.contains("Reset colors")) {
                        // For reset, show a row of three small rectangles with their colors
                        javafx.scene.layout.HBox hbox = new javafx.scene.layout.HBox(2);
                        hbox.getChildren().addAll(
                            new javafx.scene.shape.Rectangle(10, 10, memento.rec1color),
                            new javafx.scene.shape.Rectangle(10, 10, memento.rec2color),
                            new javafx.scene.shape.Rectangle(10, 10, memento.rec3color)
                        );
                        setGraphic(hbox);
                    } else {
                        // Default case - no specific graphic
                        setGraphic(null);
                    }
                }
            }
        });
        
        // Bind the observable list to the ListView
        historyListView.setItems(historyItems);
    }

    /**
     * Adds a new state (Memento) to the history list at the top
     * 
     * @param item The Memento object to add to history
     */
    public void addToHistory(Memento item) {
        historyItems.add(0, item); // Add to the top of the list (most recent first)
    }

    /**
     * Removes a specific item from the history
     * 
     * @param item The Memento object to remove from history
     */
    public void clearHistory(Memento item) {
        historyItems.remove(item);
    }

    /**
     * Returns the observable list of history items
     * 
     * @return Observable list of Memento objects
     */
    public ObservableList<Memento> getHistoryItems() {
        return historyItems;
    }

    /**
     * Event handler for when a user selects a history item to restore
     * Restores the application state to the selected Memento
     */
    @FXML
    private void goToSelectedState() {
        Memento selectedMemento = historyListView.getSelectionModel().getSelectedItem();
        if (selectedMemento != null && primaryController != null) {
            // Call back to the main controller to restore this state
            primaryController.goToState(selectedMemento);
            System.out.println("Going to state: " + selectedMemento.getDesc());
        } else if (selectedMemento != null) {
            System.out.println("Primary controller not available. Selected: " + selectedMemento.getDesc());
        }
    }
    
    /**
     * Sets the reference to the primary controller to enable state restoration
     * 
     * @param controller Reference to the main controller
     */
    public void setPrimaryController(PrimaryController controller) {
        this.primaryController = controller;
    }

    /**
     * Event handler for closing the history window
     */
    @FXML
    private void closeWindow() {
        // Get the stage from any component and close it
        javafx.stage.Stage stage = (javafx.stage.Stage) historyListView.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Refreshes the history list view to ensure proper display
     * Useful after modifications to the underlying data
     */
    public void refreshHistory() {
        historyListView.refresh();
    }
}
