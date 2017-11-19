import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class FormInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormInfo frame = new FormInfo();
					frame.setVisible(true);
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
	public FormInfo() {
		setBounds(100, 100, 322, 257);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new TitledBorder(null, "Th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JTextArea txtInfo = new JTextArea();
		txtInfo.setEditable(false);
		txtInfo.setFont(new Font("Arial", Font.PLAIN, 14));
		txtInfo.setBackground(SystemColor.menu);
		txtInfo.setText("Ph\u1EA7n m\u1EC1m: M\u00F4 ph\u1ECFng thu\u1EADt to\u00E1n s\u1EAFp x\u1EBFp\r\n\u0110\u1ED3 \u00E1n: Nh\u1EADp m\u00F4n l\u1EADp tr\u00ECnh JAVA\r\nL\u1EDBp: SE330.H21\r\nH\u1ECDc k\u00EC: 2. N\u0103m h\u1ECDc 2016 - 2017\r\nGVHD: ThS. Hu\u1EF3nh Tu\u1EA5n Anh\r\nNh\u00F3m: 06\r\n1. Nguy\u1EC5n Thi\u1EC7n Nh\u00E2n 14520626\r\n2. Nguy\u1EC5n H\u1EA3i \u0110\u0103ng 14520128\r\n3. Nguy\u1EC5n Ho\u00E0ng Nam 13520517\r\nEmail: thiennhank9@gmail.com");
		contentPane.add(txtInfo);
	}
}
