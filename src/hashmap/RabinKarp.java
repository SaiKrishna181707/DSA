package hashmap;

public class RabinKarp {

    static void search(String text, String pattern) {

        int m = pattern.length();
        int n = text.length();

        double patternHash = hash(pattern);
        double textHash = hash(text.substring(0, m));

        for (int i = 0; i <= n - m; i++) {

            if (patternHash == textHash) {
                if (text.substring(i, i + m).equals(pattern)) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            if (i < n - m) {
                textHash = updateHash(text, textHash, i, i + m, m);
            }
        }
    }

    static double hash(String str) {
        double hash = 0;

        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(101, i);
        }

        return hash;
    }

    static double updateHash(String text,
                             double oldHash,
                             int oldIndex,
                             int newIndex,
                             int patternLength) {

        double newHash = oldHash - text.charAt(oldIndex);

        newHash /= 101;

        newHash += text.charAt(newIndex) * Math.pow(101, patternLength - 1);

        return newHash;
    }

    public static void main(String[] args) {

        String text = "ABCCDDAEFG";
        String pattern = "CDD";

        search(text, pattern);
    }
}
