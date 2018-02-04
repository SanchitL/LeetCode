package com.luthra.tests;

import org.junit.*;
import com.luthra.solutions.MergeSortedLists;
import com.luthra.util.*;
import java.util.List;
import java.util.ArrayList;

public class MergeSortedListsTest {
    @Test
    public void TestEqualLength () {
        int[] vals1 = {1, 3, 5};
        int[] vals2 = {2, 4, 6};
        int[] expected = {1,2,3,4,5,6};

        ListNode result = MergeSortedLists.mergeTwoSortedLists(makeListNode(vals1), makeListNode(vals2));

        Assert.assertArrayEquals(expected, makeArray(result, 6));
    }

    @Test
    public void TestLeftOver () {
        
    }

    @Test
    public void TestEdgeCases () {

    }

    private ListNode makeListNode (int[] vals) {
        List<ListNode> nodes = new ArrayList<ListNode>();

        for (int i : vals) {
             nodes.add(new ListNode(i));
        }

        ListNode resultHead = nodes.get(0);
        ListNode resultCurrent = resultHead;

        for (int i = 1; i < nodes.size(); i++) {
            resultCurrent.next = nodes.get(i);
            resultCurrent = resultCurrent.next;
        }

        return resultHead;
    }

    private int[] makeArray (ListNode node, int size) {
        int[] result = new int[size];
        int i = 0;

        while (node != null) {
            result[i] = node.val;
            node = node.next;
            i++;
        }

        return result;
    }
}