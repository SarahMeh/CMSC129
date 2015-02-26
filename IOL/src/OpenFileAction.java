
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
public class OpenFileAction extends JFrame_IOL {

    private String new_file_name;
    String new_file_directory;

    public OpenFileAction() {
        this.sbr = new StringBuilder();
        this.fileChooser = new JFileChooser();
        this.sb = new StringBuilder();
        this.filter = new FileNameExtensionFilter("Input File", "in");
    }

    JFileChooser fileChooser;
    StringBuilder sb;
    FileFilter filter;
    StringBuilder sbr;
    private java.io.File file;

    public StringBuilder openFile() throws Exception {

        fileChooser.setFileFilter(filter);
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            //get the file
            file = fileChooser.getSelectedFile();

            //read text from file
            try ( //create scanner
                    Scanner input = new Scanner(file)) {
                //read text from file
                while (input.hasNext()) {
                    sb.append(input.nextLine());
                    sb.append("\n");
                }
            }

            this.file_directory = fileChooser.getSelectedFile().getParent();
            System.out.println(this.file_directory);
            
            if (super.file_directory.equals(this.new_file_directory)) { //Checks if same file is loaded
                sbr.replace(0, 1000, "You are trying to load the same file.");
            }
            else {
                this.new_file_name = fileChooser.getSelectedFile().getName();
                sbr.append("File named ").append(this.new_file_name).append(" was loaded successfully.\n");
            }
            
            
        } else {
            sbr.replace(0, 1000, "File Selection was cancelled.");
        }
        
        return sbr;
    }
    
    public String getInputString() {
        return sb.toString();
    }

}
