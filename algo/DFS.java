package WIL.algo;

/*
 * @ 특징
 * 재귀를 기반으로 구현한다.
 * 최단거리를 보장할 수 없다.
 * @ 구현과정
 * 시작 노드를 첫번째로, 방문처리 후 출력한다.
 * 시작 노드와 연결된 노드들을 탐색하여, 해당 노드가 방문처리가 되어있지 않으면, 방문하여 방문처리 후 출력한다.
 * 연결된 노드 중, 방문처리가 되지 않은 노드가 없으면 자신을 호출한 노드로 되돌아간다.
 * 해당 과정을 방문할 노드가 없을때까지 반복한다.
 */
public class DFS {
    // 그래프를 이차원 배열로 표현한다. 1번 노드는 2번, 3번, 8번 노드와 연결되있음을 의미한다.
    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
    // 그래프 길이만큼 방문처리 확인용 boolean 배열 변수를 선언한다.
    static boolean[] visited = new boolean[graph.length];

    public static void main(String[] args) {
        DFS(1); // 1번 노드부터 시작
    }

    static void DFS(int node) {
        visited[node] = true; // 방문처리
        System.out.print(node + " -> "); // 출력
        for (int connectNode : graph[node]) // 해당 노드와 연결된 노드 중
            if (!visited[connectNode]) // 방문되지 않은 노드가 있으면
                DFS(connectNode); // 방문
    }
}