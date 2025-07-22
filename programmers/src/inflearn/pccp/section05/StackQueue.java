package inflearn.pccp.section05;

import java.util.*;

// Queue : offer, poll, peek : 들어간 순서대로
// Stack : push, pop, peek : 들어간 반대로
// Deque : offerFirst, offerLast : 양방향

public class StackQueue {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
        System.out.println(list.remove(0));
        System.out.println(list);

        System.out.println(list.remove(0));
        System.out.println(list);

        System.out.println(list.remove(0));
        System.out.println(list);

        List<Integer> list2 = new LinkedList<>();

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        System.out.println(list2);

        System.out.println(list2.remove(list2.size()-1));
        System.out.println(list2);

        System.out.println(list2.remove(list2.size()-1));
        System.out.println(list2);

        System.out.println(list2.remove(list2.size()-1));
        System.out.println(list2);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        System.out.println("queue = " + queue);

        queue.poll();
        System.out.println("queue = " + queue);
        queue.poll();
        System.out.println("queue = " + queue);

        queue.poll();
        System.out.println("queue = " + queue);
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue = " + queue);

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("stack = " + stack);

        stack.pop();
        System.out.println("stack = " + stack);
        stack.pop();
        System.out.println("stack = " + stack);
        stack.pop();
        System.out.println("stack = " + stack);
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack = " + stack);

        Deque<Integer> deque = new LinkedList<>();

        deque.offerFirst(1);
        System.out.println("deque = " + deque);

        deque.offerLast(2);
        System.out.println("deque = " + deque);

        deque.offerFirst(3);
        System.out.println("deque = " + deque);

        deque.offerLast(4);
        System.out.println("deque = " + deque);

        deque.pollFirst();
        System.out.println("deque = " + deque);
        deque.pollFirst();
        System.out.println("deque = " + deque);

        deque.pollLast();
        System.out.println("deque = " + deque);
    }


}
