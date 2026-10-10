import java.util.*;

public class Week05 {
    static void applyMultipliers(double[] scores, int captainIndex, int viceCaptainIndex) {
        scores[captainIndex] *= 2.0; scores[viceCaptainIndex] *= 1.5;
    }
    static String findDuplicatePick(String[] names) {
        for (int i = 0; i < names.length; i++)
            for (int j = i + 1; j < names.length; j++)
                if (names[i].equals(names[j])) return "Duplicate Found: " + names[i];
        return "No Duplicates Found";
    }
    static String findMinMaxSpread(int[] scores) {
        int min = scores[0], max = scores[0];
        for (int score : scores) { if (score < min) min = score; if (score > max) max = score; }
        return "Min: " + min + " | Max: " + max + " | Spread: " + (max - min);
    }
    static double rowAverage(int[] row) {
        if (row.length == 0) return 0.0;
        int sum = 0; for (int value : row) sum += value;
        return (double) sum / row.length;
    }
    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            if (i > 0) result.append(" | ");
            result.append("Match ").append(i).append(": ").append(rowAverage(runsPerOver[i]) >= threshold ? "Power Surge" : "Normal");
        }
        return result.toString();
    }

    static class Player implements Comparable<Player> {
        String name; int matchesPlayed; double battingAverage; boolean injured;
        Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name; this.matchesPlayed = matchesPlayed; this.battingAverage = battingAverage; this.injured = injured;
        }
        static boolean isDraftable(int matchesPlayed) { return matchesPlayed >= 10; }
        static boolean isDraftable(int matchesPlayed, boolean injured) { return matchesPlayed >= 5 && !injured; }
        public int compareTo(Player other) { return Double.compare(other.battingAverage, this.battingAverage); }
    }
    static String draftAndRank(Player[] players) {
        List<Player> draftable = new ArrayList<>();
        for (Player p : players) if (Player.isDraftable(p.matchesPlayed) || Player.isDraftable(p.matchesPlayed, p.injured)) draftable.add(p);
        Collections.sort(draftable);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.size(); i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(draftable.get(i).name);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        double[] scores = {40,55,30,62}; applyMultipliers(scores,1,3); System.out.println(Arrays.toString(scores));
        System.out.println(findDuplicatePick(new String[]{"Kohli","Bumrah","Kohli","Rohit"}));
        System.out.println(findMinMaxSpread(new int[]{45,82,79,90,33,90,61}));
        System.out.println(classifyMatches(new int[][]{{4,6,8},{10,12,14},{2,3,1}},8));
        System.out.println(draftAndRank(new Player[]{new Player("Virat",15,48,false),new Player("Rahul",7,55,false),new Player("Sameer",3,60,false),new Player("Dev",12,20,true)}));
    }
}
