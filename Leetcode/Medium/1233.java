// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/editorial/?envType=daily-question&envId=2024-10-25

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> folders = new HashSet<>(Arrays.asList(folder));
        List<String> ans = new ArrayList<>();
        for (String s : folder) {
            boolean sub = false;
            String pfx = s;
            while (!pfx.isEmpty()) {
                int pos = pfx.lastIndexOf('/');
                if (pos == -1) break;
                pfx = pfx.substring(0, pos);
                if (folders.contains(pfx)) {
                    sub = true;
                    break;
                }
            }
            if (!sub) ans.add(s);
        }
        return ans;
    }
}