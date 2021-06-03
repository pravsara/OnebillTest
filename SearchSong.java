package moduleTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchSong {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	static Scanner sc = new Scanner(System.in);

	void play() {
		String SongName = new String();
		System.out.println("Enter Song Name to Search: ");
		SongName = sc.next();
		int count = 0;
		int Song_ID;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager
					.getConnection("jdbc:mysql://localhost:3307/MusicPlayer?user=root & password= Praveen@18");
			String query = "select * from musicfiles where Song_Title = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, SongName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("Song_ID") + " " + rs.getString("Song_Title") + " "
						+ rs.getString("Artist_Name") + " " + rs.getString("Album_Name") + " "
						+ rs.getString("Song_Location") + " " + rs.getString("Description"));
				count++;

			}
			System.out.println("Enter Song ID to play");
			Song_ID = sc.nextInt();
			query = "select * from musicfiles where Song_Id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Song_ID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("Playing the Song - "+rs.getString("Song_Title"));
			}
			if (count == 0) {
				System.out.println("Not Found");
			}

			System.out.println("End");

		} catch (Exception e) {
			System.out.println("Error.. Try Again");
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
