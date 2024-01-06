import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int startTime[] = {1,2,3,3};
        int endTime[] = {3,4,5,6};
        int profit[] = {50,10,40,70};
        System.out.println(jobScheduling(startTime, endTime, profit));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Job jobSchedules[] = new Job[n];
        for(int i = 0; i < n; i++){
            jobSchedules[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobSchedules, (a, b) -> a.startTime - b.startTime);

        int MEMO[] = new int[n];
        Arrays.fill(MEMO, -1);

        return f(0, jobSchedules, MEMO);
    }

    public static int f(int idx, Job jobSchedules[], int MEMO[]) {
        if (idx >= jobSchedules.length) {
            return 0;
        }

        if(MEMO[idx] != -1){
            return MEMO[idx];
        }

        // skip this job;
        int leave = 0 + f(idx + 1, jobSchedules, MEMO);
        // find next non-overlapping job
        int nextIdx = findLowerBound(idx, jobSchedules[idx].endTime, jobSchedules);
        // take this job
        int take = jobSchedules[idx].profit + f(nextIdx, jobSchedules, MEMO);

        return MEMO[idx] = Math.max(leave, take);
    }

    public static int findLowerBound(int idx, int endTime, Job jobSchedules[]) {
        int left = idx;
        int right = jobSchedules.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (jobSchedules[mid].startTime < endTime) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}