// https://leetcode.com/problems/uncommon-words-from-two-sentences/description/?envType=daily-question&envId=2024-09-17

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> f1 = new HashMap<>();
        HashMap<String, Integer> f2 = new HashMap<>();
        for (String s : s1.split(" ")) {
            f1.put(s, f1.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")) {
            f2.put(s, f2.getOrDefault(s, 0) + 1);
        }
        ArrayList<String> al = new ArrayList<>();
        for (String s : f1.keySet()) {
            if (f1.get(s) == 1 && !f2.containsKey(s)) al.add(s);
        }
        for (String s : f2.keySet()) {
            if (f2.get(s) == 1 && !f1.containsKey(s)) al.add(s);
        }
        String[] ans = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            ans[i] = al.get(i);
        }
        return ans;
    }
}