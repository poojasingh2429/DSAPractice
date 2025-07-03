public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Target found
            if (nums[mid] == target) {
                return true;
            }

            // If duplicates are at start, mid, and end — just skip them
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }

            // Left half is sorted
            else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;  // target lies in left half
                } else {
                    start = mid + 1;
                }
            }

            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;  // target lies in right half
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }
}
