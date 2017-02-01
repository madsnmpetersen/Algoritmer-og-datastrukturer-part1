/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author ShameOnU
 */
public class DictBinTree implements Dict
{
    DictBinTreeNode root;
    int nodes;
    int height;
    ArrayList helper;
    
    public DictBinTree()
    {
        root = null;
    }
    
    @Override
    public void insert(int k) 
    {
        DictBinTreeNode insert = root;
        if(insert != null)
        while(insert != null)
        {
            if(k < insert.key)
            {
                if(insert.left == null)
                {
                    insert.left = new DictBinTreeNode(k,insert);
                    insert = null;
                }
                else insert = insert.left;
            }
            else
            {
                if(insert.right == null)
                {
                    insert.right = new DictBinTreeNode(k,insert);
                    insert = null;
                }
                else insert = insert.right;
            }
        }
        else 
        {
            root = new DictBinTreeNode(k,null);
        }
        
        nodes++;
    }

    @Override
    public int[] orderedTraversal() 
    {
        helper = new ArrayList(nodes);
        treeWalk(root);
        int[] result = new int[nodes];
        int i = 0;
        while(helper.size() > 0)
        {
            result[i] = (int)helper.get(0);
            helper.remove(0);
            i++;
        }
        return result;       
    }
    
    private void treeWalk(DictBinTreeNode start)
    {
        if(start != null)
        {
            treeWalk(start.left);
            helper.add(start.key);
            treeWalk(start.right);
        }       
    }

    @Override
    public boolean search(int k) 
    {
        if(root != null)
        {
            DictBinTreeNode search = root;
            while(search.key != k)
            {
                if (search.key <= k)
                {
                    if(search.right != null)
                        search = search.right;
                    else return false;
                }
                else
                {
                    if(search.left != null)
                        search = search.left;
                    else return false;
                }
                    
            }
            return true;
        }
        return false;
    }    
}
