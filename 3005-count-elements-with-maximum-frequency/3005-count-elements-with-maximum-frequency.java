class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0;
        int totalMaxFreq = 0;
        for (int num : nums) {
            freq[num]++;
            int currentFreq = freq[num];
            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                totalMaxFreq = currentFreq; 
            } else if (currentFreq == maxFreq) {
                totalMaxFreq += maxFreq;  
            }
        }
        return totalMaxFreq;
    }
}