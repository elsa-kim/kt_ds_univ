package vending_machine;

public class DrinkMachine {
	
	DrinkProduct[] drinkArray;
	
	
	public DrinkMachine() {
		drinkArray = new DrinkProduct[4];
		
		this.drinkArray[0] = new DrinkProduct();
		this.drinkArray[0].name = "박카스";
		this.drinkArray[0].price = 900;
		this.drinkArray[0].quantity = 15;
		
		this.drinkArray[1] = new DrinkProduct();
		this.drinkArray[1].name = "몬스터";
		this.drinkArray[1].price = 1500;
		this.drinkArray[1].quantity = 25;
		
		this.drinkArray[2] = new DrinkProduct();
		this.drinkArray[2].name = "핫식스";
		this.drinkArray[2].price = 1300;
		this.drinkArray[2].quantity = 10;
		
		this.drinkArray[3] = new DrinkProduct();
		this.drinkArray[3].name = "밀키스";
		this.drinkArray[3].price = 1400;
		this.drinkArray[3].quantity = 5;
		
	}
	
	/**
	 * 주문하기
	 * @param name 주문하려는 음료 품목
	 * @param quantity 주문하려는 수량
	 * @return 주문한 내용
	 */
	public DrinkProduct order(String name, int quantity) {
		DrinkProduct orderProduct = new DrinkProduct();
		for (DrinkProduct product : this.drinkArray) {
			
			if (product!=null && product.name.equals(name)) {
				
				if (product.quantity <= 0) { 
					System.out.println("상품이 품절되었습니다.");
					return null;
				}
				else if (quantity > product.quantity) {
					System.out.println("상품 수량이 부족하여, "+product.quantity+"개만 주문 되었습니다.");
					orderProduct.name = product.name;
					orderProduct.price = product.price;
					orderProduct.quantity = product.quantity;
					product.quantity =0;
					return orderProduct;
				}
				
				System.out.println("상품 "+name+" : "+quantity+"개가 주문 되었습니다.");
				product.quantity -= quantity;
				orderProduct.name = product.name;
				orderProduct.price = product.price;
				orderProduct.quantity = quantity;
				return orderProduct;
			}
		}
			System.out.println("존재하지 않는 상품입니다.");
			return null;
	}
	
	public void add(String name, int quantity) {
		for (DrinkProduct product : this.drinkArray) {
			if (product!=null && product.name.equals(name)) {
				product.quantity += quantity;	
		
			}
		}
	}
	
	public void printStock() {
		for (DrinkProduct product : this.drinkArray) {
			if (product!=null) {
				
				System.out.println(product.name+"의 재고는 "+product.quantity+"개입니다.");
			}
		}
		
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
