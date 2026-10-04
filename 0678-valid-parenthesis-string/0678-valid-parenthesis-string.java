class Solution {
    public boolean checkValidString(String s) {
        int a=0,b=0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                a++;
                b++;
            }
            else if(ch == ')'){
                a--;
                b--;
            }
            else{
                a--;
                b++;
            }
            if(b<0){
                return false;
            }
            a = Math.max(a,0);
        }  
        return a==0;
    }
}