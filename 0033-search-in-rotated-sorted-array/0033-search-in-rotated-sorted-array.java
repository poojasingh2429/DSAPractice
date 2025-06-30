public class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // If pivot is -1, the array is not rotated
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // If pivot is the target
        if (nums[pivot] == target) {
            return pivot;
        }

        // If target is in the left sorted part
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        // If target is in the right sorted part
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    // Binary search helper function
    int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // Find pivot: index where rotation happens
    int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // 4 cases
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
