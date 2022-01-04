//time o(n)
//soace o(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int length = 0;
        int longest = 0;
        int lastRepIndex = -1;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(map.containsKey(c)) {
                // int lastOccurance = map.get(c);
                // length = i - lastOccurance;
                // longest = Math.max(length, longest);
                // map.put(c, i);
                int lastOccurance = map.get(c);
                int min = Math.max(lastOccurance, lastRepIndex);
                length = i - min;
                map.put(c, i);
                lastRepIndex = min;
                longest = Math.max(length, longest);
            } else {
                map.put(c, i);
                length += 1;
                longest = Math.max(length, longest);
            }
        }
        
        return longest;
    }
}
