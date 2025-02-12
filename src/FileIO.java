import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileIO {
    private static String filename = "C:\\Users\\akdtu\\OneDrive\\Masaüstü\\JavaProjects\\LoginPage\\src\\output.txt";



    public static void writeInside_The_File(Map<String, String> hashMap, String username, String password) throws IOException{

    //We create a BufferedWriter and set its parameter append as true so that it will not overwrite the file. (won't flush each time)
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true));

    //We write the username and password to the file with a colon between them.
    writer.write(username + ":" + password);
    writer.newLine();

    writer.close();
    }



    public static void writeInside_The_HashMap(Map<String, String> hashMap) throws IOException{
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line;
            //We read the file line by line and split the line with colon.
            //If the line has two parts, we put the first part as key and the second part as value to the hashMap.
            //If it has not two parts, we keep reading the file. (Meaning that the line is empty or we haven't read the password yet)
            while((line = reader.readLine()) != null){
                String[] parts = line.split(":",2);
                if(parts.length == 2){
                    hashMap.put(parts[0], parts[1]);
                }
            }
            reader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}


