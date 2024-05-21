// TC: O(m+n)
// SC: Hashmap: O(1), StringBuilder: O(n)
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        StringBuilder result = new StringBuilder();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(int i=0;i< order.length();i++) {
            char c = order.charAt(i);

            if(map.containsKey(c)) {
                int freq = map.get(c);

                for(int j=0;j< freq;j++) {
                    result.append(c);
                }
                map.remove(c);
            }
        }

        for(char c: map.keySet()) {
            int freq = map.get(c);
            for(int i=0;i< freq;i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}