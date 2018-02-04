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
        int[] vals1 = {1, 3, 5};
        int[] vals2 = {2, 4, 6, 7, 8};
        int[] expected = {1,2,3,4,5,6,7,8};

        ListNode result = MergeSortedLists.mergeTwoSortedLists(makeListNode(vals1), makeListNode(vals2));

        Assert.assertArrayEquals(expected, makeArray(result, 8));

        result = MergeSortedLists.mergeTwoSortedLists(makeListNode(vals2), makeListNode(vals1));

        Assert.assertArrayEquals(expected, makeArray(result, 8));
    }

    @Test
    public void TestEdgeCases () {
        int[] equals1 = {1, 3, 5};
        int[] equals2 = {1,3,5};
        int[] expected1 = {1,1,3,3,5,5};

        ListNode result = MergeSortedLists.mergeTwoSortedLists(makeListNode(equals1), makeListNode(equals2));

        Assert.assertArrayEquals(expected1, makeArray(result, 6));

        int[] empty1 = {};
        int[] empty2 = {};
        int[] expected2 = {};

        result = MergeSortedLists.mergeTwoSortedLists(makeListNode(empty1), makeListNode(empty2));

        Assert.assertArrayEquals(expected2, makeArray(result, 0));

        int[] empty3 = {1,2,3};
        int[] expected3 = {1,2,3};

        result = MergeSortedLists.mergeTwoSortedLists(makeListNode(empty1), makeListNode(empty3));

        Assert.assertArrayEquals(expected3, makeArray(result, 3));

        result = MergeSortedLists.mergeTwoSortedLists(makeListNode(empty3), makeListNode(empty1));

        Assert.assertArrayEquals(expected3, makeArray(result, 3));
    }

    private ListNode makeListNode (int[] vals) {
        List<ListNode> nodes = new ArrayList<ListNode>();

        for (int i : vals) {
             nodes.add(new ListNode(i));
        }

        if (nodes.size() == 0)
            return null;

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