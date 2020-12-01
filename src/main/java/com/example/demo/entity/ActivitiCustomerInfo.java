package com.example.demo.entity;



import javax.persistence.*;

/**
 * @author YcWang
 * @version 1.0
 * @Description TODO
 * @date 2020/10/28 10:24 上午
 */

@Entity
@Table(name = "tb_act_customerinfo")
public class ActivitiCustomerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "PROC_INST_ID")
	private String processInstanceId;

	@Column(name = "CUSTOMER_NUM")
	private String customerNum;

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "USER_POSITION")
	private String userPosition;

	public ActivitiCustomerInfo(String processInstanceId, String customerNum, String userId, String userPosition) {
		this.processInstanceId = processInstanceId;
		this.customerNum = customerNum;
		this.userId = userId;
		this.userPosition = userPosition;
	}

	public ActivitiCustomerInfo() { }

	@Override
	public String toString() {
		return "ActivitiCustomerInfo{" +
				"id=" + id +
				", processInstanceID='" + processInstanceId + '\'' +
				", customerNum='" + customerNum + '\'' +
				", userId='" + userId + '\'' +
				", userPosition='" + userPosition + '\'' +
				'}';
	}
}




