public class AnagramTool {

    public static void main(String[] args) {
        System.out.println(AnagramTool.minRemovedToBeAnagram("bcadeh", "hea")); // 3
        System.out.println(AnagramTool.minRemovedToBeAnagram("cddgk", "gcd")); // 2
        System.out.println(AnagramTool.minRemovedToBeAnagram("bca", "acb")); // 0
    }

    public static int minRemovedToBeAnagram(String a, String b) {
        // http://www.geeksforgeeks.org/remove-minimum-number-characters-two-strings-become-anagram/
        // 26 Characters in the Alphabet
        // Assuming inputs are lower cased
        int[] data = new int[26];
        int total = 0;
        for(char x : a.toCharArray()) {
            data[x - 'a']++;
        }

        for(char x : b.toCharArray()) {
            data[x - 'a']++;
        }

        for(int y : data) {
            total += y % 2;
        }

        return total;
    }
}
