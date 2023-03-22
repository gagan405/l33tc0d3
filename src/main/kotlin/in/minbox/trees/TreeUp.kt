package `in`.minbox.trees

object TreeUp {
    data class TreeNode(val value: Int, val children: MutableList<TreeNode>, var nextNode: TreeNode?) {
        var isLeaf: Boolean = false

        fun addChild(child: TreeNode) {
            children.add(child)
        }
    }

    fun connectSameLevelNodes(root: TreeNode) {
        val marker = TreeNode(-1, mutableListOf(), null)

        val queue = java.util.ArrayDeque<TreeNode>()
        queue.add(root)
        queue.add(marker)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (!node.equals(marker)) {
                val next = queue.peek()
                node.nextNode = if (!next.equals(marker)) next else null

                if (node.children.isNotEmpty()) {
                    for (n in node.children) {
                        queue.add(n)
                    }

                    // The other way is to connect the nodes here and push them to the queue
                    // that will help in removing the marker node, but doesn't improve the code readability
                }
            }

            if (queue.isNotEmpty()) {
                queue.add(marker)
            }
        }
    }
}
