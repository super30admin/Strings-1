class Solution {
    public String customSortString(String S, String T) {
     StringBuilder result = new StringBuilder();
     int count = 0;
     HashMap<Character,Integer> map = new HashMap<>();
      for(int i = 0 ;i < T.length();i++){
          char c = T.charAt(i);
          map.put(T.charAt(i),map.getOrDefault(c,0)+1);
      }    
        
      for(int i = 0 ;i < S.length();i++){
          char c = S.charAt(i);
          if(map.containsKey(c)){
              
              count = map.get(c);
              while(count > 0){
                  result.append(c);
                  count--;
              }
          
         map.remove(c); ///now that  character c is 0 remove it from the hashmap
      }}
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            int cnt = entry.getValue();
            System.out.println("cnt "+cnt);
            char c = entry.getKey();
            System.out.println("c "+c);
            while(cnt > 0 ){
                result.append(c);
                System.out.println("appended "+c);
                cnt--;
            }
            
        }
        return result.toString();
    }
}
/*
Time complexity: O(m+n) m is length of T and n is length of S
Space complexity: O(1)   max 26 characters in hashmap hence space is O(1)
*/