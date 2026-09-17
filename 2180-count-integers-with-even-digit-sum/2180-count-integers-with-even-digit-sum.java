class Solution {
    public int countEven(int num) {
        int count=0;
        while(num>0){
        int n = num;
        int sum=0;
        while(n!=0){
            int d = n%10;
            sum += d;
             n = n/10;
        }  
        if(sum%2==0){
            count++;
    }
           num--;
 }
        return count;
    }
}