import java.util.*;

public class Week02 {
    static void checkPinLength(String pin) {
        if (pin.length() != 4 || !pin.matches("\\d{4}")) System.out.println("Invalid PIN — must be exactly 4 digits.");
        else System.out.println("PIN length OK.");
    }

    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ", -1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(new StringBuilder(words[i]).reverse());
            if (i < words.length - 1) result.append(' ');
        }
        return result.toString();
    }

    static void parseInventoryRecord(String line) {
        String[] fields = line.split(",", -1);
        if (fields.length != 3) { System.out.println("Invalid Record"); return; }
        System.out.println("Product: " + fields[0].trim() + " | SKU: " + fields[1].trim() + " | Qty: " + fields[2].trim());
    }

    static String normalizeCode(String raw) {
        String code = raw.trim();
        if (code.length() < 3) return code.toUpperCase();
        return code.substring(0, 3).toUpperCase() + code.substring(3);
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: code must be exactly 13 characters";
        for (int i = 0; i < 3; i++) if (!Character.isLetter(code.charAt(i))) return "Invalid: publisher code must be 3 letters";
        for (int i = 3; i < 13; i++) if (!Character.isDigit(code.charAt(i))) return "Invalid: code body must contain 10 digits";
        StringBuilder out = new StringBuilder();
        out.append("[").append(code.substring(0, 3)).append("] YEAR: 20")
           .append(code.substring(3, 7)).append(" | CATALOG: ").append(code.substring(7));
        return out.toString();
    }

    static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "").replace("!", "").replace("?", "");
        String[] stop = {"the", "was", "and", "a", "is", "of", "in"};
        Map<String, Integer> counts = new HashMap<>();
        for (String word : cleaned.split("\\s+")) {
            word = word.replaceAll("^[^a-z0-9]+|[^a-z0-9]+$", "");
            if (word.isEmpty()) continue;
            boolean skip = false;
            for (String s : stop) if (s.equals(word)) { skip = true; break; }
            if (!skip) counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        List<String> words = new ArrayList<>(counts.keySet());
        words.sort((a, b) -> Integer.compare(counts.get(b), counts.get(a)));
        for (String word : words) System.out.println(word + ": " + counts.get(word));
    }

    public static void main(String[] args) {
        checkPinLength("4820");
        System.out.println(reverseEachWord("hello club"));
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        System.out.println(validateAndFormat(normalizeCode(" pen2026004251 ")));
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
