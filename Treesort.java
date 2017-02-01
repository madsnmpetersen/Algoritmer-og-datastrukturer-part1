/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author ShameOnU
 */
public class Treesort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Dict myTree = new DictBinTree();
        Scanner inputScanner = new Scanner(System.in);
        while(inputScanner.hasNextInt())
        {
            myTree.insert(inputScanner.nextInt());
        }
        int[] numbers = myTree.orderedTraversal();
        for(int i = 0;i < numbers.length; i++)
        {
            System.out.print(numbers[i]+" ");
        }
    }
}
