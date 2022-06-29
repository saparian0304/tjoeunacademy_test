package practice.market;

public class Order {
	private ItemVO i = new ItemVO();
	private int count;
	
	public ItemVO getI() {
		return i;
	}
	public void setI(ItemVO i) {
		this.i = i;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
