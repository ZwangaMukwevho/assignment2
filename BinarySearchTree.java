// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
	int count = 0;
	int insertCount= 0;
   public void insert ( dataType d)
   {  
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {	
	insertCount = insertCount + 1;
      if (d.compareTo (node.data) <= 0)
      { 
         if (node.left == null){
		
            node.left = new BinaryTreeNode<dataType> (d, null, null);
				}
         else{
            insert (d, node.left);}
      }
      else
      {
	
         if (node.right == null){
            node.right = new BinaryTreeNode<dataType> (d,null, null);
	}
         else{
            insert (d,node.right);}
      }
   }
   
   public BinaryTreeNode<dataType> find ( dataType e)
   {
      if (root == null)
         return null;
      else
         return find (e, root);
   }
   public BinaryTreeNode<dataType> find ( dataType e, BinaryTreeNode<dataType> node )
   {  count = count +1;
      if (e.compareTo (node.data) == 0){
         return node;}

      
      else if (e.compareTo (node.data) < 0){
	count = count + 1;
         return (node.left == null) ? null : find (e, node.left);
         	}
      else{
	//count = count + 1;
         return (node.right == null) ? null : find (e, node.right);
		}
   }
   public int countOps(){
	return count;}
   public int SearchCount(){
	return insertCount;}
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   
}
