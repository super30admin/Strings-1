// TC: O(m+n)
// SC: O(1) 26 letters only
function customSortString(order: string, s: string): string {
  let frequency_map = new Map<string, number>();
  for (let index = 0; index < s.length; index++) {
    let char = s.charAt(index);
    if (!frequency_map.has(char)) {
      frequency_map.set(char, 0);
    }
    frequency_map.set(char, frequency_map.get(char)! + 1);
  }
  let result = "";
  for (let index = 0; index < order.length; index++) {
    let char = order.charAt(index);
    let frequency = frequency_map.get(char)!;
    for (let i = 0; i < frequency; i++) {
      result = result + char;
    }
    frequency_map.delete(char);
  }
  if (frequency_map.size > 0) {
    for (const [char, frequency] of frequency_map.entries()) {
      for (let i = 0; i < frequency; i++) {
        result = result + char;
      }
    }
  }
  return result;
}

describe("791. Custom Sort String", () => {
  it("Happy Path", () => {
    expect(customSortString("cba", "abcd")).toStrictEqual("cbad");
  });
});
