class Solution {
    public boolean isAnagram(String s, String t) {
        char[] a1 = t.toCharArray();
        char[] a2 = s.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1,a2);
      }
    }