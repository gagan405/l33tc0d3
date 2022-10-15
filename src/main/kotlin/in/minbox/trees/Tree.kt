package `in`.minbox.trees

object Tree {
    var root: TreeNode? = null
    var depth: Int = -1

    /*
    Given an array where array elements denote the index of arrays which is the root of this node.
    i.e.,   {1 5 5 2 2 -1 3} means the tree looks like this:
          5
        /  \
       1    2
      /    / \
     0    3   4
         /
        6

     To get the height of the tree, there are some options
     1. First, reconstruct the tree and try get the height
     2. Second, use a hashmap to keep track of the height as we travel the array
     */

    /*
     * This builds a tree and returns the height; the height is computed while the tree is being built
     */

    fun buildTree(arr: IntArray): Tree {
        // first find the root
        var rootVal:Int? = null
        for ((index, value) in arr.withIndex()) {
            if (value == -1) {
                rootVal = index
            }
        }
        // handle cases when root is not found OR more than one found as root
        root = TreeNode(rootVal!!, mutableListOf())

        // recursively build the tree
        depth = populateChildren(root!!, arr, depth + 1)

        return this
    }

    fun populateChildren(node: TreeNode, arr: IntArray, level: Int): Int {
        for ((index, value) in arr.withIndex()) {
            if (value == node.value) {
                node.addChild(TreeNode(index, mutableListOf()))
            }
        }
        var maxDepth = level

        for(child in node.children) {
            maxDepth = Math.max(populateChildren(child, arr, level + 1), maxDepth)
        }

        if (node.children.isEmpty()) {
            node.isLeaf = true
        }

        return maxDepth
    }

    /*
    Get height of the tree without building the tree
     */
    fun getHeight(arr: IntArray): Int {
        val depth: IntArray = IntArray(arr.size) { -1 }

        for (idx in 0..arr.size - 1) {
            fillDepth(arr, idx, depth)
        }

        var max = 0
        for (item in depth) {
            max = maxOf(item, max)
        }

        return max
    }

    private fun fillDepth(arr: IntArray, idx: Int, depth: IntArray) {
        if (depth[idx] != -1) {
            return  //This is already computed
        }
        val parentIdx = arr[idx]

        if (parentIdx == -1) {
            depth[idx] = 0 // this is the root
        } else {
            if (depth[parentIdx] == -1) { // depth of parent is not known
                fillDepth(arr, parentIdx, depth)
            }
            depth[idx] = depth[parentIdx] + 1 // depth = parent depth + 1
        }
    }

    data class TreeNode(val value: Int, val children: MutableList<TreeNode>) {
        var isLeaf: Boolean = false

        fun addChild(child: TreeNode) {
            children.add(child)
        }
    }

}
