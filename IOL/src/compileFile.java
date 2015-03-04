
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sarah
 */
public class compileFile {
    public void saveFile(String filename) {
    FileWriter fwrite;
    
        try {
            fwrite = new FileWriter(filename);
            BufferedWriter bwrite = new BufferedWriter(fwrite);
           // bwrite.write(getSourceCode());
            //bwrite.flush();
        } catch (IOException ex) {
            Logger.getLogger(JFrame_IOL.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
//    public String getSourceCode() {
//        String code = "";
//        for (Object source1 : this.source) {
//            code += source1.toString();
//        }
//        return code;
//    }
}
