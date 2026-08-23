class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // Frequency arrays for characters in s1 and the current window in s2
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Initialize the frequency array for s1
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;
        while (right < s2.length()) {
            // Expand the window by including the current character
            s2Count[s2.charAt(right) - 'a']++;

            // If the window size is the same as s1, we need to check for a valid permutation
            if (right - left + 1 == s1.length()) {
                if (matches(s1Count, s2Count)) {
                    return true;
                }

                // Contract the window from the left, we don't need to check larger windows
                s2Count[s2.charAt(left) - 'a']--;
                left++;
            }

            // Expand the window to the right
            right++;
        }
        return false;
    }

    // Helper function to check if two frequency arrays are identical
    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;
    }
}
