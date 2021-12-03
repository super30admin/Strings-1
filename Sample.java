
//o(n)time and constant space
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0; int max = 0;
        for(int fast = 0; fast < s.length(); fast++){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            max = Math.max(max, fast-slow+1);
            map.put(c, fast+1);

        }
        return max;
    }

//o(m+n) time and constant space
    public String customSortString(String order, String s) {
        HashMap <Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count > 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        for(char c: map.keySet()){
            int count = map.get(c);
            while(count > 0){
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }

}


//o(nk) time 
class Solution {

    class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode(){
            this.children = new TrieNode[26];

        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word: words){
            insert(word);
        }

        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = new TrieNode();
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i >=0; i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
        }
        if(curr.word == null) return "";
        return curr.word;
    }
}