package SpierceMod2TextAnalyzer;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class TextAnalyzerApp {
			Scanner theRaven = null;
			
	public static void main(String[] args) {
		
		try (Scanner theRaven = new Scanner(new File ("theRaven.txt"));) {
			TreeMap<String, Integer> arrayInput = new TreeMap<String, Integer>();
			 
			while(theRaven.hasNext()) {
				String words = theRaven.next();
				String lowerCaseWords = words.toLowerCase();
				lowerCaseWords = lowerCaseWords.replace("," , " ");
				lowerCaseWords = lowerCaseWords.replace("." , " ");
				lowerCaseWords = lowerCaseWords.replace(";" , " ");
				lowerCaseWords = lowerCaseWords.replace(":" , " ");
				lowerCaseWords = lowerCaseWords.replace("?" , " ");
				lowerCaseWords = lowerCaseWords.replace("!" , " ");
				lowerCaseWords = lowerCaseWords.replace("'" , " ");
				lowerCaseWords = lowerCaseWords.replace("-" , " ");
				lowerCaseWords = lowerCaseWords.replace("_" , " ");
				lowerCaseWords = lowerCaseWords.replace("--" , " ");
				lowerCaseWords = lowerCaseWords.replaceAll(" ", "");
				lowerCaseWords = lowerCaseWords.replaceAll("-", "");
				
				
				if(arrayInput.containsKey(lowerCaseWords)) {
					int count = arrayInput.get(lowerCaseWords) + 1;
					arrayInput.put(lowerCaseWords, count);
				}
				else {
					arrayInput.put(lowerCaseWords, +1);	
					
					}
				} 	
			
			LinkedHashMap<String, Integer> entryOutput = arrayInput.entrySet().stream().sorted(Entry.comparingByValue())
					.collect(
							Collectors.toMap(Entry::getKey,  Entry::getValue, (x,y) -> x, LinkedHashMap::new));
					
				for(HashMap.Entry<String, Integer> sortedEntryOutput:entryOutput.entrySet()) {	
				 System.out.println(sortedEntryOutput);
				 
			}
		}
			 catch (FileNotFoundException e) {
				System.out.println("File can not be found. Check file name and resubmit");
				
			} catch (IOException e) {
			System.out.println("Problem reading the file");
			}
		
	} // end main method
	 
} // end TextAnalyzer Class























//
//File theRaven = new File("theRaven.txt");
//Scanner poemScanner = null;
//
//try {
//	poemScanner = new Scanner(new BufferedReader(new FileReader("theRaven.txt")));
//	
//	while(poemScanner.hasNextLine()) {
//		String Raven = poemScanner.nextLine();
//		System.out.println(Raven);	
//	}
//		
//} catch (FileNotFoundException e) {
//
//	System.out.println("File not found, Please verify file path is entered correctly");
//	
//} catch (IOException e) {
//	System.out.println("Problem reading the file" + theRaven.getName());
//}
//finally {
//	
//	
//	if(poemScanner != null) {
//		poemScanner.close();
//	}
//} // end try block



