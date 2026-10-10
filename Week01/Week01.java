import java.util.*;

public class Week01 {
    static void checkDuplicateSeats(int[] a) {
        boolean found = false;
        for (int i = 0; i < a.length; i++) {
            boolean alreadyPrinted = false;
            for (int k = 0; k < i; k++) if (a[k] == a[i]) alreadyPrinted = true;
            if (alreadyPrinted) continue;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) { System.out.println("Duplicate Seat Number Found: " + a[i]); found = true; break; }
            }
        }
        if (!found) System.out.println("No Duplicate Seats Found");
    }

    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0, first = -1;
        int n = Math.min(original.length(), typed.length());
        for (int i = 0; i < n; i++) {
            if (original.charAt(i) == typed.charAt(i)) matched++;
            else if (first == -1) first = i;
        }
        // Equal lengths are expected; counting missing/extra characters as mismatches is safer.
        int total = Math.max(original.length(), typed.length());
        double accuracy = total == 0 ? 100.0 : matched * 100.0 / total;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, total, accuracy);
        if (first == -1 && original.length() == typed.length()) System.out.println(" | No Mismatches");
        else {
            if (first == -1) first = n;
            String a = first < original.length() ? "'" + original.charAt(first) + "'" : "<missing>";
            String b = first < typed.length() ? "'" + typed.charAt(first) + "'" : "<missing>";
            System.out.println(" | First Mismatch at position " + (first + 1) + " (" + a + " vs " + b + ")");
        }
    }

    static void findLongestStreak(String log) {
        if (log.isEmpty()) { System.out.println("Empty signal log"); return; }
        char best = log.charAt(0), current = best;
        int bestCount = 1, count = 1;
        for (int i = 1; i < log.length(); i++) {
            if (log.charAt(i) == current) count++;
            else { current = log.charAt(i); count = 1; }
            if (count > bestCount) { bestCount = count; best = current; }
        }
        System.out.println("Longest Streak: '" + best + "' repeated " + bestCount + " times");
    }

    static void analyzeInventory(int[] a, int[] b) {
        int sumA = 0, sumB = 0, max = Integer.MIN_VALUE, maxIndex = -1;
        String section = "";
        for (int i = 0; i < a.length; i++) { sumA += a[i]; if (a[i] > max) { max = a[i]; maxIndex = i; section = "Section A"; } }
        for (int i = 0; i < b.length; i++) { sumB += b[i]; if (b[i] > max) { max = b[i]; maxIndex = i; section = "Section B"; } }
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                sumA, sumB, sumA == sumB ? "Balanced" : "Not Balanced", max, section, maxIndex + 1);
    }

    static void classifyWordLengths(String review) {
        int shortWords = 0, medium = 0, longWords = 0;
        for (String word : review.trim().split("\\s+")) {
            String cleaned = word.replaceAll("[^A-Za-z]", "");
            int len = cleaned.length();
            if (len == 0) continue;
            if (len <= 4) shortWords++; else if (len <= 8) medium++; else longWords++;
        }
        System.out.println("Short: " + shortWords + " | Medium: " + medium + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkTypingAccuracy("hello world", "hello worlt");
        findLongestStreak("RRGGGYRR");
        analyzeInventory(new int[]{20,15,30}, new int[]{25,10,30});
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
