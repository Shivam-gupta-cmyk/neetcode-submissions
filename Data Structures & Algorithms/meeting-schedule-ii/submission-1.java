/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // we need to find non overlapping intervals
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            start[i] = interval.start;
            end[i] = interval.end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0,j=0;
        int rooms = 0;
        int maxRooms = 0;
        while (i < n) {

            // New meeting starts before current meeting ends
            if (start[i] < end[j]) {
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                i++;
            }
            // A meeting has ended, so reuse its room
            else {
                rooms--;
                j++;
            }
        }

        return maxRooms;


    }
}
