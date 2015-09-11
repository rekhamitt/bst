package com.bst;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by rekhamittal on 9/10/15.
 */
public class BSTIterator<T extends Comparable<T>> implements Iterable<BST.Node<T>>, Iterator<BST.Node<T>> {
    LinkedList<BST.Node<T>> list = null;

    public BSTIterator(BST<T> bst) {
        list = new LinkedList<BST.Node<T>>();
        BST.Node<T> child;
        for (child = bst.head; child.left != null; child = child.left) {
            list.push(child);
        }
        list.push(child);
    }

    public Iterator<BST.Node<T>> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public BST.Node<T> next() {
        BST.Node<T> current = list.pop();
        for(BST.Node<T> child = current.right; child != null; child=child.left) {
            list.push(child);
        }
        return current;
    }

    @Override
    public void remove() {

    }
}
