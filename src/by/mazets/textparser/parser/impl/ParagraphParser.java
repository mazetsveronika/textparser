package by.mazets.textparser.parser.impl;

import by.mazets.textparser.composite.TextComponent;
import by.mazets.textparser.composite.TextComponentType;
import by.mazets.textparser.composite.TextComposite;
import by.mazets.textparser.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends BaseParser {
    private static final ParagraphParser instance = new ParagraphParser();

    private static final Logger logger = LogManager.getLogger();

    public static final String SENTENCE_REGEX = "[^.!?]+[.!?]{1,3}";

    private ParagraphParser() {
    }

    public static ParagraphParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) {
        logger.info("Start parse paragraphs : \n {}", text);
        setNext(SentenceParser.getInstance());

        TextComponent paragraphComposite = new TextComposite(TextComponentType.PARAGRAPH);
        TextComponent sentenceComposite;
        Matcher matcher = Pattern.compile(SENTENCE_REGEX).matcher(text);
        List<String> sentences = new ArrayList<>();
        while (matcher.find()) {
            String sentenceString = matcher.group();
            String sentenceStringTrim = sentenceString.trim();
            sentences.add(sentenceStringTrim);
        }
        for (String sentence : sentences) {
            sentenceComposite = parseNext(sentence);
            paragraphComposite.add(sentenceComposite);
        }
        logger.info("End parse paragraphs : \n {}", paragraphComposite);
        return paragraphComposite;
    }
}