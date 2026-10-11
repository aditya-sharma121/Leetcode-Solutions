class Solution {
    public int[] plusOne(int[] nums) {
      for(int i=nums.length-1;i>=0;i--){
        if(nums[i]<9){
            nums[i]++;
            return nums;
        }else{
              nums[i] =0;
        }
      }
            int[] res = new int[nums.length+1];
            res[0] = 1;
            return res;
    }
}