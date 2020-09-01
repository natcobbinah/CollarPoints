package CollarPointsGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

public class CollarPointsMainFrame extends JFrame implements ActionListener {

	private JLabel matrixlbl;

	private JTextArea matrixtxtArea;
	private JTextArea collarPointstxtArea;

	private JButton findcollarPointsbtn;
	private JButton clearbtn;
	
	private Font font;
	private Font font2;

	private collarPoints collarpoints;

	public CollarPointsMainFrame() {
		super("Collar Points Finder");

		try {
			UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
		} catch (UnsupportedLookAndFeelException | ParseException e) {
			// TODO Auto-generated catch block
		}

		setJMenuBar(createMenuBar());

		collarpointslayout();

		setResizable(false);
		setSize(700, 550);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void collarpointslayout() {
		setLayout(new BorderLayout());

		font = new Font("Courier", Font.BOLD, 16);
		font2 = new Font("Courier", Font.BOLD, 16);

		matrixlbl = new JLabel("Enter Matrix [ ] [ ]:");

		matrixtxtArea = new JTextArea(10, 38);
		matrixtxtArea.setFont(font);

		collarPointstxtArea = new JTextArea(5, 38);
		collarPointstxtArea.setEditable(false);
		collarPointstxtArea.setFont(font2);

		findcollarPointsbtn = new JButton("Find Collar Points");
		clearbtn = new JButton("Clear");

		clearbtn.addActionListener(this);
		findcollarPointsbtn.addActionListener(this);

		JPanel btnsPanel = new JPanel();
		btnsPanel.setLayout(new FlowLayout());
		btnsPanel.setBorder(BorderFactory.createEtchedBorder());
		btnsPanel.add(findcollarPointsbtn);
		btnsPanel.add(clearbtn);

		JPanel matrixPanel = new JPanel();
		matrixPanel.setLayout(new BorderLayout());
		matrixPanel.setBorder(BorderFactory.createEtchedBorder());
		matrixPanel.add(matrixlbl, BorderLayout.NORTH);
		matrixPanel.add(new JScrollPane(matrixtxtArea), BorderLayout.CENTER);
		matrixPanel.add(new JScrollPane(collarPointstxtArea), BorderLayout.SOUTH);

		JPanel allPanels = new JPanel();
		allPanels.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.ipadx = 10;
		gc.ipady = 10;
		gc.insets = new Insets(4, 4, 4, 4);
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.gridwidth = 4;
		allPanels.add(matrixPanel, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.NORTHWEST;
		allPanels.add(btnsPanel, gc);

		add(allPanels, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == findcollarPointsbtn) {
			if (isValidData()) {
				String[] lineIntxtArea = matrixtxtArea.getText().split("\\n");
				int matrixRowSize = lineIntxtArea.length;

				// split one line to get the number of columns in the array
				int cols = 0;
				String[] justOneLine = lineIntxtArea[0].split(" ");
				for (String nums : justOneLine) {
					cols++;
				}

				String[] values = new String[matrixRowSize];

				// to store lineIntxtArea
				int matrixConverted[][] = new int[matrixRowSize][cols];

				for (int i = 0; i < matrixRowSize; i++) {
					values[i] = lineIntxtArea[i];

					String[] singleValues = values[i].split(" ");

					for (int j = 0; j < singleValues.length; j++) {
						matrixConverted[i][j] = Integer.parseInt(singleValues[j]);
					}
				}
				int[] collarpointValues = collarpoints.collarPoints(matrixConverted);

				for (int i = 0; i < collarpointValues.length; i++) {
					int colJValue = collarpoints.countColJValue;
					if (collarpointValues[i] == 0) {

					} else {
						collarPointstxtArea.append("A[" + i + "," + colJValue + "] = " + collarpointValues[i]);
					}
				}
			}
		}
		
		if(e.getSource() == clearbtn) {
			clearFields();
		}
	}
	
	private void clearFields() {
		matrixtxtArea.setText(" ");
		collarPointstxtArea.setText(" ");
		
	}

	private boolean isValidData() {
		SwingValidator sv = new SwingValidator();

		return sv.isPresent(matrixtxtArea, "Key in Matrix Area");
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenuItem exitmenuItem = new JMenuItem("Exit");
		fileMenu.add(exitmenuItem);

		JMenu aboutMenu = new JMenu("About");
		JMenuItem aboutmenuItem = new JMenuItem("About");
		aboutMenu.add(aboutmenuItem);

		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);

		// -------
		exitmenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(CollarPointsMainFrame.this,
						"Do you really want to exit the application?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});

		aboutmenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == aboutmenuItem) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							new About(CollarPointsMainFrame.this);
						}
					});
				}
			}
		});
		return menuBar;
	}

}
