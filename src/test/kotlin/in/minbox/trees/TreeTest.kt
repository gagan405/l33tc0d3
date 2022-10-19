package `in`.minbox.trees

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TreeTest {
    @Test
    fun getHeight() {
        val tree: Tree = Tree.buildTree(intArrayOf(1,5,5,2,2,-1,3))
        Assertions.assertEquals(3, tree.depth)
        Assertions.assertEquals(3, Tree.getHeight(intArrayOf(1,5,5,2,2,-1,3)))
    }

    @Test
    fun getLinkedListFromTree() {
        val tree: Tree = Tree.buildTree(intArrayOf(1,5,5,2,2,-1,3))
        tree.convertToLL()
    }


    @Test
    fun connectNodesInSameLevel() {
        val treeNode = TreeUp.TreeNode(1, mutableListOf(), null)
        val third = TreeUp.TreeNode(3, mutableListOf(), null)
        treeNode.addChild(TreeUp.TreeNode(2, mutableListOf(), null))
        treeNode.addChild(third)
        treeNode.addChild(TreeUp.TreeNode(4, mutableListOf(), null))

        third.addChild(TreeUp.TreeNode(5, mutableListOf(), null))
        third.addChild(TreeUp.TreeNode(6, mutableListOf(), null))
        third.addChild(TreeUp.TreeNode(7, mutableListOf(), null))

        TreeUp.connectSameLevelNodes(treeNode)
    }
}
