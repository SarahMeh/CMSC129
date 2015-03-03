
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xiandalisay
 */
public class FileOptions {

    private String file_name;
    private String file_directory;
    private String absolute_path;
    private ArrayList source;
    
    private StringBuilder message;
    private final JFileChooser fileChooser;
    private final FileNameExtensionFilter IOL_filter;
    private java.io.File file;

    public FileOptions() {
        this.file_name = "";
        this.file_directory = "";
        this.absolute_path = "";
        this.message = new StringBuilder();
        this.fileChooser = new JFileChooser();
        this.source = new ArrayList();
        this.IOL_filter = new FileNameExtensionFilter("/*IOL File*/IOL File", "iol");
    }

    /*
     * XianDalisay
     */
    public StringBuilder openFile() throws Exception {

        this.fileChooser.setFileFilter(IOL_filter);
        if (this.fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            if (this.absolute_path.equals(fileChooser.getSelectedFile().getAbsolutePath())) { //Checks if same file is loaded
                this.setMessage("You are trying to load the same file.");
            } else {
                this.file_name = fileChooser.getSelectedFile().getName();
                this.file_directory = fileChooser.getSelectedFile().getParent();
                this.absolute_path = fileChooser.getSelectedFile().getAbsolutePath();

                //get the file
                file = fileChooser.getSelectedFile();

                //read text from file
                try ( //create scanner
                    Scanner input = new Scanner(file)) {
                    this.source.clear();
                    //read text from file
                    while (input.hasNext()) {
                        this.source.add(input.nextLine()+"\n");
                    }
                }
                this.setMessage("File named " + this.file_name + " was loaded successfully.\n");
            }

        } else {
            this.source.clear();
            //this.setSource("");
            this.setMessage( "File Selection was cancelled.");
        }

        return this.message;
    }

    public void newFile(String source) {
        if (!this.source.toString().equals(source) && !source.equals("")) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog(null,
                    "Are you sure in creating a new file?\nThere is still an unsaved file.",
                    "Warning", dialogButton);

            if (dialogButton == JOptionPane.YES_OPTION) {
                this.saveFile();
            }
        } 
    }

    public String getSourceCode() {
        String code = "";
        for (Object source1 : this.source) {
            code.concat(source1.toString());
        }
        return code;
    }
    
    public void setMessage(String message) {
        this.message.delete(0, this.message.length());
        this.message.append(message);
    }
    
    /*
    public void setSource(String source) {
        this.source.delete(0, this.source.length());
        this.source.append(source);
    }
    */
    
    public void saveFile() {
    FileWriter fwrite;
        
        try {
            fwrite = new FileWriter("output.out");
            BufferedWriter bwrite = new BufferedWriter(fwrite);
            bwrite.write(getSourceCode());
            bwrite.flush();
        } catch (IOException ex) {
            Logger.getLogger(JFrame_IOL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    public void save_asBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {      
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory( new File( "./") );
        int actionDialog;
        actionDialog = chooser.showSaveDialog(this);
        if ( actionDialog == JFileChooser.APPROVE_OPTION )
        {
            File fileName;
            fileName = new File( chooser.getSelectedFile( ) + ".out" );
            if(fileName == null)
                return;
            if(fileName.exists())
            {
                actionDialog = JOptionPane.showConfirmDialog(this,
                                   "Replace existing file?");
                // may need to check for cancel option as well
                if (actionDialog == JOptionPane.NO_OPTION)
                    return;
            }
            // okay to write file
            BufferedWriter outFile = new BufferedWriter( new FileWriter( fileName ) );
            outFile.write( sourceTextArea.getText( ) ); //put in textfile
            outFile.flush( ); // redundant, done by close()
            outFile.close( );
            //AttestDialog.getInstance( ).showErrorDialog(languageBundle.getString(
                               //"LogFil eAlreadyExists"));
    
            }
        
        }
    */
}
