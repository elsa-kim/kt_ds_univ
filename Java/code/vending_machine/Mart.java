package vending_machine;


/**
 * 자판기와 고객이 만나는 마트
 */
public class Mart {
	
	
	public static void main(String[] args) {
		// 모든 클래스의 슈퍼클래스는 object
		
		/*
		 * Object
		 *   --> Product
		 *  	--> TemperatureProduct
		 *  Project is a Object
		 *  TemperatureProduct is a Product
		 *  TemperatureProduct is a Object
		 */
		
		
//		Product p = new Product();
//		TemperatureProduct tp = new TemperatureProduct();
//		
////		printTemperatureProduct(tp);
//		printProduct(tp);
//		printProduct(p);
		
		
		Product p = new Product();
		p.setName("보드마카");
		p.setPrice(500);
		p.setQuantity(40);
		
		System.out.println(p);
		//vending_machine.Product@279f2327
		// 제품명 : 보드마카, 가격 : 500, 재고 : 40
		
		
		// Seller(추상클래스)
		// --> VendingMachine
		// --> RefundableVendingMachine
		// Is A (다형성)
		// VendingMachine is a Seller
		// RefundableVendingMachine is a Seller
		// Seller drinkVendingMachine = new VendingMachine();
		// Seller drinkVendingMachine = new RefundableVendingMachine();
		
		//Sellable(인터페이스)
		// --> VendingMachine
		// --> RefundableVendingMachine
		// 인터페이스를 구현(Is A)
		// VendingMachine is a Sellable
		// RefundableVendingMachine is a Sellable
		// Sellable drinkVendingMachine = new VendingMachine();
		// Sellable drinkVendingMachine = new RefundableVendingMachine();
		
		//객체지향 방식으로 개발
		Sellable drinkMachine = new VendingMachine();
		
		
		Customer musk = new Customer(200_000);
		
		
		// 상품 하나씩 구매
		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시", 50);
		
		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시");
		
		drinkMachine.printProducts();
		musk.printProducts();
		
		
		Sellable snackMachine = new RefundableVendingMachine(400);
		// 상품 n개씩 구매
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 50);
		
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 2);
		
		System.out.println("-------");
		snackMachine.printProducts();
		musk.printProducts();
		
		
	/*
		
		//객체지향 방식으로 개발
		VendingMachine drinkMachine = new VendingMachine();
		VendingMachine snackMachine = new VendingMachine();
		
		Customer musk = new Customer(200_000);
		
		
		drinkMachine.insertMoney(musk);
		drinkMachine.pressButton(musk);
		
		System.out.println("자판기의 잔액 : "+ drinkMachine.money);
		System.out.println("자판기의 상품 이름 : "+ drinkMachine.product.name);
		System.out.println("자판기의 상품 수량 : "+ drinkMachine.product.quantity);
		System.out.println("고객의 지갑 잔액 : "+ musk.wallet);
		System.out.println("고객의 상품 수량 : "+ musk.product.quantity);
		
		
		
		*/
	}

}
