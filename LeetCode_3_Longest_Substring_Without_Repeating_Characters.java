//approach -1
//take 1st index and check all possibilities for it  - let say n
//for n elements  - n possibilities - so it's n^2
//tc - O(n*n); sc = constant as we can maintain a length variable


//approach -2 OPTIMIZED
/*
 * we'll use a map of char and int. 
 * we traverse through the string and check if the map contains char,
 *  if yes - we get the index, and check if that's lower than slow - if so, we keep the slow, else we update slow == index
 *  if no -  then we just put entry into map(c, index+1); cause when we encounter c again in string, we dont want to go to it's index, 
 * but we want to go to it's next index!
 * we also keep a temp len = fast-slow +1 ; because we are 0-indexed here we add 1
 * we check if templen is greater than my len, I update my len to it. else will keep the old!
 * 
 * TC - O(N)
 * SC -O(1) - at max 26 characters will be there!
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0 || s == null) return 0;
        
        int slow =0, fast =0, len =0;
        
        Map<Character,Integer> map = new HashMap<>();
        
        for(fast = 0; fast< s.length(); fast++)
        {
            char c = s.charAt(fast);
            
            if(map.containsKey(c))
            {
                //we check if the index we get from value is lower thn slow? yes - keep the slow : No - keep the value
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, fast+1);
            
            //calculate the length
            int temp_len = (fast - slow) +1; //because it is index based and start from 0, so we add 1 to length!
            len = Math.max(len, temp_len);    
        }
        return len;
    }
}

//tc - O(N) - traversing through strin
//sc - constant - at max we'll have 26 character