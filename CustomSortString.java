//Time Complexity :O(N+2*M).
//Space Complexity :O(2*M)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class CustomSortString{
	
	public String customSortString(String S, String T) {
        if(null == S || S.length() == 0 || null == T || T.length() == 0){
            return T;
        }
        int arr[] = new int[26];
        for(char ch : T.toCharArray()){
            arr[ch-'a']++;
        }
        boolean visited[] = new boolean[26];
        StringBuilder result = new StringBuilder("");
        for(char ch : S.toCharArray()){
            if(arr[ch-'a'] > 0){
                for(int i = 0; i < arr[ch-'a']; i++){
                    result.append(ch);
                }
                visited[ch-'a'] = true;
            }
        }
        for(char ch : T.toCharArray()){
            if(!visited[ch-'a']){
                result.append(ch);
            }
        }
    return result.toString();
    }
	
}