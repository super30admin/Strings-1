//Time complexity:O(n)
//Space:O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
         Map<Character,Integer> map=new HashMap();
        int max=0;
        int j=0;
        int i=0;
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))){
                i=Math.max(map.get(s.charAt(j))+1,i);
            }
            map.put(s.charAt(j),j);
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}