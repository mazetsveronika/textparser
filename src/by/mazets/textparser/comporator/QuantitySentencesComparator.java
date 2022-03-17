package by.mazets.textparser.comporator;

import by.mazets.textparser.composite.TextComponent;

import java.util.Comparator;

public class QuantitySentencesComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return o1.getComponents().size()-o2.getComponents().size();
    }
}