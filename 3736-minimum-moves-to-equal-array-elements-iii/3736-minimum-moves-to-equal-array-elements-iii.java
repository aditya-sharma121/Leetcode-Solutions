class Solution {
    public int minMoves(int[] nums) {
        int max=0,ans=0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        for(int num: nums){
            int a = max-num;
            ans += Math.abs(a);
        }
        return ans;
    }
}