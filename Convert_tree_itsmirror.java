package trees;

/**
 * Created by sachin on 7/2/2018.
 */
public class Convert_tree_itsmirror {
    public static void main(String[] args) {
        Node root=new Node(1);
        Node.insert(10,root);
        Node.insert(11,root);
        Node.insert(17,root);
        Node.insert(2,root);
        Node.insert(3,root);
        Node.insert(4,root);


        //checking whether 2 trees are mirror of each other
        Node root1=new Node(1);
        Node.insert(11,root1);
        Node.insert(10,root1);
        Node.insert(4,root1);
        Node.insert(3,root1);
        Node.insert(2,root1);
        Node.insert(17,root1);

        System.out.println("\n CHECKING 2 TREES\n" );
        Boolean ans=checkMirror(root,root1);
        if(ans==false) System.out.println("NOT MIRROR of each other");
        else System.out.println("!! MIRROR !!");
        Node root2=new Node(1);
        Node.insert(11,root2);
        Node.insert(10,root2);
        Node.insert(4,root2);
        Node.insert(9,root2);
        Node.insert(0,root2);
        Node.insert(17,root2);

		 ans=checkMirror(root,root2);
        if(!ans)System.out.println("NOT MIRROR of each other");
        else System.out.println("!! MIRROR !!");



         Non_Recursive_Tree_Traversals.level(root);
        make_mirror(root);
        System.out.println();
        Non_Recursive_Tree_Traversals.level(root);

    }

    private static boolean checkMirror(Node root, Node root1) {
      //case 1 both null
        if(root==null&& root1==null)return true;
       //case 2 when any one null
        if(root==null ||root1==null)return false;
        //both not null but data at root do not match
        if(root.data!=root1.data)return false;
        //now if root data matches now we should go to left and rigth sub tree
        else {
           return (checkMirror(root.left,root1.right)&&checkMirror(root.right,root1.left));
        }

    }

    private static void make_mirror(Node root) {
        if(root!=null) {

            make_mirror(root.left);
            make_mirror(root.right);
            //after getting left and right part///swap both
            Node temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
    }
}

