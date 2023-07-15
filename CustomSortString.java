class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<order.length();i++){
            if(map.containsKey(order.charAt(i))){
                int count = map.get(order.charAt(i));
                while(count>0){
                    sb.append(order.charAt(i));
                    count--;
                }
                map.remove(order.charAt(i));
            }
        }
        for(char c:map.keySet()){
            int count = map.get(c);
            while(count>0){
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}