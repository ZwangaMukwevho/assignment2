import java.io.File; 
import java.io.FileNotFoundException; 

/** 
        * This class is a driver class that runs methods of the AVLUtiles class
        * It uses the arguments taken from the command line as arguments to methods it runs
	* It specifically runs two methods, one for printing out all areas and the other for printing out searched areas
	*@aurthor Zwanga Mukwevho
        */


public class AVLApp{

	/** @return void, [The method returns nothing]
	*@param Strings which represent a key that is to be searched for the AVLTree
	*This method prints out the areas to the command line
	*/
public static void main(String[] args) throws FileNotFoundException


	{
	AVLUtiles AVLObJ = new AVLUtiles();
	if(args.length==3){
	AVLObJ.printAreas(args[0],args[1],args[2]);
	System.out.println("");

	}
	
	else{
	AVLObJ.printAllAreas();
	}
}

}
