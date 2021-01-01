package classes;

public class ReverseString {
	
	
    public static void reverse(Character[] arrayOfChars) {

        // reverse input array of characters in place
        
        int insertIndex = 0;
        for(int i=0;i<arrayOfChars.length;i++) {
            Character presentChar = arrayOfChars[arrayOfChars.length-1];
            //arrayOfChars[arrayOfChars.length-1] = null;
            
            for(int j=arrayOfChars.length-1;j>insertIndex;j--) {
                arrayOfChars[j] = arrayOfChars[j-1];
            }
            arrayOfChars[insertIndex] = presentChar;
            insertIndex++;
        }
        
        System.out.println(arrayOfChars);

    }
	

	public static void main(String[] args) {
		
		
		Character[] arrayOfChars =  new Character[] {'n','a','l','i','n','i'};
	ReverseString.reverse(arrayOfChars);

	}

}
