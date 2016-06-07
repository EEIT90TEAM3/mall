package cn.itcast.shop.cart.model;

import cn.itcast.shop.product.model.Product;

public class CartItem {
	private Product product; //�������е���Ʒ��Ϣ
	private int count; //��Ʒ����
	private double subtotal; //��ƷС��
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return count*(product.getShop_price());
	}
	/*public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}*/
	
}
