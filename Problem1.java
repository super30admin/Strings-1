
//Solved using a hashmap. Stored index and character in hashmap. Further created another array and then stored that value on that position of the array. Return string converted to that array

class Solution {
    public String customSortString(String S, String T) {

        HashMap<Character, Integer> hp = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            hp.put(S.charAt(i), i);

        }
        System.out.println(Arrays.asList(hp));

        char[] res = new char[T.length()];

        int count = 0;
        for (int j = 0; j < T.length(); j++) {
            char c = T.charAt(j);
            if (hp.containsKey(c)) {
                res[hp.get(c)] = c;
                System.out.println(res[hp.get(c)]);
            } else {
                res[hp.size() + count] = c;
                count++;
            }
        }

        String result = String.valueOf(res);

        return result;
    }
}