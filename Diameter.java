package trees;

/**
 * Created by sachin on 7/1/2018.
 */
public class Diameter {
    public static void main(String[] args) {
       //here we have to deal with 2 cases when diameter passes through root or not
        Node root=new Node(1);
       root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.left.left=new Node(5);
        root.left.left.left.left=new Node(6);
        root.left.right=new Node(7);
        root.left.right.left=new Node(8);
        root.left.right.left.left=new Node(9);
        //this example is created to create a case where diameter do not passes through root,answer should be 7,and if we take
        //a case where if it passes through root then 6 and 7>6
        System.out.println("DIAMETER OF TREE IS " + diameter(root));

    }

    private static int diameter(Node root) {
    if(root==null)return 0;
        else {
        int dia=0;
        //case-1 if it passes through through then lheight+rheight+1
        int lheight=height(root.left);
        int rheight=height(root.right);

        //case 2 when it do not passes through root,then we will convert that into situation where it passes through root
        //by repeatedly calling diamtere function to left and right sub trees and comparing them

        int ldiamter=diameter(root.left);
        int rdiamter=diameter(root.right);

        dia=Math.max(lheight+rheight+1,Math.max(ldiamter,rdiamter));
    return dia;}
    }

    private static int height(Node root) {
        if(root==null)return 0;
        else {
            int l=height(root.left);
            int r=height(root.right);
            return 1+Math.max(l,r);
        }
    }
}
