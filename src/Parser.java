import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    public static void main (String[] args )
    {
        File file =new File("Tap your file path here ");
        BufferedReader readfile=null;
        try {
            FileReader fileReader = new FileReader(file);
            readfile = new BufferedReader(fileReader);
            String line;
            String matching=null;
            String sequence=null;
            while ((line = readfile.readLine()) != null) {
                if (line.startsWith("#=GC SS_cons")){
                    matching = line.substring(27) ;
                    System.out.println(matching);
                }else if(line.startsWith("#=GC RF")) {
                    sequence=line.substring(27);
                    System.out.println(sequence);

                }
            }

        }catch (FileNotFoundException error )
        {
            System.out.println("File was not found! " + file.toString());
        }catch(IOException error ){
            System.out.println("File can not be closed!  " + file.toString());

        }catch(NullPointerException error){
            System.out.println("File can not be opened !"+ file.toString());
        }




    }

}
