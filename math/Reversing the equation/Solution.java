import java.util.ArrayList;

class Solution {

    String reverseEqn(String S) {
        // your code here
        ArrayList<String> parts = new ArrayList<>();
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (Character.isDigit(ch)) {
                num.append(ch);
            } else {
                parts.add(num.toString());
                num.setLength(0);
                parts.add(String.valueOf(ch));
            }
        }

        if (num.length() > 0) {
            parts.add(num.toString());
        }
        StringBuilder res = new StringBuilder();
        for (int i = parts.size() - 1; i >= 0; i--) {
            res.append(parts.get(i));
        }
        return res.toString();
    }
}