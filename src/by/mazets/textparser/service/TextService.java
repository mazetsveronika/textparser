package by.mazets.textparser.service;
import by.mazets.textparser.composite.Component;

import java.util.Map;

public interface TextService {
    Component sortParagraphsByQuantitySentences(Component textComposite);
    Component findSentenceContainsLongestWord(Component textComposite);
    Component removeSentencesContainWordsLessNumber(Component textComposite, int number);
    Map<String, Integer> findQuantitySameWordsWithoutRegister(Component textComposite);
}