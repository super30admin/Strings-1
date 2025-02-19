public class CustomSortString{
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0 || s == null || s.length()==0){
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        StringBuilder builder = new StringBuilder();

        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int i=0; i<count; i++){
                    builder.append(c);
                }
                map.remove(c);
            }
        }

        for(char c: map.keySet()){
            int count = map.get(c);
            for(int i=0; i<count; i++){
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
