class Solution {
    public boolean isAnagram(String s, String t) {
         int[] count1 = new int[26];
         for(char ch : s.toCharArray()){
            count1[ch-'a']++;
         }
         int[] count2 = new int[26];
         for(char ch : t.toCharArray()){
            count2[ch-'a']++;
         } 
         return Arrays.equals(count1,count2);
      }
    }