package by.mazets.textparser.parser.impl;

import by.mazets.textparser.composite.TextComponent;
import by.mazets.textparser.composite.TextComponentType;
import by.mazets.textparser.composite.TextComposite;
import by.mazets.textparser.composite.TextLeaf;
import by.mazets.textparser.parser.BaseParser;

import java.util.regex.Pattern;

public class LexemeParser extends BaseParser {
    private static final LexemeParser instance = new LexemeParser();
    private static final String LETTER_REGEX = "";
    private static final String PUNCTUATION_REGEX = "\\.{3}|[\\.,?!]";

    private LexemeParser() {
    }

    public static LexemeParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent lexemeComposite = new TextComposite(TextComponentType.LEXEME);
        TextLeaf symbolTextLeaf;

        String[] symbols = text.split(LETTER_REGEX);
        for (String element : symbols) {
            if (Pattern.matches(PUNCTUATION_REGEX, element)) {
                symbolTextLeaf = new TextLeaf(element, TextLeaf.Type.PUNCTUATION);
            } else {
                symbolTextLeaf = new TextLeaf(element, TextLeaf.Type.CHARACTER);
            }
            lexemeComposite.add(symbolTextLeaf);
        }

        return lexemeComposite;
    }
}