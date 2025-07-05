public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // total flowers required
        long totalFlowersNeeded = (long) m * k;
        if (totalFlowersNeeded > bloomDay.length) return -1;

        int low = 1;
        int high = getMax(bloomDay);

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossible(bloomDay, m, k, mid)) {
                high = mid; // try smaller day
            } else {
                low = mid + 1; // need more days
            }
        }

        return low;
    }

    // Get maximum bloom day
    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    // Check if we can make m bouquets by day 'mid'
    private boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0; // reset after bouquet
                }
            } else {
                flowers = 0; // break streak
            }
        }

        return bouquets >= m;
    }
}
