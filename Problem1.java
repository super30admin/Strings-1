class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();i++){
            for(int j=0;j<map.getOrDefault(order.charAt(i),0);j++)
                sb.insert(sb.length(),order.charAt(i));
            map.remove(order.charAt(i));
        }

        for(char c:map.keySet()){
            for(int i=0;i<map.get(c);i++)
                sb.insert(sb.length(),c);
        }
        return sb.toString();

    }
}