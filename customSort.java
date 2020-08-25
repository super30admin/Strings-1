// Time Complexity : O(m + n) where m is the length of the string S and n is the length of the string T
// Space Complexity : O(1) 

class Solution {
    public String customSortString(String S, String T) {
    HashMap<Character, Integer> map = new HashMap<>(); 
        for(int i = 0; i < T.length(); i++)
        {
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);// create a hashmap storing charaters and their count.
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++)
        {
            char c = S.charAt(i);
            while(map.containsKey(c))
            {
                int count = map.get(c);
                if(count == 0)
                    map.remove(c);
                else {
                    sb.append(c);
                    map.put(c, count - 1); //append the character to o/p string until count is 0.
                }
            }
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            int val = entry.getValue();
            while(val != 0) {
                sb.append(entry.getKey());
                val--;
            }
        }
        return sb.toString();
    }
}