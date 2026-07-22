// Time Complexity : O(n + m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

//Description:
// - Build a frequency map for all characters in s.
// - Append characters following the sequence given in order, using their stored frequencies.
// - Append the remaining characters that are not present in order in any order.

class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            int count = 0;
            if(freqMap.containsKey(s.charAt(i))) {
                count = freqMap.get(s.charAt(i));
            }
            freqMap.put(s.charAt(i), count + 1);
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < order.length(); i++) {
            char char_ = order.charAt(i);
            if(!freqMap.containsKey(char_)) {
                continue;
            }
            int count = freqMap.get(char_);

            while(count > 0) {
                result.append(char_);
                count--;
            }
            freqMap.remove(char_);
        }

        for(Map.Entry<Character, Integer> each : freqMap.entrySet()) {
            char char_ = each.getKey();
            int count = each.getValue();
            while(count > 0) {
                result.append(char_);
                count--;
            }
        }

        return result.toString();
    }
}