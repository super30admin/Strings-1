//Time Complexity: o(2n)
//Space Complexity: o(n)
/*Expln: sliding window over the string and record the longest substring 
 *by skipping over to the next char when you hit duplicates.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int val = 0;
        if(s.length() ==0) return val;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 1;
        map.put(s.charAt(i), i);
        val = j - i;
        for(; j<s.length(); j++)
        {
            if(map.containsKey(s.charAt(j)))
            {
                if(i <= map.get(s.charAt(j))){
                    i = map.get(s.charAt(j)) + 1;
                }
            }
            val = Math.max((j -i+1), val);
            map.put(s.charAt(j), j);
        }
        return val;
    }
}