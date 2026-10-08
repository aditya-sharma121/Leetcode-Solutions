class Solution {
    public int minimumOperations(int[] nums) {
        int res=0;
        for(int num : nums){
            int r = num%3;
            if(r!=0){
                res += Math.min(r,3-r);
            }
        } 
        return res;
    }
}