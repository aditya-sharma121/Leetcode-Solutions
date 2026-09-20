class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String s : emails){
            String[] parts = s.split("@");
            String  local = parts[0];
            String domain = parts[1];
            local = local.split("\\+")[0];
            local = local.replace(".","");
            String res = local + "@" + domain;
            set.add(res);
        } 
        return set.size();
    }
}