class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] adj = new ArrayList[n];
        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] last = new int[26];
        int[] old = new int[n];
        int[] newParent = parent.clone();

        Arrays.fill(last, -1);

        int[] stack = new int[2 * n];
        int top = 0;
        stack[top++] = 0;

        while (top > 0) {
            int x = stack[--top];

            if (x < 0) {
                int u = -x - 1;
                last[s.charAt(u) - 'a'] = old[u];
                continue;
            }

            int u = x;
            int c = s.charAt(u) - 'a';

            old[u] = last[c];

            if (u != 0 && last[c] != -1) {
                newParent[u] = last[c];
            }

            last[c] = u;

            stack[top++] = -u - 1;

            for (int v : adj[u]) {
                stack[top++] = v;
            }
        }

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        int[] order = new int[n];
        top = 0;
        int count = 0;

        stack[top++] = 0;

        while (top > 0) {
            int u = stack[--top];
            order[count++] = u;

            for (int v : tree[u]) {
                stack[top++] = v;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            ans[newParent[u]] += ans[u];
        }

        return ans;
    }
}