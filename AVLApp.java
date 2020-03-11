import java.io.File; 
import java.io.FileNotFoundException; 

/** 
        * This class is a driver class that runs methods of the AVLUtiles class
        * It uses the arguments taken from the command line as arguments to methods it runs
	* It specifically runs two methods, one for printing out all areas and the other for printing out searched areas
	*@aurthor Zwanga Mukwevho
        */


public class AVLApp{
public static void main(String[] args) throws FileNotFoundException


	{
	AVLUtiles AVLObJ = new AVLUtiles();
	if(args.length==3){
	AVLObJ.printAreas(args[0],args[1],args[2]);

	}
	
	else{
	AVLObJ.printAllAreas();
	}
}

}
