import java.util.HashMap;

class Solution {
    public String customSortString(String order, String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        HashMap<Character, Integer> mapp = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            mapp.put(ch, mapp.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (mapp.containsKey(c)) {
                int times = mapp.get(c);
                for (int j = 0; j < times; j++) {
                    result.append(c);
                }
                mapp.remove(c);
            }

        }
        for (char key : mapp.keySet()) {
            int times = mapp.get(key);
            for (int j = 0; j < times; j++) {
                result.append(key);
            }
        }
        return result.toString();
    }
}