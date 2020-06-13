//Leetcode : 791. Custom Sort String
//Time Complexity: O(n), n is length of T
//Space Complexity: O(n), n is length of T
class Solution {
    public String customSortString(String S, String T) {
        if(S==null || T==null) return T;
        HashSet<Character> hs= new HashSet<>();
        for(int i=0; i<S.length();i++){
            hs.add(S.charAt(i));
        }
          HashMap<Character,Integer> hm= new HashMap<>();
        for(int j=0;j<T.length();j++){
            hm.put(T.charAt(j), hm.getOrDefault(T.charAt(j),0)+1);
        }
        StringBuilder str= new StringBuilder();
       for(int i=0; i<S.length();i++){
           if(hm.containsKey(S.charAt(i))){
               char c=S.charAt(i);
               int n=hm.get(c);
               while(n>0){
                  str.append(c); 
                   n--;
               }
           }
       }
        for(int k=0; k<T.length();k++){
            if(!hs.contains(T.charAt(k))){
                str.append(T.charAt(k)); 
                
            }
        }
        return str.toString();
    }
}