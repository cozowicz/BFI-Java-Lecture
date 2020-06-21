import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ButtonWindow {
	
	public static void createButtonwindow(final IButtonAction buttonAction) {
		JFrame frame = new JFrame("Button");
		frame.setBounds(100, 100, 300, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 1));
		JButton button = new JButton("click me to change color");
		frame.getContentPane().add(button);
		final JLabel label = new JLabel("Color", SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBackground(java.awt.Color.yellow);
		frame.getContentPane().add(label);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = buttonAction.buttonClicked();
				label.setBackground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
			}
		});
		frame.show();
	}
		
}
