public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                for(int k=0;k<count;k++){
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }
        for(char c:map.keySet()){
            int count = map.get(c);
            for(int k=0;k<count;k++){
                sb.append(c);
            }
        }
    return sb.toString();
    }
}

// TC - O(n)
// SC - O(1)