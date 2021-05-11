/*

Thought Process: 
    1. First Create a HashMap to store the count of occurrence of each character of larger string.
    2. Loop through the custom sort string and add those chars with their count times into result and then remove those keys.
    3. Now we are left (int he hashmap) with only the chars which are not present on the custom sort string.
    4. We need to traverse them and add them with their count times to the result.
    
T.C -> O(S+T) -> S - length of String S and T - length of String T
S.C -> O(T) -> HashMap Size
*/

class Solution {
    public String customSortString(String S, String T) {
        String res = "";
        if(T == null || T.length() == 0) return res;
        
        Map<Character, Integer> m = new HashMap<>();
        
        for(Character c : T.toCharArray()){
            if(!m.containsKey(c))
                m.put(c,1);
            else
                m.put(c, m.get(c) + 1);
        }
        for(Character c: S.toCharArray()){
            int repeatCount = 0;
            if(m.containsKey(c)){
                repeatCount = m.get(c);
                m.remove(c);
            }
            while(repeatCount > 0){
                res += c.toString();
                repeatCount--;
            }
        }
        
        Iterator itr = m.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry mapElement = (Map.Entry)itr.next();
            Character c = (Character)mapElement.getKey();
            int repeatCount = (int)mapElement.getValue();
            
            while(repeatCount > 0){
                res += c.toString();
                repeatCount--;
            }
        }
        return res;
    }
}