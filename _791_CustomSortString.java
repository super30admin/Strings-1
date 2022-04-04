// Time Complexity : o(n*log(n)) where n is length of s string
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// get the order from order string and write your own quick sort implementation.
class Solution {

    int[] map;
    public String customSortString(String order, String s) {
        map = new int[26];
        for(int i=0; i<order.length();i++){
            map[order.charAt(i)-'a'] = i+1;
        }
        char[] arr = s.toCharArray();
        sort(arr, 0, arr.length-1);
        return new String(arr);
    }

    public void sort(char[] arr, int start, int end){
        if(start >= end) return;
        int pos = findPivotPos(arr, start, end);
        sort(arr, start, pos-1);
        sort(arr, pos+1, end);
    }

    public int findPivotPos(char[] arr, int start, int end){
        int pivot = end;
        while(start < end){
           while(start < end && map[arr[start] -'a'] <= map[arr[pivot] -'a']) start++;
           while(start < end && map[arr[end] -'a'] >= map[arr[pivot] -'a']) end--;
           if(start == end) swap(arr, start, pivot);
           else swap(arr, start, end);
        }
        return start;
    }

    public void swap(char[] arr, int start, int end){
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}

/*****************************************************************************************************************************************/
// Time Complexity : o(m + n) where m, n is length of string
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// USe hashing to store the order and the use order to sort teh frequency map of s
class Solution {
    public String customSortString(String order, String s) {

        Map<Integer, Character> mapT = new HashMap<>();
        for(int i=0; i<order.length(); i++){
            mapT.put(i+1, order.charAt(i));
        }

        int[] mapS = new int[26];
        for(int i=0; i<s.length(); i++){
            mapS[s.charAt(i)-'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=26; i++){
            if(mapT.containsKey(i)){
                char ch = mapT.get(i);
                int count = mapS[ch-'a'];
                for( int j=0; j<count; j++){
                    sb.append(ch);
                }
                mapS[ch-'a'] = 0;
            }
        }

        for(int i=0; i<26; i++){
            if(mapS[i] > 0){
                char ch =  (char)(i +'a');
                int count = mapS[i];
                for( int j=0; j<count; j++){
                    sb.append(ch);
                }
                mapS[i] = 0;
            }
        }

        return sb.toString();
    }
}
