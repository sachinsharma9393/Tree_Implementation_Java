package trees;

/**
 * Created by sachin on 7/8/2018.
 */
public class Foldable_or_not {
    public static void main(String[] args) {
        Node root=new Node(41);
        Node.insert(22,root);
        Node.insert(19,root);
        Node.insert(6,root);
        Node.insert(8,root);
        Node.insert(7,root);
        Node.insert(5,root);
        Node.insert(8,root);
        Node.insert(7,root);
        //just like mirror tree concept

        Node root2=new Node(41);
        Node.insert(22,root2);
        Node.insert(19,root2);
        Node.insert(6,root2);
        Node.insert(8,root2);
        Node.insert(7,root2);
        Node.insert(5,root2);
        foldable(root);
        foldable(root2);
    }

    private static void foldable(Node root) {
        if(root==null)return ;
        else {
           Boolean b= check_foldable(root.left,root.right);
            if(b) System.out.println("FOLDABLE");
            else System.out.println("not foldable");
        }
    }

    private static boolean check_foldable(Node l, Node r) {
    if(l==null &&r==null)return true;

        else {
        if(l==null ||r==null)return false;
       return check_foldable(l.left,r.right)&&check_foldable(l.right,r.left);
    }
    }
}
