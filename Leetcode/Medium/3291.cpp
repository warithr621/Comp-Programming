// https://leetcode.com/problems/minimum-number-of-valid-strings-to-form-target-i/description/

class Node {
    public:
        Node* alpha[26];
        bool flag = false;
};

class Trie {
    public:
        Node* root;
        Trie() { root = new Node(); }

        void insert(const string& word) {
            Node* node = root;
            for (char c : word) {
                int i = c - 'a';
                if (!node->alpha[i]) {
                    node->alpha[i] = new Node();
                }
                node = node->alpha[i];
                node->flag = true;
            }
        }

        vector<int> query(const string& target, int start) {
            vector<int> valid;
            Node* node = root;
            for (int i = start; i < target.length(); i++) {
                if (!node->alpha[target[i] - 'a']) break;
                node = node->alpha[target[i] - 'a'];
                if (node->flag) {
                    valid.push_back(i - start + 1);
                }
            }
            return valid;
        }
};

class Solution {
public:
    int minValidStrings(vector<string>& words, string target) {
        Trie trie;
        for (const string& s : words) trie.insert(s);
        int n = target.length();
        vector<int> dp(n+1, INT_MAX);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == INT_MAX) continue;
            vector<int> lengths = trie.query(target, i);
            for (int l : lengths) {
                dp[i + l] = min(dp[i + l], dp[i] + 1);
            }
        }
        return dp[n] == INT_MAX ? -1 : dp[n];
    }
};

// below is faster sol

// class Node {
//     public:
//         Node* alpha[26] = {};
// };

// class Trie {
//     public:
//         Node* root;
//         Trie() { root = new Node(); }

//         void insert(const string& word) {
//             Node* node = root;
//             for (int d = 0; d < word.size(); d++) {
//                 int i = word[d] - 'a';
//                 if (!node->alpha[i]) {
//                     node->alpha[i] = new Node();
//                 }
//                 node = node->alpha[i];
//             }
//         }

//         int query(const string& target, int start) {
//             Node* node = root;
//             int best = start;
//             for (int i = start; i < target.length(); i++) {
//                 int c = target[i] - 'a';
//                 if (!node->alpha[c]) break;
//                 node = node->alpha[c];
//                 best = i + 1;
//             }
//             return best;
//         }
// };

// class Solution {
// public:
//     int minValidStrings(vector<string>& words, string target) {
//         Trie trie;
//         for (const string& s : words) trie.insert(s);
//         int n = target.length();
//         int steps = 0, curEnd = 0, farthest = 0;
//         for (int i = 0; i < n; i++) {
//             farthest = max(farthest, trie.query(target, i));
//             if (i == curEnd) {
//                 if (farthest == i) return -1;
//                 curEnd = farthest;
//                 steps++;
//                 if (curEnd >= n) break;
//             }
//         }
//         return steps;
//     }
// };