class Solution {
    public int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            int matches = n / 2;
            return matches + numberOfMatches(n / 2);
        } 
        else {
            int matches = (n - 1) / 2;
            return matches + numberOfMatches(((n - 1) / 2) + 1);
        }
    }
}
