
package CollarPointsGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class About extends JDialog {

	private JButton okButton;
	private JLabel amalitechImage;

	public About(JFrame parent) {
		super(parent, "About", false);

		okButton = new JButton("OK");

		Playoutdesign();

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		setVisible(true);
		setSize(650, 400);
		setLocationRelativeTo(parent);
	}

	private void Playoutdesign() {

		JPanel controlspanel = new JPanel();
		JPanel buttonspanel = new JPanel();

		setLayout(new BorderLayout());

		controlspanel.setLayout(new GridBagLayout());
		buttonspanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		Border spaceBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border titledBorder = BorderFactory.createTitledBorder("AMALITECH");

		Border compoundBorder = BorderFactory.createCompoundBorder(spaceBorder, titledBorder);
		controlspanel.setBorder(compoundBorder);

		GridBagConstraints gc = new GridBagConstraints();

		amalitechImage = new JLabel(Utilities.createIcon("/Images/amalitechlogo.JPG"));

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		controlspanel.add(amalitechImage, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		controlspanel.add(new JLabel("(c) Copyright AmaliTech 2020"), gc);

		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		controlspanel.add(new JLabel(
				"All rights reserved. This product includes software developed by other projects including synthetica libraries"),
				gc);

		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		controlspanel.add(new JLabel("From Jyloo Softwares(http://synthetica.com)"), gc);

		gc.gridx = 0;
		gc.gridy = 4;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		controlspanel.add(new JLabel("Collar Points: Refers to elements in a matrix, which are (maximum) in their rows, but minimum" +"\n"
				+ "in their columns"), gc);

		gc.gridx = 0;
		gc.gridy = 5;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		controlspanel.add(new JLabel("Developer: Nathaniel Cobbinah"), gc);

		gc.gridx = 0;
		gc.gridy = 6;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		controlspanel.add(new JLabel("Email:nathaniel.cobbinah@amalitech.org"), gc);

		buttonspanel.add(okButton);

		add(controlspanel, BorderLayout.CENTER);
		add(buttonspanel, BorderLayout.SOUTH);
	}
}
