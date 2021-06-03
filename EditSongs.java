package moduleTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class EditSongs {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static Scanner sc = new Scanner(System.in);
	
	void play() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/musicplayer?user=root & password= Praveen@18");
			String query = "update musicfiles set Song_Title = ?, Artist_Name = ?, "
					+ "Album_Name = ?, Song_Location = ?, Description = ? where Song_Id = ?";
			pstmt = con.prepareStatement(query);
			System.out.println("Enter Song ID: ");
			pstmt.setInt(6, sc.nextInt());
			System.out.println("Enter the new values:\n");
			System.out.println("Enter Song Name: ");
			pstmt.setString(1, sc.next());
			System.out.println("Enter Artist Name: ");
			pstmt.setString(2, sc.next());
			System.out.println("Enter Album Name: ");
			pstmt.setString(3, sc.next());
			System.out.println("Enter Song Location: ");
			pstmt.setString(4, sc.next());
			System.out.println("Enter Description: ");
			pstmt.setString(5, sc.next());
			int count = pstmt.executeUpdate();
			if(count != 0)
				System.out.println("Updated");
			else
				System.out.println("Song Not Found");
		} catch (Exception e) {
			System.out.println("Error.. Try Again");
		} finally {
			try {
				if(con != null) 
					con.close();
				if(pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
