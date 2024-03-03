package in.minbox.trees;

class TreeAncestor {
    private int size;
    private int[] parentIdx;

    public TreeAncestor(int n, int[] parent) {
        this.size = n;
        this.parentIdx = parent;
    }
    
    public int getKthAncestor(int node, int k) {
        if (node >= size) return -1;

        if (k == 1) {
            return parentIdx[node];
        }
        if (parentIdx[node] == 0 && k > 1 || (node == 0)) {
            return -1;
        }
        return getKthAncestor(parentIdx[node], k-1);
    }
}