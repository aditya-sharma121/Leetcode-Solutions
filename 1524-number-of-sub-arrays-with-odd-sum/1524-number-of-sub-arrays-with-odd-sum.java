class Solution {
    public int numOfSubarrays(int[] arr) {
         int mod = 1000000007;
         long Odd=0,Even=1,sum=0;
         long ans=0;
         for(long num : arr){
            sum += num;
            if(sum%2==0){
                ans = (ans+Odd)%mod;
                Even++;
            }else{
                ans = (ans+Even)%mod;
                Odd++;
            }
         }
         return (int) ans;
    }
}