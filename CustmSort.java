class Solution {
    public String customSortString(String order, String s) {
        LinkedHashMap<Character,Integer> hm = new LinkedHashMap<Character,Integer>();
         for(int i=0;i<order.length();i++){
           hm.put(order.charAt(i),0);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            }else{
                sb = sb.append(s.charAt(i));
            }
        }
        
        for(char c : hm.keySet()){
            for(int i=0;i<hm.get(c);i++){
                sb = sb.append(c);
            }
        }
        String str = new String(sb);
        return str; 
    }
}
