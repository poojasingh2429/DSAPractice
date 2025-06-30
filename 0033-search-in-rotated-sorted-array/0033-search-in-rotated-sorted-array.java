public class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;  // target in left part
                } else {
                    start = mid + 1;  // target in right part
                }
            }
            // Otherwise, right half is sorted
            else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;  // target in right part
                } else {
                    end = mid - 1;  // target in left part
                }
            }
        }

        return -1;
    }
}
