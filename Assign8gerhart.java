/*
Name: Brian Gerhart
CSU ID: 2741107
CIS 265: Assignment 8
Description: This program reads a poem from an input file and places the words in a TreeMap which has a corresponding value that will count how many times each
word occurs within the poem. After this is exicuted we will print the (key+" "+value) of each element in
our TreeMap in decending alphabetical order of the key. 
*/


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Assign8gerhart {

    public static void main(String[] args) throws IOException {


        if (args.length != 1) {//prints invalid if the arg length is not 2
            System.out.println("ERROR, invalid arguments");
        }
        File inputFile = new File(args[0]); //inputs the files to pass as arguments
        Scanner input = new Scanner(inputFile);//Scanner reads input from the input file or first argument
        String line;//creates empty string for input to read
         TreeMap<String, Integer> map = new TreeMap<String, Integer>();//creates
            int num = 0; //variable for counting for extra credit
        while (input.hasNextLine()) {
            
            line = input.nextLine();//starts at first line
            String[] array = line.split("[\\s\\p{P}]");//splits string line into substrings white spaces and punctuation as the delimeter
   
            

                for (int i = 0; i < array.length; i++) {//goes through each line array created

                    String word = array[i].toLowerCase();//converts all keys in string to be lowercase for extra credit

                        if(word.length() > 0) {

                            if (map.get(word) == null) { //if the key location does not exist, we put the key in the treemap with a value of 1  
                                map.put(word, 1);
                                num++; //put method counts +1 for extra credit
                            } else {
                                int value = map.get(word);//if key does exist increment the value of existing key
                                value++;
                                map.put(word, value);
                                num++;//after put method counts +1 for extra credit
                                 }
                       
                           }

                }
        
        
        
        }
    map.forEach((x, y) -> System.out.println(x+" "+y));//prints the key along with the value 
    System.out.println("Total: "+num); //outputs total values for extra credit
     
       }
   

}
