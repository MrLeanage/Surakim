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
public class WithdrawItemQuery {
    public static final String LOAD_ALL_INVENTORY_WITHDRAW_DATA = "SELECT * FROM withdrawn_stock";
    public static final String LOAD_SPECIFIC_INVENTORY_WITHDRAW_DATA = "SELECT * FROM withdrawn_stock WHERE wsID = ?";
    public static final String INSERT_INVENTORY_WITHDRAW_DATA = "INSERT INTO withdrawn_stock (wsISID, wsQty, wsDate) VALUES (?, ?, ?)";
    
}
