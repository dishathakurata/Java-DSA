package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Write a program to construct a Binary Search Tree (BST) and perform the following
a. Traverse the tree in preorder, inorder, postorder and levelorder
b. Count the number of nodes
c. Count the number of leaves
d. Find the height of the tree
e. Search for an item in the tree
f. Remove a node from the tree
 */

public class BST {
	
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static Node root;

    public static void insert(int key) {
        root = insertRec(root, key);
    }

    public static Node insertRec(Node root, int key) {
        if(root == null) {
            root = new Node(key);
            return root;
        }

        if(key < root.key)
            root.left = insertRec(root.left, key);
        
        else if(key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    public static void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void preorder(Node root) {
        if(root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }
    
    public static void levelOrder(Node root) {
    	if(root == null)
    		return;
    	
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(root);
    	
    	while(!queue.isEmpty()) {
    		Node tempNode = queue.poll();
    		System.out.print(tempNode.key + " ");
    		
    		if(tempNode.left != null)
    			queue.add(tempNode.left);
    		
    		if(tempNode.right != null)
    			queue.add(tempNode.right);
    	}
    }

    public static int countNodes(Node root) {
        if(root == null)
            return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int countLeaves(Node root) {
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return 1;
        
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static int height(Node root) {
        if(root == null)
            return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static boolean search(Node root, int key) {
        if(root == null || root.key == key)
            return root != null;
        
        if(key < root.key)
            return search(root.left, key);
        
        else
            return search(root.right, key);
    }

    public static Node remove(Node root, int key) {
        if(root == null)
            return root;
        
        if(key < root.key)
            root.left = remove(root.left, key);
        
        else if(key > root.key)
            root.right = remove(root.right, key);
        
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = remove(root.right, root.key);
        }
        
        return root;
    }

    public static int minValue(Node root) {
        int minv = root.key;
        
        while(root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        
        return minv;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert a node");
            System.out.println("2. Traverse the tree");
            System.out.println("3. Count the number of nodes");
            System.out.println("4. Count the number of leaves");
            System.out.println("5. Find the height of the tree");
            System.out.println("6. Search for an item");
            System.out.println("7. Remove a node");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    insert(value);
                    break;
                
                case 2:
                    System.out.println("Traversal Options:");
                    System.out.println("1. Inorder");
                    System.out.println("2. Preorder");
                    System.out.println("3. Postorder");
                    System.out.println("4. Levelorder");
                    System.out.print("Enter traversal choice: ");
                    int traversalChoice = scanner.nextInt();
                    
                    System.out.print("Tree traversal: ");
                    switch(traversalChoice) {
                        case 1:
                        	System.out.println("Inorder traveral: ");
                            inorder(root);
                            break;
                        
                        case 2:
                        	System.out.println("Preorder traversal: ");
                            preorder(root);
                            break;
                        
                        case 3:
                        	System.out.println("Postorder traversal: ");
                            postorder(root);
                            break;
                        
                        case 4:
                        	System.out.println("Levelorder traversal: ");
                            levelOrder(root);
                            break;
                        
                        default:
                            System.out.println("Invalid choice");
                    }
                    System.out.println();
                    break;
                
                case 3:
                    System.out.println("Number of nodes = " + countNodes(root));
                    break;
                
                case 4:
                    System.out.println("Number of leaves = " + countLeaves(root));
                    break;
                
                case 5:
                    System.out.println("Height of the tree = " + height(root));
                    break;
                
                case 6:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();
                    System.out.println("Item found: " + search(root, searchValue));
                    break;
                
                case 7:
                    System.out.print("Enter value to remove: ");
                    int removeValue = scanner.nextInt();
                    root = remove(root, removeValue);
                    break;
                
                case 8:
                    System.out.println("Exiting...");
                    break;
                
                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 8);

        scanner.close();
    }
}