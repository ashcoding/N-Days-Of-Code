//https://leetcode.com/problems/two-sum/#/description
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                return new int[] {map.get(compliment),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] x = sol.twoSum(new int[]{2,7,11,15}, 9);
        for(int y : x) {
            System.out.println("Num:"+y);
        }
    }
}
