import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int[] count = new int[k];

        TreeSet<Integer> free = new TreeSet<>();

        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Initially all servers are free
        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {

            int time = arrival[i];

            // Release servers which have completed their work
            while (!busy.isEmpty() && busy.peek()[0] <= time) {

                int[] server = busy.poll();
                free.add(server[1]);
            }

            // If all servers are busy
            if (free.isEmpty()) {
                continue;
            }

            // Find preferred available server
            int preferred = i % k;

            Integer server = free.ceiling(preferred);

            // Circular search
            if (server == null) {
                server = free.first();
            }

            // Increase request count
            count[server]++;

            // Remove server from free set
            free.remove(server);

            // Add server to busy queue
            busy.offer(new int[]{time + load[i], server});
        }

        // Find maximum requests
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        // Collect busiest servers
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}