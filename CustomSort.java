class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map= new HashMap<>();
        StringBuilder stri = new StringBuilder();
        for (int i=0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else  map.put(s.charAt(i),1);
        }
        for(int i=0; i < order.length(); i++){
            if(map.containsKey(order.charAt(i))){
                int val= map.get(order.charAt(i));
                for(int j=0; j< val; j++){
                     stri.append(order.charAt(i)); 
                }
              map.remove(order.charAt(i));
            }
        }
        for(Map.Entry ele : map.entrySet() ){
            for(int i=0; i< (int)ele.getValue(); i++){
                     stri.append(ele.getKey()); 
                }
        }
        return stri.toString();
    }
}
// Time Complexity: O(s+n)
// Space complexity: O(s)