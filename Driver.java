import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Driver extends JFrame implements ActionListener {

	private JButton movie, show, anime, manga;
	private JLabel message;
	private JTextField movieText, showText, animeText, mangaText
	, movieText2, showText2, animeText2, mangaText2;
	private static JPanel panel = new JPanel();
	private String movieName;
	private String type;
	private JPanel panel2 = new JPanel();
	public static String textS;

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
			System.out.println(textS);
			WriteToFile.writeToFile(movieName);
			
		} else if (e.getSource() == show) {
			type = "Show";
			clearScreen();
			afterButton();
			
		} else if (e.getSource() == anime) {
			type = "Anime";
			clearScreen();
			afterButton();
			
		} else if (e.getSource() == manga) {
			type = "Manga";
			clearScreen();
			afterButton();
			
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

	public String getText() {
		return movieName;

	}

	public void afterButton() {
		if (type.equals("Movie")) {
			whichType(movieText);
		} else if (type.equals("Manga")) {
			whichType(mangaText);
		} else if (type.equals("Anime")) {
			whichType(animeText);
		} else if (type.equals("Show")) {
			whichType(showText);
		}
	}
	
	public void afterButton2() {
		if (type.equals("Movie")){
			
		}
	}

	public void whichType(JTextField type) {
		type.setPreferredSize(new Dimension(300, 25));
		panel.add(type);
		JButton okay = new JButton("Ok");
		panel.add(okay);
		type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movieName = type.getText();
			}

		});

		type.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				type.setText("");

			}

			@Override
			public void focusLost(FocusEvent e) {
				type.setText("Enter the media you would like to log...");

			}

		});
	
		okay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == okay) {
					clearScreen();
					textS = type.getText();
				}
				
			}
			
		});
	}
}


