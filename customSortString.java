//TC - O(n+m);
//SC - O(n); n-length of order string;
//LC-791
class Solution {
    public String customSortString(String order, String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),0);
        }
        
        StringBuilder b = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else{
                b.append(s.charAt(i));
            }
        }
        
        for (int k=0;k<order.length();k++){
            for(int i=0;i<map.get(order.charAt(k));i++){
                b.append(order.charAt(k));
            }
        }
        
        return b.toString();
    }
}