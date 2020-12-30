package interviewcake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Saideep Ullal
 * @author Sivaprasad Kamath
 *
 */
public class MergeRanges {

	public static List<Meeting> mergeRanges(List<Meeting> meetings) {
		Set<Integer> ranges = new HashSet<Integer>();

		// merge meetings ranges
		for (Meeting meeting : meetings) {
			Integer startTime = meeting.getStartTime();
			Integer endTime = meeting.getEndTime();
			// Needs further code optimization here
			for (int i = startTime; i < endTime; i++) {
				ranges.add(i);
			}
		}
		List<Integer> rangesList = new ArrayList<Integer>(ranges);
		Collections.sort(rangesList);
		meetings = new ArrayList<Meeting>();
		Integer previousRange = null;
		Integer startPoint = null;
		for (int i = 0; i < rangesList.size(); i++) {
			Integer currentPoint = rangesList.get(i);
			if (previousRange == null) {
				previousRange = rangesList.get(i);
				startPoint = rangesList.get(i);
				continue;
			}
			if ((currentPoint - previousRange) == 1) {
				previousRange = currentPoint;
			} else {

				meetings.add(new Meeting(startPoint, previousRange + 1));
				startPoint = currentPoint;
				previousRange = currentPoint;
			}

		}
		meetings.add(new Meeting(startPoint, previousRange + 1));

		return meetings;
	}

	
	//Test client
	public static void main(String[] args) {
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(1, 10));
		meetings.add(new Meeting(2, 6));
		meetings.add(new Meeting(3, 5));
		meetings.add(new Meeting(7, 9));
		meetings = MergeRanges.mergeRanges(meetings);
		System.out.println(meetings);
	}

}

class Meeting {

	private int startTime;
	private int endTime;

	public Meeting(int startTime, int endTime) {
		// number of 30 min blocks past 9:00 am
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return this.startTime + " " + this.endTime;
	}
}
