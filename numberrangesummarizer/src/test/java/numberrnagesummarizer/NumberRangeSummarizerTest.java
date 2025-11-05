package numberrnagesummarizer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import numberrangesummarizer.*;

public class NumberRangeSummarizerTest {
    @Test
    void testSummarizeCollection() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplement();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> collected = summarizer.collect(input);
        String summary = summarizer.summarizeCollection(collected);
        assertEquals("1,3,6-8,12-15,21-24,31", summary);
    }

    @Test 
    void testInvalidInput() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplement();
        String input = "a,b,c,1,2,3";
        Collection<Integer> collected = summarizer.collect(input);
        String summary = summarizer.summarizeCollection(collected);
        assertEquals("1-3", summary);
    }

    @Test 
    void unsortedInput() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplement();
        String input = "5, 3, 4, 9, 11, 2, 1, 18";
        Collection<Integer> collected = summarizer.collect(input);
        String summary = summarizer.summarizeCollection(collected);
        assertEquals("1-5,9,11,18", summary);
    }
}
