package com.example.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 * Dialog window for displaying generated Java code.
 * Allows users to view and copy the pixel art code for use in other programs.
 */
public class CodeDisplayDialog {
    
    /**
     * Shows a dialog with the generated code that users can copy and paste.
     * @param code The Java code to display
     * @param parentStage The parent stage for modal positioning
     */
    public static void showCodeDialog(String code, Stage parentStage) {
        // Create new stage for the dialog
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(parentStage);
        dialog.setTitle("Generated Java Code");
        dialog.setResizable(true);
        
        // Create layout
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        
        // Add instruction label
        Label instructionLabel = new Label("Copy and paste this code into your Java program:");
        instructionLabel.setStyle(
            "-fx-font-size: 14px; " +
            "-fx-font-weight: bold; " +
            "-fx-text-fill: #333333;"
        );
        
        // Create text area for code display
        TextArea codeArea = new TextArea(code);
        codeArea.setEditable(false); // Make it read-only
        codeArea.setPrefRowCount(12); // Show about 12 lines
        codeArea.setPrefColumnCount(40); // Width for the code
        codeArea.setWrapText(false); // Don't wrap text
        codeArea.setStyle(
            "-fx-font-family: 'Consolas', 'Monaco', 'Courier New', monospace; " +
            "-fx-font-size: 12px; " +
            "-fx-background-color: #f8f8f8; " +
            "-fx-border-color: #cccccc; " +
            "-fx-border-width: 1px;"
        );
        
        // Select all text for easy copying
        codeArea.selectAll();
        
        // Create buttons
        Button copyButton = new Button("Copy to Clipboard");
        copyButton.setStyle(
            "-fx-font-size: 12px; " +
            "-fx-padding: 8px 16px; " +
            "-fx-background-color: #4CAF50; " +
            "-fx-text-fill: white; " +
            "-fx-border-radius: 3px; " +
            "-fx-background-radius: 3px;"
        );
        
        Button closeButton = new Button("Close");
        closeButton.setStyle(
            "-fx-font-size: 12px; " +
            "-fx-padding: 8px 16px; " +
            "-fx-background-color: #757575; " +
            "-fx-text-fill: white; " +
            "-fx-border-radius: 3px; " +
            "-fx-background-radius: 3px;"
        );
        
        // Button event handlers
        copyButton.setOnAction(e -> {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(code);
            clipboard.setContent(content);
            
            // Provide feedback
            copyButton.setText("Copied!");
            copyButton.setStyle(
                "-fx-font-size: 12px; " +
                "-fx-padding: 8px 16px; " +
                "-fx-background-color: #2E7D32; " +
                "-fx-text-fill: white; " +
                "-fx-border-radius: 3px; " +
                "-fx-background-radius: 3px;"
            );
            
            // Reset button text after 2 seconds
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    javafx.application.Platform.runLater(() -> {
                        copyButton.setText("Copy to Clipboard");
                        copyButton.setStyle(
                            "-fx-font-size: 12px; " +
                            "-fx-padding: 8px 16px; " +
                            "-fx-background-color: #4CAF50; " +
                            "-fx-text-fill: white; " +
                            "-fx-border-radius: 3px; " +
                            "-fx-background-radius: 3px;"
                        );
                    });
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        });
        
        closeButton.setOnAction(e -> dialog.close());
        
        // Create button container
        VBox buttonContainer = new VBox(10);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.getChildren().addAll(copyButton, closeButton);
        
        // Add all components to layout
        layout.getChildren().addAll(
            instructionLabel,
            codeArea,
            buttonContainer
        );
        
        // Create and show scene
        Scene scene = new Scene(layout, 500, 400);
        dialog.setScene(scene);
        
        // Center on parent
        if (parentStage != null) {
            dialog.setX(parentStage.getX() + (parentStage.getWidth() - 500) / 2);
            dialog.setY(parentStage.getY() + (parentStage.getHeight() - 400) / 2);
        }
        
        dialog.showAndWait();
    }
}