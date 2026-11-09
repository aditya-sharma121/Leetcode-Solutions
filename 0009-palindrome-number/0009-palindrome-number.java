class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        return check(s,0,s.length()-1);
    }
    static boolean check(String s,int l,int r){
        if(l>=r){
            return true;
        }
        if(s.charAt(l)!=s.charAt(r)){
            return false;
        }
        return check(s,l+1,r-1);
    }
}