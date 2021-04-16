package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import model.MyFont;

public class TableCtrl {

    @FXML
    protected Button infoBtn;
    @FXML
    protected Label infoLbl;
    @FXML
    protected TableView<MyFont> tableView;


    @FXML
    public void initialize() {
        infoBtn.prefWidthProperty().bind(((HBox) infoBtn.getParent()).widthProperty().multiply(0.1));
        infoLbl.prefWidthProperty().bind(((HBox) infoLbl.getParent()).widthProperty().multiply(0.9));


    }


    public void showInfo(ActionEvent actionEvent) {

    }
}
