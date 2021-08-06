package table;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import store.ItemMgr;
import store.OrderMgr;
import store.OrderedItemMgr;
import store.Store;

public class GUIMain {
    static Store store = Store.getInstance();
    public static void main(String args[]) {
    	store.run();
    	startGUI();
    }
    public static void startGUI() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
    	JFrame mainFrame = new JFrame("TableSelectionDemo");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane jtab = new JTabbedPane();
        
        //Create and set up the content pane.
        TableSelectionDemo itemPane = new TableSelectionDemo();
        itemPane.addComponentsToPane(ItemMgr.getInstance(), true);  // 싱글톤
        
        setupOrderPane();
        jtab.add("아이템", itemPane);
        jtab.add("주문", orderPane);
        mainFrame.getContentPane().add(jtab);
        //Display the window.
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    private static JPanel orderPane;
    private static void setupOrderPane() {
    	orderPane = new JPanel(new BorderLayout());
        TableSelectionDemo orderTable = new TableSelectionDemo();
        orderTable.addComponentsToPane(OrderMgr.getInstance(), true);
        
        TableSelectionDemo basketTable = new TableSelectionDemo();
        OrderedItemMgr basket = OrderedItemMgr.getInstance();
        basket.setOrder(OrderMgr.getInstance().getOrder(1));
        basketTable.addComponentsToPane(basket, false);
        orderPane.add(orderTable, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.add(basketTable, BorderLayout.CENTER);
        bottom.add(new JLabel("장바구니 테스트"), BorderLayout.LINE_END);
        orderPane.add(bottom, BorderLayout.SOUTH);
    }
}
