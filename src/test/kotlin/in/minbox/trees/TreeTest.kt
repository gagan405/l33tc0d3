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
}
