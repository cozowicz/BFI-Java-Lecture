import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * <b>Angabe</b><br>
 * GUI Klasse.
 */
public class SimpleTableModel implements TableModel {
	
	private TableContentModel tableContentModel;
	private List tableModelListener = new LinkedList();

	public SimpleTableModel(TableContentModel tableContentModel) {
		this.tableContentModel = tableContentModel;
	}

	public void addTableModelListener(TableModelListener l) {
		tableModelListener.add(l);
	}

	public Class getColumnClass(int columnIndex) {
		return JLabel.class;
	}

	public int getColumnCount() {
		return tableContentModel.getColumnCount();
	}

	public String getColumnName(int columnIndex) {
		return tableContentModel.getColumnName(columnIndex);
	}

	public int getRowCount() {
		return tableContentModel.getRowCount();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableContentModel.getValueAt(rowIndex, columnIndex);
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return tableContentModel.isColumnEditable(columnIndex);
	}

	public void removeTableModelListener(TableModelListener l) {
		tableModelListener.remove(l);
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (aValue != null) {
			tableContentModel.setValueAt(((JLabel) aValue).getText(), rowIndex, columnIndex);
			update();
		}
	}

	private void update() {
		Iterator it = tableModelListener.iterator();
		while (it.hasNext()) ((TableModelListener) it.next()).tableChanged(new TableModelEvent(this)); 	
	}

	public void insertAt(int rowIndex) {
		tableContentModel.insertRowBefore(rowIndex);
		update();
	}

	public void removeAt(int rowIndex) {
		tableContentModel.removeRowAt(rowIndex);
		update();
	}

	public void load() {
		tableContentModel.load();
		update();	
	}

	public void save() {
		tableContentModel.save();
	}

}
