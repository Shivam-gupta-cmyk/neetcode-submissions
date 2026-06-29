class Solution {
    private class Pair {
        int a;
        int b;
        int c;
        Pair(int a, int b, int c) {
            int sum = a + b + c;
            this.a = Math.min(a, Math.min(b, c));
            this.b = Math.max(a, Math.max(b, c));
            this.c = sum - (this.a + this.b);
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (!(obj instanceof Pair))
                return false;

            Pair p = (Pair) obj;

            return a == p.a && b == p.b && c == p.c;
        }

        // @Override
        // public int hashCode() {
        //     return Objects.hash(a, b, c);
        // }
    }

    private List<int[]> findTargetPair(int[] nums, int index) {
        int target = -1 * nums[index];
        int i = 0;
        int j = nums.length - 1;
        List<int[]> ls = new ArrayList<>();
        while (i < j) {
            if (i == index) {
                i++;
                continue;
            }
            if (j == index) {
                j--;
                continue;
            }
            if (nums[i] + nums[j] < target)
                i++;
            else if (nums[i] + nums[j] > target)
                j--;
            else {
                ls.add(new int[] {nums[i], nums[j]});
                i++;
                j--;
            }
        }
        return ls.size() == 0 ? null : ls;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<Pair> ls = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (findTargetPair(nums, i) != null) {
                List<int[]> targetList = findTargetPair(nums, i);
                for (int[] ans : targetList) {
                    Pair p = new Pair(nums[i], ans[0], ans[1]);
                    if (!ls.contains(p)) {
                        ls.add(p);
                    }
                }
            }
        }
        for (Pair p : ls) {
            List<Integer> list = new ArrayList<>();
            list.add(p.a);
            list.add(p.b);
            list.add(p.c);
            res.add(list);
        }
        return res;
    }
}
