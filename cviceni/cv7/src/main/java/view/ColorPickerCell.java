package view;

import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TableCell;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.MyFont;

public class ColorPickerCell extends TableCell<MyFont, Color> {
    ColorPicker picker;

    @Override
    public void startEdit() {
        super.startEdit();

        if(picker == null) {
             picker = new ColorPicker();

             Stage s = new Stage();
             VBox pane = new VBox();
             pane.getChildren().add(picker);
             s.setScene(new Scene(pane));
             s.show();

             //TODO
        } else {
            cancelEdit();
        }
    }
}
