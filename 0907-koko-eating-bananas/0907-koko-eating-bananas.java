class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int pile : piles) high = Math.max(high, pile);

        while (low < high) {
            int mid = low + (high - low) / 2;
            int hours = 0;

            for (int pile : piles)
                hours += (pile + mid - 1) / mid; // same as ceil(pile / mid)

            if (hours <= h)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}
