// ПП-12
// Черниш
// Варіант 3 (19)

import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args)
    {


            try
            {

                int N, n1, n2;

                ArrayList<Integer> firstPath = new ArrayList<>();
                ArrayList<Integer> secondPath = new ArrayList<>();

                Scanner sc = new Scanner(System.in);
                BinarySearchTree mainTree = new BinarySearchTree();

                System.out.println("Enter number of elements of tree:");

                N = sc.nextInt();

                System.out.println("Enter elements of tree:");

                for (int i = 0; i<N; i++)
                {

                    mainTree.add(sc.nextInt());

                }

                System.out.println("First tree:");

                mainTree.print();

                System.out.println();

                System.out.println("Enter first node to find:");

                n1 = sc.nextInt();

                System.out.println("Enter second node to find:");

                n2 = sc.nextInt();

                System.out.println(mainTree.findLCA(firstPath,secondPath,mainTree.treeRoot,n1,n2));


            }
            catch (java.util.InputMismatchException e)
            {

                System.out.println("Please, enter valid number");

            }







    }

    public static class BinarySearchTree {


        class TreeNode {
            int value;

            //left child < right child
            TreeNode leftNode;
            TreeNode rightNode;

            TreeNode(int value) {
                this.value = value;
                rightNode = null;
                leftNode = null;
            }
        }

        TreeNode treeRoot;

        private TreeNode addNode(TreeNode currentNode, int value) {

            if (currentNode == null) {
                return new TreeNode(value);
            }

            if (value < currentNode.value) {
                currentNode.leftNode = addNode(currentNode.leftNode, value);
            } else if (value > currentNode.value) {
                currentNode.rightNode = addNode(currentNode.rightNode, value);
            }

            return currentNode;

        }

        public void add(int value) {
            treeRoot = addNode(treeRoot, value);
        }

        public void printPreOrder(TreeNode node) {
            if (node != null) {
                System.out.print(" " + node.value);
                printPreOrder(node.leftNode);
                printPreOrder(node.rightNode);
            }
        }

        public void print()
        {

            printPreOrder(treeRoot);

        }

        public int findLCA(ArrayList<Integer> firstPath, ArrayList<Integer> secondPath, TreeNode root, int n1, int n2) {

            findPath(root,n1,firstPath);
            findPath(root,n2,secondPath);

            int i;
            for (i = 0; i < firstPath.size() && i < secondPath.size(); i++)
            {

                if (firstPath.get(i)!=secondPath.get(i))
                {

                    break;

                }

            }

            return firstPath.get(i-1);
        }

        private void findPath(TreeNode root, int n, ArrayList<Integer> path)
        {
            if (root == null) {
                return;
            }
            path.add(root.value);

            if (root.value == n) {
                return;
            }

            if (n<root.value)
            {

                findPath(root.leftNode, n, path);

            }

            if (n>root.value)
            {

                findPath(root.rightNode, n, path);

            }
        }


    }



}


