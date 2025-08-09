package Memento;

import java.util.*;
import javax.swing.table.*;

public class ScheduleTableModel extends DefaultTableModel {
    private static final long serialVersionUID = 1L;

    // DefaultTableModel uses:
    // - a Vector of column identifiers
    // - a Vector of Vectors of Object values
    // This fact is reflected by the Memento class.
    public ScheduleTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    public TableMemento createMemento() {
        // Create a memento with current state
        // Use public methods to access the data
        List<Object> columnIds = new ArrayList<Object>();
        for (int i = 0; i < getColumnCount(); i++) {
            columnIds.add(getColumnName(i));
        }
        
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        for (int i = 0; i < getRowCount(); i++) {
            List<Object> row = new ArrayList<Object>();
            for (int j = 0; j < getColumnCount(); j++) {
                row.add(getValueAt(i, j));
            }
            dataList.add(row);
        }
        
        return new TableMemento(columnIds, dataList);
    }

    public void setMemento(TableMemento memento) {
        // Restore state from memento
        List<Object> columnIds = memento.getColumnIdentifiers();
        List<List<Object>> dataList = memento.getDataList();
        
        // Clear current data
        setRowCount(0);
        setColumnCount(0);
        
        // Set column identifiers
        for (Object columnId : columnIds) {
            addColumn(columnId);
        }
        
        // Set data
        for (List<Object> row : dataList) {
            // Convert List to Vector for addRow method
            Vector<Object> rowVector = new Vector<Object>();
            for (Object cell : row) {
                rowVector.add(cell);
            }
            addRow(rowVector);
        }
        
        fireTableStructureChanged(); // Notify listeners that table structure changed
    }
}