class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map= new HashMap<>();
        int max=0;
        int a=0;
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(map.containsKey(c)){
                a= Math.max(a, map.get(c));
            }
              map.put(c, i+1);
            max= Math.max(max, i-a+1);
        }
        return max;
    }
}
//Time complexity- O(n)
// Space complexity- O(n)