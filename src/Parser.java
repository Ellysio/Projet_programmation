import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    public static void main (String[] args )
    {
        File file =new File("C:\\Users\\ilhem\\IdeaProjects\\POO\\Projet_programmation\\src\\RF00005.stockholm.txt");
        //BufferedReader readfile=null;
        //String rows;
        try
        {   FileReader fileReader=new FileReader(file);
            BufferedReader readfile= new BufferedReader(fileReader);
            String line = readfile.readLine();
            System.out.println(line);
        }
        catch (FileNotFoundException e )
        {
            System.err.printf("le fichier %s n'a pas été trouvé" , file.toString());
        }catch(IOException e){
            System.err.println("impossible  " + file.toString());

        }


    }

}
