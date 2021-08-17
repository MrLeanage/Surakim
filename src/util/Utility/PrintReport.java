package util.utility;

import bean.WithdrawItem;
import javafx.collections.ObservableList;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;

import javax.swing.*;
import java.io.File;
import java.util.*;
import javafx.collections.FXCollections;
import services.InventoryService;

public class PrintReport extends JFrame {

    public void generateWithdrawReport() {
        InventoryService inventoryService = new InventoryService();

        ArrayList<WithdrawItem> unSortedWithdrawItemList = inventoryService.loadInventoryWithdrawList();

        if (unSortedWithdrawItemList.size() > 0) {
            ArrayList<String> unsortedStringList = new ArrayList();
            ArrayList<WithdrawItem> sortedWithdrawItemList = new ArrayList<WithdrawItem>();

            String startDate = unSortedWithdrawItemList.get(0).getwSDate();
            String endDate;
            if(unSortedWithdrawItemList.size() == 1){
                endDate = "-";
            }else{
                endDate = unSortedWithdrawItemList.get(unSortedWithdrawItemList.size() - 1).getwSDate();
            }
            

            for (WithdrawItem withdrawItem : unSortedWithdrawItemList) {
                unsortedStringList.add(withdrawItem.getwSISID());
            }

            for (String itemID : removeStringDuplicate(unsortedStringList)) {
                WithdrawItem sortedItem = new WithdrawItem();
                for (WithdrawItem withdrawItem : unSortedWithdrawItemList) {
                    if (itemID.equals(withdrawItem.getwSISID())) {
                        sortedItem.setwSISID(itemID);
                        sortedItem.setwSName(withdrawItem.getwSName());
                        sortedItem.setwSQty(sortedItem.getwSQty() + withdrawItem.getwSQty());
                    }
                }
                sortedWithdrawItemList.add(sortedItem);
            }
            ObservableList<WithdrawItem> list = FXCollections.observableArrayList();
            for (WithdrawItem withdrawItem : sortedWithdrawItemList) {
                list.add(withdrawItem);
            }
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(list);
            try {
                HashMap parameter = new HashMap();
                parameter.put("SortedWithdrawItemList", jrBeanCollectionDataSource);
                parameter.put("startDate", startDate);
                parameter.put("endDate", endDate);

                JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath() + "/src/report/WithdrawReport.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(jd);
                JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, parameter, new JREmptyDataSource());
                JRViewer viewer = new JRViewer(JasperPrint);

                //viewer.setOpaque(true);
                viewer.setVisible(true);

                add(viewer);
                this.setSize(850, 800); // JFrame size
                this.setVisible(true);
                try {

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error Occured :" + ex);
                }
            } catch (JRException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "You have no records to generate the Report");
        }

    }
    public static ArrayList<String> removeStringDuplicate(ArrayList<String> list) {

        // Store unique items in result.
        ArrayList<String> result = new ArrayList<String>();

        // Record encountered Strings in HashSet.
        HashSet<String> set = new HashSet<>();

        // Loop over argument list.
        for (String item : list) {

            // If String is not in set, add it to the list and the set.
            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        return result;
    }

}
