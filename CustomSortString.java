// TC: O(n) 
// SC: O(1)

// Order is the order in which we need to return the permutation from the string 's'
// Create a frequency map of 's'
// Iterate over order, for every character in order, get all the occurences of that character 
// from the map and append it  to the string builder that many times.
// In the end there maybe some leftover characters which are not present in 'order'. Just add
// them to the string builder


class Solution {
    public String customSortString(String order, String s) {
        
        // frequency map of 's'
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        // Iterate over order and get the characters with frequencies into the stringbuilder
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            if(map.containsKey(c)){
                int count=map.get(c);
                for(int k=0;k<count;k++){
                    sb.append(c);
                }
                map.remove(c);
            }
            
        }
        
        for(char key:map.keySet()){
            int count=map.get(key);
                for(int k=0;k<count;k++){
                    sb.append(key);
                }
            
        }
        return sb.toString();
        
    }
}