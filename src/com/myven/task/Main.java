package com.myven.task;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Main {
	private static ZipFile zipFile = null;
	private static final String PASSWORD_FIRST_PART = "Twg48wT";
	private static final String EXTENSION = "zip"; 
	private static final String SOURCE_ZIP_FOLDER_PATH = "C:\\Users\\prabhakar\\Downloads\\";
	private static final String SOURCE_ZIP_FILE_PATH = SOURCE_ZIP_FOLDER_PATH + "assignment." + EXTENSION;
	
	public static boolean unpack(String password)
    {  
		try {
	        if (zipFile.isEncrypted())
	        {
	            zipFile.setPassword(password);
	        }
	
	        zipFile.extractAll(SOURCE_ZIP_FOLDER_PATH);
	        return true;
		} catch(Exception e) {
			return false;
		}
    }
	
	static void printAllKLength(char[] set, int k) 
	{ 
		int n = set.length; 
		printAllKLengthRec(set, "", n, k); 
	} 
 
	static void printAllKLengthRec(char[] set, 
								String prefix, 
								int n, int k) 
	{ 

		if (k == 0) 
		{ 
			if(unpack(PASSWORD_FIRST_PART + prefix)) {
				System.out.println("PASSWORD IS " + prefix);
				System.exit(0);
			}
			return; 
		} 
 
		for (int i = 0; i < n; ++i) 
		{ 
			// Next character of input added 
			String newPrefix = prefix + set[i]; 

			printAllKLengthRec(set, newPrefix, 
									n, k - 1); 
		} 
	} 

	// Driver Code 
	public static void main(String[] args) throws ZipException
	{ 
		zipFile = new ZipFile(SOURCE_ZIP_FILE_PATH);

		char[] set = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'i', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
				'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}; 
		int k = 3; 
		printAllKLength(set, k); 
	} 
}
