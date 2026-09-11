class Solution {
    public int lengthOfLongestSubstring(String s) {
    int[] index = new int[128];
      int max=0;
      int left=0;
      for(int right=0;right<s.length();right++){
        char ch = s.charAt(right);
        left = Math.max(index[ch],left);
        max = Math.max(max,right-left+1);
        index[ch] = right+1;
      }  
      return max;
    }
}