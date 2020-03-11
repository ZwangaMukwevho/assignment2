import java.io.File; 
import java.io.FileNotFoundException; 

/** 
        * This class is a driver class that runs methods of the BSTdata class
        * It uses the arguments taken from the command line as arguments to methods it runs
	* It specifically runs two methods, one for printing out all areas and the other for printing out searched areas
	*@aurthor Zwanga Mukwevho
        */
class LSBSTApp
{
	/** @return void
	*This method prints out the areas to the command line
	*/
	public static void main(String[] args) throws FileNotFoundException
	{
	BSTdata BSTdataobj = new BSTdata();
	if(args.length==3){
	int x;
	x = BSTdataobj.printAreas1(args[0],args[1],args[2]);
	System.out.println("");
	System.out.format("number of search operations is: %d ",x);
	System.out.println("");

	}
	
	else{
	BSTdataobj.printAllAreas1();
	
	}
}}
