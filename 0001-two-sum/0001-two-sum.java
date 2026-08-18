 class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int needs = target - nums[i];
            if(map.containsKey(needs)){
                return new int[]{map.get(needs),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}