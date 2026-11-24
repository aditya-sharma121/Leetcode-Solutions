class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long prod = 1;
            long lcm = 1;
            int g = 0;
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                g = gcd(g, nums[j]);
                lcm = lcm(lcm, nums[j]);
                if (prod == (long) g * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }
                if (prod > 25200) break;
            }
        }
        return ans;
    }
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    long lcm(long a, long b) {
        return a / gcd((int)a, (int)b) * b;
    }
}