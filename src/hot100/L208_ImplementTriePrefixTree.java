package hot100;

//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 449 👎 0


//L208、实现 Trie (前缀树) ---- 
public class L208_ImplementTriePrefixTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        class TrieNode {
            TrieNode[] child;
            boolean isEnd;

            public TrieNode() {
                this.child = new TrieNode[26];
                this.isEnd = false;
            }
        }

        TrieNode root;


        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                if (p.child[word.charAt(i) - 'a'] == null) {
                    p.child[word.charAt(i) - 'a'] = new TrieNode();
                }
                p = p.child[word.charAt(i) - 'a'];
            }
            p.isEnd = true;

        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                if (p.child[word.charAt(i) - 'a'] == null) {
                    return false;
                }
                p = p.child[word.charAt(i) - 'a'];
            }
            if (p.isEnd) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (p.child[prefix.charAt(i) - 'a'] == null) {
                    return false;
                }
                p = p.child[prefix.charAt(i) - 'a'];
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {

    }
}