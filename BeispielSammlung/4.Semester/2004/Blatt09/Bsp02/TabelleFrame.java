import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 * <b>Angabe</b><br>
 * GUI Klasse.
 */
public class TabelleFrame {

	private JFrame frame;
	private JScrollPane scrollpane;
	private JTable table;
	private JButton insertBeforeButton;
	private JButton insertAfterButton;
	private JButton deleteButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton exitButton;
	private SimpleTableModel tableModel;

	public TabelleFrame(TableContentModel model) {
		Font font = new Font("Arial", Font.PLAIN, 16);
		Font fontBold = new Font("Arial", Font.BOLD, 16);
		frame = new JFrame("Artikelliste");
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table = new JTable();
		table.setFont(font);
		table.setRowHeight(20);
		table.getTableHeader().setFont(fontBold);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableModel = new SimpleTableModel(model);
		table.setModel(tableModel);
		scrollpane = new JScrollPane();
		scrollpane.setViewportView(table);
		frame.getContentPane().setLayout(new BorderLayout(5, 5));

		insertBeforeButton = new JButton("Zeile davor einfügen");
		insertBeforeButton.setFont(fontBold);
		insertBeforeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowIndex = Math.max(0, table.getSelectedRow());
				tableModel.insertAt(rowIndex);
			}
		});
		insertAfterButton = new JButton("Zeile danach einfügen");
		insertAfterButton.setFont(fontBold);
		insertAfterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowIndex = table.getSelectedRow()+1;
				if (rowIndex == 0) rowIndex = tableModel.getRowCount();
				tableModel.insertAt(rowIndex);
			}
		});
		deleteButton = new JButton("Zeile löschen");
		deleteButton.setFont(fontBold);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) tableModel.removeAt(selectedRow); 
			}
		});
		loadButton = new JButton("Artikelliste laden");
		loadButton.setFont(fontBold);
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.load();
			}
		});
		saveButton = new JButton("Artikelliste speichern");
		saveButton.setFont(fontBold);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.save();
			}
		});
		exitButton = new JButton("Beenden");
		exitButton.setFont(fontBold);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new GridLayout(2, 3, 0, 5));
		buttonPane.add(insertBeforeButton);
		buttonPane.add(insertAfterButton);
		buttonPane.add(deleteButton);
		buttonPane.add(loadButton);
		buttonPane.add(saveButton);
		buttonPane.add(exitButton);
		
		frame.getContentPane().add(scrollpane, BorderLayout.CENTER);
		frame.getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}
	
	public void show() {
		frame.show();	
	}
	
}
