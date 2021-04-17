package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FontGenerator {
    public static ObservableList<MyFont> createData() {
        ObservableList<MyFont> list = FXCollections.observableArrayList();

//        Font.getFamilies().forEach(e -> System.out.println(e.toString()));

        list.add(new MyFont("Arial", Color.BLACK, Emphasis.PLAIN, 24, true));
        list.add(new MyFont("Marlett", Color.BLACK, Emphasis.ITALIC, 12, true));
        list.add(new MyFont("Serif", Color.RED, Emphasis.BOLD, 16, true));
        list.add(new MyFont("Source Sans Pro", Color.BLACK, Emphasis.PLAIN, 15, true));
        list.add(new MyFont("Calibri", Color.ORANGE, Emphasis.PLAIN, 56, true));
        list.add(new MyFont("Calibri", Color.BLACK, Emphasis.PLAIN, 56, false));

        return list;
    }
}
