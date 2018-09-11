
public class PrintLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        Node node = solution.build(arr);
        solution.work(node);
    }

    public static class Solution {
        /**
         * print list
         * @param root
         */
        public void work(Node list) {
            Node node = list;
            while(node != null) {
                System.out.println(node.val);
                node = node.next;
            }
        }

        /**
         * build list
         * @param arr
         * @return
         */
        public Node build(int[] arr) {
            Node root = new Node(-1); 
            Node tail = root;
            for (int i = 0; i < arr.length; i++) {
                Node node = new Node(arr[i]);
                tail.next = node;
                tail = tail.next;
            }
            return root;
        }
    }
}

class Node {
    int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}