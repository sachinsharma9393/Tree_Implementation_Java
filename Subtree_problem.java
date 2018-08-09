package trees;

/**
 * Created by sachin on 7/4/2018.
 */
public class Subtree_problem {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node.insert(2, root);
        Node.insert(3, root);
        Node.insert(4, root);
        Node.insert(5, root);
        Node.insert(6, root);
        Node.insert(7, root);
        Node.insert(8, root);

        Node root1=new Node(3);
        Node.insert(6,root1);
        Node.insert(7,root1);

        Node root2=new Node(2);
        Node.insert(4,root2);
        Node.insert(5,root2);
        Node.insert(8,root2);

        System.out.println("WHETHER ROOT1 IS SUBTREE OF ROOT ??,ANSWER IS " + subtree(root, root1));
        System.out.println("WHETHER ROOT2 IS SUBTREE OF ROOT ??,ANSWER IS " + subtree(root,root2));

    }

    private static boolean subtree(Node root, Node root1) {
    if(root1==null)return true;//null tree is sub tree of each other
        else if(root==null)return false;
        else if(identical(root,root1))return true;
        else
        {
            return subtree(root.left,root1)||subtree(root.right,root1);
        }
    }



    private static boolean identical(Node root, Node root1) {
        if(root==null &&root1==null)return true;

        else if(root!=null && root1!=null) {
            return ((root.data==root1.data) &&identical(root.left,root1.left)&&identical(root.right,root1.right));
        }
        return false;
    }
}

/* *




public static boolean isSubtree(Tree T, Tree S)
    {
      //add code here si subtree
      if(T==null )return false;
      else if(S==null)return true;
     else
      {
          if(identical(S,T))return true;
          else
          {
              return isSubtree(T.left,S)|| isSubtree(T.right,S);
          }

      }
    }
    public static boolean identical(Tree T,Tree S )
    {
        if(T==null && S==null)return true;
        else if(T==null || S==null)return false;
        else
        {
            return ((T.data==S.data) && identical(T.left,S.left) &&
            identical(T.right,S.right));
        }

    }
 */