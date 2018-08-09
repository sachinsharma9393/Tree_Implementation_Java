package trees;

/**
 * Created by sachin on 7/2/2018.
 */
public class Recursive_Tree_Traversals {
    public static void main(String[] args) {
        Node root=new Node(1);
        Node.insert(10,root);
        Node.insert(11,root);
        Node.insert(17,root);
        Node.insert(2,root);
        Node.insert(3,root);
        Node.insert(4,root);
        Node.insert(30,root);
        System.out.println("PREORDER TRAVERSAL OF GIVEN TREE\t");
        preorder(root);
        System.out.println("\nINORDER TRAVERSAL OF GIVEN TREE\t");
        inorder(root);
        System.out.println("\nPOSTORDER TRAVERSAL OF GIVEN TREE\t");
        postorder(root);

    }
    private static void postorder(Node root) {
        if(root==null) System.out.println("no nodes");
        else {


            if(root.left!=null)postorder(root.left);
            if(root.right!=null)postorder(root.right);
            System.out.print(root.data+"\t");
        }

    }
    private static void preorder(Node root) {
        if(root==null) System.out.println("no nodes");
        else {

            System.out.print(root.data+"\t");
            if(root.left!=null)preorder(root.left);
            if(root.right!=null)preorder(root.right);
        }
    }


    public static void inorder(Node root) {
        if(root==null) System.out.println("no nodes");
        else {

            if(root.left!=null)inorder(root.left);
            System.out.print(root.data+"\t");
            if(root.right!=null)inorder(root.right);
        }
    }
}
