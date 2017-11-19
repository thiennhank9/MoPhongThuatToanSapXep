import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;

public class FormMain extends JFrame {
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Declare JObjects on JFrame
	 */
	
	private JPanel contentPane;
	private JLabel lbTitle;
	private JPanel pnImitiate;
	private JPanel pnTool;
	private JPanel pnArray;
	private JPanel pnCreateArray;
	private JLabel lbNum, lbMaxNum;
	private JSpinner spNum;
	private JButton btnCreateArray, btnDeleteArray, btnSetZero;
	private JPanel pnSetValueArray;
	private JButton btnRandom, btnByHand, btnOpenFile, btnReadFile;
	private JPanel pnCode;
	private JSlider slSize;
	private JScrollPane pnScroll; 
	private DefaultListModel<String> model;
	private ActionListener eInterchangeSort, eSelectionSort, eBubbleSort, eInsertionSort, eShellSort, eHeapSort, eQuickSort, eMergeSort;
	private ChangeListener eSize;
	private JList<String> lsCode;
	private JPanel pnAlgorithm;
	private JRadioButton rdInterchangeSort, rdSelectionSort, rdBubbleSort, rdInsertionSort, rdShellSort, rdHeapSort, rdQuickSort, rdMergeSort;
	private ButtonGroup grSort;
	private JPanel pnControl;
	private JRadioButton rdIncrease, rdDecrease;
	private ActionListener eIncrease, eDecrease;
	private boolean isIncrease = true;
	private JButton btnSort, btnStop;
	private JSlider slSpeed;
    private ChangeListener eSpeed;
	public int num;
	private JLabel[] lbArrays;
	private int[] array;
	private static FormMain frame;
	private Thread[] threads = new Thread[1000000];
	private int curT = -1;
	private int time = 50;
    private int step = 0;	
    private int[] lbI = new int[50];
    private int[] lbJ = new int[50];
    private int[] oriLocat = new int[15];
    private int[] lbL = new int[50];
    private int[] lbR = new int[50];
    private File file = new File ("src//array.txt");
    private float speed;
    private JButton btnNewButton;
    private boolean isStep = false;
    private JLabel lbPoint1 = new JLabel();
    private JLabel lbPoint2 = new JLabel();
    private JLabel lbPointM = new JLabel();
    private Color processingColor = new Color(255, 153, 153);
    private Color selectedGreen = new Color(153, 255, 153);
    private Color selectedYellow = new Color(255, 255, 153);
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				setLockAndFeel();
				try {
					frame = new FormMain();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //set JFrame full screen
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
	public FormMain() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("M\u00F4 ph\u1ECFng thu\u1EADt to\u00E1n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1376, 742);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbTitle = new JLabel("M\u00D4 PH\u1ECENG THU\u1EACT TO\u00C1N");
		lbTitle.setBackground(SystemColor.menu);
		lbTitle.setBounds(5, 5, 1286, 28);
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lbTitle);
		
		pnTool = new JPanel();
		pnTool.setBounds(5, 415, 1350, 287);
		contentPane.add(pnTool);
		
		pnArray = new JPanel();
		pnArray.setBackground(SystemColor.menu);
		pnArray.setBorder(new TitledBorder(null, "D\u1EEF li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		pnCode = new JPanel();
		pnCode.setBackground(SystemColor.menu);
		pnCode.setBorder(new TitledBorder(null, "Code C/C++", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		pnAlgorithm = new JPanel();
		pnAlgorithm.setBackground(SystemColor.menu);
		pnAlgorithm.setBorder(new TitledBorder(null, "L\u1EF1a ch\u1ECDn thu\u1EADt to\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		pnControl = new JPanel();
		pnControl.setBackground(SystemColor.menu);
		pnControl.setBorder(new TitledBorder(null, "\u0110i\u1EC1u khi\u1EC3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_pnTool = new GroupLayout(pnTool);
		gl_pnTool.setHorizontalGroup(
			gl_pnTool.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTool.createSequentialGroup()
					.addComponent(pnArray, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnCode, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnAlgorithm, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnControl, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
		);
		gl_pnTool.setVerticalGroup(
			gl_pnTool.createParallelGroup(Alignment.TRAILING)
				.addComponent(pnArray, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
				.addComponent(pnCode, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
				.addComponent(pnAlgorithm, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
				.addComponent(pnControl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
		);
		pnControl.setLayout(null);
		
		slSpeed = new JSlider();
		slSpeed.setOrientation(SwingConstants.VERTICAL);
		slSpeed.setBounds(267, 21, 32, 244);
        slSpeed.setMinimum(1);
        slSpeed.setMaximum(9);
        slSpeed.setValue(5);
		pnControl.add(slSpeed);
		
		rdIncrease = new JRadioButton("S\u1EAFp x\u1EBFp t\u0103ng d\u1EA7n");
		rdIncrease.setBounds(52, 42, 144, 23);
		pnControl.add(rdIncrease);
		
		rdDecrease = new JRadioButton("S\u1EAFp x\u1EBFm gi\u1EA3m d\u1EA7n");
		rdDecrease.setBounds(52, 87, 144, 23);
		pnControl.add(rdDecrease);
		
		btnSort = new JButton("S\u1EAFp x\u1EBFp");
		btnSort.setBackground(SystemColor.activeCaption);
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if (!isSorted()) {
					setState(3);
					for (int i = 0; i < num; i++) 
						lbArrays[i].setForeground(Color.BLUE);
					
					if (rdInterchangeSort.isSelected())
						InterchangeSort();
					if (rdSelectionSort.isSelected())
						SelectionSort();
					if (rdBubbleSort.isSelected())
						BubbleSort();
					if (rdInsertionSort.isSelected())
						InsertionSort();
					if (rdShellSort.isSelected())
						ShellSort();
					if (rdHeapSort.isSelected()) {
						HeapSort();
						threadReLocate();
					}
					
					if (rdQuickSort.isSelected())
						QuickSort();
					if (rdMergeSort.isSelected())
						MergeSort();
					waitEnd();						
				}
			}
		});
		btnSort.setBounds(52, 140, 120, 25);
		pnControl.add(btnSort);
		
		btnStop = new JButton("||");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteArrays();
				setState(0);
			}
		});
		btnStop.setBackground(SystemColor.activeCaption);
		btnStop.setBounds(52, 192, 120, 25);
		pnControl.add(btnStop);
		pnAlgorithm.setLayout(null);
		
		rdInterchangeSort = new JRadioButton("Interchange Sort");
		rdInterchangeSort.setBounds(24, 44, 149, 23);
		pnAlgorithm.add(rdInterchangeSort);
		
		rdSelectionSort = new JRadioButton("Selection Sort");
		rdSelectionSort.setBounds(24, 70, 149, 23);
		pnAlgorithm.add(rdSelectionSort);
		
		rdBubbleSort = new JRadioButton("Bubble Sort");
		rdBubbleSort.setBounds(24, 96, 149, 23);
		pnAlgorithm.add(rdBubbleSort);
		
		rdInsertionSort = new JRadioButton("Insertion Sort");
		rdInsertionSort.setBounds(24, 122, 149, 23);
		pnAlgorithm.add(rdInsertionSort);
		
		rdShellSort = new JRadioButton("Shell Sort");
		rdShellSort.setBounds(24, 148, 149, 23);
		pnAlgorithm.add(rdShellSort);
		
		rdHeapSort = new JRadioButton("Heap Sort");
		rdHeapSort.setBounds(24, 174, 149, 23);
		pnAlgorithm.add(rdHeapSort);
		
		rdQuickSort = new JRadioButton("Quick Sort");
		rdQuickSort.setBounds(24, 200, 149, 23);
		pnAlgorithm.add(rdQuickSort);
		
		rdMergeSort = new JRadioButton("Merge Sort");
		rdMergeSort.setBounds(24, 226, 149, 23);
		pnAlgorithm.add(rdMergeSort);
		pnCode.setLayout(null);
		
		slSize = new JSlider();
                slSize.setMinimum(13);
                slSize.setMaximum(20);
                slSize.setValue(14);
		slSize.setBounds(20, 21, 466, 26); //default 10, 21, 486, 26
		pnCode.add(slSize);
		
		pnScroll = new JScrollPane();
		pnScroll.setBounds(15, 53, 476, 223); // default 10, 53, 486, 223
		pnCode.add(pnScroll);
		model = new DefaultListModel<>();
		lsCode = new JList<String>(model);
		lsCode.setBorder(new LineBorder(new Color(0, 0, 0)));
		lsCode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lsCode.setFont(new Font("Monospaced",Font.BOLD,14));
		pnScroll.setViewportView(lsCode);
		
		pnCreateArray = new JPanel();
		pnCreateArray.setBackground(SystemColor.menu);
		pnCreateArray.setBorder(new TitledBorder(null, "Kh\u1EDFi t\u1EA1o m\u1EA3ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		pnSetValueArray = new JPanel();
		pnSetValueArray.setBackground(SystemColor.menu);
		pnSetValueArray.setBorder(new TitledBorder(null, "T\u1EA1o d\u1EEF li\u1EC7u m\u1EA3ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_pnArray = new GroupLayout(pnArray);
		gl_pnArray.setHorizontalGroup(
			gl_pnArray.createParallelGroup(Alignment.LEADING)
				.addComponent(pnSetValueArray, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
				.addComponent(pnCreateArray, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
		);
		gl_pnArray.setVerticalGroup(
			gl_pnArray.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnArray.createSequentialGroup()
					.addComponent(pnCreateArray, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pnSetValueArray, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
		);
		
		btnRandom = new JButton("Ng\u1EABu nhi\u00EAn");
		btnRandom.setBackground(SystemColor.activeCaption);
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createRandom();
			}
		});
		btnRandom.setBounds(15, 27, 120, 25);
		
		btnByHand = new JButton("B\u1EB1ng tay");
		btnByHand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormInput formInput = new FormInput();
				formInput.setVisible(true);
				setState(3);
			}
		});
		btnByHand.setBackground(SystemColor.activeCaption);
		btnByHand.setBounds(160, 27, 120, 25);
		
		btnOpenFile = new JButton("M\u1EDF file");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop desktop = null;
				    if (Desktop.isDesktopSupported()) {
				    	desktop = Desktop.getDesktop();
				    }
				    desktop.open(file);
				} catch (IOException ioe) {
					//file isn't existed
				    ioe.printStackTrace();				   
				}
			}
		});
		btnOpenFile.setBackground(SystemColor.activeCaption);
		btnOpenFile.setBounds(15, 61, 120, 25);
		
		btnReadFile = new JButton("\u0110\u1ECDc file");
		btnReadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteArrays();
				try {
					Scanner in = new Scanner(file);
					num = Integer.parseInt(in.nextLine());
					array = new int[num];
					int pos = 0;
					while (in.hasNextLine()) {
						array[pos] = Integer.parseInt(in.nextLine());
						pos++;
					}
					in.close();
					lbArrays = new JLabel[num];
				
					for (int i = 0; i < num; i++) {
						//create label, set text "0"
					
						lbArrays[i] = new JLabel(String.valueOf(array[i]));
						pnImitiate.add(lbArrays[i]);
						
						//set size label
						lbArrays[i].setSize(50,50);
						lbArrays[i].setOpaque(true);
						lbArrays[i].setForeground(Color.BLUE);
						
						//set location label
						if (i == 0)
							lbArrays[i].setLocation(((int) ((18 - num) * 0.5) * 70) + 100, 150);
						else
							lbArrays[i].setLocation(lbArrays[i-1].getX() + 70, 150);
						
						//set fonts
						lbArrays[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
						
						//set background color
						lbArrays[i].setBackground(SystemColor.inactiveCaption);
						
						//set text alignment center
						lbArrays[i].setHorizontalAlignment(SwingConstants.CENTER); 
						lbArrays[i].setVerticalAlignment(SwingConstants.CENTER);
					}
					pnImitiate.setVisible(true);
					pnImitiate.validate();
					pnImitiate.repaint();
					setState(2);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnReadFile.setBackground(SystemColor.activeCaption);
		btnReadFile.setBounds(160, 61, 120, 25);
		pnSetValueArray.setLayout(null);
		pnSetValueArray.add(btnOpenFile);
		pnSetValueArray.add(btnRandom);
		pnSetValueArray.add(btnReadFile);
		pnSetValueArray.add(btnByHand);
		
		lbNum = new JLabel("S\u1ED1 ph\u1EA7n t\u1EED m\u1EA3ng\r\n:");
		lbNum.setBounds(16, 27, 139, 20);
		
		SpinnerModel sm = new SpinnerNumberModel(2, 2, 15, 1);
		spNum = new JSpinner(sm);
		spNum.setBounds(160, 25, 120, 25);
		JFormattedTextField txt = ((JSpinner.NumberEditor) spNum.getEditor()).getTextField();
		((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
		
		btnCreateArray = new JButton("T\u1EA1o m\u1EA3ng");
		btnCreateArray.setBackground(SystemColor.activeCaption);
		btnCreateArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createArrays();
			}
		});
		btnCreateArray.setBounds(160, 59, 120, 25);
		
		btnDeleteArray = new JButton("X\u00F3a m\u1EA3ng");
		btnDeleteArray.setBackground(SystemColor.activeCaption);
		btnDeleteArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteArrays();		
				setState(0);
			}
		});
		btnDeleteArray.setBounds(160, 95, 120, 25);
		
		btnSetZero = new JButton("\u0110\u1EB7t v\u1EC1 0");
		btnSetZero.setBackground(SystemColor.activeCaption);
		btnSetZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setZero();
			}
		});
		btnSetZero.setBounds(15, 95, 120, 25);
		pnCreateArray.setLayout(null);
		pnCreateArray.add(lbNum);
		pnCreateArray.add(btnSetZero);
		pnCreateArray.add(btnCreateArray);
		pnCreateArray.add(spNum);
		pnCreateArray.add(btnDeleteArray);
		
		lbMaxNum = new JLabel("(T\u1ED1i \u0111a 15)");
		lbMaxNum.setHorizontalAlignment(SwingConstants.CENTER);
		lbMaxNum.setBounds(10, 47, 109, 14);
		pnCreateArray.add(lbMaxNum);
		pnArray.setLayout(gl_pnArray);
		pnTool.setLayout(gl_pnTool);
		
		pnImitiate = new JPanel();
		pnImitiate.setBackground(SystemColor.menu);
		pnImitiate.setBorder(new TitledBorder(null, "Khung ch\u1EA1y m\u00F4 ph\u1ECFng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnImitiate.setBounds(5, 44, 1355, 360);
		contentPane.add(pnImitiate);
		pnImitiate.setLayout(null);
                
                lbPoint1.setSize(50, 25);
                lbPoint1.setOpaque(true);
                lbPoint1.setLocation(50, 50);
                lbPoint1.setFont(new Font("Helvetica", Font.BOLD, 17));
                lbPoint1.setBackground(SystemColor.menu);
                lbPoint1.setHorizontalAlignment(SwingConstants.CENTER);
                lbPoint1.setVerticalAlignment(SwingConstants.CENTER);
                pnImitiate.add(lbPoint1);
                pnImitiate.add(lbPoint2);
                lbPoint2.setSize(50, 25);
                lbPoint2.setOpaque(true);
                lbPoint2.setLocation(50, 50);
                lbPoint2.setFont(new Font("Helvetica", Font.BOLD, 17));
                lbPoint2.setBackground(SystemColor.menu);
                lbPoint2.setHorizontalAlignment(SwingConstants.CENTER);
                lbPoint2.setVerticalAlignment(SwingConstants.CENTER);
                pnImitiate.add(lbPointM);
                lbPointM.setSize(50, 25);
                lbPointM.setOpaque(true);
                lbPointM.setLocation(50, 50);
                lbPointM.setFont(new Font("Helvetica", Font.BOLD, 17));
                lbPointM.setBackground(SystemColor.menu);
                lbPointM.setHorizontalAlignment(SwingConstants.CENTER);
                lbPointM.setVerticalAlignment(SwingConstants.CENTER);
		
		grSort = new ButtonGroup();
		grSort.add(rdInterchangeSort);
		grSort.add(rdSelectionSort);
		grSort.add(rdBubbleSort);
		grSort.add(rdInsertionSort);
		grSort.add(rdShellSort);
		grSort.add(rdHeapSort);
		grSort.add(rdQuickSort);
		grSort.add(rdMergeSort);
		rdInterchangeSort.setSelected(true);
		
		ButtonGroup grDirect = new ButtonGroup();
		grDirect.add(rdDecrease);
		grDirect.add(rdIncrease);
		rdIncrease.setSelected(true);

		lsCode.setSelectedIndex(0);
		lsCode.ensureIndexIsVisible(lsCode.getSelectedIndex());
		
		/*
		 * event Action Listener all sorts
		 */
		eInterchangeSort = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  model.removeAllElements();
		    	  addInterchangeSort();
		    	  lsCode.setSelectedIndex(0);
		      }
		};
		
		eSelectionSort = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  model.removeAllElements();
		    	  addSelectionSort();
		    	  lsCode.setSelectedIndex(0);
		      }
		};
		
		eBubbleSort = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  model.removeAllElements();
		    	  addBubbleSort();
		    	  lsCode.setSelectedIndex(0);
		      }
		};
		
		eInsertionSort = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  model.removeAllElements();
		    	  addInsertionSort();
		    	  lsCode.setSelectedIndex(0);
		      }
		};
		
		eShellSort = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  model.removeAllElements();
		    	  addShellSort();
		    	  lsCode.setSelectedIndex(0);
		      }
		};
		
		eHeapSort = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  model.removeAllElements();
		    	  addHeapSort();
		    	  lsCode.setSelectedIndex(0);
		      }
		};
		
		eQuickSort = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
		    	  model.removeAllElements();
		    	  addQuickSort();
		    	  lsCode.setSelectedIndex(0);
			}
		};
		
		eMergeSort = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
		    	  model.removeAllElements();
		    	  addMergeSort();
		    	  lsCode.setSelectedIndex(0);
			}
		};
		
		//add ActionListener to radio buttons
		rdInterchangeSort.addActionListener(eInterchangeSort);
		rdSelectionSort.addActionListener(eSelectionSort);
		rdBubbleSort.addActionListener(eBubbleSort);
		rdInsertionSort.addActionListener(eInsertionSort);
		rdShellSort.addActionListener(eShellSort);
		rdHeapSort.addActionListener(eHeapSort);
		rdQuickSort.addActionListener(eQuickSort);
		rdMergeSort.addActionListener(eMergeSort);
		
		model.removeAllElements();
		addInterchangeSort();
		lsCode.setSelectedIndex(0);
		
		btnNewButton = new JButton("Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormInfo form = new FormInfo();
				form.setVisible(true);
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(1294, 5, 61, 31);
		contentPane.add(btnNewButton);
		
		eSize = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lsCode.setFont(new Font("Monospaced",Font.BOLD,slSize.getValue()));
				lsCode.repaint();
		    }
		};
		
		slSize.addChangeListener(eSize);
                
                eSpeed = new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        time = 100 - slSpeed.getValue() * 10;
                    }
                };
                
                slSpeed.addChangeListener(eSpeed);
		
		eIncrease = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  //set Increase or Decrease
		    	  isIncrease = true;
		    	  
		    	  //update element sort
		    	  if (rdInterchangeSort.isSelected())
		    		  model.set(4, "                    if(a[j] < a[i])");
		    	  if (rdSelectionSort.isSelected())
		    		  model.set(5, "               if (a[j] < a[pos])");
		    	  if (rdBubbleSort.isSelected())
		    		  model.set(4,"               if(a[j] < a[j-1])");
		    	  if (rdInsertionSort.isSelected())
		    		  model.set(6,"          while ((pos >= 0) && (a[pos] > x)) {");
		      }
		};
		
		eDecrease = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  isIncrease = false;
		    	  
		    	  if (rdInterchangeSort.isSelected())
		    		  model.set(4, "                    if(a[j] > a[i])");
		    	  if (rdSelectionSort.isSelected())
		    		  model.set(5, "               if (a[j] > a[pos])");
		    	  if (rdBubbleSort.isSelected())
		    		  model.set(4,"               if(a[j] > a[j-1])");
		    	  if (rdInsertionSort.isSelected())
		    		  model.set(6,"          while ((pos >= 0) && (a[pos] < x)) {");
		      }
		};
		
		rdIncrease.addActionListener(eIncrease);
		rdDecrease.addActionListener(eDecrease);
		setState(0);
	}
	
	/*
	 * Set Lock And Feel
	 */
	public static void setLockAndFeel() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    
		}
	}
	
	/*
	 * Set state and manage GUI
	 */
	public void setState(int state) {
		switch (state) {
		case 0: //first state, haven't created arrays.
			btnCreateArray.setEnabled(true);
			btnDeleteArray.setEnabled(false);
			btnSetZero.setEnabled(false);

			btnRandom.setEnabled(false);
			btnByHand.setEnabled(true);
			btnOpenFile.setEnabled(true);
			btnReadFile.setEnabled(true);
			
			rdInterchangeSort.setEnabled(true);
			rdSelectionSort.setEnabled(true);
			rdBubbleSort.setEnabled(true);
			rdInsertionSort.setEnabled(true);
			rdShellSort.setEnabled(true);
			rdHeapSort.setEnabled(true);
			rdQuickSort.setEnabled(true);
			rdMergeSort.setEnabled(true);
			
			rdIncrease.setEnabled(true);
			rdDecrease.setEnabled(true);
			
			btnSort.setEnabled(false);
			//btnNext.setEnabled(false);
			//btnNext2.setEnabled(false);
			btnStop.setEnabled(false);
			break;
			
		case 1: //created arrays, be waiting to set value arrays.
			btnDeleteArray.setEnabled(true);
			btnSetZero.setEnabled(true);
			
			btnRandom.setEnabled(true);
			btnByHand.setEnabled(true);
			btnOpenFile.setEnabled(true);
			btnReadFile.setEnabled(true);
			
			rdInterchangeSort.setEnabled(true);
			rdSelectionSort.setEnabled(true);
			rdBubbleSort.setEnabled(true);
			rdInsertionSort.setEnabled(true);
			rdShellSort.setEnabled(true);
			rdHeapSort.setEnabled(true);
			rdQuickSort.setEnabled(true);
			rdMergeSort.setEnabled(true);
			
			rdIncrease.setEnabled(true);
			rdDecrease.setEnabled(true);	
			break;
			
		case 2: //be set values, ready to sort
			btnDeleteArray.setEnabled(true);
			btnSetZero.setEnabled(true);

			btnRandom.setEnabled(true);
			
			rdInterchangeSort.setEnabled(true);
			rdSelectionSort.setEnabled(true);
			rdBubbleSort.setEnabled(true);
			rdInsertionSort.setEnabled(true);
			rdShellSort.setEnabled(true);
			rdHeapSort.setEnabled(true);
			rdQuickSort.setEnabled(true);
			rdMergeSort.setEnabled(true);
			
			rdIncrease.setEnabled(true);
			rdDecrease.setEnabled(true);
			
			btnSort.setEnabled(true);
			//btnNext.setEnabled(false);
			//btnNext2.setEnabled(false);
			btnStop.setEnabled(false);
			break;
			
		case 3: //sorting
			btnCreateArray.setEnabled(true);
			btnDeleteArray.setEnabled(true);
			btnSetZero.setEnabled(false);
			
			btnRandom.setEnabled(false);
			btnByHand.setEnabled(false);
			btnOpenFile.setEnabled(false);
			btnReadFile.setEnabled(false);
			
			rdIncrease.setEnabled(false);
			rdDecrease.setEnabled(false);
			
			rdInterchangeSort.setEnabled(false);
			rdSelectionSort.setEnabled(false);
			rdBubbleSort.setEnabled(false);
			rdInsertionSort.setEnabled(false);
			rdShellSort.setEnabled(false);
			rdHeapSort.setEnabled(false);
			rdQuickSort.setEnabled(false);
			rdMergeSort.setEnabled(false);
			
			btnSort.setEnabled(false);
			//btnNext.setEnabled(true);
			//btnNext2.setEnabled(true);
			btnStop.setEnabled(true);
			break;
			
		case 4: //sort done
			btnCreateArray.setEnabled(true);
			btnDeleteArray.setEnabled(true);
			btnSetZero.setEnabled(true);
			
			btnRandom.setEnabled(true);
			btnByHand.setEnabled(true);
			btnOpenFile.setEnabled(true);
			btnReadFile.setEnabled(true);
			
			rdInterchangeSort.setEnabled(true);
			rdSelectionSort.setEnabled(true);
			rdBubbleSort.setEnabled(true);
			rdInsertionSort.setEnabled(true);
			rdShellSort.setEnabled(true);
			rdHeapSort.setEnabled(true);
			rdQuickSort.setEnabled(true);
			rdMergeSort.setEnabled(true);
			
			rdIncrease.setEnabled(true);
			rdDecrease.setEnabled(true);
			
			btnSort.setEnabled(true);
			//btnNext.setEnabled(true);
			//btnNext2.setEnabled(true);
			btnStop.setEnabled(true);
			break;
			default:
				btnCreateArray.setEnabled(true);
				btnDeleteArray.setEnabled(false);
				btnSetZero.setEnabled(false);

				btnRandom.setEnabled(false);
				btnByHand.setEnabled(true);
				btnOpenFile.setEnabled(true);
				btnReadFile.setEnabled(true);
				
				rdInterchangeSort.setEnabled(true);
				rdSelectionSort.setEnabled(true);
				rdBubbleSort.setEnabled(true);
				rdInsertionSort.setEnabled(true);
				rdShellSort.setEnabled(true);
				rdHeapSort.setEnabled(true);
				rdQuickSort.setEnabled(true);
				rdMergeSort.setEnabled(true);
				
				rdIncrease.setEnabled(true);
				rdDecrease.setEnabled(true);
				
				btnSort.setEnabled(false);
				//btnNext.setEnabled(false);
				//btnNext2.setEnabled(false);
				btnStop.setEnabled(false);
		}
	}
	
	/*
	 * Doing with arrays
	 */
	public void createArrays() {
		
		//delete previous arrays and set number elements of array
		deleteArrays();
		num = (Integer)spNum.getValue();
		
		lbArrays = new JLabel[num];
		array = new int[num];
		
		for (int i = 0; i < num; i++) {
			
			//create label, set text "0"
			lbArrays[i] = new JLabel("0");
			array[i] = 0;
			pnImitiate.add(lbArrays[i]);
			lbArrays[i].setText(String.valueOf(array[i]));
			
			//set size label
			lbArrays[i].setSize(50,50);
			lbArrays[i].setOpaque(true);
			lbArrays[i].setForeground(Color.blue);
			
			//set location label
			if (i == 0)
				lbArrays[i].setLocation(((int) ((18 - num) * 0.5) * 70) + 100, 150);
			else
				lbArrays[i].setLocation(lbArrays[i-1].getX() + 70, 150);
			
			//set fonts
			lbArrays[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
			
			//set background color
			lbArrays[i].setBackground(SystemColor.inactiveCaption);
			//set text alignment center
			lbArrays[i].setHorizontalAlignment(SwingConstants.CENTER); 
			lbArrays[i].setVerticalAlignment(SwingConstants.CENTER);
		}
                
                pnImitiate.add(lbPoint1);
                pnImitiate.add(lbPoint2);
                pnImitiate.add(lbPointM);
                
		pnImitiate.setVisible(true);
		pnImitiate.validate();
		pnImitiate.repaint();
		setState(1);
	}
	
	public void deleteArrays() {
		for (int i = 0; i < num; i++) {
			lbArrays[i].setText("0");
			array[i] = 0;
			lbArrays[i].setVisible(false);
			pnImitiate.remove(lbArrays[i]);
		}
                
                lbPoint1.setText("");
                lbPoint2.setText("");
                lbPointM.setText("");
                pnImitiate.remove(lbPoint1);
                pnImitiate.remove(lbPoint2);
                pnImitiate.remove(lbPointM);
		
		for (int i = 0; i < curT; i++) {
			try {
					threads[i].interrupt();
			} 
			catch (Exception e) {
				
			}
		}
		curT = -1;
		
		pnImitiate.revalidate();
		pnImitiate.repaint();
		setState(0);
	}
	
	public void setZero() {
		for (int i = 0; i < num; i++) {
			lbArrays[i].setText("0");
			array[i] = 0;
		}
		createArrays();
		pnImitiate.revalidate();
		pnImitiate.repaint();
		setState(1);
	}
	
	public void createRandom() {
		Random rand = new Random();
		for (int i = 0; i < num; i++) {
			int ranNum = rand.nextInt(101) + 0;
			lbArrays[i].setText(String.valueOf(ranNum));
			lbArrays[i].setForeground(Color.BLUE);
			array[i] = ranNum;
		}
		pnImitiate.setVisible(true);
		pnImitiate.validate();
		pnImitiate.repaint();
		setState(2);
	}
	
	/*
	 * Add Text Sort to JList
	 */
	public void addInterchangeSort() {
		model.addElement("void InterchangeSort(int a[], int N) {");
		model.addElement("     int i, j;");
		model.addElement("          for (i = 0 ; i<N-1 ; i++)");
		model.addElement("               for (j =i+1; j < N ; j++)");
		model.addElement("                    if(a[j ]< a[i])");
		model.addElement("                         Swap(a[i], a[j])");
		model.addElement("}");
	}
	
	public void addSelectionSort() {
		model.addElement("void SelectionSort(int a[],int n ) {");
		model.addElement("     int pos,i,j;");
		model.addElement("     for (i=0; i<n-1 ; i++) {");
		model.addElement("          pos = i;");
		model.addElement("          for(j = i+1; j <N ; j++)");
		model.addElement("               if (a[j] < a[pos])");
		model.addElement("                    pos = j;");
		model.addElement("               Swap(a[pos],a[i]);");
		model.addElement("     }");
		model.addElement("}");
	}
	
	public void addBubbleSort() {
		model.addElement("void BubbleSort(int a[],int n) {");
		model.addElement("     int i, j;");
		model.addElement("     for (i = 0 ; i<n-1 ; i++)");
		model.addElement("          for (j =n-1; j >i ; j --)");
		model.addElement("               if(a[j] < a[j-1])");
		model.addElement("                    Swap(a[j], a[j-1]");
		model.addElement("}");
	}
	
	public void addInsertionSort() {
		model.addElement("void InsertionSort(int a[], int n ) {");
		model.addElement("     int pos, i;");
		model.addElement("     int x;");
		model.addElement("     for(i = 1; i < n; i++) {"); 
		model.addElement("          x = a[i];");
		model.addElement("          pos = i - 1;");
		model.addElement("          while ((pos >= 0) && (a[pos] > x)) {");
		model.addElement("               a[pos+1] = a[pos];");
		model.addElement("               pos--;");
		model.addElement("          }");
		model.addElement("     a[pos+1] = x];");
		model.addElement("     }");
		model.addElement("}");
	}
	
    public void addShellSort() {
        model.addElement("void ShellSort(int a[], int n) {");
        model.addElement("    int len, i, j, x;");
        model.addElement("    for (len = 11; len > 0; len /= 2) {");
        model.addElement("        for (i = len; i < n; i++) {");
        model.addElement("            x = a[i];");
        model.addElement("            j = i - len;");
        model.addElement("            while (j >= 0 && x < a[i]) {");
        model.addElement("                a[j + len] = a[j];");
        model.addElement("            }");
        model.addElement("            j -= len;");
        model.addElement("        }");
        model.addElement("        a[j + len] = x;");
        model.addElement("    }");
        model.addElement("}");
    }
    
    public void addHeapSort() {
    	model.addElement("void HeapSort(int a[],int n) {");
    	model.addElement("     int r;");
    	model.addElement("     CreateHeap(a,n);");
    	model.addElement("     r=n-1;");
    	model.addElement("     while(r>0) {");
    	model.addElement("          Swap(a[0],a[r]);");
    	model.addElement("          r--;");
    	model.addElement("          if(r>0)");
    	model.addElement("               shift(a,0,r);");
    	model.addElement("     }");
    	model.addElement("}");
    	model.addElement("");
      	model.addElement("void CreateHeap(int a[],int n) {");
    	model.addElement("     int l;");
    	model.addElement("     l=n/2-1;");
    	model.addElement("     while(l>=0) {");
    	model.addElement("          shift(a,l,n-1);");
    	model.addElement("          l=l-1;");
    	model.addElement("     }");
    	model.addElement("}");
    	model.addElement("");
    	model.addElement("void shift(int a[],int l,int r) {");
    	model.addElement("     int x,i,j;");
    	model.addElement("     i=l;");
    	model.addElement("     j=2*i+1;");
    	model.addElement("     x=a[i];");
    	model.addElement("     while(j<=r) {");
    	model.addElement("          if(j<r)");
    	model.addElement("          if(a[j]<a[j+1])");
    	model.addElement("          j++;");
    	model.addElement("          if(a[j]<=x)");
    	model.addElement("               return;");
    	model.addElement("          else {");
    	model.addElement("               a[i]=a[j]");
    	model.addElement("               a[j]=x;");
    	model.addElement("               i=j;");
    	model.addElement("               j=2*i+1;");
    	model.addElement("               x=a[i];");
    	model.addElement("          }");
    	model.addElement("     }");
    	model.addElement("}");  	
    }
    
    public void addQuickSort() {
    	model.addElement("void QuickSort(int a[], int left, int right) {");
    	model.addElement("     int i, j, x;");
    	model.addElement("     x = a[(left+right)/2];");
    	model.addElement("     i = left; j = right;");
    	model.addElement("     while(i < j) {");
    	model.addElement("          while(a[i] < x) i++;");
    	model.addElement("          while(a[j] > x) j--;");
    	model.addElement("          if(i <= j) {");
    	model.addElement("               Swap(a[i],a[j]);");
    	model.addElement("               i++ ; j--;");
    	model.addElement("          }");
    	model.addElement("     }");
    	model.addElement("     if(left<j)");
    	model.addElement("          QuickSort(a, left, j)");
    	model.addElement("     if(i<right)");
    	model.addElement("          QuickSort(a, i, right);");
    	model.addElement("}");
    }
	
    public void addMergeSort() {
    	model.addElement("void MergeSort(int left, int right) {");
    	model.addElement("    if (left < right) {");
    	model.addElement("        int mid = (left + right) / 2;");
    	model.addElement("        MergeSort(left, mid);");
    	model.addElement("        MergeSort(mid + 1, right);");
    	model.addElement("        Merge(left, mid, right);");
    	model.addElement("    }");
    	model.addElement("}");
    	model.addElement("");
    	model.addElement("public void Merge(int left, int mid, int right) {");
    	model.addElement("    int n1 = mid - left + 1;");
    	model.addElement("    int n2 = right - mid;");
    	model.addElement("    int[] T = new int[n1 + n2];");
    	model.addElement("    int[] L = new int[n1];");
    	model.addElement("    int[] R = new int[n2];");
    	model.addElement("    int i, j, k;");
    	model.addElement("    for (i = 0; i < n1; i ++)");
    	model.addElement("        L[i] = array[left + i];");
    	model.addElement("    for (j = 0; j < n2; j ++)");
    	model.addElement("        R[j] = array[mid + 1 + j];");
    	model.addElement("    i = 0; j = 0;");
        model.addElement("    k = left;");
        model.addElement("    while (i < n1 && j < n2) {");
        model.addElement("        if (L[i] <= R[j]) {");
        model.addElement("            array[k] = L[i];");
        model.addElement("            i ++;");
        model.addElement("        } else {");
        model.addElement("            array[k] = R[j];");
        model.addElement("            j ++;");
        model.addElement("        }");
        model.addElement("        k ++;");
        model.addElement("    }");
        model.addElement("    while (i < n1) {");
        model.addElement("        array[k] = L[i];");
        model.addElement("        i ++;");
        model.addElement("        k ++;");
        model.addElement("    }");
        model.addElement("    while (j < n2) {");
        model.addElement("        array[k] = R[j];");
        model.addElement("        j ++;");
        model.addElement("        k ++;");
        model.addElement("    }");
        model.addElement("}");
    }
    /*
	 * Sort and Swap
	 */
	public void Swap(JLabel lb1, JLabel lb2) {
		int x1 = lb1.getX();
		int x2 = lb2.getX();
		curT ++;
		
		int cur = curT;
		threads[cur] = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	try {
		    		if (cur != 0) {
			    		threads[cur-1].join();
			    	}
		    		
		    		lb1.setBackground(processingColor);
		    		lb2.setBackground(processingColor);
			        while (lb1.getY() > 100) {
			        	lb1.setLocation(lb1.getX(), lb1.getY() - 10);
			        	lb2.setLocation(lb2.getX(), lb2.getY() + 10);
                                        lbPointM.setLocation(x2, lbPointM.getY() + 10);
			        	Thread.sleep(time);
			        }
			        while (lb1.getX() < x2) {
			        	lb1.setLocation(lb1.getX() + 10, lb1.getY());
			        	lb2.setLocation(lb2.getX() - 10, lb2.getY());
                                        lbPointM.setLocation(lb2.getX(), 250);
			        	Thread.sleep(time);
			        }
			        while (lb1.getY() < 140) {
			        	lb1.setLocation(lb1.getX(), lb1.getY() + 10);
			        	lb2.setLocation(lb2.getX(), lb2.getY() - 10);
                                        lbPointM.setLocation(x1, lbPointM.getY() - 10);
			        	Thread.sleep(time);
			        }
			        String txtLb1 = lb1.getText();
			        lb1.setText(lb2.getText());
			        lb2.setText(txtLb1);
			        lb1.setLocation(x1, 150);
		        	lb2.setLocation(x2, 150);
		        	lb1.setBackground(SystemColor.inactiveCaption);
		        	lb2.setBackground(SystemColor.inactiveCaption);
		    	} catch (Exception e) {
		    	}
		    }
		});
		threads[cur].start();
	}
        
        public void setlbPoint(JLabel lbPoint, int i, String s) {
            curT ++;
            System.out.println(curT);
            int cur = curT;
            threads[cur] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (cur != 0)
                            threads[cur - 1].join();
                        if (i == -1) {
                            lbPoint.setText("");
                            return;
                        }
                        if (s.charAt(0) == 'm') {
                            lbPoint.setLocation(lbArrays[i].getX(), 200);
                            lbPoint.setText(s);
                        } else if (s.charAt(0) == 'k') {
                            lbPoint.setLocation(oriLocat[i], 200);
                            lbPoint.setText(s + i);
                        } else {
                            lbPoint.setLocation(lbArrays[i].getX(), 275);
                            lbPoint.setText(s + i);
                        }
                    } catch (Exception e){}
                }
            });
            threads[cur].start();
        }
	
	/*
	 * Interchange Sort
	 */
	public void InterchangeSort() {
		if (isIncrease) {
			highLight(1);
			int i, j;
			for (i = 0 ; i < num ; i++) {
				highLight(2);
                                setlbPoint(lbPoint1, i, "i = ");
				for (j = i + 1; j < num ; j++) {
                                    setlbPoint(lbPoint2, j, "j = ");
					highLight(3);
					highLight(4);
					if(array[j] < array[i]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						highLight(5);
						Swap(lbArrays[i], lbArrays[j]);
					}
				}
			}
			highLight(0);
		} else {
			highLight(1);
			int i, j;
			for (i = 0 ; i < num ; i++) {
				highLight(2);
                                setlbPoint(lbPoint1, i, "i = ");
				for (j = i + 1; j < num ; j++) {
                                    setlbPoint(lbPoint2, j, "j = ");
					highLight(3);
					highLight(4);
					if(array[j] > array[i]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						highLight(5);
						Swap(lbArrays[i], lbArrays[j]);
					}
				}
			}
			highLight(0);
		}
	}
	
	/*
	 * Selection Sort
	 */
	public void SelectionSort() {
		if (isIncrease) {
			highLight(1);
			int min,i,j; 
			for (i = 0; i < num - 1; i++) {
				highLight(2);
                                setlbPoint(lbPoint1, i, "i = ");
				min = i;
                                setlbPoint(lbPointM, i, "min");
				highLight(3);
				for(j = i + 1; j < num; j++) {
					highLight(4);
					highLight(5);
                                        setlbPoint(lbPoint2, j, "j = ");
					if (array[j] < array[min]) {
						highLight(6);
						min = j;
                                                setlbPoint(lbPointM, j, "min");
					}
				}				
				if (min > i) {
					int temp = array[min];		
					array[min] = array[i];			
					array[i] = temp;
					highLight(7);
					Swap(lbArrays[i], lbArrays[min]);
				}
			}
		} else {
			highLight(1);
			int min,i,j; 
			for (i = 0; i < num - 1; i++) {
				highLight(2);
                                setlbPoint(lbPoint1, i, "i = ");
				min = i;
                                setlbPoint(lbPointM, i, "max");
				highLight(3);
				for(j = i + 1; j < num; j++) {
					highLight(4);
					highLight(5);
                                        setlbPoint(lbPoint2, j, "j = ");
					if (array[j] > array[min]) {
						highLight(6);
						min = j;
                                                setlbPoint(lbPointM, j, "max");
					}
				}				
				if (min > i) {
					int temp = array[min];		
					array[min] = array[i];			
					array[i] = temp;
					highLight(7);
					Swap(lbArrays[i], lbArrays[min]);
				}
			}
		}
		highLight(0);
	}
	
	/*
	 * Bubble Sort
	 */
	public void BubbleSort() {
		if (isIncrease) {
			highLight(1);
			int i, j;
			for (i = 0; i< num; i++) {
				highLight(2);
                                setlbPoint(lbPoint1, i, "i = ");
				for (j = num - 1; j > i; j--) {
					highLight(3);
					highLight(4);
                                        setlbPoint(lbPoint2, j, "j = ");
					if(array[j]< array[j-1]) {
						int temp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = temp;
						highLight(5);
						Swap(lbArrays[j - 1], lbArrays[j]);
					}
				}
			}
			highLight(0);
		} else {
			highLight(1);
			int i, j;
			for (i = 0; i< num; i++) {
				highLight(2);
                                setlbPoint(lbPoint1, i, "i = ");
				for (j = num - 1; j > i; j--) {
					highLight(3);
					highLight(4);
                                        setlbPoint(lbPoint2, j, "j = ");
					if(array[j] > array[j-1]) {
						int temp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = temp;
						highLight(5);
						Swap(lbArrays[j - 1], lbArrays[j]);
					}
				}
			}
			highLight(0);
		}
	}
	
	public void Move(JLabel lb1, JLabel lb2, int pos) {
        int x1 = lb1.getX();
        int x2 = lb2.getX();
        curT ++;
        
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    lb1.setOpaque(true);
                    lb2.setOpaque(true);
                    lb1.setBackground(processingColor);
                    lb2.setBackground(processingColor);
                    while (lb1.getY() > 100) {
                        lb1.setLocation(lb1.getX(), lb1.getY() - 10);
                        Thread.sleep(time);
                    }
                    while (lb1.getX() > x2) {
                        lb2.setLocation(lb2.getX() + 10, lb2.getY());
                        lb1.setLocation(lb1.getX() - 10, lb1.getY());
                        Thread.sleep(time);
                    }
                    while (pos == 0 && lb1.getY() < 150) {
                        lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        Thread.sleep(time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    int y1 = lb1.getY();
                    lb1.setLocation(x1, lb2.getY());
                    lb2.setLocation(x2, y1);
                    lb1.setBackground(SystemColor.inactiveCaption);
                    if (pos == 0)
                        lb2.setBackground(SystemColor.inactiveCaption);
               } catch (Exception e) {
               }
           }
        });
        threads[cur].start();
    }
    
	/*
	 * Insertion Sort
	 */
    public void InsertionSort() {
    	if (isIncrease) {
	        int pos, i;
	        highLight(1);
	        int x;
	        highLight(2);
	        for (i = 1; i < num; i++) {
                    highLight(3);
                    setlbPoint(lbPoint1, i, "i = ");
	            x = array[i];
	            highLight(4);
	            pos = i - 1;
	            highLight(5);
	            while ((pos >= 0) && (array[pos] > x)) {
	            	highLight(6);
                        setlbPoint(lbPoint2, pos, "j = ");
	                array[pos + 1] = array[pos];
	                highLight(7);
	                if (pos > 0 && array[pos - 1] <= x) {
	                    Move(lbArrays[pos + 1], lbArrays[pos], 0);
	                } else {
	                    Move(lbArrays[pos + 1], lbArrays[pos], pos);
	                }	              
	                pos--;
	                highLight(8);
	            }
	            highLight(9);
	            array[pos + 1] = x;
                    setlbPoint(lbPoint2, -1, null);
	        }
	        highLight(0);
    	}
    	else {
    		int pos, i;
    		highLight(1);
	        int x;
	        highLight(2);
	        for (i = 1; i < num; i++) {
                    highLight(3);
                    setlbPoint(lbPoint1, i, "i = ");
	            x = array[i];
	            highLight(4);
	            pos = i - 1;
	            highLight(5);
	            while ((pos >= 0) && (array[pos] < x)) {
	            	highLight(6);
                        setlbPoint(lbPoint2, pos, "j = ");
	                array[pos + 1] = array[pos];
	                highLight(7);
	                if (pos > 0 && array[pos - 1] >= x) {
	                    Move(lbArrays[pos + 1], lbArrays[pos], 0);
	                } else {
	                    Move(lbArrays[pos + 1], lbArrays[pos], pos);
	                }
	                pos--;
	                highLight(8);
	            }
	            array[pos + 1] = x;
	            highLight(9);
                    setlbPoint(lbPoint2, -1, null);
	        }
	        highLight(0);
    	}
    }
    
    /*
     * Shell Sort
     */

    public void MoveShell(JLabel lb1, JLabel lb2,  int next) {
        int x1 = lb1.getX();
        int x2 = lb2.getX();
        curT ++;
       
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    setBackgroundMoving(lb1, lb2);
                    while (lb2.getY() < 200) {
                        if (lb1.getY() > 100)
                            lb1.setLocation(lb1.getX(), lb1.getY() - 10);
                        lb2.setLocation(lb2.getX(), lb2.getY() + 10);
                        Thread.sleep(time);
                    }
                    while (lb1.getX() > x2) {
                        lb2.setLocation(lb2.getX() + 10, lb2.getY());
                        lb1.setLocation(lb1.getX() - 10, lb1.getY());
                        Thread.sleep(time);
                    }
                    while (lb2.getY() > 150) {
                        if (next == 0) {
                            lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        }
                        lb2.setLocation(lb2.getX(), lb2.getY() - 10);
                        Thread.sleep(time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    int y1 = lb1.getY();
                    lb1.setLocation(x1, lb2.getY());
                    lb2.setLocation(x2, y1);
                    if (next == 0)
                        setBackgroundDone(lb1, lb2);
                    else
                        lb1.setBackground(SystemColor.inactiveCaption);
               } catch (Exception e) {
               }
           }
        });
        threads[cur].start();
    }

    public void ShellSort() {
        if (isIncrease) {
            int len, i, j, x;
            highLight(1);
            for (len = 11; len > 0; len /= 2) {
            	highLight(2);
                for (i = len; i < num; i ++) {
                    highLight(3);
                    setlbPoint(lbPoint1, i, "i = ");
                    x = array[i];
                    highLight(4);
                    j = i - len;
                    highLight(5);
                    while (j >= 0 && x < array[j]) {
                    	highLight(6);
                        setlbPoint(lbPoint2, j, "j = ");
                        array[j + len] = array[j];
                        highLight(7);
                        if (len > 1) {
                            if (j < len) {
                                MoveShell(lbArrays[j + len], lbArrays[j], 0);
                            } else {
                                if (x >= array[j - len])
                                    MoveShell(lbArrays[j + len], lbArrays[j], 0);
                                else
                                    MoveShell(lbArrays[j + len], lbArrays[j], 1);
                            }
                        } else {
                            if (j < len) {
                                Move(lbArrays[j + len], lbArrays[j], 0);
                            } else {
                                if (x >= array[j - len])
                                    Move(lbArrays[j + len], lbArrays[j], 0);
                                else
                                    Move(lbArrays[j + len], lbArrays[j], 1);
                            }
                        }
                        j -= len;
                        highLight(8);
                    }
                    array[j + len] = x;
                    highLight(9);
                    setlbPoint(lbPoint2, -1, null);
                }
            }
            highLight(0);
        }
        else {
            int len, i, j, x;
            highLight(1);
            for (len = 11; len > 0; len /= 2) {
            	 highLight(2);
                for (i = len; i < num; i ++) {
                    highLight(3);
                    setlbPoint(lbPoint1, i, "i = ");
                    x = array[i];
                    highLight(4);
                    j = i - len;
                    highLight(5);
                    while (j >= 0 && x > array[j]) {
                    	highLight(6);
                        setlbPoint(lbPoint2, j, "j = ");
                        array[j + len] = array[j];
                        highLight(7);
                        if (len > 1) {
                            if (j < len) {
                                MoveShell(lbArrays[j + len], lbArrays[j], 0);
                            } else {
                                if (x <= array[j - len])
                                    MoveShell(lbArrays[j + len], lbArrays[j], 0);
                                else
                                    MoveShell(lbArrays[j + len], lbArrays[j], 1);
                            }
                        } else {
                            if (j < len) {
                                Move(lbArrays[j + len], lbArrays[j], 0);
                            } else {
                                if (x <= array[j - len])
                                    Move(lbArrays[j + len], lbArrays[j], 0);
                                else
                                    Move(lbArrays[j + len], lbArrays[j], 1);
                            }
                        }
                        j -= len;
                        highLight(8);
                    }
                    array[j + len] = x;
                    highLight(9);
                    setlbPoint(lbPoint2, -1, null);
                }
            }
        }
        highLight(0);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HeapSort">
    public void MovetoLocation(JLabel lb1, int x, int y) {
        curT ++;
        
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    lb1.setBackground(processingColor);
                    int x1 = lb1.getX();
                    int y1 = lb1.getY();
                    if (x1 < x && y1 < y) {
                        while (lb1.getX() < x) {
                            lb1.setLocation(lb1.getX() + 10, y1);
                            Thread.sleep(time);
                        }
                        while (lb1.getY() < y) {
                            lb1.setLocation(x, lb1.getY() + 10);
                            Thread.sleep(time);
                        }
                    } else if (x1 >= x && y1 < y) {
                        while (lb1.getX() > x) {
                            lb1.setLocation(lb1.getX() - 10, y1);
                            Thread.sleep(time);
                        }
                        while (lb1.getY() < y) {
                            lb1.setLocation(x, lb1.getY() + 10);
                            Thread.sleep(time);
                        }
                    } else if (x1 < x && y1 >= y) {
                        while (lb1.getY() > y) {
                            lb1.setLocation(x1, lb1.getY() - 10);
                            Thread.sleep(time);
                        }
                        while (lb1.getX() < x) {
                            lb1.setLocation(lb1.getX() + 10, y);
                            Thread.sleep(time);
                        }
                    } else if (x1 >= x && y1 >= y) {
                        while (lb1.getY() > y) {
                            lb1.setLocation(x1, lb1.getY() - 10);
                            Thread.sleep(time);
                        }
                        while (lb1.getX() > x) {
                            lb1.setLocation(lb1.getX() - 10, y);
                            Thread.sleep(time);
                        }
                    }
                    lb1.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void HeapLocationInit() {
        int i, j = 0;
        int row = 1;
        int maxirow = 0;
        int[] xi = {600, 480, 720, 420, 540, 660, 780, 390, 450, 510, 570, 630, 690, 750, 810};
        int[] yi = {60, 110, 160, 210};
        MovetoLocation(lbArrays[0], xi[0], yi[0]);
        for (i = 0; i <= (num - 1) / 2; i ++) {
            if (i > maxirow) {
                row ++;
                maxirow = maxirow * 2 + 2;
            }
            j = i * 2 + 1;
            while (j <= i * 2 + 2 && j < num) {
                if (j == i * 2 + 1) {
                    MovetoLocation(lbArrays[j], xi[j], yi[row]);
                } else {
                    MovetoLocation(lbArrays[j], xi[j], yi[row]);
                }
                j ++;
            }
        }
    }
    
    public void SwapinHeap(JLabel lb1, JLabel lb2) {
        curT ++;
        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur-1].join();
                    }
                    setBackgroundMoving(lb1, lb2);
                    int x1 = lb1.getX();
                    int x2 = lb2.getX();
                    int y1 = lb1.getY();
                    int y2 = lb2.getY();
                    while (lb2.getY() > y1) {
                        if (lb1.getY() > y1 - 50)
                            lb1.setLocation(lb1.getX(), lb1.getY() - 10);
                        lb2.setLocation(lb2.getX(), lb2.getY() - 10);
                        Thread.sleep(time);
                    }
                    if (x2 < x1) {
                        while (lb2.getX() < x1) {
                            lb1.setLocation(lb1.getX() - 10, lb1.getY());
                            lb2.setLocation(lb2.getX() + 10, lb2.getY());
                            Thread.sleep(time);
                        }
                    } else {
                        while (lb2.getX() > x1) {
                            lb1.setLocation(lb1.getX() + 10, lb1.getY());
                            lb2.setLocation(lb2.getX() - 10, lb2.getY());
                            Thread.sleep(time);
                        }
                    }
                    while (lb1.getY() < y2) {
                        lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        Thread.sleep(time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    lb1.setLocation(x1, y1);
                    lb2.setLocation(x2, y2);
                    setBackgroundDone(lb1, lb2);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void SwapHeapEnd(JLabel lb1, JLabel lb2, int xend) {
                    MovetoLocation(lb1, xend, 260);
                    MovetoLocation(lb2, 600, 60);
                    SwapwithoutMoving(lb1, lb2);
    }
    
    public void SwapwithoutMoving(JLabel lb1, JLabel lb2) {
        curT ++;
        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    int x = lb1.getX();
                    int y = lb1.getY();
                    lb1.setLocation(lb2.getX(), lb2.getY());
                    lb2.setLocation(x, y);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void Shift(int l, int r) {
        int x, i ,j;
        highLight(23);
        i = l;
        highLight(24);
        j = i * 2 + 1;
        highLight(25);
        x = array[i];
        if (isIncrease) {
            while (j <= r) {
                highLight(26);
                highLight(27);
                if (j < r) {
                    highLight(28);
                    if (array[j] < array[j + 1]) {
                        highLight(29);
                        j++;
                    }
                }
                highLight(30);
                if (array[j] <= x) {
                    highLight(31);
                    return;
                } else {
                    highLight(33);
                    array[i] = array[j];
                    highLight(34);
                    array[j] = x;
                    SwapinHeap(lbArrays[i], lbArrays[j]);
                    highLight(35);
                    i = j;
                    highLight(36);
                    j = i * 2 + 1;
                    highLight(37);
                    x = array[i];
                }
            }
        } else {
            while (j <= r) {
                highLight(26);
                highLight(27);
                if (j < r) {
                    highLight(28);
                    if (array[j] > array[j + 1]) {
                        highLight(29);
                        j ++;
                    }
                }
                highLight(30);
                if (array[j] >= x) {
                    highLight(31);
                    return;
                } else {
                    highLight(33);
                    array[i] = array[j];
                    highLight(34);
                    array[j] = x;
                    SwapinHeap(lbArrays[i], lbArrays[j]);
                    highLight(35);
                    i = j;
                    highLight(36);
                    j = i * 2 + 1;
                    highLight(37);
                    x = array[i];
                }
            }
        }
    }
    
    public void CreateHeap() {
        int l;
        highLight(14);
        l = num / 2 - 1;
        while (l >= 0) {
            highLight(15);
            highLight(16);
            Shift(l, num - 1);
            highLight(17);
            l --;
        }
    }
    
    public void HeapSort() {
        int r;
        int xend = ((int) ((18 - num) * 0.5) * 70) + 100 + (num - 1) * 70;
        HeapLocationInit();
        highLight(2);
        CreateHeap();
        highLight(3);
        r = num - 1;
        while (r > 0) {
            highLight(4);
            highLight(5);
            int x = array[0];
            array[0] = array[r];
            array[r] = x;
            SwapHeapEnd(lbArrays[0], lbArrays[r], xend);
            xend -= 70;
            highLight(6);
            r --;
            highLight(7);
            if (r > 0) {
                highLight(8);
                Shift(0, r);
            }
        }
        SwapHeapEnd(lbArrays[0], null, xend);
    }
    // </editor-fold>

    /*
     * HightLight lines
     */
    public void highLight(int line) {
		curT++;
		
		int cur = curT;
		threads[cur] = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	try {
		    		if (cur != 0) {
			    		threads[cur-1].join();
			    	}
		    		lsCode.setSelectedIndex(line);
                                lsCode.ensureIndexIsVisible(line); // Tu cuon den dong dang highlight
		    		Thread.sleep(time);
		    	} catch (Exception e) {
		    		
		    	}
		    }
		});
		threads[cur].start();
	}
    
    /*
     * Stop all Threads[]
     */
    
    public void stopAllThreads() {
    	for (int i = 0; i < curT; i++) {
			try {
			threads[i].interrupt();
			} catch (Exception e) {
				
			}
		}
		curT = -1;
    }
    
    /*
     * Waiting to end sorting
     */
    public void waitEnd() {
    	curT++;
		
		int cur = curT;
		threads[cur] = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	try {
		    		if (cur != 0) {
			    		threads[cur-1].join();
			    	}
		    		setState(4);
		    		for (int i = 0; i < num; i++) {
		    			lbArrays[i].setForeground(Color.darkGray);
		    		}
                                lbPoint1.setText("");
                                lbPoint2.setText("");
                                lbPointM.setText("");
		    		FormCompleteSorted form = new FormCompleteSorted();
		    		form.setVisible(true);
		    	} catch (Exception e) {
		    		
		    	}
		    }
		});
		threads[cur].start();
    }
    
    // <editor-fold defaultstate="collapsed" desc="QuickSort">
    public void QuickSort() {
        QuickSortAl(0, num - 1);
        QuickSortAnimation();
        step = 0;
    }
    
    public void Coloring(JLabel lb1, Color c) {
        curT ++;
        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    lb1.setBackground(c);
                    Thread.sleep(time);
                } catch (Exception e) {}
            }
        });
        threads[cur].start();
    }
    
    public void Coloring(int left, int right, Color c) {
        curT ++;
        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    int i = left;
                    while (i <= right) {
                        if (i != (left + right) / 2)
                            lbArrays[i].setBackground(c);
                        i ++;
                    }
                    Thread.sleep(time);
                } catch (Exception e) {}
            }
        });
        threads[cur].start();
    }

    public void QuickSortAnimation() {
        int s, i, j;
        for (s = 0; s < step; s ++) {
            i = lbI[s];
            j = lbJ[s];
            setlbPoint(lbPoint1, i, "i = ");
            setlbPoint(lbPoint2, j, "j = ");
            if (i != j) {
                Coloring(lbArrays[(lbL[s] + lbR[s]) / 2], selectedGreen);
                Coloring(lbL[s], lbR[s], selectedYellow);
                Swap(lbArrays[i], lbArrays[j]);
            }
            if (lbL[s + 1] + lbR[s + 1] != lbL[s] + lbR[s]) {
                Coloring(lbArrays[(lbL[s] + lbR[s]) / 2], SystemColor.inactiveCaption);
                Coloring(lbL[s], lbR[s], SystemColor.inactiveCaption);
            }
        }
    }
    
    public void QuickSortAl(int left, int right) {
        if (isIncrease) {
	    	int i, j, x;
	        x = array[(left + right) / 2];
	        i = left; j = right;
	        while (i < j) {
	            while (array[i] < x) {
                        i ++;
                    }
	            while (array[j] > x) {
                        j --;
                    }
	            if (i <= j) {
                        if (array[i] != array[j]) {
	                    int temp = array[i];
	                    array[i] = array[j];
	                    array[j] = temp;
	                    if (i != j) {
                                lbL[step] = left; lbR[step] = right;
	                        lbI[step] = i; lbJ[step] = j;
	                        step ++;
	                    }
                        }
	                i ++; j --;
	            }
	        }
	        if (left < j)
	            QuickSortAl(left, j);
	        if (i < right)
	            QuickSortAl(i, right);
        }
        else {
        	int i, j, x;
	        x = array[(left + right) / 2];
	        i = left; j = right;
	        while (i < j) {
	            while (array[i] > x) {
                        i ++;
                    }
	            while (array[j] < x) {
                        j --;
                    }
	            if (i <= j) {
                        if (array[i] != array[j]) {
	                    int temp = array[i];
	                    array[i] = array[j];
	                    array[j] = temp;
	                    if (i != j) {
                                lbL[step] = left; lbR[step] = right;
	                        lbI[step] = i; lbJ[step] = j;
	                        step ++;
	                    }
                        }
	                i ++; j --;
	            }
	        }
	        if (left < j)
	            QuickSortAl(left, j);
	        if (i < right)
	            QuickSortAl(i, right);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="MergeSort">
    public void PutUp(int left, int right) {
        curT ++;
        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    int mid = (left + right) / 2;
                    for (int i = left; i <= right; i ++) {
                        if (i < mid + 1)
                            lbArrays[i].setBackground(selectedGreen);
                        else
                            lbArrays[i].setBackground(selectedYellow);
                    }
                    while (lbArrays[right].getY() > 50) {
                        for (int i = left; i <= right; i ++) {
                            if (lbArrays[i].getY() > 50)
                                lbArrays[i].setLocation(lbArrays[i].getX(), lbArrays[i].getY() - 10);
                        }
                        Thread.sleep(time);
                    }
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void PutDown(JLabel lb1, int x, int y) {
        curT ++;
        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    int x1 = lb1.getX();
                    lb1.setBackground(processingColor);
                    while (lb1.getY() < 100) {
                        lb1.setLocation(x1, lb1.getY() + 10);
                        Thread.sleep(time);
                    }
                    int y1 = lb1.getY();
                    if (x1 < x) {
                        while (lb1.getX() < x) {
                            lb1.setLocation(lb1.getX() + 10, y1);
                            Thread.sleep(time);
                        }
                        while (lb1.getY() < y) {
                            lb1.setLocation(x, lb1.getY() + 10);
                            Thread.sleep(time);
                        }
                    } else {
                        while (lb1.getX() > x) {
                            lb1.setLocation(lb1.getX() - 10, y1);
                            Thread.sleep(time);
                        }
                        while (lb1.getY() < y) {
                            lb1.setLocation(x, lb1.getY() + 10);
                            Thread.sleep(time);
                        }
                    }
                    lb1.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void Relocat(int left, int right, int[] T) {
        curT ++;
        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    for (int i = left; i <= right; i ++) {
                        if (lbArrays[i].getX() != oriLocat[i]) {
                            lbArrays[i].setLocation(oriLocat[i], 150);
                            lbArrays[i].setText(T[i - left] + "");
                        }
                    }
                    Thread.sleep(time);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void Merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] T = new int[n1 + n2];
        int[] L = new int[n1];
        int[] R = new int[n2];
        int i, j, k;
        highLight(16);
        for (i = 0; i < n1; i ++)
            L[i] = array[left + i];
        highLight(18);
        for (j = 0; j < n2; j ++)
            R[j] = array[mid + 1 + j];
        setlbPoint(lbPoint1, left, "i = ");
        setlbPoint(lbPoint2, mid + 1, "j = ");
        PutUp(left, right);
        if (isIncrease) {
            i = 0; j = 0;
            k = left;
            while (i < n1 && j < n2) {
                highLight(22);
                setlbPoint(lbPointM, k, "k = ");
                highLight(23);
                if (L[i] <= R[j]) {
                    setlbPoint(lbPoint1, left + i, "i = ");
                    highLight(24);
                    array[k] = L[i];
                    PutDown(lbArrays[left + i], oriLocat[k], 150);
                    highLight(25);
                    i ++;
                } else {
                    setlbPoint(lbPoint2, mid + 1 + j, "j = ");
                    highLight(27);
                    array[k] = R[j];
                    PutDown(lbArrays[mid + 1 + j], oriLocat[k], 150);
                    highLight(28);
                    j ++;
                }
                highLight(30);
                k ++;
            }
            while (i < n1) {
                highLight(32);
                setlbPoint(lbPointM, k, "k = ");
                setlbPoint(lbPoint1, left + i, "i = ");
                highLight(33);
                array[k] = L[i];
                PutDown(lbArrays[left + i], oriLocat[k], 150);
                i ++;
                k ++;
            }
            while (j < n2) {
                highLight(37);
                setlbPoint(lbPointM, k, "k = ");
                setlbPoint(lbPoint2, mid + 1 + j, "j = ");
                highLight(38);
                array[k] = R[j];
                PutDown(lbArrays[mid + 1 + j], oriLocat[k], 150);
                j ++;
                k ++;
            }
        } else {
            i = 0; j = 0;
            k = left;
            while (i < n1 && j < n2) {
                highLight(22);
                setlbPoint(lbPointM, k, "k = ");
                highLight(23);
                if (L[i] >= R[j]) {
                    setlbPoint(lbPoint1, left + i, "i = ");
                    highLight(24);
                    array[k] = L[i];
                    PutDown(lbArrays[left + i], oriLocat[k], 150);
                    highLight(25);
                    i ++;
                } else {
                    setlbPoint(lbPoint2, mid + 1 + j, "j = ");
                    highLight(27);
                    array[k] = R[j];
                    PutDown(lbArrays[mid + 1 + j], oriLocat[k], 150);
                    highLight(28);
                    j ++;
                }
                highLight(30);
                k ++;
            }
            while (i < n1) {
                highLight(32);
                setlbPoint(lbPointM, k, "k = ");
                setlbPoint(lbPoint1, left + i, "i = ");
                highLight(33);
                array[k] = L[i];
                PutDown(lbArrays[left + i], oriLocat[k], 150);
                i ++;
                k ++;
            }
            while (j < n2) {
                highLight(37);
                setlbPoint(lbPointM, k, "k = ");
                setlbPoint(lbPoint2, mid + 1 + j, "j = ");
                highLight(38);
                array[k] = R[j];
                PutDown(lbArrays[mid + 1 + j], oriLocat[k], 150);
                j ++;
                k ++;
            }
        }
        for (i = 0; i < n1 + n2; i ++)
            T[i] = array[left + i];
        Relocat(left, right, T);
    }
    
    public void MergeSortAl(int left, int right) {
        highLight(1);
        if (left < right) {
            highLight(2);
            int mid = (left + right) / 2;
            MergeSortAl(left, mid);
            MergeSortAl(mid + 1, right);
            Merge(left, mid, right);
        }
    }
    
    public void MergeSort() {
        for (int i = 0; i < num; i ++)
            oriLocat[i] = lbArrays[i].getX();
        MergeSortAl(0, num - 1);
    }
    // </editor-fold>
    
    public void setArray(int[] array) {
    	spNum.setValue(array.length);
    	deleteArrays();
		num = (Integer)spNum.getValue();
		
		lbArrays = new JLabel[num];
		this.array = array;
		
		for (int i = 0; i < num; i++) {
			
			//create label, set text "0"
			lbArrays[i] = new JLabel(String.valueOf(array[i]));
			pnImitiate.add(lbArrays[i]);
			
			//set size label
			lbArrays[i].setSize(50,50);
			lbArrays[i].setOpaque(true);
			lbArrays[i].setForeground(Color.BLUE);
			
			//set location label
			if (i == 0)
				lbArrays[i].setLocation(((int) ((18 - num) * 0.5) * 70) + 100, 150);
			else
				lbArrays[i].setLocation(lbArrays[i-1].getX() + 70, 150);
			
			//set fonts
			lbArrays[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
			
			//set background color
			lbArrays[i].setBackground(SystemColor.inactiveCaption);
			
			//set text alignment center
			lbArrays[i].setHorizontalAlignment(SwingConstants.CENTER); 
			lbArrays[i].setVerticalAlignment(SwingConstants.CENTER);
		}
		pnImitiate.setVisible(true);
		pnImitiate.validate();
		pnImitiate.repaint();
		setState(2);
    }
    
    public boolean isSorted() {
    	if (isIncrease) {
    		for (int i = 0; i < array.length - 1; i++)
    			if (array[i] > array[i+1])
    				return false;
    	}	
    	else {
    		for (int i = 0; i < array.length - 1; i++)
    			if (array[i] < array[i+1])
    				return false;
    	}
    	return true;
    }
    
    public void threadReLocate() {
    	curT++;
		
		int cur = curT;
		threads[cur] = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	try {
		    		if (cur != 0) {
			    		threads[cur-1].join();
			    	}
		    		reLocate();
		    	} catch (Exception e) {
		    		
		    	}
		    }
		});
		threads[cur].start();
    }
    
    public void reLocate() {
    	for (int i = 0; i < num; i++) {
			//set location label
			if (i == 0)
				lbArrays[i].setLocation(((int) ((18 - num) * 0.5) * 70) + 100, 150);
			else
				lbArrays[i].setLocation(lbArrays[i-1].getX() + 70, 150);
    	}
    }
    
    public void setBackgroundMoving(JLabel lb1, JLabel lb2) {
    	lb1.setOpaque(true);
    	lb2.setOpaque(true);
    	
    	lb1.setBackground(processingColor);
    	lb2.setBackground(processingColor);
    }
    
    public void setBackgroundDone(JLabel lb1, JLabel lb2) {
    	lb1.setOpaque(true);
    	lb2.setOpaque(true);
    	
    	lb1.setBackground(SystemColor.inactiveCaption);
    	lb2.setBackground(SystemColor.inactiveCaption);
    }

}

