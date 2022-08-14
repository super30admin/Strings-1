
// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
public String customSortString(String order, String s) {
    if(order == null || order.length() == 0) return s;
    
    HashMap<Character,Integer> map = new HashMap<>();
    //storing all the char and its repeatation value in map
    for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
        map.put(c,map.getOrDefault(c,0)+1);
    }
    
    StringBuilder sb = new StringBuilder();
    //searching thru order and adding the number of times from hashmap
    for(int i=0;i<order.length();i++){
        char c = order.charAt(i);
        int cnt =0;
        if(map.containsKey(c)){
            cnt = map.get(c);
            while(cnt>0){
                sb.append(c);
                cnt--;
            }
            map.remove(c); // necesary to remove from map, because will need to addd remaining items at last
        }
    }
    
    for(char c: map.keySet()){
        int cnt = map.get(c);
        while(cnt>0){
            sb.append(c);
            cnt--;
        }
    }
    return sb.toString();
}