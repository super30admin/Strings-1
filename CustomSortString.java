class CustomSortString {
    // Time complexity O(n)
    // Space complexity O(1)
    // Tested in leetcode
    
    public String customSortString(String S, String T) {
        // A constant space storage for storing charaters of target array
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        // loop over the target array and store the charcters and its number of occurences into hashmap 
        for(char c : T.toCharArray()){
            map.put(c, map.getOrDefault(c,0) +1);
        }
        
        // use the sequence of charater from the given reference string S 
        // and form permutauion of string using characters of target array
        for(char c : S.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int i=0; i<count; i++)
                    sb.append(c);
                map.remove(c);
            }
        }
        
        // add the leftover characters from the target string into output string 
        for(char c :map.keySet()){
             for(int i=0; i<map.get(c); i++)
                    sb.append(c);
        }
        
        return sb.toString();
    }
}