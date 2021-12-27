package interview;

import java.util.*;



public class T04_01 {
    static int[][] graph = new int[][]{{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}};
    static int[][] graph1 = new int[][]{{0, 1}, {0, 3}, {0, 10}, {0, 18}, {1, 2}, {1, 7}, {1, 11}, {1, 12}, {2, 4}, {2, 5}, {2, 13}, {2, 16}, {3, 6}, {3, 8}, {4, 9}, {5, 17}, {7, 20}, {7, 22}, {8, 10}, {10, 19}, {11, 15}, {13, 14}, {14, 21}, {15, 23}, {19, 24}, {20, 22}};
    static int[][] graph2 = new int[][]{{0, 1}, {0, 4}, {0, 12}, {1, 2}, {1, 3}, {1, 5}, {2, 10}, {3, 13}, {5, 6}, {5, 8}, {5, 9}, {5, 19}, {6, 7}, {8, 11}, {8, 14}, {10, 16}, {11, 15}, {12, 14}, {14, 17}, {14, 18}};
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.findWhetherExistsPath(20, graph2, 8, 11);
        System.out.println(res);
    }
    static class Solution{
        int[] DFSFlag;
        boolean isExistPath = false;
        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            ListNode[] nodeArr = init(n, graph);
            //return  BFS(n, nodeArr, start, target);
            DFSFlag = new int[n];
            DFS(nodeArr[start], nodeArr, target);
            return isExistPath;
        }

        public void DFS(ListNode p,ListNode[] nodeArr, int target){
            if(p.next == null ){
                return ;
            }
            ListNode q = p.next;
            while(q != null){
                if(q.val == target)
                    isExistPath = true;
                DFS(nodeArr[q.val], nodeArr, target);
                q = q.next;
            }
        }

        public boolean BFS(int n, ListNode[] nodeArr, int start, int target){
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            int[] flag = new int[n];
            while(queue.size() > 0){
                int s = queue.poll();
                flag[s] = 1;
                ListNode p = nodeArr[s].next;
                while(p != null){
                    if (p.val == target){
                        return true;
                    }
                    if (flag[p.val] == 0){
                        queue.offer(p.val);
                    }
                    p = p.next;
                }
            }
            return false;
        }

        public ListNode[] init(int n, int[][] graph){
            ListNode[] nodeArr = new ListNode[n];
            for (int i = 0; i < n; ++i){
                nodeArr[i] = new ListNode();
            }
            for(int i = 0; i < graph.length; ++i){
                ListNode temp = new ListNode(graph[i][1]);
                temp.next = nodeArr[graph[i][0]].next;
                nodeArr[graph[i][0]].next = temp;
            }
            return nodeArr;
        }
    }
}
