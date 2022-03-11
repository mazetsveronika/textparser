package test.mazets.main.textparser.parser;
import by.mazets.textparser.parser.impl.SentenceParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SentenceParserTest {
    private SentenceParser parser;
    private final static String FILEPATH = "data/test/parser/sentence.txt";

    @BeforeClass
    public void setUp() {
        parser = SentenceParser.getInstance();

    }

    @Test
    public void parseTestValid() {
        int expectedLexeme = 1;
        int actualLexeme = parser.parse(FILEPATH).getComponents().size();
        assertEquals(actualLexeme, expectedLexeme);
    }

    @Test
    public void parseTestInvalid() {
        int expectedLexeme = 7;
        int actualLexeme = parser.parse(FILEPATH).getComponents().size();
        assertNotEquals(actualLexeme, expectedLexeme);
    }

    @AfterClass
    public void tierDown() {
        parser = null;
    }
}