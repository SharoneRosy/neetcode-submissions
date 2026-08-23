
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int minLen = Integer.MAX_VALUE;
        int matchedCount = 0;
        int startIdx = -1;
        int left = 0, right = 0;

        // Frequency map for characters in `t`
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Sliding window
        while (right < n) {
            char currChar = s.charAt(right);

            // Decrement frequency and update matched count
            if (map.getOrDefault(currChar, 0) > 0) {
                matchedCount++;
            }
            map.put(currChar, map.getOrDefault(currChar, 0) - 1);

            // Shrink the window when all characters from `t` are matched
            while (matchedCount == m) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                char leftChar = s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);

                if (map.get(leftChar) > 0) {
                    matchedCount--;
                }
                left++;
            }
            right++;
        }

        return (startIdx == -1) ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
