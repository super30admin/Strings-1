// TC: O(n)
// SC: O(n) -> converting string builder to string

// 1: We use a HashMap to store the values of String s
// 2: Then, using the String order, if the character is present in the map, we append to stringbuilder
// 3: At the end, if there are any left over characters in the hashmap, they are iterated over and appended to the stringbuilder
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, freq + 1);
        }
        for(int i =0;i<order.length();i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                int freq = map.get(ch);
                for(int j=0;j<freq;j++){
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }
        if(map.size() != 0){
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                int freq = entry.getValue();
                for(int i=0;i<freq;i++){
                    sb.append(entry.getKey());
                }
            }
        }
        return sb.toString();
    }
}