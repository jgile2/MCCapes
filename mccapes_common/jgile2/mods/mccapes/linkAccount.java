package jgile2.mods.mccapes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import net.minecraft.entity.player.EntityPlayer;

public class linkAccount {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public linkAccount(String user, String pass){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mccapes","root","");
			st = con.createStatement();
			String SQL= "SELECT * FROM link WHERE user='" + user + "' && pass='" + pass+ "'";
			
			rs = st.executeQuery(SQL);
				
				System.out.println(rs.getRow());
				rs.beforeFirst();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getData(){
		
	}
}
