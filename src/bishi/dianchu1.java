package bishi;

public class dianchu1 {
    public String[] ys(String[] s) {
        String[] ans = new String[s.length];

        for(int i=0;i<s.length;i++) {
            StringBuilder temp = new StringBuilder();
            int count = s[i].length();

            char forward = s[i].charAt(0);
            int sum = 1;
            for (int j = 1; j < count; j++) {
                char now = s[i].charAt(j);
                if (forward == now) {
                    sum++;
                    continue;
                }
                if (sum>1)
                    temp.append(forward).append(sum);
                else
                    temp.append(forward);

                forward = now;
                sum = 1;
            }

            //处理最后个循环剩余
            if (sum>1)
                temp.append(forward).append(sum);
            else
                temp.append(forward);

            ans[i] = temp.toString();
        }

        return ans;
    }
}
