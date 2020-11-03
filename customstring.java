
//Time Complexity - O(1)
// Space Complexity - O(n) - n is length of 26 chars


class Solution {
    public String customSortString(String S, String T) {
        if(T == null || T.length() == 0)
            return T;
        if(S == null || S.length() == 0)
            return T;

        int[] arr = new int[26];
        Set<Character> sCharSet = new HashSet();
        List<Character> tLeftOverChars = new ArrayList();

        for(char c : S.toCharArray())
            sCharSet.add(c);

        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            arr[c-'a']++;

            if(!sCharSet.contains(c))
                tLeftOverChars.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            int count = arr[c-'a'];
            for(int j = 0; j < count; j++){
                sb.append(c);
            }
        }

        for(char c :tLeftOverChars){
            sb.append(c);
        }

        return sb.toString();
    }
}
