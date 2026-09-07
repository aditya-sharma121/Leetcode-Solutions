class Solution {
    public int finalValueAfterOperations(String[] operations) {
      int X = 0;
      for(int i=0;i<operations.length;i++){
        String s = operations[i];
        if(s.contains("++")){
            X++;
        }else{
            X--;
        }
      }
      return X;
    }
}