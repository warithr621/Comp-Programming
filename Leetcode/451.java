// https://leetcode.com/problems/sort-characters-by-frequency/description/


class Solution {
    public String frequencySort(String s) {
        HashSet<Character> hs = new HashSet<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hs.add(c);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        ArrayList<Character> al = new ArrayList<>(hs);
        Collections.sort(al, new Comparator<Character>() {
            public int compare(Character a, Character b) {
                return hm.get(b) - hm.get(a);
            }
        });
        StringBuilder ans = new StringBuilder();
        for (char c : al) {
            for (int i = 0; i < hm.get(c); i++) ans.append(c);
        }
        return ans.toString();
    }
}