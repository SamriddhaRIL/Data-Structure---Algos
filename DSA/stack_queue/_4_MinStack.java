package stack_queue;

import linked_list.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem Link : https://leetcode.com/problems/min-stack/
 * Video Explanation :
 *
 * 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
* */
public class _4_MinStack extends SinglyLinkedList{

    Node head = null;
    Integer minValue = Integer.MAX_VALUE;
    ArrayList<Integer> minValues = new ArrayList<>();

    public _4_MinStack() {

    }

    public void push(int val) {
        Node node = new Node(val);

        if (val<minValue) {
            minValue = val;
            minValues.add(minValue);
        }

        if (head==null){
            head = node;
            return;
        }

        node.next = head;
        head = node;
    }

    public void pop() {
        if (head.data == minValue){
            minValues.remove(minValue);
            if (minValues.size()>0) minValue = minValues.get(minValues.size()-1);
            else minValue = 0;
        }
        head = head.next;
    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return minValues.get(minValues.size()-1);
    }

    public static void main(String[] args) {
        _4_MinStack minStack = new _4_MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2

    }
}
