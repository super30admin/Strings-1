function lengthOfLongestSubstring(s: string): number {
  let maxLength = 0;
  let set = new Set<string>();

  let left = 0;
  let right = 0;
  for (let index = 0; index < s.length; index++) {
    let char = s.charAt(index);
    if (set.has(char)) {
      while (s.charAt(left) != char) {
        set.delete(s.charAt(left));
        left++;
      }
      set.delete(char);
      left++;
    }
    set.add(char);
    maxLength = Math.max(maxLength, right - left + 1);
    right++;
  }
  return maxLength;
}

describe("3. Longest Substring Without Repeating Characters", () => {
  it("Happy Path", () => {
    expect(lengthOfLongestSubstring("abcabcbb")).toStrictEqual(3);
  });
  it("Negative", () => {
    expect(lengthOfLongestSubstring("bbbbb")).toStrictEqual(1);
  });
  it("Negative 2", () => {
    expect(lengthOfLongestSubstring("pwwkew")).toStrictEqual(3);
  });
});
