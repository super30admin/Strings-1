class Solution {
    public String customSortString(String S, String T) {
        StringBuilder str = new StringBuilder();
        HashMap<Character, Integer> hmap = new HashMap<>();
        
        // hashmap to store character frequencies of 'T'
        for(char ch: T.toCharArray())
        {
            hmap.put(ch, hmap.getOrDefault(ch,0)+1);
        }
        // Adding the pattern in the stringbuilder object -result
        for(char ch: S.toCharArray()){
            int freq = hmap.getOrDefault(ch,0);
            while(freq>0)
            {
                str.append(ch);
                freq--;
            }
            hmap.remove(ch); // This keeps only charctaers absent in the pattern
        }
        // Adding the remaining characters in result
        for(Map.Entry<Character, Integer> entry: hmap.entrySet()){
            int freq = entry.getValue();
            char ch = entry.getKey();
            while(freq>0)
            {
                str.append(ch);
                freq--;
            }
        }
        
        return str.toString();
    }
}

// TC- O(# charcaters in S and T) since we go over the characters in S that may not be present in T eg- S- "cbafg", T-"abcd"
// SC- O(# characters in T)
