class Solution {
    public boolean canSortArray(int[] nums) {
       for(int i=0;i<nums.length-1;i++){
        if(nums[i]>nums[i+1]){
            int count1 = Integer.bitCount(nums[i]);
            int count2 = Integer.bitCount(nums[i+1]);
            if(count1!=count2){
                return false;
            }
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;

            i=-1;
        }
       }
        return true;
    }
}