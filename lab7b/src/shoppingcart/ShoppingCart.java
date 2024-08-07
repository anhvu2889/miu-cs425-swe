package shoppingcart;
import java.util.ArrayList;


import java.util.Iterator;

import products.Product;

public class ShoppingCart {
	ArrayList<CartLine> cartLines = new ArrayList<CartLine>();

	public void addToCart(Product product) {
		if (productExists(product)) {
			addExistingProduct(product);
		}
		else {
			addNewProduct(product);
		}		
	}

	private void addNewProduct(Product product) {
		CartLine cartLine = new CartLine();
		cartLine.setProduct(product);
		cartLine.setQuantity(1);
		cartLines.add(cartLine);
	}

	private void addExistingProduct(Product product) {
		for (CartLine cartLine : cartLines) {
			if (isProductInCartLine(product, cartLine)) {
				cartLine.setQuantity(cartLine.getQuantity()+1);
				return;
			}
		}
	}
	
	private boolean productExists(Product product) {
		for (CartLine cartLine : cartLines) {
			if (isProductInCartLine(product, cartLine)) {
				return true;
			}
		}
		return false;
	}

	public void print() {
		System.out.println("Content of the shoppingcart:");
		for (CartLine cartLine : cartLines) {
			System.out.println(cartLine.getQuantity() + " "
					+ cartLine.getProduct().getProductNumber() + " "
					+ cartLine.getProduct().getDescription() + " "
					+ cartLine.getProduct().getPrice());
		}
		System.out.println("Total price ="+getTotalPrice());
	}
	
	public double getTotalPrice(){
		double totalPrice = 0.0;
		for (CartLine cartLine : cartLines) {
			totalPrice=totalPrice+(cartLine.getProduct().getPrice() * cartLine.getQuantity());
		}
		return totalPrice;
	}
	
	public void removeFromCart(Product product){
		Iterator<CartLine> cartLineIterator = cartLines.iterator();
		while (cartLineIterator.hasNext()){
			CartLine cartLine = cartLineIterator.next();
			if (isProductInCartLine(product, cartLine)){
				if (cartLine.getQuantity()>1){
					cartLine.setQuantity(cartLine.getQuantity()-1);
				}
				else{
					cartLineIterator.remove();
				}
			}
		}	
	}

	private boolean isProductInCartLine(Product product, CartLine cartLine) {
		return cartLine.getProduct().getProductNumber().equals(product.getProductNumber());
	}
}
