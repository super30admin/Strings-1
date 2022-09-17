//Time Complexity: O(m+n)
//Space Complexity: O(1)

class Solution {
    public String customSortString(String order, String s) {
        if(order==null || order.length() == 0) return s;
        StringBuilder str = new StringBuilder();
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int j=0;j<order.length();j++){
            char c = order.charAt(j);
            int count =0;
            if(map.containsKey(c)){
                count=map.get(c);
                map.remove(c);
            }
            while(count>0){
                str.append(c);
                count--;
            }
            
        }
        for(char key: map.keySet()){
            int count =0;
            count=map.get(key);
            while(count>0){
                str.append(key);
                count--;
            }
           
        }
        return str.toString();
    }
}