package by.mazets.textparser.composite;
import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private static final String TABULATION = "\t";
    private static final String SPACE = " ";
    private final TextComponentType type;
    private final List<TextComponent> textComponents = new ArrayList<>();

    public TextComposite(TextComponentType textComponentType) {
        this.type = textComponentType;
    }

    @Override
    public void add(TextComponent textComponent) {
        this.textComponents.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
        this.textComponents.remove(textComponent);
    }

    @Override
    public List<TextComponent> getComponents() {
        return this.textComponents;
    }

    @Override
    public TextComponent getComponent(int index) {
        return this.textComponents.get(index);
    }

    @Override
    public TextComponentType getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextComposite that = (TextComposite) o;

        if (type != that.type) {
            return false;

        }
        return textComponents.equals(that.textComponents);
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + textComponents.hashCode();
        return result;
    }

   @Override
   public String toString() {
       StringBuilder builder = new StringBuilder();
       for (TextComponent textComponent : textComponents) {
           switch (textComponent.getType()) {

               case PARAGRAPH:
                   builder.append(TABULATION);
                   break;

               case SENTENCE:
                   builder.append(SPACE);
                   break;

           }
           builder.append(textComponent.toString().trim());
       }
       return builder.toString();
   }
}
