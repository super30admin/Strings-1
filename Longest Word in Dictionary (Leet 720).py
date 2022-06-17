# Using BFS
# Time: O(nk), where k is the average of the word

# we can also implement without flag by using length of thw word logic
# doing the for loop reverse as we need the output to follow the alphabetical (lexographical) order

class Solution:
    
    class Trie:
        def __init__(self):
            self.children = [None]*26
            self.flag = False
            self.word = ''
    
    root = Trie()
    
    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            temp = ord(word[i]) - ord('a')
            if curr.children[temp] is None:
                curr.children[temp] = self.Trie()
            curr = curr.children[temp]
        curr.flag = True
        curr.word = word
    
    
    def longestWord(self, words: List[str]) -> str:
        if words is None or len(words) == 0:
            return ''
        
        self.root = self.Trie()
        
        for word in words:
            self.insert(word)  ##O(nk)
            
        q = list()
        q.append(self.root)
        curr = self.root
        while len(q) != 0:
            curr = q.pop(0)
            for i in range(len(curr.children)-1,-1,-1):
                if curr.children[i] != None and curr.children[i].flag == True:
                    q.append(curr.children[i])
                    print(curr.children[i].word)
        return curr.word
                



# Using DFS
# Time: O(nk), where k is the average of the word

# doing the for loop reverse as we need the output to follow the alphabetical (lexographical) order

class Solution:
    
    class Trie:
        def __init__(self):
            self.children = [None]*26
            self.flag = False
            self.ch = ''
    
    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            temp = ord(word[i]) - ord('a')
            if curr.children[temp] is None:
                curr.children[temp] = self.Trie()
            curr = curr.children[temp]
            curr.ch = word[i]
        curr.flag = True

    def longestWord(self, words: List[str]) -> str:
        if words is None or len(words) == 0:
            return ''
        
        self.res = ''
        self.root = self.Trie()
        
        
        for word in words:
            self.insert(word)
        
        self.backtrack(self.root, '')
        return self.res
    
    def backtrack(self, curr, currstr):
        # base
        if len(self.res) <= len(currstr):
            self.res = currstr
        
        # logic
        for i in range(len(curr.children)-1,-1,-1):
            if curr.children[i] != None and curr.children[i].flag == True:
                # action
                currstr = currstr + curr.children[i].ch
                # recurse:
                self.backtrack(curr.children[i], currstr)
                # backtrack
                currstr = currstr[:-1]
                
        
        
        
        
        
        
        
        
        
        
        
                
        
        
        
            
        
        
        