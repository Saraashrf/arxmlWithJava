
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user
 */
public class Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            String fileN=args[0];
            if(!fileN.endsWith(".arxml"))
                throw new NotValidExtension("NotValidAutosarFileException");
            File file=new File(fileN);
            FileInputStream stream = new FileInputStream(file);
            if(stream.read()== -1)
                throw new EmptyException("EmptyAutosarFileException");
            int i;
            StringBuilder sb=new StringBuilder();
            while(( i=stream.read())!= -1){
                sb.append((char)i);
            }
            String data=sb.toString();
            Scanner scanner=new Scanner(data);
            ArrayList<Container> arr= new ArrayList<Container>();
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                if(line.contains("<CONTAINER")){
                    String id=line.substring(line.indexOf("UUID"), line.indexOf(">"));
                    String l1=scanner.nextLine();
                    String sn=l1.substring(l1.indexOf(">")+1,l1.indexOf("</"));
                    String l2=scanner.nextLine();
                    String ln=l2.substring(l2.indexOf(">")+1,l2.indexOf("</"));
                    Container con= new Container(id,sn,ln);
                    arr.add(con);
                }
            }
            Collections.sort(arr);
            String finalN=fileN.substring(0,fileN.indexOf(".") )+"_mod.arxml";
            FileOutputStream outputStream =new FileOutputStream(finalN);
            outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            outputStream.write("<AUTOSAR>\n".getBytes());
            for(int l=0;l<arr.size();l++){
                outputStream.write(arr.get(l).toString().getBytes());
            }
            outputStream.write("</AUTOSAR>\n".getBytes());
        }
        catch(NotValidExtension ex){
            System.out.println(ex);
        }
      
       
        catch (IOException ex) {
            System.out.println("IOException takes place");
        }
    }
    
}
