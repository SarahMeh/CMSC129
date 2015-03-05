
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    public void getLexeme(String file[]){
        JFrame_IOL iol = new JFrame_IOL();
        DefaultTableModel model = (DefaultTableModel) iol.LexTokTable.getModel();
        for (String file1 : file) {
            if (null != file1) switch (file1) {
                case "INTEGER":
                    String input1[]={"INTEGER","Integer"};
                    model.addRow(input1);
                    break;
                case "STRING":
                    String input2[]={"STRING","String"};
                    model.addRow(input2);
                    break;
                case "BOOL":
                    String input3[]={"BOOL","Boolean"};
                    model.addRow(input3);
                    break;
                case "YEAH":
                    String input4[]={"YEAH","true"};
                    model.addRow(input4);
                    break;
                case "NOPE":
                    String input5[]={"NOPE","False"};
                    model.addRow(input5);
                    break;
                case "IS":
                    String input6[]={"IS","Variable Declaration"};
                    model.addRow(input6);
                    break;
                case "INTO":
                    String input7[]={"INTO","Assignment"};
                    model.addRow(input7);
                    break;
                case "BEG":
                    String input8[]={"BEG","Input Operation"};
                    model.addRow(input8);
                    break;
                case "PRINT":
                    String input9[]={"PRINT","Output Operation w/o new line"};
                    model.addRow(input9);
                    break;
                case "PRINTLN":
                    String input10[]={"PRINTLN","Output Operation w/ new line"};
                    model.addRow(input10);
                    break;
                case "IOL":
                    String input11[]={"IOL","Code starts"};
                    model.addRow(input11);
                    break;
                case "LOI":
                    String input12[]={"LOI","Code ends"};
                    model.addRow(input12);
                    break;
                case "DEFINE":
                    String input13[]={"DEFINE","Define Division"};
                    model.addRow(input13);
                    break;
                case "END":
                    String input14[]={"END","Section ends"};
                    model.addRow(input14);
                    break;
                case "COMMAND":
                    String input15[]={"COMMAND","Command Division"};
                    model.addRow(input15);
                    break;
                case "AND?":
                    String input16[]={"AND?","And"};
                    model.addRow(input16);
                    break;
                case "OR?":
                    String input17[]={"OR?","Or"};
                    model.addRow(input17);
                    break;
                case "NOT?":
                    String input18[]={"NOT?","Not"};
                    model.addRow(input18);
                    break;
                case "NEWLN":
                    String input19[]={"NEWLN","New Line"};
                    model.addRow(input19);
                    break;
                case "ADD":
                    String input20[]={"ADD","Addition"};
                    model.addRow(input20);
                    break;
                case "SUB":
                    String input21[]={"SUB","Subtraction"};
                    model.addRow(input21);
                    break;
                case "MULT":
                    String input22[]={"MULT","Multiplication"};
                    model.addRow(input22);
                    break;
                case "DIV":
                    String input23[]={"DIV","Division"};
                    model.addRow(input23);
                    break;
                case "MOD":
                    String input24[]={"MOD","Modulus"};
                    model.addRow(input24);
                    break;
                case "GT?":
                    String input25[]={"GT?","Greater Than"};
                    model.addRow(input25);
                    break;
                case "GTE?":
                    String input26[]={"GTE?","Greater Than or Equal"};
                    model.addRow(input26);
                    break;
                case "LT?":
                    String input27[]={"LT?","Less Than"};
                    model.addRow(input27);
                    break;
                case "LTE?":
                    String input28[]={"LTE?","Less Than or Equal"};
                    model.addRow(input28);
                    break;
                case "EQ?":
                    String input29[]={"EQ?","Equal"};
                    model.addRow(input29);
                    break;
                case "NEQ?":
                    String input30[]={"NEQ?","Not Equal"};
                    model.addRow(input30);
                    break;
                default:
                    iol.variablesTextArea.append(file1+"\n");
            }
        }
    }
}
