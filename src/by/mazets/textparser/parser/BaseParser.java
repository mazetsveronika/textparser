package by.mazets.textparser.parser;

import by.mazets.textparser.composite.Component;

public abstract class BaseParser {
    private BaseParser next;

    public void setNext(BaseParser next) {
        this.next = next;
    }

    public abstract Component parse(String text);

    protected Component parseNext(String text) {
        return next.parse(text);
    }
}