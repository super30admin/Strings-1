//TC : O(m+n) m,n - length of string
//SC : O(1)

class Solution {
    public String customSortString(String S, String T) {
        if(S.length() == 0 )
            return T;
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(Character c : T.toCharArray()){
            // if(!map.containsKey(c))
            //     map.put(c,1);
            // else
                map.put(c,map.getOrDefault(c,0)+1);
        }
        
        //System.out.println(map);
        
        for(Character c : S.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count > 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            int count = e.getValue();
            Character c = e.getKey();
            
            while(count>0){
                sb.append(c);
                count--;
            }
            
        }
        
        return sb.toString();
            
    }
}