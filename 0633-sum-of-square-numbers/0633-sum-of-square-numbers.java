class Solution {
    public boolean judgeSquareSum(int c) {
      HashSet<Integer> set = new HashSet<>();
       set.add(0);
       int limit = (int)Math.sqrt(c);
       for(int i=0;i<=limit;i++){
        set.add(i*i);
        if(set.contains(c-(i*i))) return true;
       } 
       return false;
    }
}
