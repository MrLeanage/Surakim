/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.query;

/**
 *
 * @author dulshan
 */
public class InventoryItemQuery {
    public static final String LOAD_ALL_INVENTORY_STOCK_DATA = "SELECT * FROM inventory_stock";
    public static final String LOAD_SPECIFIC_INVENTORY_STOCK_DATA = "SELECT * FROM inventory_stock WHERE iSID = ?";
    public static final String INSERT_INVENTORY_STOCK_DATA = "INSERT INTO inventory_stock (iSName, iSQTy, iSDate) VALUES (?, ?, ?)";
    public static final String UPDATE_INVENTORY_STOCK_DATA = "UPDATE inventory_stock SET iSName = ?, iSQTy = ?, iSDate = ?WHERE iSID = ?";
    public static final String DELETE_INVENTORY_STOCK_DELETE = "DELETE FROM inventory_stock WHERE iSID = ?";
}
