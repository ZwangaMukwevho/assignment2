import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;

/** 
        * This class reads in data from the textfile that inludes loadshedding schedules and stores each line in array 
        * It the stores each line in a Binary Search Tree node. 
        * The text in each file is read in using the scanner class by using Scanner class.  
        * @author: Zwanga
*/

public class BSTdata{
 	/** 
	*It then reads each line in the text file and store each line in a BinarySearchTree node
	*@param This methed takes in a file name as its parameter, it also takes in a BinarySearchTreeObject
	*@return void
	*/

	public static void DataCollection1(String a,BinarySearchTree<LSObject> node) throws FileNotFoundException {
	
	File file = new File(a); 
 	Scanner sc = new Scanner(file);
	
 
 
        // Counter variable to count the number of entries in text file
	int counter = 0;
	String line;
	

        // While loop to take in data from text file 
	while(sc.hasNextLine())
	{
	line = sc.nextLine();
	//sc.useDelimiter("\\Z"); 
	String[] tempArr= line.split("\\s");
	
	// Inserting data in each line to array
	counter = counter + 1;
	node.insert(new LSObject(line));
	
	}
	
 	}
	
	 /** 
	*searches for key in a BinarySearchTree and also calculate the number of comparisons made when searching
	*@param Strings which represent a key that is to be searched for in an array
	*@return the number of comparisons made when searching and print out the item if it was found while searching
	*/
	public static int printAreas1(String a, String b, String c)  throws FileNotFoundException
	{
	String check = "false";
	String key = a + "_"+b+"_"+c;
	BinarySearchTree<LSObject> BSTobj = new BinarySearchTree<LSObject>();
        DataCollection1("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt",BSTobj);
	
	try{
	String value2 = BSTobj.find(new LSObject(key,"")).data.getZones();
	System.out.format("match found was %s ",key);
	System.out.println("Which means load shedding of: ");
	System.out.format("Stage %s , on the %sth , at %s:00 ",a,b,c);			
	System.out.format("At zone %s ",value2);
	System.out.println("");
	System.out.format("Number of insert comparisons is %d", BSTobj.SearchCount());
	System.out.println("");
	System.out.format("Number of search comparisons is %d ", BSTobj.countOps());
	System.out.println("");
	    }
	catch(NullPointerException e) 
        { 
	   System.out.format("no match was found for: %s",key);
	System.out.println("");
	   System.out.format("Number of insert comparisons is %d ", BSTobj.SearchCount());
	   System.out.println("");
	   System.out.format("Number of search comparisons is %d ", BSTobj.countOps());
	System.out.println("");
           
        } 			
	
	return BSTobj.countOps();			
	}

	/** 
	*This methed reads a text file, loads it to a BinarySearchTree, and traverses though the Tree inOrder
	*@return void
	*/
	public static void printAllAreas1() throws FileNotFoundException
	{
	BinarySearchTree<LSObject> BSTobj = new BinarySearchTree<LSObject>();
        DataCollection1("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt",BSTobj);
	BSTobj.inOrder();
	System.out.format("Number of insert comparisons is %d", BSTobj.SearchCount());
			
	}

	 /** 
	* method used for part 5 when automating the searching process
	*searches for key in a BinarySearchTree and also calculate the number of comparisons made when searching
	*@param Strings which represent a key that is to be searched for in an array
	*@return the number of comparisons made when searching and print out the item if it was found while searching
	*/
	public static int[]  printAreas2(String c, String d ) throws FileNotFoundException
	{
	String key = c;
	BinarySearchTree<LSObject> BSTobj = new BinarySearchTree<LSObject>();
        DataCollection1(d,BSTobj);

	try{
	BSTobj.find(new LSObject(key,""));
	
	// Output
	int[] keyArr = new int[2];
		keyArr[0] = BSTobj.countOps();		
		keyArr[1] = BSTobj.SearchCount();		
	
	return keyArr;}
	catch(Exception e){
		int[] keyArr = new int[2];
		keyArr[0] = 0;		
		keyArr[1] = 0;		
	
	return keyArr;

		}		
	}

	public static String printAreas3(String a, String b, String c)  throws FileNotFoundException
	{

	String key = a + "_"+b+"_"+c;
	String output = "";
	BinarySearchTree<LSObject> BSTobj = new BinarySearchTree<LSObject>();
        DataCollection1("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt",BSTobj);
	
	try{
	String value2 = BSTobj.find(new LSObject(key,"")).data.getZones();
	output = "match found was "+key +"\n";
	output = output.concat("Which means load shedding of: \n");
	output = output+ "Stage "+a+"on the "+b+"th"+" , at "+c+":00";			
	output = output.concat("At zones ");
	output = output + value2;
	output = output.concat("\nNumber of insert comparisons is ");
	output = output + BSTobj.SearchCount();
	output = output.concat("\nNumber of search comparisons is ");
	output = output + BSTobj.countOps();
	return output;
	    }
	catch(NullPointerException e) 
        { 
	output = "no match was found for: "+key;
	output = output.concat("\nNumber of insert comparisons is ");
	output = output + BSTobj.SearchCount();
	output = output.concat("\nNumber of search comparisons is ");
	output = output + BSTobj.countOps();
	return output;
           
        } 			
	
			
	}

	
	
	
}
