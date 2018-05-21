import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.awt.Color;

public class mainMenu extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	Dabbingonthehaters kidz = new Dabbingonthehaters();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu frame = new mainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton btnDab = new JButton("Dab");
		btnDab.setBounds(5, 226, 513, 61);
		btnDab.addActionListener(new ActionListener() {
			int number = 0;
			public void actionPerformed(ActionEvent arg0) {
				Random generator = new Random();
				int choose = generator.nextInt(8);
				while (choose == number) {
					choose = generator.nextInt(8);
				}
				String word = kidz.dab(choose);
				JOptionPane.showMessageDialog(null, word);
				number = choose;
			}
		});
		contentPane.setLayout(null);
		
		JLabel lblTekSimulator = new JLabel("Tek Simulator 2018", SwingConstants.CENTER);
		lblTekSimulator.setBounds(87, 0, 359, 204);
		lblTekSimulator.setFont(new Font("Roboto Condensed", Font.PLAIN, 36));
		contentPane.add(lblTekSimulator);
		contentPane.add(btnDab);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(mainMenu.class.getResource("/resources/dab.jpg")));
		label_1.setBounds(-193, 0, 711, 287);
		contentPane.add(label_1);
		}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
