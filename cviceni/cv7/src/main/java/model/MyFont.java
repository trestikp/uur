package model;

import javafx.beans.property.*;
import javafx.scene.paint.Color;

public class MyFont {

    private final StringProperty name = new SimpleStringProperty();
    private final ObjectProperty<Color> color = new SimpleObjectProperty<>();
    private final ObjectProperty<Emphasis> emphasis = new SimpleObjectProperty<>();
    private final IntegerProperty size = new SimpleIntegerProperty();
    private final BooleanProperty visibility = new SimpleBooleanProperty();

    public MyFont(String name, Color color, Emphasis emphasis, int size, boolean visibility) {
        this.name.set(name);
        this.color.set(color);
        this.emphasis.set(emphasis);
        this.size.set(size);
        this.visibility.set(visibility);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public Emphasis getEmphasis() {
        return emphasis.get();
    }

    public ObjectProperty<Emphasis> emphasisProperty() {
        return emphasis;
    }

    public int getSize() {
        return size.get();
    }

    public IntegerProperty sizeProperty() {
        return size;
    }

    public boolean isVisibility() {
        return visibility.get();
    }

    public BooleanProperty visibilityProperty() {
        return visibility;
    }
}