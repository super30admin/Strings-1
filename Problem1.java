//time complexity:o(n)
//space complexity:o(1) as we are only storing 26 charc in hashmap
//run on letcode: yes
//any doubts: no

class Solution {
    //adding all the characters in string s to hashmap and taking one char each from order string we append the charc to result until that char is finished.
        public String customSortString(String order, String s) {
           HashMap<Character, Integer> hmap = new HashMap<>();
           for(int i=0;i<s.length();i++){
               char c = s.charAt(i);
               hmap.put(c,hmap.getOrDefault(c,0)+1);
           } 
           StringBuilder result = new StringBuilder();
           for(int i=0;i<order.length();i++){
               char c= order.charAt(i);
               if(hmap.containsKey(c)){
                 int count=hmap.get(c);
                 while(count>0){
                  result.append(c);  
                  count--;
                 }
               }
              hmap.remove(c);  
           } 
            for(char c : hmap.keySet()){
               int count=hmap.get(c);
               while(count>0){
                  result.append(c);  
                  count--;
               }
           } 
            
           return result.toString();
        }
    }