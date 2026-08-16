class MedianFinder {

    List<Integer> ls;
    public MedianFinder() {
        ls = new ArrayList<>();
    }
    
    public void addNum(int num) {
        ls.add(num);
    }
    
    public double findMedian() {
       Collections.sort(ls);
       int size = ls.size();
       if(size%2==0){
            double ans = ls.get(size/2-1)+ ls.get(size/2);
            return ans*1.0/2;
       }
       else{
            return ls.get(size/2)*1.0;
       }

    }
}
