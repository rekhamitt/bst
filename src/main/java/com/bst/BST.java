package com.bst;

/**
 * Created by rekhamittal on 9/10/15.
 */
public class BST<T extends Comparable<T>> {
    public Node<T> head = null;

    public BST(T data) {
        this.head = new Node(data, null, null);
    }

    public void insertValue(T data) {
        insertNode(data, head);
    }

    public void insertNode(T data, Node<T> node) {
        if(data.compareTo(node.data) > 0) {
            if (node.right != null) {
                if(data.compareTo(node.right.data) > 0) {
                    insertNode(data, node.right);
                } else {
                    insertRightNode(node, data);
                }
            } else {
                insertRightNode(node, data);
            }
        } else if (data.compareTo(node.data) < 0){
            if (node.left != null) {
                if(data.compareTo(node.left.data) < 0) {
                    insertNode(data, node.left);
                } else {
                    insertLeftNode(node, data);
                }
            } else {
                insertLeftNode(node, data);
            }
        }
    }

    public void insertLeftNode(Node<T> node, T data) {
        System.out.println(String.format("Inserting as left node of %s: data %s", node.data, data));
        Node<T> newNode = new Node(data, node.left, null);
        node.left = newNode;
    }

    public void insertRightNode(Node<T> node, T data) {
        System.out.println(String.format("Inserting as right node of %s: data %s", node.data, data));
        Node<T> newNode = new Node(data, null, node.right);
        node.right = newNode;
    }

    public void printInOrder() {
        printInOrder(this.head);
    }

    public void printInOrder(Node<T> node) {
        if (node.left != null) {
            printInOrder(node.left);
        }
        print(node);
        if (node.right != null) {
            printInOrder(node.right);
        }
    }

    public void print(Node<T> node) {
        System.out.println(node.data);
    }
    static class Node<T extends Comparable<T>> {
        private T data;
        public Node<T> left;
        public Node<T> right;

        private Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right  = right;
        }
    }

//    public static void main(String[] args) {
//        BST<Integer> bst = new BST(new Integer(25));
//        bst.insertValue(new Integer(20));
//        bst.insertValue(new Integer(10));
//        bst.insertValue(new Integer(15));
//        bst.insertValue(new Integer(5));
//        bst.insertValue(new Integer(50));
//        bst.insertValue(new Integer(60));
//        BSTIterator<Integer> iter = new BSTIterator(bst);
//        for (Node<Integer> node: iter) {
//            System.out.println(String.format("The iterator node is : %s", node.data));
//        }
//        bst.printInOrder();
//    }
}
