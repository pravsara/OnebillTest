package moduleTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PlayParticularSong {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	static Scanner sc = new Scanner(System.in);

	public void play() {
		String SongName = new String();
			System.out.println("Enter Song Name to Search: ");
			SongName = sc.next();
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager
					.getConnection("jdbc:mysql://localhost:3307/MusicPlayer?user=root & password= Praveen@18");
			String query = "select * from musicfiles where Song_Title = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, SongName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("Playing the Song - " + rs.getString("Song_Title"));
				TimeUnit.SECONDS.sleep(20);
			} else {
				System.out.println("Not found....");
			}
			System.out.println("End");
		}

		catch (Exception e) {
			System.out.println("Exception occured");
			e.printStackTrace();
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
