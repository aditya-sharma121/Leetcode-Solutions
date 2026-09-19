class Solution {
    public String convertToBase7(int num) {
        if(num==0) return "0";
        boolean neg = false;
        while(num<0){
            neg = true;
            num = -num;
        }   
        String ans = "";
        while(num>0){
            int d = num%7;
            ans = d + ans;
            num = num/7;
        }
        if(neg) ans = "-" + ans;
        return ans;
    }
}