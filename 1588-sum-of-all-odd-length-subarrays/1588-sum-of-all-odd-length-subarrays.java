class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum=0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            int a = (i+1)*(n-i);
            int odd = (a+1)/2;
            sum += arr[i]*odd;
        }  
        return sum;
    }
}