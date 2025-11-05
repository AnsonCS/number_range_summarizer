package numberrangesummarizer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplement();

        // String input = "w, e, r,1,3,6,7,8, t, p, -, 9,10,10,10,12,13,14,15,21,22,23,24,31";
        String input = "1,3,6,7,8,29,10,98, 43, 22 ,12,13,14,15,21,22,23,24,31";
        Collection<Integer> collected = summarizer.collect(input);
        String summary = summarizer.summarizeCollection(collected);

        System.out.println("Input: " + input);
        System.out.println("Collected: " + collected);
        System.out.println("Summary: " + summary);
    }
}
