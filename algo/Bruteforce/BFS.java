package WIL.algo.Bruteforce;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @ 특징
 * Queue 자료구조를 기반으로 구현한다.
 * 노드간의 거리가 같으면 최단거리를 보장한다.
 * @ 구현과정
 * 시작 노드를 첫번째로, 큐에 넣고 방문처리를 한다.
 * 시작 노드와 연결된 노드들을 탐색하여, 해당 노드가 방문처리가 되어있지 않으면, 큐에 넣는다.
 * 시작 노드를 큐에서 제거한다.
 * 해당 과정을 큐가 빌때까지 반복한다.
 */
public class BFS {
    public static void main(String[] args) {
        // 그래프를 이차원 배열로 표현한다.
        // 1번 노드는 2번, 3번, 8번 노드와 연결되있음을 의미한다.
        int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
        // 그래프 길이만큼 방문처리 확인용 boolean 배열 변수를 선언한다.
        boolean[] visited = new boolean[graph.length];
        String result = BFS(1, graph, visited);
        System.out.println("result = " + result);
        // result = 시작 -> 1 -> 2 -> 3 -> 8 -> 6 -> 5 -> 4 -> 7
    }
    public static String BFS(int start, int[][] graph, boolean[] visited){
        // 탐색 순서를 반환하는 StringBuilder 변수 선언
        StringBuilder sb = new StringBuilder("시작");
        Queue<Integer> q = new LinkedList<>();

        q.add(start); // 시작 노드 큐 삽입
        visited[start] = true; // 시작 노드는 방문 처리

        while(!q.isEmpty()){ // 큐가 빌때까지
            int node = q.peek(); // 대상 노드는 큐의 가장 첫번째 노드
            // 대상 노드와 연결되어있는 노드들의 방문처리 확인
            for (int i = 0; i < graph[node].length; i++) {
                int connectNode = graph[node][i];
                if(!visited[connectNode]){ // 연결된 노드가 방문처리되어있지 않으면, 방문처리 후 큐에 삽입
                    visited[connectNode] = true;
                    q.add(connectNode);
                }
            }
            sb.append(" -> ").append(q.poll());
        }
        return sb.toString();
    }
}
