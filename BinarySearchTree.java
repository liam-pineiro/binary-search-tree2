package examTwo;

import java.util.Scanner;

import binaryTree.BTNode;

public class BinarySearchTree {
	public static void main(String[ ] args) {
		BTNode<Integer> tree = buildTree();
		
		System.out.println("Binary Search Tree:");
		tree.inorderPrint();
		System.out.println("");
		
		System.out.println("Enter an int to search the tree for: ");
		Scanner userInput = new Scanner(System.in);
		int input = userInput.nextInt();
		
		String btree = inOrderTraversal(tree); 
		findInt(btree, input, tree);
	}
	
	public static BTNode<Integer> buildTree(){
		BTNode<Integer> root;
		BTNode<Integer> child;
		   
		root = new BTNode<Integer>(5, null, null);
		
		child = new BTNode<Integer>(2, null, null);
		child.setLeft(new BTNode<Integer>(1, null, null));
		child.setRight(new BTNode<Integer>(3, null, null));
		root.setLeft(child);
		
		child = new BTNode<Integer>(21, null, null);
		child.setLeft(new BTNode<Integer>(13, null, null));
		child.setRight(new BTNode<Integer>(34, null, null));
		root.setRight(child);
		
		return root;
	}
	
	public static void findInt(String result, int target, BTNode<Integer> tree) {
		String placeholder = "";
		int count = 0;
		int level = 0;
		for(int i = 0; i < result.length(); i++) {
			placeholder += result.charAt(i);
			if(!(placeholder.equals(" "))) {
				if(result.charAt(i+1) != ' ') {
					placeholder += result.charAt(i+1);
					i++;
				}
				if(Integer.parseInt(placeholder) == target) {
					if(Integer.parseInt(placeholder) == 5) {
						level = 1;
					}
					else if(Integer.parseInt(placeholder) == 2 || Integer.parseInt(placeholder) == 21) {
						level = 2;
					}
					else {
						level = 3;
					}
					System.out.println("Int " + placeholder + " located at level " + level);
				}
				else {
					count++;
				}
			}
			placeholder = "";
		}
		if(count == 7) {
			System.out.println("Int not found");
		}
	}
	
	public static String inOrderTraversal(BTNode<Integer>  root) {
        return inOrderTraversalHelper(root).trim();
	}

	private static String inOrderTraversalHelper(BTNode<Integer>  root) {
		if (root == null) {
			return "";
		}

		String left = inOrderTraversalHelper(root.getLeft());
		String current = root.getData() + " ";
		String right = inOrderTraversalHelper(root.getRight());

       
		return left + current + right;
	}
}
