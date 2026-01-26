// TC - O(m + n) ~ O(n) where n is the length of s
// SC - O(1) constant number of characters


/*
Created a hashmap to maintain the count of s string.
ITerated through order and if the character exists in the hashmap, appended it as per the number of times encountered in s
In this way, the order is preserved as per the order string
*/
class Problem1 {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        for(int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<order.length();i++) {
            char ch = order.charAt(i);
            if(hmap.containsKey(ch)) {
                int cnt = hmap.get(ch);
                for(int j = 0;j<cnt;j++) {
                    sb.append(ch);
                }

                hmap.remove(ch);
            }
        }

        for(Character ch : hmap.keySet()) {
            int cnt = hmap.get(ch);
            for(int i = 0;i<cnt;i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}