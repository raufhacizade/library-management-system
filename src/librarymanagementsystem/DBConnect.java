package librarymanagementsystem;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBConnect {
    
    public static Connection connect(){
        Connection con=null;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management?","root","");
            //JOptionPane.showMessageDialog(null, "Connection Success");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Connection Unsuccess\n\n"+e);
        }
        return con;
    }
    
}
