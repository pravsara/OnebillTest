package moduleTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PlaySongsRandomly {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public void play() {
		Random rand = new Random();
		Integer count = 0;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager
					.getConnection("jdbc:mysql://localhost:3307/MusicPlayer?user=root & password= Praveen@18");
			String query = "select * from musicfiles where Song_ID = ?";
			String query1 = "Select count(Song_ID) from musicfiles";
			pstmt = con.prepareStatement(query1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = Integer.parseInt(rs.getString("Count(Song_ID)"));
			}
			pstmt = con.prepareStatement(query);
			while (true) {
				pstmt.setInt(1, rand.nextInt(count));
				rs = pstmt.executeQuery();
				if (rs == null) {
					System.out.println("Folder Empty");
					break;
				} else {
					while (rs.next()) {
						System.out.println("Playing the Song - " + rs.getString("Song_Title"));
						TimeUnit.SECONDS.sleep(20);
					}
				}
			}
		} catch (Exception e) {
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
