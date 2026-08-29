 class Solution {
    public int lengthOfLastWord(String s) {
     int a = 0;
     for(int i=s.length()-1;i>=0;i--){
        if(s.charAt(i) != ' '){
            a++;
        }else if(a>0){
            break;
        }
     }     
     return a;
    }
}