// Time Complexity : O(m+n) , //m=length of string, n= length of order
// Space Complexity :O(1)
class Solution {
    public String customSortString(String order, String s) {
        if(order==null || order.length()==0 || s==null || s.length()==0) return s;
        HashMap<Character,Integer> hm=new HashMap<>();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        
        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            
            if(hm.containsKey(c)){
            int j=hm.remove(c);
            
            for(int p=0;p<j;p++){
                res.append(c);
            }
            }
        }
        
        for(char key:hm.keySet()){
            int cnt=hm.get(key);
            while(cnt>0){
                res.append(key);
                cnt--;
            }
        }
        
        return res.toString();
    }
}