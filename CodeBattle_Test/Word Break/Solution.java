/*
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * Example 1:
 * 
 * codebattle
 * 2
 * battle
 * code
 * Input
 * True
 * Output
 * Example 2:
 * 
 * applepenapple
 * 2
 * apple
 * pen
 * Input
 * True
 * Output
 * Example 3:
 * 
 * catsandog
 * 5
 * cats
 * dog
 * sand
 * and
 * cat
 * Input
 * False
 * 
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // write your code here
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }
}