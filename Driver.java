import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver extends JFrame implements ActionListener {

	private JButton movie;
	private JButton show;
	private JButton anime;
	private JButton manga;
	private JLabel message;
	private JPanel panel = new JPanel();
	private byte check;
	private String type;

	public static void main(String[] args) {
		new Driver();

	}

	public Driver() {

		movie = new JButton("Movie");
		show = new JButton("Show");
		anime = new JButton("Anime");
		manga = new JButton("Manga");
		message = new JLabel("Choose what you would like to log.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1368, 768);
		movie.addActionListener(this);
		show.addActionListener(this);
		anime.addActionListener(this);
		manga.addActionListener(this);

		panel.add(message);
		panel.add(anime);
		panel.add(manga);
		panel.add(show);
		panel.add(movie);
		add(panel);
		setVisible(true);
		setResizable(false);

		switch (check) {
		case 0:
			type = "Movie";
			clearScreen();
			break;
		case 1:
			type = "Show";
			clearScreen();
			break;
		case 2:
			type = "Anime";
			clearScreen();
			break;
		case 3:
			type = "Manga";
			clearScreen();
			break;
		}
	}

	public JButton buttonGetter(JButton value) {
		return value;
	}

	public byte getCheck() {
		return check;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == movie) {
			check = 0;
		} else if (e.getSource() == show) {
			check = 1;
		} else if (e.getSource() == anime) {
			check = 2;
		} else if (e.getSource() == manga) {
			check = 3;
		}
	}

	public void clearScreen() {
		panel.removeAll();
		revalidate();
		repaint();
	}

}
