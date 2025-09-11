package com.assignment11;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Primary controller class that implements the Memento pattern for state management.
 * This controller manages a UI with three colored rectangles that can be customized
 * and animated, with undo/redo functionality.
 */
public class PrimaryController implements Initializable {

    // UI Elements injected from FXML
    @FXML
    private Rectangle rectangle1;
    @FXML
    private Rectangle rectangle2;
    @FXML
    private Rectangle rectangle3;
    @FXML
    private ColorPicker colorPicker1;
    @FXML
    private ColorPicker colorPicker2;
    @FXML
    private ColorPicker colorPicker3;
    @FXML
    private CheckBox animationCheckBox;

    // Core components for application functionality
    private Timeline animation;        // Controls the color cycling animation
    private State state;               // Current state of the application
    private Stack<Memento> undoStack = new Stack<>();  // History of states for undo
    private Stack<Memento> redoStack = new Stack<>();  // History of undone states for redo
    
    // List to keep track of open history controllers
    private List<HistoryController> openHistoryControllers = new ArrayList<>();

    /**
     * Initializes the controller after FXML elements are injected.
     * Sets up initial state, color values, and animation.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize state with default colors
        state = new State();
        state.setRec1color(Color.RED); 
        state.setRec2color(Color.GREEN);
        state.setRec3color(Color.BLUE); 
        state.setCheckboxStatus(false);

        // Initialize color pickers with default colors
        colorPicker1.setValue(Color.RED);
        colorPicker2.setValue(Color.GREEN);
        colorPicker3.setValue(Color.BLUE);

        // Setup the animation for color cycling
        setupAnimation();

        // Save initial state to history
        saveState("Initial state");

        // Setup keyboard shortcuts (Ctrl+Z, Ctrl+Y) when scene is available
        rectangle1.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                setupKeyboardShortcuts(newScene);
            }
        });
    }

    /**
     * Opens a new history window that displays the action history.
     * The history window allows direct navigation to previous states.
     */
    @FXML
    private void openHistoryWindow() {
        try {
            // Load the FXML file for history view
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("history.fxml"));
            javafx.scene.Parent root = loader.load();

            // Get the controller for the history view
            HistoryController controller = loader.getController();

            // Pass the history items to the controller
            controller.getHistoryItems().addAll(undoStack);
            
            // Set reference to this primary controller for state restoration
            controller.setPrimaryController(this);
            
            // Add this controller to our list for real-time updates
            openHistoryControllers.add(controller);

            // Create a new stage for the history window
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Action History");
            stage.setScene(new javafx.scene.Scene(root));
            stage.setResizable(true);
            
            // Remove controller from list when window is closed
            stage.setOnCloseRequest(event -> {
                openHistoryControllers.remove(controller);
            });

            // Show the stage
            stage.show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Configures the animation that cycles colors between rectangles.
     */
    private void setupAnimation() {
        animation = new Timeline(
                new KeyFrame(Duration.millis(500), e -> {
                    // Cycle through colors by rotating them between rectangles
                    Color color1 = rectangle1.getFill() instanceof Color ? (Color) rectangle1.getFill() : Color.RED;
                    Color color2 = rectangle2.getFill() instanceof Color ? (Color) rectangle2.getFill() : Color.GREEN;
                    Color color3 = rectangle3.getFill() instanceof Color ? (Color) rectangle3.getFill() : Color.BLUE;

                    rectangle1.setFill(color2);
                    rectangle2.setFill(color3);
                    rectangle3.setFill(color1);

                    // Update color pickers to match rectangle colors
                    colorPicker1.setValue((Color) rectangle1.getFill());
                    colorPicker2.setValue((Color) rectangle2.getFill());
                    colorPicker3.setValue((Color) rectangle3.getFill());

                    // Update internal state to match UI
                    updateStateColors();
                }));
        animation.setCycleCount(Timeline.INDEFINITE);
    }

    /**
     * Changes the color of rectangle 1 based on color picker selection.
     */
    @FXML
    private void changeColor1() {
        rectangle1.setFill(colorPicker1.getValue());
        updateStateColors();
        saveState("Changed rectangle 1 " );
    }

    /**
     * Changes the color of rectangle 2 based on color picker selection.
     */
    @FXML
    private void changeColor2() {
        rectangle2.setFill(colorPicker2.getValue());
        updateStateColors();
        saveState("Changed rectangle 2 " );
    }

    /**
     * Changes the color of rectangle 3 based on color picker selection.
     */
    @FXML
    private void changeColor3() {
        rectangle3.setFill(colorPicker3.getValue());
        updateStateColors();
        saveState("Changed rectangle 3 " );
    }

    /**
     * Toggles the animation on/off based on checkbox state.
     */
    @FXML
    private void toggleAnimation() {
        if (animationCheckBox.isSelected()) {
            animation.play();
        } else {
            animation.stop();
        }
        state.setCheckboxStatus(animationCheckBox.isSelected());
        saveState("Animation toggle: " + (animationCheckBox.isSelected() ? "on" : "off"));
    }

    /**
     * Resets all rectangles to their default colors.
     */
    @FXML
    private void resetColors() {
        // Reset to initial colors
        rectangle1.setFill(Color.RED);
        rectangle2.setFill(Color.GREEN);
        rectangle3.setFill(Color.BLUE);

        colorPicker1.setValue(Color.RED);
        colorPicker2.setValue(Color.GREEN);
        colorPicker3.setValue(Color.BLUE);

        state.setRec1color(Color.RED);
        state.setRec2color(Color.GREEN);
        state.setRec3color(Color.BLUE);

        saveState("Reset colors");
    }

    /**
     * Updates the internal state object with current rectangle colors.
     */
    private void updateStateColors() {
        state.setRec1color((Color) rectangle1.getFill());
        state.setRec2color((Color) rectangle2.getFill());
        state.setRec3color((Color) rectangle3.getFill());
    }

    /**
     * Saves the current state to the undo stack with a description.
     * Clears the redo stack since a new action invalidates previous redos.
     *
     * @param description Text description of the state change
     */
    private void saveState(String description) {
        Memento memento = state.createMemento(description);
        undoStack.push(memento);
        redoStack.clear(); // Clear redo stack when new action is performed
        
        // Update all open history windows in real-time
        updateAllHistoryWindows();
    }

    /**
     * Undoes the last action by restoring the previous state.
     * The current state is moved to the redo stack.
     */
    public void undo() {
        if (undoStack.size() <= 1) {
            System.out.println("Nothing to undo!");
            return;
        }

        // Save current state to redo stack
        Memento currentState = undoStack.pop();
        redoStack.push(currentState);

        // Restore previous state
        Memento previousState = undoStack.peek();
        state.restoreMementoState(previousState);
        applyStateToUI();
        
        // Update all open history windows
        updateAllHistoryWindows();
    }

    /**
     * Redoes a previously undone action by restoring the state from the redo stack.
     */
    public void redo() {
        if (redoStack.empty()) {
            System.out.println("Nothing to redo!");
            return;
        }

        // Get state to redo
        Memento redoState = redoStack.pop();
        undoStack.push(redoState);

        // Apply the state
        state.restoreMementoState(redoState);
        applyStateToUI();
        
        // Update all open history windows
        updateAllHistoryWindows();
    }

    /**
     * Applies the current state to the UI elements.
     */
    private void applyStateToUI() {
        // Update rectangle colors
        rectangle1.setFill(state.getRec1color());
        colorPicker1.setValue(state.getRec1color());

        rectangle2.setFill(state.getRec2color());
        colorPicker2.setValue(state.getRec2color());

        rectangle3.setFill(state.getRec3color());
        colorPicker3.setValue(state.getRec3color());

        // Update animation checkbox state
        animationCheckBox.setSelected(state.isCheckboxStatus());
        if (state.isCheckboxStatus()) {
            animation.play();
        } else {
            animation.stop();
        }
    }

    /**
     * Clears the redo stack.
     */
    public void clearRedo() {
        redoStack.clear();
    }

    /**
     * Sets up keyboard shortcuts for undo (Ctrl+Z) and redo (Ctrl+Y).
     *
     * @param scene The JavaFX scene to attach event handlers to
     */
    public void setupKeyboardShortcuts(javafx.scene.Scene scene) {
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown()) {
                switch (event.getCode()) {
                    case Z:
                        System.out.print("Undo pressed");
                        undo();
                        event.consume();
                        break;
                    case Y:
                        System.out.print("Redo pressed");
                        redo();
                        event.consume();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    /**
     * Restores the application to a specific historical state.
     * Used by the history window to jump to a specific point in time.
     *
     * @param memento The state to restore
     */
    public void goToState(Memento memento) {
        // Clear all actions after this state
        while (!undoStack.isEmpty() && !undoStack.peek().equals(memento)) {
            Memento removed = undoStack.pop();
            redoStack.push(removed);
        }

        // Apply the selected state
        state.restoreMementoState(memento);
        applyStateToUI();
        
        // Update all open history windows
        updateAllHistoryWindows();
    }
    
    /**
     * Updates all open history windows with the current state of the undo stack.
     * This ensures all history views stay in sync with the latest changes.
     */
    private void updateAllHistoryWindows() {
        // Update each open history controller with the current undo stack
        for (HistoryController controller : openHistoryControllers) {
            // Clear existing items and add current undo stack
            javafx.application.Platform.runLater(() -> {
                controller.getHistoryItems().clear();
                controller.getHistoryItems().addAll(undoStack);
                controller.refreshHistory();
            });
        }
    }
}
