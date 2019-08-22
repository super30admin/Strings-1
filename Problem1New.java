// Question : In S, no letter occurs more than once.
// S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted.
// More specifically, if x occurs before y in S, then x should occur before y in the returned string.
// i/p : S = "cba"  T = "abcd"   Output: "cbad"

//TC:O(n+m) , where n and m are the size of the String S and T .
//SC: O(T Size ) -- Constant. if input String S is changed for a given T, the space used will be always Constant.

// Hash Map Implementation.
/*
1. Store all the character and its occurences in a HashMap<Char, Int> of given String T. 
2. print the custom sort String S, and append the remaining character in T to final output String Result and return the result.
*/

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //Prepare the HashMap
        for(char c : T.toCharArray()){
            if(!map.containsKey(c)) map.put(c,1);
            else map.put(c,map.get(c)+1);
        }
        //Iterate the custom sort string S.
        for(char c : S.toCharArray()){
            if(map.containsKey(c)){
                for(int i=0;i<map.get(c);i++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char c : map.keySet()){
            	        	for(int i=0; i<map.get(c);i++) {

            sb.append(c);
                            }
        }
        
        return sb.toString();
    }
}
