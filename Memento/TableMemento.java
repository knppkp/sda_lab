package Memento;

import java.util.*;

// Value object.
//
public class TableMemento implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private List<Object> columnIdentifiers;
    private List<List<Object>> dataList;

    // Package visibility to only allow access for
    // the Originator.
    // We receive from the TableModel:
    // - a List of column identifiers
    // - a List of Lists of Object values (assumption: Strings)
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

    // Package visibility to only allow access for
    // the Originator.
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

    public String toString() {
        return "[ci=" + columnIdentifiers.toString() + "\n"
                + "dl=" + dataList.toString() + "]";
    }

    // Other private (static) helper methods.
    // COMPLETE if necessary.
}