class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128]; 
        int res = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(index[c], left);
            res = Math.max(res, right - left + 1);
            index[c] = right + 1;
        }
        return res;
    }
}