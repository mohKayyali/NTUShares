package ntu.stock.market.sharesbrokering;

public class UserShare {
	
	private int id;
	private int userId;
	private String shareSymbol;
	private int shareCount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShareSymbol() {
		return shareSymbol;
	}
	public void setShareSymbol(String shareSymbol) {
		this.shareSymbol = shareSymbol;
	}
	public int getShareCount() {
		return shareCount;
	}
	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
