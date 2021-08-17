/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bean.InventoryItem;
import bean.WithdrawItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utility.JUtility;
import util.connection.DBConnection;
import util.query.InventoryItemQuery;
import util.query.WithdrawItemQuery;

/**
 *
 * @author dulshan
 */
public class InventoryService {

    public ArrayList<InventoryItem> loadInventoryItemsList() {
        ArrayList<InventoryItem> inventoryItemList = new ArrayList<InventoryItem>();
        Connection connection = DBConnection.getDBConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(InventoryItemQuery.LOAD_ALL_INVENTORY_STOCK_DATA);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                inventoryItemList.add(new InventoryItem(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4)));

            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return inventoryItemList;
    }

    public boolean addInventoryItem(InventoryItem inventoryItem) {
        Connection connection = DBConnection.getDBConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(InventoryItemQuery.INSERT_INVENTORY_STOCK_DATA);
            preparedStatement.setString(1, inventoryItem.getiSName());
            preparedStatement.setInt(2, inventoryItem.getiSQty());
            preparedStatement.setString(3, inventoryItem.getiSDate());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InventoryService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean updateInventoryItem(InventoryItem inventoryItem) {
        Connection connection = DBConnection.getDBConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(InventoryItemQuery.UPDATE_INVENTORY_STOCK_DATA);
            preparedStatement.setString(1, inventoryItem.getiSName());
            preparedStatement.setInt(2, inventoryItem.getiSQty());
            preparedStatement.setString(3, inventoryItem.getiSDate());
            preparedStatement.setInt(4, JUtility.seperateID(inventoryItem.getiSID()));
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InventoryService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean deleteInventoryItem(String id) {
        Connection connection = DBConnection.getDBConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(InventoryItemQuery.DELETE_INVENTORY_STOCK_DELETE);

            preparedStatement.setInt(1, JUtility.seperateID(id));
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InventoryService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<WithdrawItem> loadInventoryWithdrawList() {
        ArrayList<WithdrawItem> withdrawItemList = new ArrayList<WithdrawItem>();
        Connection connection = DBConnection.getDBConnection();

        try {
            PreparedStatement withdrawPreparedStatement = connection.prepareStatement(WithdrawItemQuery.LOAD_ALL_INVENTORY_WITHDRAW_DATA);
            PreparedStatement stockPreparedStatement = connection.prepareStatement(InventoryItemQuery.LOAD_SPECIFIC_INVENTORY_STOCK_DATA);
            ResultSet withdrawResultSet = withdrawPreparedStatement.executeQuery();
            while (withdrawResultSet.next()) {
                stockPreparedStatement.setInt(1, withdrawResultSet.getInt(2));
                ResultSet stockResultSet = stockPreparedStatement.executeQuery();
                while (stockResultSet.next()) {
                    withdrawItemList.add(new WithdrawItem(withdrawResultSet.getString(1), withdrawResultSet.getString(2), stockResultSet.getString(2), withdrawResultSet.getInt(3), withdrawResultSet.getString(4)));
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return withdrawItemList;
    }

    public boolean addWithdrawItem(WithdrawItem withdrawItem) {
        Connection connection = DBConnection.getDBConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(WithdrawItemQuery.INSERT_INVENTORY_WITHDRAW_DATA);
            preparedStatement.setInt(1, JUtility.seperateID(withdrawItem.getwSISID()));
            preparedStatement.setInt(2, withdrawItem.getwSQty());
            preparedStatement.setString(3, withdrawItem.getwSDate());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InventoryService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
