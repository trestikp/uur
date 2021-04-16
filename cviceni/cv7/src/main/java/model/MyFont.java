package model;

import javafx.beans.property.*;
import javafx.scene.paint.Color;

public class MyFont {

    private StringProperty name = new SimpleStringProperty();
    private ObjectProperty<Color> color = new SimpleObjectProperty<>();
    private ObjectProperty<Emphasis> emphasis = new SimpleObjectProperty<>();
    private IntegerProperty size = new SimpleIntegerProperty();
    private BooleanProperty visibility = new SimpleBooleanProperty();

    private MyFont(String name, Color color, Emphasis emphasis, int size, boolean visibility) {
        this.name.set(name);
        this.color.set(color);
        this.emphasis.set(emphasis);
        this.size.set(size);
        this.visibility.set(visibility);
    }
}