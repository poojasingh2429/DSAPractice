class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        int n = nums.length;

        // Step 1: Place each number at its correct index
        while (i < n) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        // Step 2: Find duplicate and missing number
        for (int index = 0; index < n; index++) {
            if (nums[index] != index + 1) {
                // nums[index] is duplicate, index+1 is missing
                return new int[]{nums[index], index + 1};
            }
        }

        // If nothing found (edge case)
        return new int[]{-1, -1};
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
