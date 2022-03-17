package by.mazets.textparser.composite;
import java.util.List;

public class TextLeaf implements TextComponent {
    public enum Type {
        PUNCTUATION, CHARACTER
    }

    private String content;
    private Type type;

    public TextLeaf(String symbol, Type type) {
        this.content = symbol;
        this.type = type;
    }

    @Override
    public TextComponentType getType() {
        return TextComponentType.SYMBOL;
    }

    @Override
    public void add(TextComponent textComponent) {
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public void remove(TextComponent textComponent) {
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public TextComponent getComponent(int index) {
        throw new UnsupportedOperationException("Method is not supported");
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextLeaf symbolTextLeaf1 = (TextLeaf) o;

        if (content.equals(symbolTextLeaf1.content)) {
            return false;
        }
        return type == symbolTextLeaf1.type;
    }

    @Override
    public int hashCode() {
        int result = Integer.parseInt(content);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return content;
    }
}