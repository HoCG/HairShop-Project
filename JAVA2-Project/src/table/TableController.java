package table;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import facade.DataEngineInterface;
import facade.UIData;
import store.Store;
import store.UserMgr;

public class TableController implements ListSelectionListener {
    DefaultTableModel tableModel;
    JTable table;
    int selectedIndex = -1;
    DataEngineInterface dataMgr;
    @SuppressWarnings("serial")
	void init(DataEngineInterface mgr) {
    	dataMgr = mgr;
    	tableModel = new DefaultTableModel(mgr.getColumnNames(), 0){  //�� ���� ���ϰ� �ϴ� �κ�
    		 public boolean isCellEditable(int row, int column){
    			    return false;
    		 }
    	};
    	loadData("");
    	
    	table = new JTable(tableModel);
        ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(this);
        table.setPreferredScrollableViewportSize(new Dimension(500, 220));
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
    }
    // �Ŵ������� �˻��� ��ü���� ���̺� �����ش�. kwd�� ""�� ��� ���
    void loadData(String kwd) {
    	List<?> result = dataMgr.search(kwd);
    	tableModel.setRowCount(0);
    	for (Object m : result)
    		tableModel.addRow(((UIData)m).getUiTexts());
    }
    void addRow(String[] editTexts) {  // �� �߰�, ���ο� ��ü �����ؼ� �������� �߰�
		try {
			dataMgr.addNewItem(editTexts);
		} catch (Exception ex) {  // �߰� �� ���� �߻�
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "�߰� ������ ����");
			return;
		}
		tableModel.addRow(editTexts);
    }
    // ���� ���õ� ���� SongMgr���� �����ϰ� ���̺��� ����
    void removeRow() {
    	if (selectedIndex < 0) return;
    	String key = (String)tableModel.getValueAt(selectedIndex, 0);
    	dataMgr.remove(key);
    	tableModel.removeRow(selectedIndex);
    }
    // ���� ���õ� ���� ����â�� �������� ����
    void updateRow(String[] editTexts) {
    	if (selectedIndex < 0) return;
		try {
			dataMgr.update(editTexts);
    	} catch (Exception ex) {  // SongMgr���� ���� �� ���� �߻�
			ex.printStackTrace();  
			JOptionPane.showMessageDialog(null, "���� �� ������ ����");
    		return;
    	}
    	for (int i = 0; i < editTexts.length; i++) {
    		tableModel.setValueAt(editTexts[i], selectedIndex, i);
    	}
    }
    // ���õ� ���� ����Ǹ� �� ������ ����â���� ����
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        if (!lsm.isSelectionEmpty()) {
        	selectedIndex = lsm.getMinSelectionIndex();
        	String[] rowTexts = new String[tableModel.getColumnCount()];
        	for (int i = 0; i < rowTexts.length; i++)
        		rowTexts[i] = (String)tableModel.getValueAt(selectedIndex, i);
        	//TableSelectionDemo.bottom.moveSelectedToEdits(rowTexts);
        }
    }
}