// APPROACH 1: 2 pointers with HASHSET
// TC: O(n)
// SC: O(1) because only 26 lowercase characters in set


// slow pointer and 'i' pointer. I pointer in for loop
// slow at 0, i at 0
// Itreate over the string with 'i', and add the char to hashset if not present.
// If character is present in hashset, move the slow pointer until you reach the first 
// occurence of that repeating character
// At the same time remove those characters the slow pointer traverses and move the slow pointer ahead
// After that move the slow pointer 1 step, so as to escape the repeating character
// Lastly at every iteration you maintain the max length of the sliding window


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int slow=0;
        int result=0;
        HashSet<Character> set = new HashSet<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(set.contains(ch)){
                while(s.charAt(slow)!=ch){ //iterate and remove from set until slow reaches
                    // repeating character
                    char sch=s.charAt(slow);
                    set.remove(sch);
                    slow++;
                }
                slow++; // escape the repeating character
            }
            else {
                set.add(ch);
            }
            result=Math.max(result,i-slow+1); //length is index+1
        }
        
        return result;
        
        
        
    }
}


// APPROACH 2: 2 pointers with HASHMAP
// TC: O(n)
// SC: O(1) because only 26 lowercase characters in set


// slow pointer and 'i' pointer. I pointer in for loop
// slow at 0, i at 0
// Itreate over the string with 'i',
// If character already present in the map, get the max between current slow pointer
// and the index of the potential new slow pointer by doing map.get(ch)+1
// We get the max because it is possible that you reach a character, whose 1st occurence
// is already outside the sliding window // behind the slow pointer 
// So if a repeating char is behind slow pointer, slow pointer will not move
// After this IF condition, we add the character to the map, repeating characters' index will
// be updated in the map
// Lastly we get the length of the window at every iteration


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //TWO POINTER HASHMAP
        
        int slow=0;
        int result=0;
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                slow=Math.max(slow,map.get(ch)+1); //it could be that slow pointer 
                //is already ahead of the duplicate character so get max 
            }
            map.put(ch,i); //no else condition, you add to the map which will replace the old index
            result=Math.max(result,i-slow+1);
        }
        return result;
    }
}