package wx.sunl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wx.sunl.bean.Orders;
import wx.sunl.dao.DBHelper;
import wx.sunl.dao.OrdersDao;

public class OrdersDaoImpl implements OrdersDao {
	
	static DBHelper dbh = null;
	
	@Override
	public Orders findById(String orderId) {
		Orders orders = null;
		ResultSet rst = null;
		String[] params = new String[1];
		String sql = "SELECT * FROM tb_order WHERE ORDER_ID = ?";
		params[0] = orderId;
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, params);
		try {
			while(rst.next()){
				orders = new Orders();
				orders.setOrderId(rst.getString("ORDER_ID"));
				orders.setOrderNo(rst.getString("ORDER_NO"));
				orders.setCreateTime(rst.getTimestamp("CREATE_TIME"));
				orders.setRoomNo(rst.getString("ROOM_NO"));
				orders.setRoomId(rst.getString("ROOM_ID"));
				orders.setOrderStatus(rst.getString("ORDER_STATUS"));
				orders.setHandleTime(rst.getTimestamp("HANDLE_TIME"));
				orders.setEmpNo(rst.getString("EMP_NO"));
				orders.setEmpId(rst.getString("EMP_ID"));
				orders.setRemark(rst.getString("REMARK"));
				orders.setUserId(rst.getString("USER_ID"));
				orders.setCheckInTime(rst.getTimestamp("PLAN_IN_TIME"));
				orders.setCheckInDays(rst.getString("PLAN_IN_DAYS"));
				orders.setRoomType(rst.getString("ROOM_TYPE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<Orders> queryAllOrders() {
		Orders orders = null;
		ResultSet rst = null;
		List<Orders> orderList = new ArrayList<Orders>();
		String sql = "SELECT * FROM tb_order";
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, null);
		try {
			while(rst.next()){
				orders = new Orders();
				orders.setOrderId(rst.getString("ORDER_ID"));
				orders.setOrderNo(rst.getString("ORDER_NO"));
				orders.setCreateTime(rst.getTimestamp("CREATE_TIME"));
				orders.setRoomNo(rst.getString("ROOM_NO"));
				orders.setRoomId(rst.getString("ROOM_ID"));
				orders.setOrderStatus(rst.getString("ORDER_STATUS"));
				orders.setHandleTime(rst.getTimestamp("HANDLE_TIME"));
				orders.setEmpNo(rst.getString("EMP_NO"));
				orders.setEmpId(rst.getString("EMP_ID"));
				orders.setRemark(rst.getString("REMARK"));
				orders.setUserName(rst.getString("USER_NAME"));
				orders.setUserId(rst.getString("USER_ID"));
				orders.setCheckInTime(rst.getTimestamp("PLAN_IN_TIME"));
				orders.setCheckInDays(rst.getString("PLAN_IN_DAYS"));
				orders.setRoomType(rst.getString("ROOM_TYPE"));
				orderList.add(orders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public boolean saveOrUpdate(Orders orders, String order) {
		boolean flag = false;
		String sql = null;
		String[] params = null;
		dbh = new DBHelper();
		if(order.equals("save")){
			sql = "INSERT INTO tb_order VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			params = new String[15];
			params[0] = orders.getOrderId();
			params[1] = orders.getOrderNo();
			params[2] = String.valueOf(orders.getCreateTime());
			params[3] = orders.getRoomNo();
			params[4] = orders.getRoomId();
			params[5] = orders.getOrderStatus();
			params[6] = !String.valueOf(orders.getHandleTime()).equals("null") ? String.valueOf(orders.getHandleTime()) : "1970-01-02 00:00:00";
			params[7] = orders.getEmpNo();
			params[8] = orders.getEmpId();
			params[9] = orders.getRemark();
			params[10] = orders.getUserName();
			params[11] = orders.getUserId();
			params[12] = String.valueOf(orders.getCheckInTime());
			params[13] = orders.getCheckInDays();
			params[14] = orders.getRoomType();
			flag = dbh.excuteSql(sql, params);
		}else{
			sql = "UPDATE tb_order SET ORDER_NO=?,CREATE_TIME=?,ROOM_NO=?,ROOM_ID=?,ORDER_STATUS=?,HANDLE_TIME=?,EMP_NO=?,EMP_ID=?,REMARK=?,USER_NAME=?,USER_ID=?,PLAN_IN_TIME=?,PLAN_IN_DAYS=?,ROOM_TYPE=? WHERE ORDER_ID=?";
			params = new String[15];
			params[0] = orders.getOrderNo();
			params[1] = !String.valueOf(orders.getCreateTime()).equals("null") ? String.valueOf(orders.getCreateTime()) : "1970-01-02 00:00:00";
			params[2] = orders.getRoomNo();
			params[3] = orders.getRoomId();
			params[4] = orders.getOrderStatus();
			params[5] = !String.valueOf(orders.getHandleTime()).equals("null") ? String.valueOf(orders.getHandleTime()) : "1970-01-02 00:00:00";
			params[6] = orders.getEmpNo();
			params[7] = orders.getEmpId();
			params[8] = orders.getRemark();
			params[9] = orders.getUserId();
			params[10] = orders.getUserName();
			params[11] = !String.valueOf(orders.getCheckInTime()).equals("null") ? String.valueOf(orders.getCheckInTime()) : "1970-01-02 00:00:00";
			params[12] = orders.getCheckInDays();
			params[13] = orders.getRoomType();
			params[14] = orders.getOrderId();
			flag = dbh.excuteSql(sql, params);
		}
		return flag;
	}

	@Override
	public boolean deleteById(String orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Orders> queryActiveOrders() {
		Orders orders = null;
		ResultSet rst = null;
		List<Orders> orderList = new ArrayList<Orders>();
		String sql = "SELECT * FROM tb_order WHERE ORDER_STATUS = '0'";
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, null);
		try {
			while(rst.next()){
				orders = new Orders();
				orders.setOrderId(rst.getString("ORDER_ID"));
				orders.setOrderNo(rst.getString("ORDER_NO"));
				orders.setCreateTime(rst.getTimestamp("CREATE_TIME"));
				orders.setRoomNo(rst.getString("ROOM_NO"));
				orders.setRoomId(rst.getString("ROOM_ID"));
				orders.setOrderStatus(rst.getString("ORDER_STATUS"));
				orders.setHandleTime(rst.getTimestamp("HANDLE_TIME"));
				orders.setEmpNo(rst.getString("EMP_NO"));
				orders.setEmpId(rst.getString("EMP_ID"));
				orders.setRemark(rst.getString("REMARK"));
				orders.setUserName(rst.getString("USER_NAME"));
				orders.setUserId(rst.getString("USER_ID"));
				orders.setCheckInTime(rst.getTimestamp("PLAN_IN_TIME"));
				orders.setCheckInDays(rst.getString("PLAN_IN_DAYS"));
				orderList.add(orders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public List<Orders> queryPersonalOrders(String userId) {
		Orders orders = null;
		ResultSet rst = null;
		List<Orders> orderList = new ArrayList<Orders>();
		String[] params = new String[1];
		String sql = "SELECT * FROM tb_order WHERE USER_ID = ?";
		params[0] = userId;
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, params);
		try {
			while(rst.next()){
				orders = new Orders();
				orders.setOrderId(rst.getString("ORDER_ID"));
				orders.setOrderNo(rst.getString("ORDER_NO"));
				orders.setCreateTime(rst.getTimestamp("CREATE_TIME"));
				orders.setRoomNo(rst.getString("ROOM_NO"));
				orders.setRoomId(rst.getString("ROOM_ID"));
				orders.setOrderStatus(rst.getString("ORDER_STATUS"));
				orders.setHandleTime(rst.getTimestamp("HANDLE_TIME"));
				orders.setEmpNo(rst.getString("EMP_NO"));
				orders.setEmpId(rst.getString("EMP_ID"));
				orders.setRemark(rst.getString("REMARK"));
				orders.setUserName(rst.getString("USER_NAME"));
				orders.setUserId(rst.getString("USER_ID"));
				orders.setCheckInTime(rst.getTimestamp("PLAN_IN_TIME"));
				orders.setCheckInDays(rst.getString("PLAN_IN_DAYS"));
				orders.setRoomType(rst.getString("ROOM_TYPE"));
				orderList.add(orders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

}
