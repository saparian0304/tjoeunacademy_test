package practice.market;

public class Order {
	private Item i = new Item();
	private int count;
	
	public Item getI() {
		return i;
	}
	public void setI(Item i) {
		this.i = i;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
