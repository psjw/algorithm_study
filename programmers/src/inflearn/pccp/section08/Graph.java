package inflearn.pccp.section08;

import java.util.*;

class Node {
    String name;
    List<Node> links = new LinkedList<>();
    boolean visited;

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, List<Node> links) {
        this.name = name;
        this.links = links;
    }

    void link(Node node) {
        links.add(node);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Node node = (Node) object;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    void visit(){
        this.visited = true;
    }

    boolean isVisited(){
        return this.visited;
    }
}

public class Graph {
    public static void main(String[] args) {
        //Graph
        //Node, Edge

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.link(b);
        a.link(d);
        b.link(a);
        b.link(c);
        b.link(e);
        c.link(b);
        c.link(d);
        d.link(a);
        d.link(c);
        d.link(e);
        e.link(b);
        e.link(d);


        Node target = e;
        //BFS
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(a);
//
//        while (!queue.isEmpty()) {
//            Node n = queue.poll();
//            n.visit();
//            System.out.println(n);
//
//            if (n.equals(target)) {
//                //find!!
//                System.out.println("Found!! " + n);
//                break;
//            }
//
//            for (Node link : n.links) {
//                if(link.isVisited()) continue;
//                if(queue.contains(link)) continue;
//
//                queue.offer(link);
//            }
//        }

        //DFS
        Stack<Node> stack = new Stack<>();
        stack.push(a);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            n.visit();
            System.out.println(n);

            if (n.equals(target)) {
                //find!!
                System.out.println("Found!! " + n);
                break;
            }

            for (Node link : n.links) {
                if(link.isVisited()) continue;
                if(stack.contains(link)) continue;

                stack.push(link);
            }
        }
    }
}
