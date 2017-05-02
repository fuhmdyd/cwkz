package wx.sunl.bean;

import java.sql.Timestamp;

public class Orders {
	private String orderId;
	private String orderNo;
	private Timestamp createTime;
	private String roomNo;
	private String roomId;
	private String orderStatus;
	private Timestamp handleTime;
	private String empNo;
	private String empId;
	private String userName;
	private String userId;
	private Timestamp planInTime;
	private String planInDays;
	private String remark;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Timestamp getHandleTime() {
		return handleTime;
	}
	public void setHandleTime(Timestamp handleTime) {
		this.handleTime = handleTime;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getPlanInTime() {
		return planInTime;
	}
	public void setPlanInTime(Timestamp planInTime) {
		this.planInTime = planInTime;
	}
	public String getPlanInDays() {
		return planInDays;
	}
	public void setPlanInDays(String planInDays) {
		this.planInDays = planInDays;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
