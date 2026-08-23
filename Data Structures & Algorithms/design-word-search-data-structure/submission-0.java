class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode curr) {
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : curr.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int charIndex = c - 'a';
                if (curr.children[charIndex] == null) {
                    return false;
                }
                curr = curr.children[charIndex];
            }
        }
        return curr.endOfWord;
    }
}
