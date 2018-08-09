package trees;

/**
 * Created by sachin on 7/2/2018.
 */
public class Least_Common_Ancestor {
    public static void main(String[] args) {
        Node root=new Node(1);
        Node.insert(10,root);
        Node.insert(11,root);
        Node.insert(17,root);
        Node.insert(2,root);
        Node.insert(3,root);
        Node.insert(4,root);
        Node.insert(30,root);
        Node ans=find_LCA(root,30,3);
        System.out.println("LCA OF 30,3 IS "+ans.data);
       ans= find_LCA(root,17,11);
        System.out.println("LCA OF 17,11 IS "+ans.data);
        ans=find_LCA(root, 17,2);
        System.out.println("LCA OF 17,2 IS "+ans.data);
        ans=find_LCA(root, 17,30);
        System.out.println("LCA OF 17,30 IS "+ans.data);
        ans=find_LCA(root, 30,1);
        System.out.println("LCA OF 30,1 IS "+ans.data);
        ans=find_LCA(root, 3,4);
        System.out.println("LCA OF 3,4 IS "+ans.data);
    }

    private static Node find_LCA(Node root, int p, int q) {
        if(root==null)return root ;

            //forming variant of pre order
            //case 1
            if(root.data==p||root.data==q)
            {
                //System.out.println("LCA of " + p + " and " + q + " is  " + root.data);
                return root;
            }
            Node l=find_LCA(root.left,p,q);
            Node r=find_LCA(root.right,p,q);
            //2 cases if both nodes are there or either one of the nodes is null
            if(l!=null && r!=null)//this statement means we are on different branches so print root as starting parent which will
            //be LCA
            return root;
            else
                return l!=null?l:r;//either one of the nodes or none was found
        }

}
