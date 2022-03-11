package test.mazets.main.textparser.parser;


import by.mazets.textparser.parser.impl.TextParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TextParserTest {
    private TextParser parser;
    private final static String FILEPATH = "data/test/parser/text.txt";

    @BeforeClass
    public void setUp() {
        parser = TextParser.getInstance();
            }

    @Test
    public void parseTestValid() {
        int expectedParagraphs = 1;
        int actualParagraphs = parser.parse(FILEPATH).getComponents().size();
        assertEquals(actualParagraphs, expectedParagraphs);
    }

    @Test
    public void parseTestInvalid() {
        int expectedParagraphs = 2;
        int actualParagraphs = parser.parse(FILEPATH).getComponents().size();
        assertNotEquals(actualParagraphs, expectedParagraphs);
    }

    @AfterClass
    public void tierDown() {
        parser = null;
    }
}