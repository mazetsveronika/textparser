package by.mazets.textparser.service;
import by.mazets.textparser.composite.TextComponent;

import java.util.Map;

public interface TextService {
    TextComponent sortParagraphsByQuantitySentences(TextComponent textComposite);
    TextComponent findSentenceContainsLongestWord(TextComponent textComposite);
    TextComponent removeSentencesContainWordsLessNumber(TextComponent textComposite, int number);
    Map<String, Integer> findQuantitySameWordsWithoutRegister(TextComponent textComposite);
}