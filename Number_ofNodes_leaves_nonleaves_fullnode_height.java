package trees;

import java.util.LinkedList;
import java.util.Queue;

public class Number_ofNodes_leaves_nonleaves_fullnode_height {


    public static void main(String[] args) {
        Node root=new Node(20);
        Node.insert(10,root);
        Node.insert(11,root);
        Node.insert(31,root);
        Node.insert(12,root);
        Node.insert(34,root);

        int count=count_nodes(root);
        System.out.println("TOTAL NUMBER OF NODES ARE " + count);
        System.out.println("NON-RECURSIVE NUMBER OF NODES ARE " + count_nodes_non_recursive(root));


        System.out.println("Leaf nodes are " + leaf(root));
        System.out.println("NON-LEAF NODE ARE " + nonleaf(root));
        System.out.println("full odes are " + full(root));
        System.out.println("Height of tree is " + height(root));
        System.out.println("SERACH 31 IN TREE " + search(31,root));
        System.out.println("SERACH 30 IN TREE " + search(30,root));
    }

    private static boolean search(int data, Node root) {
        if(root ==null)return false;
        if(root.getData()==data)return true;
        return search(data,root.left)||search(data,root.right);

        //iterative is easy

    }

    private static int height(Node root) {
        if(root==null)return 0;
            else
        {
            int l=0,r=0;
            if(root.left!=null)l=height(root.left);
            if(root.right!=null)r=height(root.right);
            return Math.max(l,r)+1;
        }

    }

    private static int full(Node root) {
        if(root==null)return 0;
        int l=0,r=0;
        if(root.left!=null &&root.right !=null)
        {
            l=full(root.left);
            r=full(root.right);
            return 1+l+r;
        }
        //now whether any 1 left or right is not null
        if(root.right!=null || root.right!=null)
        {
            if(root.left!=null)l=full(root.left);
                else l=0;
            if(root.right!=null)r=full(root.right);
            else r=0;
            return l+r;
        }
         return 0;//if here case not checking

        //non recursive is easy
    }

    private static int nonleaf(Node root) {
            if(root==null)return 0;
        int l=0,r=0;
            if(root.left!=null||root.right!=null)
            {
                if(root.left!=null)
                {
                   l= nonleaf(root.left);
                }
                else l=0;
                if(root.right!=null)
                {
                    r=nonleaf(root.right);
                }
                else r=0;
                return 1+l+r;
            }
        else return 0;
//non-recursive is easy
    }

    private static int leaf(Node root) {
        if(root==null)return 0;

        else {
            int l=0,r=0;
            if(root.left==null &&root.right==null)return 1;
            else {

                if(root.left !=null)l=leaf(root.left);
                    if(root.right!=null)leaf(root.right);
                return 1+l+r;
            }
        }
       // return 0;

        //non recursive is easy
    }

    private static int  count_nodes(Node root) {
        if(root==null)return 0;
        else {
            int l=0,r=0;
            if(root.left!=null) l=count_nodes(root.left);
            if(root.right!=null) r=count_nodes(root.right);
            return (1+l+r);
        }
    }
    private static int count_nodes_non_recursive(Node root)
    {
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        int count=1;
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            if(temp.left!=null)
            {q.offer(temp.left);
                count++;}
            if(temp.right!=null)
            {
                q.offer(temp.right);
                count++;
            }

        }
        return count;
    }

}
