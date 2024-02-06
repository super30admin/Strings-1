class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n= s.length();
        int left=0;
        int right=0;
        int max=0;
       
        while(right<n){
            char c= s.charAt(right);
            if(map.containsKey(c)){
                left=Math.max(left, map.get(c)+1);
            }
            map.put(c,right);
            max=Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
}