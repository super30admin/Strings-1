//Time complexity: o(n)
// space complexity: o(n)


class Solution {
    public String customSortString(String order, String str) {
        StringBuilder sb = new StringBuilder();
        if(str == null || str.length() == 0)  return sb.toString();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i =0; i< str.length(); i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i< order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count !=0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        for(char c: map.keySet()){
            int count = map.get(c);
            while(count!= 0){
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
        
    }
}
