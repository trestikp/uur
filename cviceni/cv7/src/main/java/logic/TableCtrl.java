package logic;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import javafx.util.converter.BooleanStringConverter;
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

        /*
            Init columns
         */
        TableColumn<MyFont, String> nameCol = new TableColumn<>("Name");
        TableColumn<MyFont, Color> colorCol = new TableColumn<>("Color");
        TableColumn<MyFont, Emphasis> emphasisCol = new TableColumn<>("Emphasis");
        TableColumn<MyFont, Integer> sizeCol = new TableColumn<>("Size");
        TableColumn<MyFont, Boolean> visibilityCol = new TableColumn<>("Visibility");
        TableColumn<MyFont, Text> previewCol = new TableColumn<>("Preview");

        /*
            Bind column values
         */
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
//        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        colorCol.setCellValueFactory(cellData -> cellData.getValue().colorProperty());
        emphasisCol.setCellValueFactory(new PropertyValueFactory<>("emphasis"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        visibilityCol.setCellValueFactory(new PropertyValueFactory<>("visibility"));
        previewCol.setCellValueFactory(cellData -> cellData.getValue().previewProperty());

        /*
            Make columns editable
         */
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        //Check if new font is in the system
        nameCol.setOnEditCommit(event -> {
            if(!Font.getFamilies().contains(event.getNewValue())) {
                tableView.refresh();
                return;
            } else {
                tableView.getSelectionModel().getSelectedItem().nameProperty().set(event.getNewValue());
            }
        });

        colorCol.setCellFactory(event -> new ColorPickerCell());
        emphasisCol.setCellFactory(ComboBoxTableCell.forTableColumn(Emphasis.values()));
        visibilityCol.setCellFactory(ComboBoxTableCell.forTableColumn(new BooleanStringConverter(),
                                                                      new Boolean[]{true, false}));
        //IntegerStringConverter doesn't handle NumberFormatException
        sizeCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object.toString();
            }

            @Override
            public Integer fromString(String string) {
                int current = tableView.getSelectionModel().getSelectedItem().getSize();
                try {
                    int val = Integer.parseInt(string);

                    if(val <= 0) {
                        return current;
                        //dialog or something?
                    }

                    return val;
                } catch (NumberFormatException e) {
                    return current;
                }
            }
        }));

//        sizeCol.setOnEditCommit(event -> tableView.refresh());

        /*
            ContextMenu for "Adding" (Copying) and removing items
         */
        tableView.setRowFactory(param -> {
            TableRow<MyFont> row = new TableRow<>();

            row.contextMenuProperty().set(createContextMenu());

            return row;
        });

        /*
            Add columns and data
         */
        tableView.setEditable(true);
        tableView.getColumns().addAll(nameCol, colorCol, emphasisCol, sizeCol, visibilityCol, previewCol);
        tableView.setItems(data);
    }

    private ContextMenu createContextMenu() {
        ContextMenu cm = new ContextMenu();
        MenuItem copy = new MenuItem("Copy entry");
        MenuItem delete = new MenuItem("Remove entry");

        copy.setOnAction(event -> {
            MyFont item = tableView.getSelectionModel().getSelectedItem();
            int index = tableView.getSelectionModel().getSelectedIndex();

            try {
                data.add(index + 1, item.clone());
            } catch (CloneNotSupportedException e) {
                //again dialog or something would be nice there
                return;
            }
        });

        delete.setOnAction(event -> {
            MyFont item = tableView.getSelectionModel().getSelectedItem();
            data.remove(item);
        });

        cm.getItems().addAll(copy, delete);

        return cm;
    }

    public void showInfo(ActionEvent actionEvent) {
        if(tableView.getSelectionModel().getSelectedItem() != null) {
//            infoLbl.setText(tableView.getSelectionModel().getSelectedItem().toString());
            int index = tableView.getSelectionModel().getSelectedIndex();
            infoLbl.setText(data.get(index).toString());
        } else {
            infoLbl.setText("No font selected");
        }
    }
}
