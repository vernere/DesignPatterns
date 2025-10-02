package com.example.commands;

import com.example.receivers.PixelGrid;
import com.example.gui.CodeDisplayDialog;
import javafx.stage.Stage;

/**
 * Command that generates and displays code representation of the PixelGrid.
 * Implements the Command pattern to encapsulate the code generation operation.
 * Shows the generated code in a dialog for easy copying.
 */
public class GenerateCodeCommand implements Command {
    /** The PixelGrid instance to generate code from */
    private PixelGrid pg;
    
    /** The parent stage for modal dialog positioning */
    private Stage parentStage;

    /**
     * Constructs a GenerateCodeCommand with the specified PixelGrid.
     * 
     * @param pg the PixelGrid to generate code from
     */
    public GenerateCodeCommand(PixelGrid pg){
        this.pg = pg;
        this.parentStage = null;
    }
    
    /**
     * Constructs a GenerateCodeCommand with the specified PixelGrid and parent stage.
     * 
     * @param pg the PixelGrid to generate code from
     * @param parentStage the parent stage for dialog positioning
     */
    public GenerateCodeCommand(PixelGrid pg, Stage parentStage){
        this.pg = pg;
        this.parentStage = parentStage;
    }

    /**
     * Executes the command by generating code and displaying it in a dialog.
     * Also prints to console for backup reference.
     */
    @Override
    public void execute() {
        // Print to console (existing functionality)
        pg.print();
        
        // Show in dialog for easy copying
        String code = pg.generateCode();
        CodeDisplayDialog.showCodeDialog(code, parentStage);
    }
}
