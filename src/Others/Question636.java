package Others;

import java.util.*;

public class Question636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int time = 0;
        for (String log : logs) {
            String[] message = log.split(":");
            int index = Integer.parseInt(message[0]);
            int TimeStamp = Integer.parseInt(message[2]);
            if (message[1].equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += TimeStamp- time;
                }
                stack.push(index);
                time = TimeStamp;
            } else {
                stack.pop();
                result[index] += TimeStamp - time + 1;
                time = TimeStamp + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> logs = new ArrayList<>(Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"));
        List<String> logs2 = new ArrayList<>(Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8"));
        int n = 1;
        Question636 a = new Question636();
        System.out.println(Arrays.toString(a.exclusiveTime(2, logs2)));
    }
}
