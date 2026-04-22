class Solution {
    public int[] merge(int[] arr1, int[] arr2){
        int[] ans  = new int[2];
        ans[0] = Math.min(arr1[0],arr2[0]);
        ans[1] = Math.max(arr1[1],arr2[1]);
        return ans;
    }

    public boolean compare (int[] arr1, int[] arr2){
        if(arr1[0]<arr2[0] && arr1[1]<arr2[0]) return false;
        return true;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int startIndex = -1;
        int endIndex = -1;
        List<int[]> ls = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        for(int[] interval:intervals){
            ls.add(interval);
        }
        ls.add(newInterval);
        Collections.sort(ls,(a,b)-> a[0]-b[0]);
        for(int i=0;i<ls.size();i++){
            int[] a1 = ls.get(i);
            if(i+1>=ls.size()){
                ans.add(a1);
                break;
            }
            int[] a2 = ls.get(i+1);
            if(!compare(a1,a2)) ans.add(a1);
            else{
                int[] mergedArray = merge(a1,a2);
                i=i+2;
                while(i<ls.size() && compare(mergedArray,ls.get(i))){
                    mergedArray = merge(mergedArray,ls.get(i));
                    i++;
                }
                ans.add(mergedArray);
                if(i<ls.size()) ans.add(ls.get(i));
            }
        }

        int[][] result = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}
