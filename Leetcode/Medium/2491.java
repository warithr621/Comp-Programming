// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/?envType=daily-question&envId=2024-10-04

class Solution {
    public long dividePlayers(int[] skill) {
        // O(N) time, O(1) space
        long[] freq = new long[1001];
        long sum = 0;
        int sz = skill.length;
        for (int x : skill) {
            freq[x]++;
            sum += x;
        }
        if (sum % (sz / 2) != 0) return -1;
        long goal = sum / (sz / 2);
        int used = 0;
        long ans = 0;
        // System.out.println(goal);
        for (int i = 1; i <= Math.min(goal, 1000); i++) {
            if (freq[i] == 0) continue;
            if (freq[i] != freq[(int) goal - i]) return -1;
            // System.out.println("~" + i);
            if (i * 2 == goal) {
                ans += freq[i] / 2 * i * i;
                used += freq[i];
            } else {
                // System.out.println("!" + i + " " + freq[i]);
                ans += freq[i] * i * (goal - i);
                used += 2 * freq[i];
            }
            // System.out.println(ans + "+");
            freq[i] = freq[(int) goal - i] = 0;
        }
        if (used != sz) return -1;
        return ans;
    }


    public long dividePlayers(int[] skill) {
        // more straightforward, but slower
        // O(N log N) time, O(log N) space
        Arrays.sort(skill);
        int n = skill.length;
        long goal = skill[0] + skill[n-1];
        long ans = 0;
        for (int i = 0; i < n/2; i++) {
            if (skill[i] + skill[n - i - 1] != goal) return -1;
            ans += 1L * skill[i] * skill[n-i-1];
        }
        return ans;
    }
}