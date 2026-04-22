class Solution {
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> tset = new TreeSet<>();
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            tset.add(nums[i]);
        }
        if (tset.size() < 2)
            return tset.size();
        Iterator<Integer> itr = tset.iterator();
        Integer ele = null;
        Integer ele2 = itr.next();
        while (itr.hasNext()) {
            ele = ele2;
            ele2 = itr.next();
            int count = 1;
            while (itr.hasNext() && (ele2 - ele) == 1) {
                ele = ele2;
                ele2 = itr.next();
                count++;
            }
            if ((ele2 - ele) == 1)
                count++;
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }
}
