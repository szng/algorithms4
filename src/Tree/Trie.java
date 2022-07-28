package Tree;

/**
 * leetcode 208
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++) {
            if (temp.children[word.charAt(i) - 'a'] == null) {
                temp.children[word.charAt(i) - 'a'] = new Trie();
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++) {
            if (temp.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie temp = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            temp = temp.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}
