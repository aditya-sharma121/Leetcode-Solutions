class Solution {
    public int[] searchRange(int[] nums, int target) {
         int first = firstindex(nums,target);
         int last =  lastindex(nums,target);
         return new int[]{first,last};
    }
    public int firstindex(int[]nums,int target){
        int start = 0;
        int end = nums.length-1;
        int ans =-1;
        while(start<=end){
            int mid = start+ (end-start)/2;
            if(nums[mid]==target){
               ans = mid;
               end = mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
            return ans;
        }
        public int lastindex(int[]nums,int target){
        int start = 0;
        int end = nums.length-1;
        int ans =-1;
        while(start<=end){
            int mid = start+ (end-start)/2;
            if(nums[mid]==target){
               ans = mid;
               start = mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
            return ans;
    }
}