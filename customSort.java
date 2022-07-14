class Solution {
  //TC:O(n) SC:O(1) 
    public String customSortString(String order, String s) {
     HashMap<Character, Integer> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);    
            if(map.containsKey(ch))
                map.put(ch,map.get(ch)+1);
            else
                map.put(ch,1);
        }
        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            if(map.containsKey(c)){
               int  count=map.get(c);
                while(count>0){
                    sb.append(c);
                    count--;
                    if(count==0)map.remove(c);
                }
            }
            
        }
        for(char c:map.keySet()){
                int count=map.get(c);
           while(count>0){
                    sb.append(c);
                    count--;
                    
                }
    }

        return sb.toString();}
}
