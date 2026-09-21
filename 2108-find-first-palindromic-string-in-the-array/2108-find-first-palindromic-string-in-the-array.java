class Solution {
    public String firstPalindrome(String[] words) {
        for(String s : words){
            String  sb = new StringBuilder(s).reverse().toString();
            if(s.equals(sb)){
                return sb;
            }
        } 
        return "";
    }
}