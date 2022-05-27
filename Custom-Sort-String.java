//time - O(m+n) m-length of order, n - length of s
//space - O(1)
class Solution {
    public String customSortString(String order, String s) {
        if(order==null || order.length()==0) return s;
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<order.length(); i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                while(count > 0){
                    sb.append(ch);
                    count--;
                }
            }
            map.remove(ch);
        }

        for(char ch : map.keySet()){
            int count = map.get(ch);
            while(count > 0){
                sb.append(ch);
                count--;
            }
        }

        return sb.toString();
    }
}
