public class LengthOfLongestSubstring {

    /**
     * 无重复字符的最长子串
     * 滑动窗口
     * @param args
     */
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring1("abcdafjaf");
        System.out.print(length);
    }

    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < n && j < n){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int start = 0, end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            if (map.containsKey(currentChar)){
                start = Math.max(map.get(currentChar), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(currentChar, end +1);
        }
        return ans;
    }
}
