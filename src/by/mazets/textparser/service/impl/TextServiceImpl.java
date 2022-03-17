package by.mazets.textparser.service.impl;

import by.mazets.textparser.comporator.QuantitySentencesComparator;
import by.mazets.textparser.composite.TextComponent;
import by.mazets.textparser.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextServiceImpl implements TextService {
    private static final TextServiceImpl instance = new TextServiceImpl();

    private static final Logger logger = LogManager.getLogger();

    private static final String PUNCTUATION_REPLACE_REGEX = "[^1-9a-zA-Z-_]";

    private TextServiceImpl() {
    }

    public static TextServiceImpl getInstance() {
        return instance;
    }

    @Override
    public TextComponent sortParagraphsByQuantitySentences(TextComponent textComposite) {
        logger.info("Start to sort paragraphs by quantity of sentences : \n {}", textComposite);
        List<TextComponent> paragraphs = textComposite.getComponents();
        paragraphs.sort(new QuantitySentencesComparator());
        logger.info("Sorted paragraphs by quantity of sentences : \n {}", textComposite);
        return textComposite;
    }

    @Override
    public TextComponent findSentenceContainsLongestWord(TextComponent textComposite) {
        logger.info("Start to find sentence contain longest word : \n {}", textComposite);
        TextComponent resultSentence = null;
        String longestWord = "";
        for (TextComponent paragraphs : textComposite.getComponents()) {
            for (TextComponent sentence : paragraphs.getComponents()) {
                for (TextComponent lexeme : sentence.getComponents()) {
                    String lexemeWord = lexeme.toString();
                    String lexemeWordPunctuationReplaced =
                            lexemeWord.replaceAll(PUNCTUATION_REPLACE_REGEX, "");
                    if (longestWord.length() < lexemeWordPunctuationReplaced.length()) {
                        longestWord = lexemeWordPunctuationReplaced;
                        resultSentence = sentence;
                    }
                }
            }
        }
        logger.info("Found sentence contain longest word : {}", resultSentence);
        return resultSentence;
    }

    @Override
    public TextComponent removeSentencesContainWordsLessNumber(TextComponent textComposite, int number) {
        logger.info("Start to remove sentence, which contain words less number : {} : \n {}",
                number,
                textComposite);
        for (TextComponent paragraph : textComposite.getComponents()) {
            List<TextComponent> sentences = paragraph.getComponents();
            for (int i = 0; i < paragraph.getComponents().size(); i++) {
                if (sentences.get(i).getComponents().size() < number) {
                    paragraph.remove(sentences.get(i));
                    i--;
                }
            }
        }
        logger.info("Removed sentence, which contain words less number : {} : {}",number, textComposite);
        return textComposite;
    }

    @Override
    public Map<String, Integer> findQuantitySameWordsWithoutRegister(TextComponent textComposite) {
        logger.info("Start to find quantity same words without register : \n {}", textComposite);
        Map<String, Integer> result = new HashMap<>();
        int quantity;

        for (TextComponent paragraph : textComposite.getComponents()) {
            for (TextComponent sentence : paragraph.getComponents()) {
                for (TextComponent lexeme : sentence.getComponents()) {
                    String lexemeWord = lexeme.toString();
                    String lexemeWordPunctuationReplaced =
                            lexemeWord.replaceAll(PUNCTUATION_REPLACE_REGEX, "");
                    quantity = 0;
                    if (!result.containsKey(lexemeWordPunctuationReplaced)) {
                        for (TextComponent paragraphN : textComposite.getComponents()) {
                            for (TextComponent sentenceN : paragraphN.getComponents()) {
                                for (TextComponent lexemeN : sentenceN.getComponents()) {
                                    String lexemeWordN = lexemeN.toString();
                                    String lexemeWordPunctuationReplacedN =
                                            lexemeWordN.replaceAll(PUNCTUATION_REPLACE_REGEX, "");

                                    if (lexemeWordPunctuationReplacedN.equalsIgnoreCase(lexemeWordPunctuationReplaced)) {
                                        quantity++;
                                    }
                                }
                            }
                        }
                        if (quantity > 1) {
                            result.put(lexemeWordPunctuationReplaced, quantity);
                        }
                    }
                }
            }
        }
        logger.info("Found quantity same words without register : {}", result);
        return result;
    }
}