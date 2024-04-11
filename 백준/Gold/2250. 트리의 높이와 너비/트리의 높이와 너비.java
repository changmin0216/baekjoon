

import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int value;
        int left;
        int right;
        int parent;

        public Node(int value, int left, int right, int parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
    static int n, maxLevel, loc = 1;
    static Node[] tree;
    static int[] levelMax, levelMin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];
        levelMax = new int[n + 1];
        levelMin = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new Node(-1, i, -1, -1);
            levelMax[i] = 0;
            levelMin[i] = n;
        }


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree[cur].left = left;
            tree[cur].right = right;

            if (left != -1) {
                tree[left].parent = cur;
            }
            if (right != -1) {
                tree[right].parent = cur;
            }

        }

        //루트노드를 찾는 과정
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (tree[i].parent == -1) {
                root = i;
                break;
            }
        }

        inorder(root, 1);

        int ans = 0;
        int ansIdx = 0;
        // 각 레벨 별로 너비를 구함
        for (int i = 1; i <= maxLevel; i++) {
            int diff = levelMax[i] - levelMin[i] + 1;
            if (ans < diff) {
                ans = diff;
                ansIdx = i;
            }
        }
        System.out.println(ansIdx + " " + ans);
    }

    static void inorder(int root, int level){
        Node cur = tree[root];

        maxLevel = Math.max(maxLevel, level);

        if (cur.left != -1) {
            inorder(cur.left, level + 1);
        }

        levelMin[level] = Math.min(levelMin[level], loc);
        levelMax[level] = loc++;

        if (cur.right != -1) {
            inorder(cur.right, level + 1);
        }
    }
}
