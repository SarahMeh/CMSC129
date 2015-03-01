
import java.util.Scanner;
import javax.swing.JFileChooser;
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
    private StringBuilder source;
    
    private StringBuilder message;
    private final JFileChooser fileChooser;
    private final FileNameExtensionFilter filter;
    private java.io.File file;

    public FileOptions() {
        this.file_name = "";
        this.file_directory = "";
        this.absolute_path = "";
        this.message = new StringBuilder();
        this.fileChooser = new JFileChooser();
        this.source = new StringBuilder();
        this.filter = new FileNameExtensionFilter("/*Input File*/Input File", "in");
    }

    /*
     * XianDalisay
     */
    public StringBuilder openFile() throws Exception {

        this.fileChooser.setFileFilter(filter);
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
                    this.setSource("");
                    //read text from file
                    while (input.hasNext()) {
                        this.source.append(input.nextLine());
                        this.source.append("\n");
                    }
                }
                this.setMessage("File named " + this.file_name + " was loaded successfully.\n");
            }

        } else {
            this.setSource("");
            this.setMessage( "File Selection was cancelled.");
        }

        return this.message;
    }

    public String getSourceCode() {
        return this.source.toString();
    }
    
    public void setMessage(String message) {
        this.message.delete(0, this.message.length());
        this.message.append(message);
    }
    
    public void setSource(String source) {
        this.source.delete(0, this.source.length());
        this.source.append(source);
    }
    
    

}
