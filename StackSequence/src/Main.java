import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    입력 예제
    8
    4
    3
    6
    8
    7
    5
    2
    1
*/

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = Integer.parseInt(br.readLine());
            Stack stack = new Stack();
            int[] num = new int[count];
            for(int i=0; i<count; i++) {
                num[i] = Integer.parseInt(br.readLine());
            }
            System.out.print(main.makeSequence(stack, num));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String makeSequence(Stack stack, int[] num) {
        StringBuilder sb = new StringBuilder();
        int sequenceNum = 0;
        for(int i=0; i<num.length; i++) {
            while(num[i] > stack.peek()) {
                stack.push(++sequenceNum);
                sb.append("+\n");
            }
            if(num[i] < stack.peek()) {
                return "NO";
            }
            stack.pop();
            sb.append("-\n");
        }
        return sb.toString();
    }
}

class Stack {
    private Node head;
    private int size;

    public Stack() {
        size = 0;
    }
    public void push(int num) {
        Node node = new Node(num);
        node.setNextNode(head);
        head = node;
        size++;
    }
    public int pop() {
        if(head == null) {
            return -1;
        }
        int num = head.getNumber();
        head = head.getNextNode();
        size--;
        return num;
    }
    public int peek() {
        if(head == null) {
            return -1;
        }
        return head.getNumber();
    }
}

class Node {
    private int number;
    private Node nextNode;

    public Node() {
        number = -1;
    }
    public Node(int num) {
        number = num;
    }
    public int getNumber() {
        return number;
    }
    public Node getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node node) {
        nextNode = node;
    }
}