class Solution {
    public int maxArea(int[] height) {
       int max = 0;
        int a = 0;
        int b = height.length-1;
        while(a<b){
            int h = Math.min(height[a],height[b]);
            int w = b-a;
            int area = h*w;
            max = Math.max(max,area);
            if(height[a]<height[b]){
                a++;
            }else{
                b--;
            }
        }
        return max;
    }
}