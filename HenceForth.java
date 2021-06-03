package moduleTest;

import java.util.Scanner;

public class HenceForth {

	public static void main(String[] args) {

		int choice = 0; // Main Selection
		int choice1; // play a song
		Scanner sc = new Scanner(System.in);
		while (choice != 5) {

			System.out.println("Music Player");
			System.out.println("1.Play a Song");
			System.out.println("2.Search a Song");
			System.out.println("3.Show all Songs");
			System.out.println("4.Operate on Songs Database");
			System.out.println("5.Exit");
			System.out.println("Please enter your choice:");
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("1.Play all songs");
				System.out.println("2.Play Songs Randomly");
				System.out.println("3.Play a Particular Song");
				System.out.println("Enter your choice:");
				choice1 = sc.nextInt();
				if (choice1 == 1) {
					PlaySong ps = new PlaySong();
					ps.play();
				} else if (choice1 == 2) {
					PlaySongsRandomly ps = new PlaySongsRandomly();
					ps.play();
				} else if (choice1 == 3) {
					PlayParticularSong ps = new PlayParticularSong();
					ps.play();
				} else
					System.out.println("Invalid Input");
			} else if (choice == 2) {
				SearchSong ss = new SearchSong();
				ss.play();
			} else if (choice == 3) {
				ShowSongs ss = new ShowSongs();
				ss.play();
			} else if (choice == 4) {
				System.out.println("1.Add Song");
				System.out.println("2.Edit an existing Song");
				System.out.println("3.Delete an existing Song");
				System.out.println("Enter your choice:");
				choice1 = sc.nextInt();
				if (choice1 == 1) {
					AddSong as = new AddSong();
					as.play();
				} else if (choice1 == 2) {
					EditSongs es = new EditSongs();
					es.play();
				} else if (choice1 == 3) {
					DeleteSong ds = new DeleteSong();
					ds.play();
				} else {
					System.out.println("Invalid input");
				}
			} else if (choice == 5) {
				sc.close();
				System.exit(0);
			}
			
		}
	}

}
