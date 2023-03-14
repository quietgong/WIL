package WIL.algo;

import java.util.*;
/*
 * 요구사항 :
 * 응급실에 환자를 치료할 수 있는 병상 N개가 주어지고, 응급실에 들어오는 환자 리스트 careTimes 배열이 주어진다.
 * careTimes 배열 원소는 해당 환자를 치료하는데 걸리는 시간을 의미한다.
 * 예를 들어, 병상이 3개이고 careTimes가 [4,2,2,5,3] 일 때, 1번 환자부터 3번 환자까지 병상에서 치료를 받게 되고,
 * 2만큼 지났을 때, 4번 환자부터 5번 환자까지 병상에 들어오게 되고 1번 환자는 2만큼 지났을 때 치료가 끝나게 된다.
 * 이러할 떄, 치료가 완료되는 환자의 환자 리스트 번호를 출력한다.
 * 해당 경우, careTimes의 2번째, 3번째, 1번째, 5번째, 4번째 환자 순서대로 치료가 끝나므로 [2,3,1,5,4]를 반환해야 한다.
 */
class Solution {
    public static List<Integer> exitOrder(int[] careTimes, int N) {
        // 우선순위 큐를 선언 (배열의 1번 인덱스 기준으로 오름차순 정렬)
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 반환되는 인덱스를 담는 exitOrder
        List<Integer> exitOrder = new ArrayList<>();
        // careTimes 배열의 길이만큼 큐에 careTimes 원소를 삽입한다.
        for (int i = 0; i < careTimes.length; i++) {
            // careTimes=[4,2,2,5,3] 일 때, int[] data = {1,4}, {2,2}, {3,2}, {4,5}, {5,3} 형태로 추가된다.
            int[] data = {i + 1, careTimes[i]};
            queue.offer(data);
            // 큐의 크기가 정해진 최대 크기가 되었을 때
            if(queue.size()==N && queue.size()>0){
                int min = queue.peek()[1]; // {2,2}
                // 최소값만큼 각 원소들의 값을 빼준다.
                for(int[] arr : queue)
                    arr[1]-=min;
                // 최소값에 해당하는 원소들은 0이 되었으므로 0인 값은 큐에서 제거해준다.
                while(queue.size()>0 && queue.peek()[1]==0){
                    exitOrder.add(queue.peek()[0]);
                    queue.poll();
                }
            }
        }
        // 병상에 남아있는 환자가 없을때까지
        while(!queue.isEmpty()){
            exitOrder.add(queue.peek()[0]);
            queue.poll();
        }
        return exitOrder;
    }
    public static void main(String[] args) {
        int[] careTimes = {4, 2, 2, 5, 3};
        int queueSize = 3;
        // 출력 exitOrder(careTimes,queueSize) = [2, 3, 1, 5, 4]
        System.out.println("exitOrder(careTimes,queueSize) = " + exitOrder(careTimes, queueSize));
    }
}
