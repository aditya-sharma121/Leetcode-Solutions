class Solution {
    public boolean checkDivisibility(int n) {
        int temp=n;
        int sum=0;
        int p=1;
      while(n>0){
        int d = n%10;
        sum +=d;
        p *= d;
        n = n/10;
      }  
      int total = temp%(sum+p);
       return total==0;
    }
}