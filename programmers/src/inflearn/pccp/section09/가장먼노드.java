package inflearn.pccp.section09;

import java.util.*;

public class 가장먼노드 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    private static int solution(int n, int[][] edge) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Node> pqueue = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        int maxCount = 0;
        queue.add(new Node(1, 0));
        visited[1] = true;
        pqueue.offer(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i < graph[curNode.node].size(); i++) {
                int nextNode = graph[curNode.node].get(i);
                if (visited[nextNode]) continue;
                visited[nextNode] = true;
                Node next = new Node(nextNode, curNode.count + 1);
                queue.add(next);
                pqueue.offer(next);
                maxCount = Math.max(curNode.count + 1, maxCount);
            }
        }

        int pqueueSize = pqueue.size();
        for (int i = 0; i < pqueueSize; i++) {
            Node node = pqueue.poll();
            if(node.count == maxCount){
                answer++;
            }
        }
        return answer;
    }

    private static class Node implements Comparable<Node> {
        int node;
        int count;

        public Node(int node, int count) {
            this.node = node;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(count, o.count);
        }
    }
}
