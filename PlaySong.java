package moduleTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class PlaySong {
	public void play() {
		String query = "Select * from musicfiles order by Song_Title";
		try (Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3307/MusicPlayer?user=root & password= Praveen@18");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			if (rs == null) {
				System.out.println("The folder is empty");
			} else {
				while (rs.next()) {
					System.out.println("Playing the Song - " + rs.getString("Song_Title"));
					TimeUnit.SECONDS.sleep(20);
				}
				System.out.println("End of Songs");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
