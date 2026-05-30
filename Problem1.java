class Problem1 {
    public String customSortString(String order, String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<s.length();i++) {
            char ch = s.charAt(i);
            map.put(s.charAt(i), map.getOrDefault(ch,0)+1);
        }

        for(int i = 0 ; i<order.length();i++) {
            char ch = order.charAt(i);
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                for(int j = 0; j<count;j++){
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }

           for(char c : map.keySet()){
            int cnt = map.get(c);
            for(int k=0; k<cnt; k++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
