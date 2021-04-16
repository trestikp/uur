package logic;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.Emphasis;
import model.FontGenerator;
import model.MyFont;
import view.ColorPickerCell;

public class TableCtrl {

    @FXML
    protected Button infoBtn;
    @FXML
    protected Label infoLbl;
    @FXML
    protected TableView<MyFont> tableView;

    private final ObservableList<MyFont> data = FontGenerator.createData();

    @FXML
    public void initialize() {
        infoBtn.prefWidthProperty().bind(((HBox) infoBtn.getParent()).widthProperty().multiply(0.1));
        infoLbl.prefWidthProperty().bind(((HBox) infoLbl.getParent()).widthProperty().multiply(0.9));

        TableColumn<MyFont, String> nameCol = new TableColumn<>("Name");
        TableColumn<MyFont, Color> colorCol = new TableColumn<>("Color");
        TableColumn<MyFont, Emphasis> emphasisCol = new TableColumn<>("Emphasis");
        TableColumn<MyFont, Integer> sizeCol = new TableColumn<>("Size");
        TableColumn<MyFont, Boolean> visibilityCol = new TableColumn<>("Visibility");
        TableColumn<MyFont, String> previewCol = new TableColumn<>("Preview");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        emphasisCol.setCellValueFactory(new PropertyValueFactory<>("emphasis"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        visibilityCol.setCellValueFactory(new PropertyValueFactory<>("visibility"));

        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        colorCol.setCellFactory(col -> new ColorPickerCell());


        tableView.setEditable(true);
        tableView.getColumns().addAll(nameCol, colorCol, emphasisCol, sizeCol, visibilityCol, previewCol);
        tableView.setItems(data);
    }


    public void showInfo(ActionEvent actionEvent) {

    }
}
