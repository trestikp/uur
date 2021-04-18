package view;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.TableCell;
import javafx.scene.paint.Color;
import model.MyFont;

public class ColorPickerCell extends TableCell<MyFont, Color> {
    ColorPicker picker;

    public ColorPickerCell() {
        picker = new ColorPicker();

        this.itemProperty().bindBidirectional(picker.valueProperty());

        picker.setOnAction(event -> {
            System.out.println("Action");
            this.commitEdit(picker.getValue());
//            this.setItem(picker.getValue());
            this.getTableView().refresh();
        });

        setGraphic(picker);
    }

    @Override
    protected void updateItem(Color item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            picker.setValue(item);
        }
    }

    @Override
    public void commitEdit(Color newValue) {
        super.commitEdit(newValue);

        System.out.println("Commit " + newValue.toString());
    }
}
