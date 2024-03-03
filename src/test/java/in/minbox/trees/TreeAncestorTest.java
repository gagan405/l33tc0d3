package in.minbox.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeAncestorTest {

    @Test
    void getKthAncestor() {
        var treeAncestor = new TreeAncestor(5, new int[]{-1,0,0,1,2});
        assertEquals(-1, treeAncestor.getKthAncestor(3, 5));
        assertEquals(0, treeAncestor.getKthAncestor(3, 2));
        assertEquals(-1, treeAncestor.getKthAncestor(2, 2));
        assertEquals(-1, treeAncestor.getKthAncestor(0, 2));
        assertEquals(0, treeAncestor.getKthAncestor(2, 1));
    }
}