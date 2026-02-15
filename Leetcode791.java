// Solution - use HashMap to keep count
// TC - O(n+m) -> length of both strings.
// SC - O(n) -> length of s strings.
class Solution {
    public String customSortString(String order, String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();

        for(int i=0; i< s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1 );
        }
        
        for(int i =0; i<order.length(); i++) {
            char ch = order.charAt(i);
            int count = map.getOrDefault(ch, 0);
            while(count != 0) {
                res.append(ch);
                count-=1;
            }
            map.remove(ch);
        }

        for(Character ch : map.keySet()) {
            int count = map.getOrDefault(ch, 0);
            while(count != 0) {
                res.append(ch);
                count-=1;
            }
        }
        return res.toString();

    }
}
