# TC: O(n) 
# SC: O(1)
def lengthOfLongestSubstring(s):
    i = 0
    j = 0
    counter = 0
    unique_char = set()
    while j < len(s):
        if s[j] in unique_char:
            unique_char.remove(s[i])
            i += 1
            continue
        unique_char.add(s[j])
        counter = max(counter, len(unique_char))
        j +=1
    return counter