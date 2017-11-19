import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

public class FormInput extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner spNum;
	private JSpinner[] txtArrays;
	private JLabel[] lbArrays;
	private int num = 0;
	private int[] arrays;
	private JButton btnOK;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				setLockAndFeel();
				try {
					FormInput frame = new FormInput();
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
	public FormInput() {
		setTitle("Nh\u1EADp d\u1EEF li\u1EC7u m\u1EA3ng");
		setBounds(100, 100, 504, 312);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JLabel lblNewLabel = new JLabel("S\u1ED1 ph\u1EA7n t\u1EED c\u1EE7a m\u1EA3ng (t\u1EEB 2 \u0111\u1EBFn 15)");
		lblNewLabel.setBounds(10, 8, 200, 25);
		contentPane.add(lblNewLabel);
		
		SpinnerModel sm = new SpinnerNumberModel(2, 2, 15, 1);
		spNum = new JSpinner(sm);
		JFormattedTextField txt = ((JSpinner.NumberEditor) spNum.getEditor()).getTextField();
		((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
		spNum.setBounds(217, 8, 100, 25);
		contentPane.add(spNum);	
		
		JButton btnCreateArray = new JButton("T\u1EA1o m\u1EA3ng");
		btnCreateArray.setBackground(SystemColor.activeCaption);
		btnCreateArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createArray();
			}
		});
		btnCreateArray.setBounds(337, 8, 120, 25);
		contentPane.add(btnCreateArray);
		
		btnOK = new JButton("Xác nhận");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beAccepted();
			}
		});
		btnOK.setBackground(SystemColor.activeCaption);
		btnOK.setBounds(185, 237, 120, 25);
		contentPane.add(btnOK);
		
	}
	
	public static void setLockAndFeel() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    System.out.println("Cannot set Lock and Feel! Errors!");
		}
	}
	
	public void createArray() {
		deleteArrays();
		num = (Integer)spNum.getValue();
		arrays = new int[num];
		lbArrays = new JLabel[num];
		txtArrays = new JSpinner[num];
		arrays = new int[num];
		
		for (int i = 0; i < num; i++) {
			lbArrays[i] = new JLabel("A[" + i + "]:");
			SpinnerModel smValue = new SpinnerNumberModel(0, 0, 100, 1);
			txtArrays[i] = new JSpinner(smValue);
			JFormattedTextField txt = ((JSpinner.NumberEditor) txtArrays[i].getEditor()).getTextField();
			((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
			contentPane.add(lbArrays[i]);
			contentPane.add(txtArrays[i]);
			lbArrays[i].setSize(40,30);
			if (i == 0 || i == 5 || i == 10) 
				lbArrays[i].setLocation(150 * (i + 1)/5  , 40);
			else
				lbArrays[i].setLocation(lbArrays[i-1].getX(), lbArrays[i-1].getY() + 40);
			txtArrays[i].setSize(50,30);
			txtArrays[i].setLocation(lbArrays[i].getX() + 40, lbArrays[i].getY());
		}
		contentPane.setVisible(true);
		contentPane.validate();
		contentPane.repaint();
	}
	
	public void deleteArrays() {
		for (int i = 0; i < num; i++) {
			lbArrays[i].setVisible(false);
			txtArrays[i].setVisible(false);
			contentPane.remove(lbArrays[i]);
			contentPane.remove(txtArrays[i]);
		}
	}
	
	public void beAccepted() {
		for (int i = 0; i < num; i++) {
			arrays[i] = (int) txtArrays[i].getValue();
			System.out.println(arrays[i]);	
		}
		Frame[] listFrames = Frame.getFrames();
		((FormMain) listFrames[0]).setArray(arrays);
		
		if (num != 0) {
			JOptionPane.showMessageDialog(this, "Đã tạo dữ liệu mảng thành công!\nChuẩn bị thoát!");
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
		else {
			JOptionPane.showMessageDialog(this, "Chưa tạo được dữ liệu mảng!\nChuẩn bị thoát!");
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
			
	}
	
	/*
	 * Get number and arrays back to main.
	 */
	public int getNum() {
		return num;
	}
	
	public int[] getArrays() {
		return arrays;
	}
}
