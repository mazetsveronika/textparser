package by.mazets.textparser.parser;

import by.mazets.textparser.composite.TextComponent;

public abstract class BaseParser {
    private BaseParser next;

    public void setNext(BaseParser next) {
        this.next = next;
    }

    public abstract TextComponent parse(String text);

    protected TextComponent parseNext(String text) {
        return next.parse(text);
    }
}