package logic;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import model.NodeType;
import model.TreeNode;
import view.TreeNodeCell;

public class TreeCtrl {

    @FXML
    protected TreeView<TreeNode> treeView;


    @FXML
    public void initialize() {
        TreeNode root = new TreeNode("Virtual root", NodeType.DIR);
        TreeNode etc = new TreeNode("etc", NodeType.DIR);
        TreeNode usr = new TreeNode("usr", NodeType.DIR);
        TreeNode lib = new TreeNode("lib", NodeType.DIR);
        TreeNode jvm = new TreeNode("jvm", NodeType.DIR);
        TreeNode etc_fstab = new TreeNode("fstab", NodeType.FILE);
        TreeNode etc_resolv = new TreeNode("resolv", NodeType.FILE);
        TreeNode hacked = new TreeNode("Hacked", NodeType.FILE);

        TreeItem<TreeNode> rootItem = new TreeItem<>(root);
        /*--*/TreeItem<TreeNode> etcItem = new TreeItem<>(etc);
        /*-- --*/TreeItem<TreeNode> fstabItem = new TreeItem<>(etc_fstab);
        /*-- --*/TreeItem<TreeNode> resolvItem = new TreeItem<>(etc_resolv);
        /*--*/TreeItem<TreeNode> usrItem = new TreeItem<>(usr);
        /*--*/TreeItem<TreeNode> libItem = new TreeItem<>(lib);
        /*-- --*/TreeItem<TreeNode> jvmItem = new TreeItem<>(jvm);
        /*--*/TreeItem<TreeNode> hackedItem = new TreeItem<>(hacked);

        //noinspection unchecked
        rootItem.getChildren().addAll(etcItem, usrItem, libItem, hackedItem);
        //noinspection unchecked
        etcItem.getChildren().addAll(fstabItem, resolvItem);
        libItem.getChildren().add(jvmItem);

        treeView.setEditable(true);
        treeView.setRoot(rootItem);
        treeView.setCellFactory(e -> new TreeNodeCell());
    }
}
