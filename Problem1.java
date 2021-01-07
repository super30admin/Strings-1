class Solution {
    //Space complexity : O(1)
    //Time complexity : O(m+n) m is size of S, n is size of T
    public String customSortString(String S, String T) {
        if(S == null || S.length() == 0 || T == null || T.length() == 0)
            return T;
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder finalString = new StringBuilder();
        for(int i = 0; i < T.length(); i++){ //O(n)
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < S.length(); i++) {
            char c= S.charAt(i);
            if(map.containsKey(c)){
                int times = map.get(c);
                for(int j = 0; j < times; j++) {
                    finalString.append(c);
                }
                map.remove(c);
            }
        }
        for(char c : map.keySet()) {
            int times = map.get(c);
            for(int j = 0; j < times; j++) {
                finalString.append(c);
            }
        }
        return finalString.toString();
    }
}