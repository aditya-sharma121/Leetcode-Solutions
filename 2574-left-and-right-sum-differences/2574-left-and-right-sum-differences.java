class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
            int totalsum=0;
            int[] ans = new int[n];
            for(int  num : nums){
                totalsum += num;
        }
        int leftsum=0;
        for(int i=0;i<nums.length;i++){
            int rightsum = totalsum-leftsum-nums[i];
            ans[i] = Math.abs(leftsum-rightsum);
            leftsum += nums[i];
        }
        return ans;
    }
}
 