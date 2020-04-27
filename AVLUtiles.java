import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;

/** 
        * This class reads in data from the textfile line by line 
        * It the stores each line in the text file in an AVLTree 
        * The text in each file is read in using the scanner class by using Scanner class.  
        * @author: Zwanga
*/

public class AVLUtiles{
/** 
	*Function reads in line by line of a textfile and stores each line in an AVLTree
	*@param This methed takes in a file name as its parameter, it also takes in a AVLTreeObject
	*@return void
	*/
	public static void DataCollection(String a,AVLTree<LSObject> node) throws FileNotFoundException {
	
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
	*searches for key in an AVLTree and also calculate the number of comparisons made when searching
	*@param Strings which represent a key that is to be searched for in an array
	*@return void
	*/
	public static void printAreas(String a, String b, String c)  throws FileNotFoundException
	{
	String check = "false";
	String key = a + "_"+b+"_"+c;
	AVLTree<LSObject> AVLobj = new AVLTree<LSObject> ();
        DataCollection("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt",AVLobj);
	
	try{
	String value2 = AVLobj.find(new LSObject(key,"")).data.getZones();
	System.out.format("match found was %s ",key);
	System.out.println("Which means load shedding of: ");
	System.out.format("Stage %s , on the %sth , at %s:00 ",a,b,c);			
	System.out.format("At zone %s ",value2);
	System.out.println("");
	System.out.format("Number of insert comparisons is %d ", AVLobj.countInsert());
	System.out.println("");
	System.out.format("Number of search comparisons is %d ", AVLobj.countFind());
	System.out.println("");
	    }
	catch(NullPointerException e) 
        { 
	System.out.format("no match was found for: %s",key);
	System.out.println("");
	System.out.format("Number of insert comparisons is %d ", AVLobj.countInsert());
	System.out.println("");
	System.out.format("Number of search comparisons is %d ", AVLobj.countFind());
	System.out.println("");} 			
				
	}

	/** 
	*This methed reads a text file, loads it to an AVLTree, and traverses though the Tree inOrder and prints out each item in the AVLTree
	*@param this method does not take any parameters
	*@return void
	*/
	public static void printAllAreas()  throws FileNotFoundException
	{
	AVLTree<LSObject> AVLobj = new AVLTree<LSObject> ();
        DataCollection("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt",AVLobj);
	AVLobj.levelOrder();
	}

	 /** 
	* method used for part 5 when automating the searching process
	*searches for key in an ALVTree and also calculate the number of comparisons made when searching and inserting the data in the AVLTree
	*@param Strings which represent a key that is to be searched for in an array
	*@return the number of comparisons made when searching and inserting the data in the AVLTree
	*/
	public static int[] printAreas2(String a,String c)  throws FileNotFoundException
	{
	String key = a;
	AVLTree<LSObject> AVLobj = new AVLTree<LSObject> ();
        DataCollection(c,AVLobj);
	
	try{
	String value2 = AVLobj.find(new LSObject(key,"")).data.getZones();
	int[] Arr = new int[2];
		Arr[0] = AVLobj.countInsert();		
		Arr[1] = AVLobj.countFind();		
	
	return Arr;
	
	    }
	catch(Exception e) 
        { int[] Arr = new int[2];
		Arr[0] = 0;		
		Arr[1] = 0;		
	
	return Arr;			
	}
		}
	
	  /** 
	* method used for the Graphic User Interphase to handle the output to the user
	*searches for key in the AVLTree and also calculate the number of comparisons made when searching and inserting the data to the Binary Search Tree
	*@param Strings which represent a key that is to be searched for in an array
	*@return a string which tells the user whether a match was found or not with details of the operations that took place during the search 
	*/
	public static String printAreas2(String a, String b, String c)  throws FileNotFoundException
	{
	String output = "";
	String key = a + "_"+b+"_"+c;
	AVLTree<LSObject> AVLobj = new AVLTree<LSObject> ();
        DataCollection("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt",AVLobj);
	
	try{
	String value2 = AVLobj.find(new LSObject(key,"")).data.getZones();
	output = "match found was "+key +"\n";
	output = output.concat("Which means load shedding of: \n");
	output = output+ "Stage "+a+"on the "+b+" , at "+c+":00";			
	output = output.concat("At zones ");
	output = output + value2;
	output = output.concat("\nNumber of insert comparisons is ");
	output = output + AVLobj.countInsert();
	output = output.concat("\nNumber of search comparisons is ");
	output = output + AVLobj.countFind();
	return output;
	    }
	catch(NullPointerException e) 
        {
	output = "no match was found for: "+key;
	output = output.concat("\nNumber of insert comparisons is ");
	output = output + AVLobj.countInsert();
	output = output.concat("\nNumber of search comparisons is ");
	output = output +AVLobj.countFind();
	return output;
	} 			
				
	}
}


