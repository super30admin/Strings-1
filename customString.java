class Solution {
    //TC: O(m) ---> m length of string s
    //SC: O(1)
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                for(int k = 0; k < cnt; k++){
                    result.append(c);
                }
                map.remove(c);
            }
        }
        for(char c : map.keySet()){
            int cnt = map.get(c);
            for(int k = 0; k < cnt; k++){
                    result.append(c);
            }
            // map.remove(c);
        }
        return result.toString();
    }
}