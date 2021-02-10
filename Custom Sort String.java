// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
        //set a string builder
        StringBuilder sb = new StringBuilder();
        //check edege 
        if(T == null || T.length() == 0) return sb.toString();
        //create a hashmap to hold the letters and their occurences
        HashMap<Character, Integer> hash = new HashMap<>();
        //start the for loop to iterate through T to find the occuernces
        for(int i = 0; i < T.length(); i++){
            //get the letter with char
            char c = T.charAt(i);
            //put it in the hashmap
            hash.put(c, hash.getOrDefault(c,0) + 1);
        }
        //start a for loop to go through the hashmap and find the letters from S
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            //check if it is the hashmap
            if(hash.containsKey(c)){
                //set a count with the number of characters there are
                int count = hash.get(c);
                //start a while loop to put that nummber of times this specific character
                while(count > 0){
                    //put into the string
                    sb.append(c);
                    //decrase count
                    count --;
                }
                //remove the letter from the hashmap
                hash.remove(c);
            }
        }
        //start a for loop to go through the remaining letters in the hashmap
        for(Map.Entry<Character, Integer> ent : hash.entrySet()){
            char c = ent.getKey();
            //set a count with the number of characters there are
            int count = ent.getValue();
            //start a while loop to put that nummber of times this specific character
            while(count > 0){
                //put into the string
                sb.append(c);
                //decrase count
                count --;
            }
        }
        return sb.toString();
    }
}