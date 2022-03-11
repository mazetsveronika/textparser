package by.mazets.textparser.parser.impl;

import by.mazets.textparser.composite.Component;
import by.mazets.textparser.composite.ComponentType;
import by.mazets.textparser.composite.Composite;
import by.mazets.textparser.interpreter.TextInterpreter;
import by.mazets.textparser.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class SentenceParser extends BaseParser {
    public static final SentenceParser instance = new SentenceParser();

    private static final Logger logger = LogManager.getLogger();

    private static final String LEXEME_REGEX = " ";
    private static final String CONDITION_CALCULATION_REGEX = "\\p{N}+";

    private SentenceParser(){

    }

    public static SentenceParser getInstance(){
        return instance;
    }

    @Override
    public Component parse(String text) {
        logger.info("Start parse sentence : \n {}", text);
        setNext(LexemeParser.getInstance());

        Component sentenceComposite = new Composite(ComponentType.SENTENCE);
        Component lexemeComposite;
        String[] lexemes = text.split(LEXEME_REGEX);

        Pattern pattern = Pattern.compile(CONDITION_CALCULATION_REGEX);
        for (int i = 0; i < lexemes.length; i++) {
            if (pattern.matcher(lexemes[i]).find()) {
                lexemes[i] = TextInterpreter.convertExpression(lexemes[i]);
            }
        }

        for(String lexeme:lexemes){
            lexemeComposite = parseNext(lexeme);
            sentenceComposite.add(lexemeComposite);
        }
        logger.info("End parse sentence : \n {}", sentenceComposite);
        return sentenceComposite;
    }
}