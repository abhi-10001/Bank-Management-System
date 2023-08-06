package bank.management.system;

import java.sql.*;

public class Conn {
    
    /*
    For connecting database to the application we have 5 following steps...
    1. Register the Driver
    2. Create Connection
    3. Create Statement 
    4. Execute Query 
    5. Close Connection
    */
    
    
    Connection c;
    Statement s;
    public Conn() {
        try {
            /*Step 1.
            
             In this step we don't have to write *Class.forName(com.mysql.cj.jdbc.Driver);* below code for resiter the driver, Because we added the 
              neccessary library and java will automatically detect and add required library
            */
            
            //Step 2. 
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root");
            
            //Step 3. 
            s = c.createStatement();
            
        }catch(Exception e) {
                System.out.print(e);
        }
    }
}
