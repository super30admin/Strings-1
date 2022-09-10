//Technique1 : HashMap 
//Time Complexity : O(n)
//Space : Complexity : O(1) ==> O(26) alphabets in HashMap
 
class Solution {
    public String customSortString(String order, String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){  
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c,0)+1); 
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<order.length(); i++){
            
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int k= 0; k < count; k++){
                    sb.append(c); 
                }
                  map.remove(c);
            }
            //sb.append(c);
         
        }
        
        for(Character c : map.keySet()){
            System.out.println(c);
            int count = map.get(c);
            System.out.println(count);
            for(int k= 0; k < count; k++){
                    sb.append(c); 
            }
              
        }
        return sb.toString();
    }
}
