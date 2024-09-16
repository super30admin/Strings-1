"""
https://leetcode.com/problems/longest-word-in-dictionary/
"""


class Trie:
    def __init__(self):
        self.children = {}
        self.word = None
        self.isEnd = False

    def insert(self, word):
        cur = self
        for w in word:
            if w not in cur.children:
                cur.children[w] = Trie()
            cur = cur.children[w]
        cur.isEnd = True
        cur.word = word


class Solution:

    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for word in words:
            trie.insert(word)
        # print(trie.children)
        # # return root
        # print(trie.children.values)
        # print(trie)
        answer = ""
        queue = collections.deque([trie])
        while queue:
            current = queue.popleft()
            for child in current.children.values():
                if child.word != None:
                    if len(child.word) > len(answer) or len(child.word) == len(answer) and child.word < answer:
                        answer = child.word
                    queue.append(child)
        return answer





