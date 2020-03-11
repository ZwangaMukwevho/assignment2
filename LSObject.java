import java.util.*;
/** 
        * This class that represents a LoadShedding objects that stores the key and zones represented by the key
        * Each of these object will be stored in a BSTree and an AVLTree
        * @author: Zwanga
*/
public class LSObject implements Comparable<LSObject>{
	private String[] keys;
	private String zones;
	private String key;
	
/** 
	*Constructor that initializes the key and zones
	*@param String that contains the key and values
	*/
	public LSObject(String A){
	String[] tempArr4 = A.split(" ",2);
	key  = tempArr4[0];
	zones = tempArr4[1];
	keys = key.split("_");
		
	}

/** 
	*Constructor that initializes the key to be searched for
	*@param String which represent the object to be searched for, and an empty string to overload the first constructor
	*/
	public LSObject(String B,String C){
	key = B;

	}

/** 
	*Accessor method that returns the key
	*@return returns the Key
	*/
	public String getKey(){
	return key;}

/** 
	*Accessor method that returns the zones
	*@return returns the zones
	*/
	public String getZones(){
	return zones;
	}

/** 
	*Method to override the toString method of the LSobject
	*@return String that is to be outputed when printing zones 
	*/	
	public String toString(){
	return "The key is "+keys[0]+" "+keys[1]+" "+keys[2]+" And the zones are: "+zones;
	}

/** 
	*Overriding the compareTo method so that it only compares keys when being used by BST and AVLTrees
	*@return int that is found when comparing two keys, 
	*/
	public int compareTo(LSObject LSO){
	return key.compareTo(LSO.getKey());
	}

	}
