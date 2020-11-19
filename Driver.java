import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver extends JFrame implements ActionListener {

	private JButton movie, show, anime, manga;
	private JLabel message;
	private JTextField movieText, showText, animeText, mangaText;
	private static JPanel panel = new JPanel();
	private String movieName;
	private String type;
	private JPanel panel2 = new JPanel();

	public static void main(String[] args) {
		new Driver();
	}

	public Driver() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		panel.setLayout(new GridBagLayout());
		movie = new JButton("Movie"); // Initializes
		show = new JButton("Show");
		anime = new JButton("Anime");
		manga = new JButton("Manga");
		message = new JLabel("Choose what you would like to log.");
		movieText = new JTextField();
		showText = new JTextField();
		animeText = new JTextField();
		mangaText = new JTextField();

		movie.setFocusable(false);
		show.setFocusable(false);
		manga.setFocusable(false);
		anime.setFocusable(false);

		movie.addActionListener(this); // Adds listener to movie
		show.addActionListener(this);
		anime.addActionListener(this);
		manga.addActionListener(this);

		message.setHorizontalTextPosition(message.CENTER);
		message.setVerticalTextPosition(message.CENTER);

		panel2.setLayout(new GridLayout(1, 4));
		panel2.setPreferredSize(new Dimension(400, 30));
		panel.add(message, new GridBagConstraints());
		panel2.add(anime, new GridBagConstraints());
		panel2.add(manga, new GridBagConstraints());
		panel2.add(show, new GridBagConstraints());
		panel2.add(movie, new GridBagConstraints());

		panel.add(panel2);
		add(panel); // Adds the panel
		setVisible(true); // Lets person see panel
		setResizable(false); // Cannot resize window
		System.out.println(movieName);
	}

	public JButton buttonGetter(JButton value) {
		return value;
	}

	// Checks what has been clicked by user
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == movie) {
			type = "Movie";
			clearScreen();
			afterButton();
		} else if (e.getSource() == show) {
			type = "Show";
			clearScreen();
		} else if (e.getSource() == anime) {
			type = "Anime";
			clearScreen();
		} else if (e.getSource() == manga) {
			type = "Manga";
			clearScreen();
		}
	}

	/*
	 * Method is used to clear screen after a choice has been made, allowing the
	 * user to enter the name of the show, movie, etc..
	 */
	public static void clearScreen() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}

	public void afterButton() {
		if (type.equals("Movie")) {
			panel.add(new JLabel("Which movie would you like to log?"));
			movieText.addActionListener(this);
			movieText.setPreferredSize(new Dimension(100, 25));
			panel.add(movieText);
			movieName = movieText.getText();
		} else if (type.equals("Manga")) {
			panel.add(new JLabel("Which manga would you like to log?"));
		} else if (type.equals("Anime")) {
			panel.add(new JLabel("Which anime would you like to log?"));
		} else if (type.equals("Show")) {
			panel.add(new JLabel("Which show would you like to log?"));
		}
	}
}
