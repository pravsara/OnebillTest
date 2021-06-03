package moduleTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class DeleteSong {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static Scanner sc = new Scanner(System.in);
	
	
	void play() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/musicplayer?user=root & password= Praveen@18");
			String query = "delete from musicfiles where Song_Id = ?";
			pstmt = con.prepareStatement(query);
			System.out.println("Enter Song ID: ");
			pstmt.setInt(1, sc.nextInt());
			int count = pstmt.executeUpdate();
			if(count != 0)
				System.out.println("Deleted");
			else
				System.out.println("Not Found");
		} catch (Exception e) {
			System.out.println("Exception occured");
			e.printStackTrace();
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
