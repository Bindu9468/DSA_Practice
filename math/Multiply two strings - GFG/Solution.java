class Solution {
    public String multiplyStrings(String s1, String s2) {
        // code here.
        boolean neg = false;
        if (s1.charAt(0) == '-') {
            neg = !neg;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            neg = !neg;
            s2 = s2.substring(1);
        }

        s1 = trimzero(s1);
        s2 = trimzero(s2);

        if (s1.equals("0") || s2.equals("0"))
            return "0";

        int m = s1.length();
        int n = s2.length();
        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int d1 = s1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int d2 = s2.charAt(j) - '0';

                int product = d1 * d2 + res[i + j + 1];
                res[i + j + 1] = product % 10;
                res[i + j] += product / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        if (neg)
            sb.insert(0, "-");
        return sb.toString();
    }

    private String trimzero(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0')
            i++;
        return i == str.length() ? "0" : str.substring(i);
    }

}