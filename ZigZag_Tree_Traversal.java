package trees;

import java.util.Stack;

/**
 * Created by sachin on 7/2/2018.
 */
public class ZigZag_Tree_Traversal {
    public static void main(String[] args) {
        Node root=new Node(1);
        Node.insert(2,root);
        Node.insert(3,root);
        Node.insert(4,root);
        Node.insert(5,root);
        Node.insert(6,root);
        Node.insert(7,root);
        Node.insert(8,root);
        Node.insert(9,root);
        Node.insert(10,root);
        Node.insert(11,root);
        Node.insert(12,root);
        Node.insert(13,root);
        Node.insert(14,root);
        Node.insert(15,root);
        System.out.println("level order traversal of tree is ");
        Non_Recursive_Tree_Traversals.level(root);
        System.out.println("\nZIG-ZAG TRAVERSAL IS ");
        zigzag(root);

    }

    private static void zigzag(Node root) {
        Stack<Node>s1=new Stack<>();
        Stack<Node>s2=new Stack<>();
        //concept is to use stack
        //in s2  put left child first then right and in s1 put right first and then left
        if(root==null)return;
        else {

            s1.push(root);
            while (!s1.isEmpty()&&s2.isEmpty())
            {
                //first empty s1 and put all in s2
                while(!s1.isEmpty()){
                    Node temp=s1.pop();
                    System.out.print(temp.data+"\t");
                    //now put its left first then right
                    if(temp.left!=null) s2.push(temp.left);
                    if(temp.right!=null)s2.push(temp.right);
                }


                //now pop from s2
                while(!s2.isEmpty())
                {
                    Node temp=s2.pop();
                    System.out.print(temp.data+"\t");
                    //now put its left first then right
                    if(temp.right!=null)s1.push(temp.right);
                    if(temp.left!=null) s1.push(temp.left);
                }
            }

        }

    }
}
