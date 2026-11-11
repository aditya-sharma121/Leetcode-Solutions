class Solution {
    public int search(int[] nums, int target) {
        return Binary(nums,target,0,nums.length-1);  
    }
    static int Binary(int[] nums,int target,int left,int right){
        if(left>right){
            return -1;
        }
        int mid = left+(right-left)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]>target){
            return Binary(nums,target,left,mid-1);
        }
        return Binary(nums,target,mid+1,right);
    }
}