
import java.util.*;

class Solution {

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;
        int N = n + 1;

        // Coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] s = new int[N];

        for (int i = 0; i < n; i++) {
            s[i] = Arrays.binarySearch(sorted, nums[i]) + 1;
        }

        s[n] = 0; // Sentinel

        // Build Suffix Array using counting sort
        int[] p = new int[N];
        int[] c = new int[N];
        int[] cnt = new int[Math.max(N, n + 1)];

        for (int x : s) {
            cnt[x]++;
        }

        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }

        for (int i = N - 1; i >= 0; i--) {
            p[--cnt[s[i]]] = i;
        }

        int classes = 1;
        c[p[0]] = 0;

        for (int i = 1; i < N; i++) {
            if (s[p[i]] != s[p[i - 1]]) {
                classes++;
            }
            c[p[i]] = classes - 1;
        }

        int[] pn = new int[N];
        int[] cn = new int[N];

        for (int len = 1; len < N; len *= 2) {

            for (int i = 0; i < N; i++) {
                pn[i] = p[i] - len;
                if (pn[i] < 0) {
                    pn[i] += N;
                }
            }

            Arrays.fill(cnt, 0, classes, 0);

            for (int i = 0; i < N; i++) {
                cnt[c[pn[i]]]++;
            }

            for (int i = 1; i < classes; i++) {
                cnt[i] += cnt[i - 1];
            }

            for (int i = N - 1; i >= 0; i--) {
                int x = pn[i];
                p[--cnt[c[x]]] = x;
            }

            cn[p[0]] = 0;
            int newClasses = 1;

            for (int i = 1; i < N; i++) {

                int cur = p[i];
                int prev = p[i - 1];

                if (c[cur] != c[prev] ||
                    c[(cur + len) % N] !=
                    c[(prev + len) % N]) {

                    newClasses++;
                }

                cn[cur] = newClasses - 1;
            }

            int[] temp = c;
            c = cn;
            cn = temp;

            classes = newClasses;

            if (classes == N) {
                break;
            }
        }

        // Remove sentinel from suffix array
        int[] sa = new int[n];

        for (int i = 0; i < n; i++) {
            sa[i] = p[i + 1];
        }

        // Build rank array
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }

        // Kasai's LCP algorithm
        int[] lcp = new int[n];
        int k = 0;

        for (int i = 0; i < n; i++) {

            int r = rank[i];

            if (r == n - 1) {
                k = 0;
                continue;
            }

            int j = sa[r + 1];

            while (i + k < n &&
                   j + k < n &&
                   nums[i + k] == nums[j + k]) {
                k++;
            }

            lcp[r] = k;

            if (k > 0) {
                k--;
            }
        }

        // Find minimum unique subarray length
        int ans = n;

        for (int r = 0; r < n; r++) {

            int maxLcp = 0;

            if (r > 0) {
                maxLcp = Math.max(maxLcp, lcp[r - 1]);
            }

            if (r < n - 1) {
                maxLcp = Math.max(maxLcp, lcp[r]);
            }

            int required = maxLcp + 1;

            if (required <= n - sa[r]) {
                ans = Math.min(ans, required);
            }
        }

        return ans;
    }
}
