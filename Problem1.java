

//Time complexity: O(s.length + order.length)
//Space complexity: O(s.length) we are using stringbuilder to store intermediate results

class Solution1 {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < len; i++ ) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int l = order.length();
        for(int i = 0; i < l; i++) {
            char c = order.charAt(i);
            if( map.containsKey(c) ) {
                int count = map.get(c);
                for(int j = 0; j < count; j++ ) {
                    result.append(c);
                }
                map.remove(c);
            }
        }

        for(Character ch: map.keySet() ) {
            int ct = map.get(ch);
            for(int k = 0; k < ct; k++ ) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
