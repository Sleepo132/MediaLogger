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
	private JTextField movieText, numberOf;
	private static JPanel panel = new JPanel();
	private static String movieName, showNum;
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
			whichType(movieText);

		} else if (e.getSource() == show) {
			type = "Show";
			clearScreen();
			whichType(movieText);

		} else if (e.getSource() == anime) {
			type = "Anime";
			clearScreen();
			whichType(movieText);

		} else if (e.getSource() == manga) {
			type = "Manga";
			clearScreen();
			whichType(movieText);

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
		if (type.equals("Show") || type.equals("Anime")) {
			numberOf = new JTextField("Enter the amount of episodes watched.");
			panel.add(numberOf);
			JButton okay2 = new JButton("OK");
			numberOf.setPreferredSize(new Dimension(300, 25));

			numberOf.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					showNum = numberOf.getText();
				}

			});

			okay2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					showNum = numberOf.getText();
				}

			});

		} else if (type.equals("Manga")) {
			numberOf = new JTextField("Enter the amount of chapters read.");
			panel.add(numberOf);
			JButton okay2 = new JButton("OK");
			numberOf.setPreferredSize(new Dimension(300, 25));

			numberOf.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					showNum = numberOf.getText();
				}

			});

			okay2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					showNum = numberOf.getText();
				}

			});
		}
	}

	public void whichType(JTextField type) {
		panel.add(type);
		JButton okay = new JButton("Ok");
		panel.add(okay);
		type.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				movieName = type.getText();
			}
		});

		okay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == okay) {
					movieName = type.getText();
					if (movieName == null || movieName.isBlank()) {
						System.out.println("Name of media is not valid.");
						clearScreen();
						afterButton();
					}
				}

			}
		});
	}
}
