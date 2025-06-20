//Time : O(n)
//Space: O(1) hashmap max size - 256 chars
class Solution {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int res=0;
        int slow=0;

        for(int i=0;i<s.length();i++){

            char c=s.charAt(i);

            if(map.containsKey(c)){
                slow=Math.max(slow, map.get(c)+1);
            }
            map.put(c,i);
            res=Math.max(res, i-slow+1);
        }
        return res;
    }
}