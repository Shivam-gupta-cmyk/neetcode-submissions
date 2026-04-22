class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. Count task frequencies
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;

        // 2. Max-heap to store frequencies (highest first)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) pq.add(f);
        }

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1; // The window size
            int taskCount = 0;

            // Try to fill the cycle with the most frequent tasks
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll() - 1);
                    taskCount++;
                }
            }

            // Put tasks back if they still have occurrences left
            for (int remaining : temp) {
                if (remaining > 0) pq.add(remaining);
            }

            // If heap is empty, we only add the actual tasks performed
            // Otherwise, we add the full cycle length (including idle time)
            time += pq.isEmpty() ? taskCount : cycle;
        }

        return time;
    }
}