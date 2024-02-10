//tc: o(m) where m is length of String s, SC: o(1)
class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb =new StringBuilder();
        if(s == null || s.length() == 0) return sb.toString();
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i = 0; i< order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                while(cnt>0){
                    sb.append(c);
                    cnt--;
                }
                map.remove(c);
            }
        }
        if(map.size()>0){
            for(char c : map.keySet()){
                int cnt = map.get(c);
                while(cnt>0){
                    sb.append(c);
                    cnt--;
                }
            }
        }
        return sb.toString();
    }
}
