class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxPile = piles[0];
        for (int i = 1; i < piles.length; i++) {
            maxPile = Math.max(piles[i], maxPile);
        }
        int k = 0;
        while (minSpeed < maxPile) {
            k = minSpeed + (maxPile - minSpeed) / 2;
            int sum = 0;
            for (int nBanana : piles) {
                sum += (nBanana / k) + (nBanana % k == 0 ? 0 : 1);
            }
            if (sum <= h) {
                maxPile = k;
            } else {
                minSpeed = k + 1; 
            }

        }
        return minSpeed;
    }
}
