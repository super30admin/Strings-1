#https://leetcode.com/problems/custom-sort-string/
#Runtime complexity:
#Space complexity:
#Problems:
#
# Algo explanation:
#
# Store T characters into a hashmap by key:pair character:number_occurrences
# for each character in S
#    write number of characters (if any) from T
#    (remove this character from hashmap)
#
# write out any characters left from T

#/**
# * @param {string} S
# * @param {string} T
# * @return {string}
# */
customSortString = (S, T) ->
  return T if S == null or S.length < 1
  return null if T == null or T.length < 1

  hashmap = new Map()

  for i in [0...T.length]
    hashmap.set(T[i], (hashmap.get(T[i]) || 0) + 1)

  output = []
  for i in [0...S.length]
    if hashmap.has(S[i])
      output.push(S[i]) for j in [0...hashmap.get(S[i])]
      hashmap.delete(S[i])

  hashmap.forEach (v, k) ->
    for l in [0...v]
      output.push(k)

  output.join('')


console.log(customSortString("cba", "abcd")) # expect 'cbad'

console.log(customSortString("kqep", "pekeq")) # expect 'kqeep'
