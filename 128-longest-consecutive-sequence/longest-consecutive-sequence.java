import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // Store all elements in HashSet
        }

        int longest = 0;

        for (int num : set) {
            // Check if it's the start of a sequence
            if (!set.contains(num - 1)) { 
                int currentNum = num;
                int currentStreak = 1;

                // Expand the sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }
}
