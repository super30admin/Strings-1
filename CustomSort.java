// TC - o(n) 
// SC - o(1)
public class CustomSort {
    public String customSortString(String order, String s) {
        if ( s == null || s.length() == 0){
            return "" ;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i =0 ; i < s.length(); i ++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for ( int i =0 ; i < order.length(); i ++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int times = map.get(c);
                for( int j =0 ; j < times ; j ++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for (char c: map.keySet()){
            int times = map.get(c);
            for (int i =0 ; i < times; i ++){
                sb.append(c);
            }
        }
        return sb.toString();
        
    }
}
