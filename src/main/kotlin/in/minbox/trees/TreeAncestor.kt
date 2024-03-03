/*
package `in`.minbox.trees

class TreeAncestor(private val size, ) {
    private var size = 0
    private var parentIdx: IntArray

    fun TreeAncestor(n: Int, parent: IntArray) {
        this.size = n
        this.parentIdx = parent
    }

    fun getKthAncestor(node: Int, k: Int): Int {
        if (node >= size) return -1

        if (k == 1) {
            return parentIdx[node]
        }
        if (parentIdx[node] == 0 && k > 1) {
            return -1
        }
        return getKthAncestor(parentIdx[node], k - 1)
    }
}*/
