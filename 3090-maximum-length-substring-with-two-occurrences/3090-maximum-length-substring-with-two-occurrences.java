class Solution {
    public int maximumLengthSubstring(String s) {
      int n = s.length();
      int res = 0;
      int[] f = new int[26];
      int l=0;
      for(int r=0;r<n;r++){
        f[s.charAt(r)-'a']++;

        while(f[s.charAt(r)-'a']>2){
            f[s.charAt(l)-'a']--;
            l++;
        }
        res = Math.max(res,r-l+1);
      }  
      return res;
    }
}