class longestWordInDictionary {
    
    class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) return "";
        root = new TrieNode();
        for(String word : words){
            insert(word);
        }
        
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        
        TrieNode curr = new TrieNode();
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i >= 0; i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
        }
        
        if(curr.word == null) return "";
        return curr.word;
    }
}

//time complexity O(nk) n is length of arrat of given string 
//and K is average length of each string
//space complexity O(nk)