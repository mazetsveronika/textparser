package by.mazets.textparser.comporator;

import by.mazets.textparser.composite.Component;

import java.util.Comparator;

public class QuantitySentencesComparator implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
        return o1.getComponents().size()-o2.getComponents().size();
    }
}