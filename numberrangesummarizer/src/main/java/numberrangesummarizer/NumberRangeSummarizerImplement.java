package numberrangesummarizer;

import java.util.*; 
import java.util.stream.*;

public class NumberRangeSummarizerImplement implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        if (input == null || input.trim().isEmpty()){
            return Collections.emptyList();
        }

        List<Integer> numbers = new ArrayList<>();

        Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .forEach(s -> {
                    try {
                        numbers.add(Integer.parseInt(s));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format skipped: \"" + s + "\"");
                    }
                });
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        List<Integer> sortedList = input.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        StringBuilder results = new StringBuilder();
        int start = sortedList.get(0);
        int end = start;

        for (int i = 1; i < sortedList.size(); i++) {
            int current = sortedList.get(i);
            if (current == end + 1) {
                end = current;
            } else {
                appendRange(results, start, end);
                start = current;
                end = current;
            }
        }
        appendRange(results, start, end);

        return results.toString();
    }

    private void appendRange(StringBuilder sb, int start, int end) {
        if (sb.length() > 0) {
            sb.append(",");
        }
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start).append("-").append(end);
        }
    }
}
