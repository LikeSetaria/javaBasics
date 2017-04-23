package interview;

import pojo.TreeNode;

/**
 * Created by 宝超 on 2017/4/22.
 */
public class BinaryTree {
    /*
    创建二叉树
     */
    private TreeNode root;
    public BinaryTree(){}
    public  BinaryTree(TreeNode root){
        this.root=root;
    }
    public TreeNode getRoot(){
        return this.root;
    }
    public void setRoot(TreeNode root){
        this.root=root;
    }
    /*
    清空二叉树
     */
    public void clear(){
        clear(root);
    }
    //清除子树的所有的节点
    public void clear(TreeNode node){
        if(node!=null){
            clear(node.getLeft());
            clear(node.getRight());
            node=null;
        }
    }
    /*
    判断二叉树是否为空
     */
    public boolean isEmpty(){
        return root==null;
    }
    /*
    求二叉树的高度
     */
    public int height(){
       return    height(root);
    }
    //得到任一子树高度
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }else {
            int l_high=height(node.getLeft());
            int r_high=height(node.getRight());
            return l_high>r_high?l_high+1:r_high+1;
        }
    }
     /*
     求子树的节点数
      */
    public int size(){
        return size(root);
    }
    //求任一节点子树下的节点数
    public int size(TreeNode node){
        if(node==null){
            return 0;
        }else
        {
            return 1+size(node.getLeft())+size(node.getRight());
        }
    }
    /*
    中序遍历
     */
    public void inOrder(TreeNode node){
        if(node!=null){
            inOrder(node.getLeft());
            //访问节点 visit(node);
            inOrder(node.getRight());
        }
    }
}
