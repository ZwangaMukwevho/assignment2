

public class LSObject{
	private String key;
	private String zones;
	
 /** 
	*Constructor that initializes the key and zones
	*@param String that contains the key and values
	*/
	public LSObject(String A){
	String[] tempArr4 = value.split("\\s");
	key  = tempArr4[0];
	zones = tempArr4[1];
	
	String[] keys = key.split("_");
		
	}

 /** 
	*Constructor that initializes the key and zones
	*@return returns the key to be searched
	*@param void
	*/
	public String getKey(){
	return key;}

 /** 
	*Constructor that initializes the key and zones
	*@return returns the zones that are searched for by keys
	*@param void
	*/
	public String getZones(){
	return zones;
	}
	
	public String toString(){
	return "The key is "+key[0]+" "key[1]+" "key[2]+" And the zones are: "+zones;
	}
	}
