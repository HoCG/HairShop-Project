package table;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import facade.DataEngineInterface;

public class TableSelectionDemo extends JPanel {
    private static final long serialVersionUID = 1L;
 	static TableController tableController;
    public TableSelectionDemo() {
    	super(new BorderLayout());
    }
    void addComponentsToPane(DataEngineInterface mgr, boolean hasTop) {
    	tableController = new TableController();
     	tableController.init(mgr);
    	JScrollPane center = new JScrollPane(tableController.table);   	
    	add(center, BorderLayout.CENTER);
    	if (hasTop)
    		setupTopPane();
    }
    void setupTopPane() {
    	JPanel topPane = new JPanel();
        JTextField kwdTextField = new JTextField("", 20);
        topPane.add(kwdTextField, BorderLayout.LINE_START);
        JButton search = new JButton("검색");
        topPane.add(search, BorderLayout.LINE_END);
        search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getActionCommand().equals("검색")) {
        			tableController.loadData(kwdTextField.getText());
            	}
           }
        });
        add(topPane, BorderLayout.PAGE_START);
    }

}