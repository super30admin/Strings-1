// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+ 1);
        }

        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int freq = map.get(c);
                for(int k=0; k< freq; k++)
                    result.append(c);
                map.remove(c);
                
            }
        }

        for(char key: map.keySet()){
            int freq = map.get(key);
            for(int k=0; k< freq; k++)
                result.append(key);
        }

        return result.toString();

    }
}