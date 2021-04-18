package view;

import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.input.KeyCode;
import model.TreeNode;

public class TreeNodeCell extends TreeCell<TreeNode> {
    private TextField tf;

    @Override
    public void startEdit() {
        super.startEdit();

        if(tf == null) {
            tf = new TextField();

            tf.setOnKeyReleased(event -> {
                if(event.getCode() == KeyCode.ENTER) {
                    TreeNode nd = this.getItem();
                    nd.nameProperty().set(tf.getText());
                    commitEdit(nd);
                    setGraphic(null);
                }
            });
        }

        setText(null);
        tf.setText(this.getItem().getName());
        setGraphic(tf);
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setGraphic(null);
        //TODO format
        this.setText(this.getItem().getName());
    }

    @Override
    protected void updateItem(TreeNode item, boolean empty) {
        super.updateItem(item, empty);

        if(empty) {
            setText(null);
            setGraphic(null);
        } else {
            if(this.isEditing()) {
                if(tf != null) {
                    tf.setText(item.getName());
                    this.setText(null);
                    setGraphic(tf);
                }
            } else {
                this.setText(item.getName());
            }
        }
    }
}