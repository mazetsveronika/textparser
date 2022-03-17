package by.mazets.textparser.composite;

import java.util.List;

public interface TextComponent {
    void add(TextComponent textComponent);
    void remove(TextComponent textComponent);
    List<TextComponent> getComponents();
    TextComponent getComponent(int index);
    TextComponentType getType();
}
