package test.mazets.main.textparser.parser;

import by.mazets.textparser.parser.impl.ParagraphParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ParagraphParserTest {
    private ParagraphParser parser;
    private final static String FILEPATH = "data/test/parser/paragraph.txt";

    @BeforeClass
    public void setUp() {
        parser = ParagraphParser.getInstance();
            }

    @Test
    public void parseTestValid() {
        int expectedSentences = 1;
        int actualSentences = parser.parse(FILEPATH).getComponents().size();
        assertEquals(actualSentences, expectedSentences);
    }

    @Test
    public void parseTestInvalid() {
        int expectedSentences = 7;
        int actualSentences = parser.parse(FILEPATH).getComponents().size();
        assertNotEquals(actualSentences, expectedSentences);
    }

    @AfterClass
    public void tierDown() {
        parser = null;
    }
}