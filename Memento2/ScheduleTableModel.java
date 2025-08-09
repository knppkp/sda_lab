package Memento2;

import java.util.*;
import javax.swing.table.*;

public class ScheduleTableModel extends DefaultTableModel {
    private static final long serialVersionUID = 1L;

    // Inner Memento class - only accessible within ScheduleTableModel
    public static class TableMemento implements java.io.Serializable {
        private static final long serialVersionUID = 1L;

        private List<Object> columnIdentifiers;
        private List<List<Object>> dataList;

        // Package visibility to only allow access for the Originator
        TableMemento(List<Object> columnIdentifiers, List<List<Object>> dataList) {
            // Deep copy the column identifiers
            this.columnIdentifiers = new ArrayList<Object>();
            for (Object columnId : columnIdentifiers) {
                this.columnIdentifiers.add(columnId);
            }
            
            // Deep copy the data list (list of lists)
            this.dataList = new ArrayList<List<Object>>();
            for (List<Object> row : dataList) {
                List<Object> newRow = new ArrayList<Object>();
                for (Object cell : row) {
                    newRow.add(cell);
                }
                this.dataList.add(newRow);
            }
        }

        // Package visibility to only allow access for the Originator
        List<Object> getColumnIdentifiers() {
            // Return a copy to maintain immutability
            List<Object> copy = new ArrayList<Object>();
            for (Object columnId : columnIdentifiers) {
                copy.add(columnId);
            }
            return copy;
        }

        List<List<Object>> getDataList() {
            // Return a deep copy to maintain immutability
            List<List<Object>> copy = new ArrayList<List<Object>>();
            for (List<Object> row : dataList) {
                List<Object> newRow = new ArrayList<Object>();
                for (Object cell : row) {
                    newRow.add(cell);
                }
                copy.add(newRow);
            }
            return copy;
        }

        @Override
        public String toString() {
            return "[ci=" + columnIdentifiers.toString() + "\n"
                    + "dl=" + dataList.toString() + "]";
        }
    }

    // ScheduleTableModel constructor and methods
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