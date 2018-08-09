package trees;

/**
 * Created by sachin on 7/4/2018.
 */
public class Identical {
    public static void main(String[] args) {
      //FIRST TREE
        Node root=new Node(10);
        Node.insert(2,root);
        Node.insert(3,root);
        Node.insert(4,root);
        Node.insert(5,root);
        Node.insert(6,root);
        Node.insert(7,root);

        Node root1=new Node(10);
        Node.insert(2,root1);
        Node.insert(3,root1);
        Node.insert(4,root1);
        Node.insert(5,root1);
        Node.insert(6,root1);
        Node.insert(7,root1);

        Node root2=new Node(10);
		Node.insert(2,root2);
        Node.insert(3,root2);
        Node.insert(4,root2);
        Node.insert(5,root2);
        Node.insert(6,root2);


        System.out.println("WHETEHER ROOT,ROOT IDENTICAL?? ANSWER IS " + checkIdentical(root, root1));
        System.out.println("WHETEHER ROOT,ROOT2 IDENTICAL?? ANSWER IS " + checkIdentical(root, root2));
    }
	
	public static boolean checkIdentical(Node root, Node cmp)
	{
		if(root==null && cmp==null)//null tree are identical
		return true;
       else if(root==null||cmp==null)return false;
		else
        {
			return ((root.data==cmp.data)&&checkIdentical(root.left,cmp.left)&&checkIdentical(root.right,cmp.right));
        }

	}
}
