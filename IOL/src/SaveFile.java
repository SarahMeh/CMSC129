
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LJR
 */
public class SaveFile extends JFrame_IOL{
    OpenFileAction of = new OpenFileAction();
    private String file_name;
    private String file_directory;
    
   public void writeFile() throws IOException{ 
        
       /*FileWriter fwrite = new FileWriter((of.fileChooser.getSelectedFile().getParent() + "/output.out"));
        BufferedWriter bwrite = new BufferedWriter(fwrite);
        bwrite.write(of.sb.toString());
        bwrite.flush();
        bwrite.close();*/
   }
}
