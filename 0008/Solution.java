import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int longest = 0;
        int i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < n && j < n) {

            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                longest = Math.max(longest, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Expected 3 - Ans " + sol.lengthOfLongestSubstring("dvdf"));
        System.out.println("Expected 1 - Ans " + sol.lengthOfLongestSubstring("c"));
        System.out.println("Expected 3 - Ans " + sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Expected 1 - Ans " + sol.lengthOfLongestSubstring("bbbbb"));
        System.out.println("Expected 3 - Ans " + sol.lengthOfLongestSubstring("pwwkew"));
        // https://leetcode.com/problems/longest-substring-without-repeating-characters/tabs/description

    }
}
