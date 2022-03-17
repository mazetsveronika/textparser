package by.mazets.textparser.parser.impl;

import by.mazets.textparser.composite.TextComponent;
import by.mazets.textparser.composite.TextComponentType;
import by.mazets.textparser.composite.TextComposite;
import by.mazets.textparser.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser extends BaseParser {
    private static final TextParser instance = new TextParser();

    private static final Logger logger = LogManager.getLogger();

    private static final String TABULATION_REGEX = "\\t";
    private static final String NEW_LINE_REGEX = "\\n";

    private TextParser() {
    }

    public static TextParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) {
        logger.info("Start parse text : \n {}", text);
        setNext(ParagraphParser.getInstance());

        TextComponent paragraphComposite;
        TextComponent textComposite = new TextComposite(TextComponentType.TEXT);
        String[] paragraphs = text.split(NEW_LINE_REGEX);
        for (String element : paragraphs) {
            element = element.replace(TABULATION_REGEX, "");
            element = element.replace("    ", "");
            paragraphComposite = parseNext(element);
            textComposite.add(paragraphComposite);
        }
        logger.info("End parse text : \n {}", textComposite);
        return textComposite;
    }
}