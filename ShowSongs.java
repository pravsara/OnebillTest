package moduleTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowSongs{
	public void play() {
		int count = 0;
		String query = "Select * from musicfiles order by Song_Title";
		try (Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3307/MusicPlayer?user=root & password= Praveen@18");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			while (rs.next()) {
				/*System.out.println(rs.getInt("Song_ID") + " " + rs.getString("Song_Title") + " "
						+ rs.getString("Artist_Name") + " " + rs.getString("Album_Name") + " "
						+ rs.getString("Song_Location") + " " + rs.getString("Description"));
				*/
				System.out.format("%-10d%-50s%-50s%-50s%-50s%-250s\n",rs.getInt("Song_ID"), rs.getString("Song_Title"),
						rs.getString("Artist_Name"),rs.getString("Album_Name"),
					rs.getString("Song_Location"),rs.getString("Description"));
				count++;
			}
			if(count == 0) {
				System.out.println("Nothing to show");
			}
			System.out.println("End of Songs");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
