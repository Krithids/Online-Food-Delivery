package onlinefooddelivery.model;

public class Order extends Restaurant{
//	private int orderId;
//	private int uid;
//	private int quantity;
//	private String date;
//	private int productId;
//	
//	public Order() {}
//	
//	public Order(int orderId,int uid,int quantity,String date) {
//		super();
//		this.orderId=orderId;
//		this.uid=uid;
//		this.quantity=quantity;
//		this.date=date;
//	}
//	
//	public Order(int uid,int quantity,String date) {
//		super();
//		this.uid=uid;
//		this.quantity=quantity;
//		this.date=date;
//	}
//	
//	public int getOrderId() {
//		return orderId;
//	}
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//	
//	public int getUid() {
//		return uid;
//	}
//
//	public void setUid(int uid) {
//		this.uid = uid;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int qunatity) {
//		this.quantity = quantity;
//	}
//	public String getDate() {
//		return date;
//	}
//	public void setDate(String date) {
//		this.date = date;
//	}
//	
//	@Override
//	public String toString() {
//	    return "Order [orderId=" + orderId + ", uid=" + uid + ", quantity=" + quantity + ", date=" + date + "]";
//	}
////
////	public void setProductId(int parseInt) {
////		// TODO Auto-generated method stub
//
//	public void setProductId(int parseInt) {
//		// TODO Auto-generated method stub
//		this.productId=productId;
//		
//	}
//		
//	
//
//}
	private int orderId;
	private int uid;
	private int quantity;
	private String date;
	
	public Order() {
	}
	
	public Order(int orderId, int uid, int quantity, String date) {
		super();
		this.orderId = orderId;
		this.uid = uid;
		this.quantity = quantity;
		this.date = date;
	}

	public Order(int uid, int quantity, String date) {
		super();
		this.uid = uid;
		this.quantity = quantity;
		this.date = date;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}

	
	