package easy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend
 * all meetings.
 *
 * Example
 * Given intervals = [[0,30],[5,10],[15,20]], return false.
 */
public class MeetingRooms {

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (isConflict(intervals.get(i), intervals.get(j))) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean isConflict(Interval a, Interval b) {
        if ((b.start >= a.end) || (b.end <= a.start)) {
            return false;
        }
        return true;
    }

    /**
     * (465,497),(386,462),(354,380),(134,189),(199,282),(18,104),(499,562),(4,14),(111,129),(292,345)
     * @param args
     */
    public static void main(String[] args) {

        List<Interval> list = new ArrayList<>();
        Interval a = new Interval(465, 497);
        Interval b = new Interval(386, 462);
        Interval c = new Interval(354, 380);
        Interval d = new Interval(134, 189);
        Interval e = new Interval(199, 282);
        Interval f = new Interval(18, 104);
        Interval g = new Interval(499, 562);
        Interval h = new Interval(4, 14);
        Interval i = new Interval(111, 129);
        Interval j = new Interval(292, 345);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);
        list.add(h);
        list.add(i);
        list.add(j);
        System.out.println(new MeetingRooms().canAttendMeetings(list));

        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }

}

class Interval {
    int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
