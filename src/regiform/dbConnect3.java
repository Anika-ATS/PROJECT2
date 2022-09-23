package regiform;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class dbConnect3 {

	
		private Connection con;
		Statement st;
		dbConnect3(){
		
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/home", "root","");
					 								
					 st= con.createStatement();
				     } catch(Exception e)
				     {
				    	 System.out.println(e);
				     }
				        
				}
	
			public void RegisterInsert(String insertQuary)
					{
						
							try {
								st.executeUpdate(insertQuary);
								JOptionPane.showMessageDialog(null, " Done !! Your registration is completed");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, "Your registration is not completed");
								 System.out.println(e);
								e.printStackTrace();
							}
							
							
							
							
	}
			
			public void SaveInsert2(String insertQuary)
			{
				
					try {
						st.executeUpdate(insertQuary);
						JOptionPane.showMessageDialog(null, " Done !! Your staff info is saved");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Your staff info isn't saved");
						 System.out.println(e);
						e.printStackTrace();
					}
			}
		public void SaveInsert3(String insertQuary)
					{
						
							try {
								st.executeUpdate(insertQuary);
								JOptionPane.showMessageDialog(null, " Done !! data of senior citizen is saved");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, "Your data of senior citizen is not saved");
								 System.out.println(e);
								e.printStackTrace();
							}			
					}
 			public void RegisterInsert4(String insertQuary)
							{
								
									try {
										st.executeUpdate(insertQuary);
										JOptionPane.showMessageDialog(null, " Done !! Your apply is completed");
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										JOptionPane.showMessageDialog(null, "Your apply is not completed");
										 System.out.println(e);
										e.printStackTrace();
									}
													
					
							}
 			
 			public void SaveInsert5(String insertQuary)
			{
				
					try {
						st.executeUpdate(insertQuary);
						JOptionPane.showMessageDialog(null, " Done !! Doctor data  is saved");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Your  Doctor data is not saved");
						 System.out.println(e);
						e.printStackTrace();
					}			
			}
 			
 			
 			
}

