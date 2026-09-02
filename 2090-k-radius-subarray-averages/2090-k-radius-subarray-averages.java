class Solution {
    public int[] getAverages(int[] nums, int k) {
      int n = nums.length;
      int[] res = new int[n];  
      Arrays.fill(res,-1);
      long sum=0;
      int temp = k;
      int idx = 2*k+1;
      if(idx>n){
        return res;
      }
      for(int i=0;i<idx;i++){
        sum += nums[i];
      } 
      res[temp] = (int) (sum/idx);
      for(int i=idx;i<n;i++){
        sum = sum-nums[i-idx]+nums[i];
        res[++k] = (int) (sum/idx);
      }
      return res;
    }
}