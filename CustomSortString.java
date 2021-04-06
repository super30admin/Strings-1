class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder(); 
        HashMap<Character, Integer> hashMap = new HashMap<>();
        
        //Storing characters and its occurances of T in a hashMap
        for(char ch: T.toCharArray()){
            hashMap.put(ch, hashMap.getOrDefault(ch, 0)+1);
        }
        
        //when you encounter a character in s i.e., present in hashmap, 
        // iterate in hashmap for count and remove it from hashmap
        for(char ch: S.toCharArray()){
            if(hashMap.containsKey(ch)){
                int count = hashMap.get(ch);
                while(count != 0){
                    sb.append(ch);
                    count--;
                }
                hashMap.remove(ch);
            }
        }
        
        //check for remaining charcaters and append it to string builder
        for(Character ch : hashMap.keySet()){
            int count = hashMap.get(ch);
            while(count != 0){
                sb.append(ch);
                count--;
            }
        }
        
        //return in string format
        return sb.toString();
    }
}
//Time Complexity: O(n)
//Space Complexity: O(t)