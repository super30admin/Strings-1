//TIme Complexity: O(max(m,n))
//Space Complexity: O(1)
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<order.length();i++){
            if(map.containsKey(order.charAt(i))){
                for(int k=0;k<map.get(order.charAt(i));k++){
                    sb.append(order.charAt(i));
                }
                map.remove(order.charAt(i));
            }
        }
        
        for(char c:map.keySet()){
            for(int k=0;k<map.get(c);k++)
                sb.append(c);
        }
        return sb.toString();
    }
}
