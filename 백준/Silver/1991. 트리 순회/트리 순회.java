

import java.util.*;
import java.io.*;
public class Main {
    private static class Node{
        char value;
        Node left;
        Node right;
        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new Node[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[parent - 'A'] == null) { // 부모가 없을 때
                tree[parent - 'A'] = new Node(parent);
            }

            if (left != '.') { //왼쪽 자식이 있을 때
                tree[left - 'A'] = new Node(left);
                tree[parent - 'A'].left = tree[left - 'A'];
            }

            if (right != '.') { //왼쪽 자식이 있을 때
                tree[right - 'A'] = new Node(right);
                tree[parent - 'A'].right = tree[right - 'A'];
            }

        }
        preorder(tree[0]);
        System.out.println();
        inorder(tree[0]);
        System.out.println();
        postorder(tree[0]);
    }
    static void preorder(Node node){
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }
    static void inorder(Node node){
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }
    static void postorder(Node node){
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

}
