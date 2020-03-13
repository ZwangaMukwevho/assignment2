import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.io.PrintWriter; 

/** 
        * This class is used to run automate the running of part 1 and part 4 for different dataSets
	* It is run through a python script called python.py
	*@aurthor Zwanga Mukwevho
        */

public class part5{
/** 
        * This method uses BSTdata objects and the learn object for comparisons of the BST and linear array
        * It writes out the comparisons done over a certain interal into a text file
	*@return void
        */
public static void main(String[] args) 
                        throws FileNotFoundException, Exception 
  { 
    //Object that gets methods for BSTTrees
    BSTdata BSTdataobj = new BSTdata();
    File file = new File(args[0]); 
    Scanner sc = new Scanner(file);
    PrintWriter writer = new PrintWriter(args[1], "UTF-8");
    String line;
    String Outputline;

    //Object that gets method for AVLTrees
    AVLUtiles AVLobj = new AVLUtiles();
    int count=0;

    // Heading of output textfile
    Outputline = String.format("%13s %13s  %13s %13s \r\n", "BST_find |", " BST_insert |", "AVL_find |","AVL_insert |");	
    writer.println(Outputline);

    // Variable to hold average case, worst and best case for each dataset
    int avaragecase = 0;
    int bestcase = 100000; //impossible by default,
    int worstcase = 0;
    int counter = 0;
    int BSTinsert = 0;

    // Array best, worst and avarage case
    int AVLBestcase = 1000000;
    int AVLWorstcase = 0;
    int AVLAveragecase = 0;
    int AVLinsert = 0;

while(sc.hasNextLine())
	{

	// Tests code for part3 and part 4
	line = sc.nextLine();
	String[] tempArr= line.split("\\s");
	
	
	int[] CountArr = new int[2];
	int[] AVLArr = new int[2];	
	
	CountArr = BSTdata.printAreas2(tempArr[0], args[0]);
	
	AVLArr = AVLobj.printAreas2(tempArr[0],args[0]);
	
        Outputline = String.format("%15d %15d %15d %15d \r\n", CountArr[0], CountArr[1], AVLArr[1],  AVLArr[0]);	
	writer.println(Outputline);

	// Calculating best, worst and avarage case for BST and AVL
	counter = counter + 1;
	avaragecase = avaragecase + CountArr[0];
	AVLAveragecase = AVLAveragecase + AVLArr[1];
	
        //bestcase for BST
	int[] bestcaseArr = new int[1];
	bestcaseArr[0] = CountArr[0];
	if(bestcaseArr[0]<=bestcase){
	bestcase = bestcaseArr[0];}

	//Bestcase for AVL
	int[] bestcaseArr1 = new int[1];
	bestcaseArr1[0] = AVLArr[1];
	if(bestcaseArr1[0]<=AVLBestcase){
	AVLBestcase = bestcaseArr1[0];}
	
	
	//worstcase for BST
	int[] worstcaseArr = new int[1];
	worstcaseArr[0] = CountArr[0];
	if(worstcaseArr[0]>=worstcase){
	worstcase = worstcaseArr[0];}

	//worstcase for avl
	int[] worstcaseArr1 = new int[1];
	worstcaseArr1[0] = AVLArr[1];
	if(worstcaseArr1[0]>=AVLWorstcase){
	AVLWorstcase = worstcaseArr1[0];}

	// The best, worst and average case of inserting in the AVL and BST trees
	BSTinsert = CountArr[1];
	AVLinsert = AVLArr[0];

	}
	
	// Calculating averageCase for the BST and AVL
	avaragecase = avaragecase/counter;
	AVLAveragecase = AVLAveragecase/counter;

        // Printing out the best, worst and avarage case of each statement to the text files
	writer.println("BST search cases");
	Outputline = String.format("%13s %13s %13s \r\n","BestCase |", " WorstCase |", "AverageCase|");
	writer.println(Outputline);
	Outputline = String.format("%13d %13d %13d  \r\n", bestcase, worstcase,avaragecase);
	writer.println(Outputline);
	
	writer.println("AVL search Cases");
	Outputline = String.format("%13s %13s %13s \r\n", "BestCase |", " WorstCase |", "AverageCase|");
	writer.println(Outputline);
	Outputline = String.format("%13d %13d %13d  \r\n",AVLBestcase , AVLWorstcase,AVLAveragecase);
	writer.println(Outputline);
	
	
	writer.println("BST insert cases");
	Outputline = String.format("%13s %13s %13s \r\n","BestCase |", " WorstCase |", "AverageCase|");
	writer.println(Outputline);
	Outputline = String.format("%13d %13d %13d  \r\n", BSTinsert, BSTinsert,BSTinsert*counter/counter);
	writer.println(Outputline);
	
	writer.println("AVL insert Cases");
	Outputline = String.format("%13s %13s %13s \r\n", "BestCase |", " WorstCase |", "AverageCase|");
	writer.println(Outputline);
	Outputline = String.format("%13d %13d %13d  \r\n", AVLinsert, AVLinsert,AVLinsert*counter/counter);
	writer.println(Outputline);
	

	
	
     writer.close();

    
 
  } 




}


