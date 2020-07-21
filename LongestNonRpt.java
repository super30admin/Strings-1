Executed in leetcode- failing for all same chars

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        int result= Integer.MIN_VALUE;
        if(s==null || s.isEmpty()) return 0;
        if(s.length()==1) return 1;
        int sp=0; int fp=0;
        boolean check=true; int ct;
        while(fp<s.length()){
            char c= s.charAt(fp);
            if(fp==s.length()-1){
                result =Math.max(result,fp-sp+1);
            }
            if(map.containsKey(c)){
                sp= map.get(c)+1;
                result =Math.max(result,fp-sp+1);
            }
            map.put(c,fp);
            fp++;
        }
      
        return result;
    }
}
