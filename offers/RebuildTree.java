

public class RebuildTree {

    public static void main(String[] args) {
        int[] preArr = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inArr = {4, 7, 2, 1, 5, 3, 8, 6};

    }

    static class Solution {

        public TreeNode work(int[] preArr, int preIdx, int preLen, int[] inArr, int inIdx, int inLen) {
            int num = preArr[preIdx];
            TreeNode node = new TreeNode(num);

            if (preLen == 1) {
                return node;
            }

            int i=inIdx;
            while(i<inIdx+inLen) {
                if (inArr[i] == num) {
                    break;
                }
                i++;
            }

            int len1 = i - inIdx;
            int len2 = inLen - len1 - 1;

            node.left = work(preArr, preIdx+1, len1, inArr, inIdx, len1);
            node.right = work(preArr, preIdx+1+len1, len2, inArr, i+1, len2);

            return node;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(val) {
        this.val = val;
    }
}