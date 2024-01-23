package vending_machine;

public class DrinkMachine {
	Product product1;
	Product product2;
	Product product3;
	Product product4;
	
	
	public DrinkMachine() {
		this.product1 = new Product();
		this.product1.name = "박카스";
		this.product1.price = 900;
		this.product1.quantity = 15;
		
		this.product2 = new Product();
		this.product2.name = "몬스터";
		this.product2.price = 1500;
		this.product2.quantity = 25;
		
		this.product3 = new Product();
		this.product3.name = "핫식스";
		this.product3.price = 1300;
		this.product3.quantity = 10;
		
		this.product4 = new Product();
		this.product4.name = "밀키스";
		this.product4.price = 1400;
		this.product4.quantity = 5;
		
	}
	
	/**
	 * 주문하기
	 * @param name 주문하려는 음료 품목
	 * @param quantity 주문하려는 수량
	 * @return 주문한 내용
	 */
	public Product order(String name, int quantity) {
		Product orderProduct = new Product();
		// String 비교는 == 으로 할 수 없습니다.
		// 단, hard-coding된 String은 == 으로 비교할 수 있지만 추천하지 않습니다.
		// String은 "문자열".equals("비교할 문자열")과 같이 equals 메소드를 통해서 해야 합니다.
		if (name == this.product1.name) {
			if (this.product1.quantity<=0) {
				System.out.println("상품이 품절되었습니다.");
				return null;
			}else if (quantity>this.product1.quantity) {
				System.out.println("상품 수량이 부족하여, "+this.product1.quantity+"개만 주문 되었습니다.");
				orderProduct.name = this.product1.name;
				orderProduct.price = this.product1.price;
				orderProduct.quantity = this.product1.quantity;
				this.product1.quantity =0;
				return orderProduct;
			}
			this.product1.quantity -= quantity;
			orderProduct.name = this.product1.name;
			orderProduct.price = this.product1.price;
			orderProduct.quantity = quantity;
			return orderProduct;
		}
		else if (name == this.product2.name) {
			
			if (this.product2.quantity<=0) {
				System.out.println("상품이 품절되었습니다.");
				return null;
			}else if (quantity>this.product2.quantity) {
				System.out.println("상품 수량이 부족하여, "+this.product2.quantity+"개만 주문 되었습니다.");
				orderProduct.name = this.product2.name;
				orderProduct.price = this.product2.price;
				orderProduct.quantity = this.product2.quantity;
				this.product2.quantity =0;
				return orderProduct;
			}
			this.product2.quantity -= quantity;
			orderProduct.name = this.product2.name;
			orderProduct.price = this.product2.price;
			orderProduct.quantity = quantity;
			return orderProduct;
		}
		else if (name == this.product3.name) {
			if (this.product3.quantity<=0) {
				System.out.println("상품이 품절되었습니다.");
				return null;
			}else if (quantity>this.product3.quantity) {
				System.out.println("상품 수량이 부족하여, "+this.product3.quantity+"개만 주문 되었습니다.");
				orderProduct.name = this.product3.name;
				orderProduct.price = this.product3.price;
				orderProduct.quantity = this.product3.quantity;
				this.product3.quantity =0;
				return orderProduct;
			}
			this.product3.quantity -= quantity;
			orderProduct.name = this.product3.name;
			orderProduct.price = this.product3.price;
			orderProduct.quantity = quantity;
			return orderProduct;
		} 
		else if (name == this.product4.name) {
			if (this.product4.quantity<=0) {
				System.out.println("상품이 품절되었습니다.");
				return null;
			}else if (quantity>this.product4.quantity) {
				System.out.println("상품 수량이 부족하여, "+this.product4.quantity+"개만 주문 되었습니다.");
				orderProduct.name = this.product4.name;
				orderProduct.price = this.product4.price;
				orderProduct.quantity = this.product4.quantity;
				this.product4.quantity =0;
				return orderProduct;
			}
			this.product4.quantity -= quantity;
			orderProduct.name = this.product4.name;
			orderProduct.price = this.product4.price;
			orderProduct.quantity = quantity;
			return orderProduct;
		} 
		else {
			System.out.println("존재하지 않는 상품입니다.");
			return null;
		}
		
	}
	
	public void add(String name, int quantity) {
		if (name==this.product1.name) {
			this.product1.quantity+=quantity;
		}else if (name==this.product2.name) {
				this.product2.quantity+=quantity;
		}else if (name==this.product3.name) {
			this.product3.quantity+=quantity;
		}else if (name==this.product4.name){
			this.product4.quantity+=quantity;
		}else {
			System.out.println("존재하지 않는 상품입니다.");
		}
	}
	
	public void printStock() {
		System.out.println(this.product1.name+"의 재고는 "+this.product1.quantity+"개입니다.");
		System.out.println(this.product2.name+"의 재고는 "+this.product2.quantity+"개입니다.");
		System.out.println(this.product3.name+"의 재고는 "+this.product3.quantity+"개입니다.");
		System.out.println(this.product4.name+"의 재고는 "+this.product4.quantity+"개입니다.");
	}

}

// 강사님 코드
//public class DrinkVendingMachine {
//
//	/**
//	 * 상품1
//	 */
//	Drink drink1;
//	
//	/**
//	 * 상품2
//	 */
//	Drink drink2;
//	
//	/**
//	 * 상품3
//	 */
//	Drink drink3;
//	
//	/**
//	 * 상품4
//	 */
//	Drink drink4;
//	
//	public DrinkVendingMachine() {
//		this.drink1 = new Drink();
//		this.drink1.name = "박카스";
//		this.drink1.price = 900;
//		this.drink1.stock = 15;
//		
//		this.drink2 = new Drink();
//		this.drink2.name = "몬스터";
//		this.drink2.price = 1500;
//		this.drink2.stock = 20;
//		
//		this.drink3 = new Drink();
//		this.drink3.name = "핫식스";
//		this.drink3.price = 1300;
//		this.drink3.stock = 10;
//		
//		this.drink4 = new Drink();
//		this.drink4.name = "밀키스";
//		this.drink4.price = 1400;
//		this.drink4.stock = 5;
//	}
//	
//	/**
//	 * 주문하기
//	 * @param name 주문할 상품의 이름
//	 * @param quantity 주문할 수량
//	 * @return 주문한 상품의 정보
//	 */
//	public Drink order(String name, int quantity) {
//		Drink orderedDrink = null;
//		
//		// String 비교는 == 으로 할 수 없습니다.
//		// 단, hard-coding된 String은 == 으로 비교할 수 있지만 추천하지 않습니다.
//		// String은 "문자열".equals("비교할 문자열")과 같이 equals 메소드를 통해서 해야 합니다.
//		if (this.drink1.name == name) {
//			if (this.drink1.stock < quantity) {
//				System.out.println("상품이 품절되었습니다.");
//				return null;
//			}
//			this.drink1.stock -= quantity;
//			orderedDrink = new Drink();
//			orderedDrink.name = this.drink1.name;
//			orderedDrink.stock = quantity;
//			orderedDrink.price = this.drink1.price;
//		}
//		else if (this.drink2.name == name) {
//			if (this.drink2.stock < quantity) {
//				System.out.println("상품이 품절되었습니다.");
//				return null;
//			}
//			this.drink2.stock -= quantity;
//			orderedDrink = new Drink();
//			orderedDrink.name = this.drink2.name;
//			orderedDrink.stock = quantity;
//			orderedDrink.price = this.drink2.price;
//		}
//		else if (this.drink3.name == name) {
//			if (this.drink3.stock < quantity) {
//				System.out.println("상품이 품절되었습니다.");
//				return null;
//			}
//			this.drink3.stock -= quantity;
//			orderedDrink = new Drink();
//			orderedDrink.name = this.drink3.name;
//			orderedDrink.stock = quantity;
//			orderedDrink.price = this.drink3.price;
//		}
//		else if (this.drink4.name == name) {
//			if (this.drink4.stock < quantity) {
//				System.out.println("상품이 품절되었습니다.");
//				return null;
//			}
//			this.drink4.stock -= quantity;
//			orderedDrink = new Drink();
//			orderedDrink.name = this.drink4.name;
//			orderedDrink.stock = quantity;
//			orderedDrink.price = this.drink4.price;
//		}
//		
//		return orderedDrink;
//	}
//	
//	/**
//	 * 입고하기
//	 * @param name 입고할 상품의 이름
//	 * @param quantity 입고할 상품의 수량
//	 */
//	public void fill(String name, int quantity) {
//		if (this.drink1.name == name) {
//			this.drink1.stock += quantity;
//		}
//		else if (this.drink2.name == name) {
//			this.drink2.stock += quantity;
//		}
//		else if (this.drink3.name == name) {
//			this.drink3.stock += quantity;
//		}
//		else if (this.drink4.name == name) {
//			this.drink4.stock += quantity;
//		}
//	}
//	
//	public void printStock() {
//		System.out.println("===============================");
//		System.out.println("자판기 재고 상황 출력");
//		System.out.println("===============================");
//		System.out.println("상품1: " + this.drink1.name + ", " + this.drink1.price + ", " + this.drink1.stock);
//		System.out.println("상품2: " + this.drink2.name + ", " + this.drink2.price + ", " + this.drink2.stock);
//		System.out.println("상품3: " + this.drink3.name + ", " + this.drink3.price + ", " + this.drink3.stock);
//		System.out.println("상품4: " + this.drink4.name + ", " + this.drink4.price + ", " + this.drink4.stock);
//		System.out.println();
//	}
//	
//}
