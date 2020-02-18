//Time Complexity: O(m+n)
//Space Complexity: O(1)

class Solution {
    public String customSortString(String S, String T) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int t = T.length();
        int s = S.length();
        
        //for T -> add elements to map
        for(int i=0; i<t; i++){
            //if already present in map; get and add 1 to the value
            if(map.containsKey(T.charAt(i))){
                map.put(T.charAt(i), map.get(T.charAt(i))+1);
            } else
                //simply add value 1 to the newly occured character
                map.put(T.charAt(i), 1);
        }
        
        //for S
        //if character in string S present in map
        for(int j=0; j<s; j++){
            if(map.containsKey(S.charAt(j))){
                //get the value (occurence)
                int sfreq = map.get(S.charAt(j));
                //append the occurences to stringBuilder
                for(int k=0; k<sfreq; k++)
                    sb.append(S.charAt(j));
                //remove from map
                //or value -> 0
                map.remove(S.charAt(j));
            }
        }
       
        //if map contains values >0
        //append at the end
        for(char c : map.keySet()){
            int tfreq = map.get(c);
            for(int l=0; l<tfreq; l++)
                sb.append(c);
        }
        return sb.toString();
    }
}