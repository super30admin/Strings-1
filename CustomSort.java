// time -O(n)
//space - O(1)

class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }
        
        for( int j = 0; j< order.length(); j++){
            char c = order.charAt(j);
            int count = map.getOrDefault(c,0);
            while(count!=0){
                sb.append(c);
                count--;
            }
            map.remove(c);
        }
        
        for(char key : map.keySet()){
            int count = map.get(key);
            while(count!=0){
                sb.append(key);
                count--;
            }
        }
        return sb.toString();
    }
}