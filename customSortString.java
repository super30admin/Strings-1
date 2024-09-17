// TC: O(n) why actually O(n + m) → n = len(s) m=len(order string) → but m worst case can be all 26characters or ascii string of 256 characters so its considered constant
// SC-O(1) →lower case characters

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //iterate on order and append those characters in result
        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int k=0; k < count; k++){
                    result.append(c);
                }
                map.remove(c);
            }
        }
        //append remaining characters from s in result
        for(Character c: map.keySet()){
            int count = map.get(c);
            for(int k=0; k < count; k++){
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
