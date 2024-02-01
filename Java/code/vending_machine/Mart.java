package vending_machine;

import java.util.ArrayList;
import java.util.List;

/**
 * 자판기와 고객이 만나는 마트
 */
public class Mart {
	/*
	 * Refactoring ==> 코드 깔끔하게 개선하는 과정
	 * 1. 메소드 Body 라인 수 : 20라인 이하 작성할 것
	 * 2. 클래스명, 메소드명, 변수(인스턴스)명은 명확(축약, 애매모호 x)하게 지을 것
	 * 3. 메소드 구성은 신문기사처럼 쓸 것
	 * 		- 기사의 내용처럼, 편하게 읽을 수 있도록 만든다
	 * 			- 메소드 Chain을 순서대로 작성
	 */
	
	public static List<Product> initiateProduct(){
		List<Product> productList = new ArrayList<>();
		
		Product product1 = new Product();
		product1.setName("제로펩시");
		product1.setPrice(1600);
		product1.setQuantity(50);
		productList.add(product1);
		
		Product product2 = new Product();
		product2.setName("제로콜라");
		product2.setPrice(1500);
		product2.setQuantity(30);
		productList.add(product2);
		
		Product product3 = new Product();
		product3.setName("제로스프라이트");
		product3.setPrice(1400);
		product3.setQuantity(20);
		productList.add(product3);
		
		return productList;
	}
	
	public static void initiateInsertMoneyHandler(Sellable<Product> sellable) {
		sellable.setInsertMoneyHandler(new InsertMoneyHandler<Product>() {
			@Override
			public void handle(VendingMachine<Product> machine, Customer customer, Product item, String productName) {
				if(item.equals(productName)) {
					int money = machine.getMoney();
					money += item.getPrice();
					machine.setMoney(money);
					
					customer.pay(item.getPrice());
				}
			}});
	}
	
	public static void initiatePressButtonHandler(Sellable<Product> sellable) {
		sellable.setPressButtonHandler(new PressButtonHandler<Product>() {
			@Override
			public void handle(VendingMachine<Product> machine, Customer customer, Product item, String productName,
					int orderCount) {
				if(item.equals(productName)) {
					
					if (item.getQuantity() <= 0) {
						machine.refund(customer, item.getPrice());
						return; // 메소드 종료
					}
					
					int quantity = item.getQuantity();
					quantity -= orderCount;
					item.setQuantity(quantity);
					
					customer.addStock(productName, item.getPrice(), orderCount);
				}
			}
			
		});
	}
	
	public static void initiatePrintHandler(Sellable<Product> sellable) {
		sellable.setPrintHandler(new PrintHandler<Product>() {
			@Override
			public void handle(Product item) {
				System.out.println("자판기의 상품 이름 : "+ item.getName());
				System.out.println("자판기의 상품 수량 : "+ item.getQuantity());
			}
			
		});
	}
	
	public static void main(String[] args) {
		
		//객체지향 방식으로 개발
		Sellable<Product> drinkMachine = new VendingMachine<>(100_000, initiateProduct());
		initiateInsertMoneyHandler(drinkMachine);
		initiatePressButtonHandler(drinkMachine);
		initiatePrintHandler(drinkMachine);
		

		
		Customer musk = new Customer(200_000);
		
		
		// 상품 하나씩 구매
		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시", 50);
		
		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시");
		
		drinkMachine.printProducts();
		musk.printProducts();
		
		
		Sellable<Product> snackMachine = new RefundableVendingMachine<>(400, initiateProduct());
		initiateInsertMoneyHandler(snackMachine);
		initiatePressButtonHandler(snackMachine);
		initiatePrintHandler(snackMachine);
		
		
		// 상품 n개씩 구매
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 50);
		
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 2);
		
		System.out.println("-------");
		snackMachine.printProducts();
		musk.printProducts();
		
		
	}

}

// /**
//  * 자판기와 고객이 만나는 마트
//  */
// public class Mart {

// 	public static void main(String[] args) {
// 		// 모든 클래스의 슈퍼클래스는 object
		
		
// 		Product p = new Product();
// 		p.setName("보드마카");
// 		p.setPrice(500);
// 		p.setQuantity(40);
		
// 		System.out.println(p);
// 		//vending_machine.Product@279f2327
// 		// 제품명 : 보드마카, 가격 : 500, 재고 : 40
		
// 		List<Product> productList = new ArrayList<>();
		
// 		Product product1 = new Product();
// 		product1.setName("제로펩시");
// 		product1.setPrice(1600);
// 		product1.setQuantity(50);
// 		productList.add(product1);
		
// 		Product product2 = new Product();
// 		product2.setName("제로콜라");
// 		product2.setPrice(1500);
// 		product2.setQuantity(30);
// 		productList.add(product2);
		
// 		Product product3 = new Product();
// 		product3.setName("제로스프라이트");
// 		product3.setPrice(1400);
// 		product3.setQuantity(20);
// 		productList.add(product3);
		
// 		//객체지향 방식으로 개발
// 		Sellable<Product> drinkMachine = new VendingMachine<>(100_000, productList);
// 		drinkMachine.setInsertMoneyHandler(new InsertMoneyHandler<Product>() {
// 			@Override
// 			public void handle(VendingMachine<Product> machine, Customer customer, Product item, String productName) {
// 				if(item.equals(productName)) {
// 					int money = machine.getMoney();
// 					money += item.getPrice();
// 					machine.setMoney(money);
					
// 					customer.pay(item.getPrice());
// 				}
// 			}});
		
// 		drinkMachine.setPressButtonHandler(new PressButtonHandler<Product>() {
// 			@Override
// 			public void handle(VendingMachine<Product> machine, Customer customer, Product item, String productName,
// 					int orderCount) {
// 				if(item.equals(productName)) {
					
// 					if (item.getQuantity() <= 0) {
// 						machine.refund(customer, item.getPrice());
// 						return; // 메소드 종료
// 					}
					
// 					int quantity = item.getQuantity();
// 					quantity -= orderCount;
// 					item.setQuantity(quantity);
					
// 					customer.addStock(productName, item.getPrice(), orderCount);
// 				}
// 			}
			
// 		});
		
// 		drinkMachine.setPrintHandler(new PrintHandler<Product>() {
// 			@Override
// 			public void handle(Product item) {
// 				System.out.println("자판기의 상품 이름 : "+ item.getName());
// 				System.out.println("자판기의 상품 수량 : "+ item.getQuantity());
// 			}
			
// 		});
		
// 		Customer musk = new Customer(200_000);
		
		
// 		// 상품 하나씩 구매
// 		drinkMachine.insertMoney(musk, "제로펩시");
// 		drinkMachine.pressButton(musk, "제로펩시", 50);
		
// 		drinkMachine.insertMoney(musk, "제로펩시");
// 		drinkMachine.pressButton(musk, "제로펩시");
		
// 		drinkMachine.printProducts();
// 		musk.printProducts();
		
		
// 		Sellable<Product> snackMachine = new RefundableVendingMachine<>(400, productList);
		
// 		snackMachine.setInsertMoneyHandler(new InsertMoneyHandler<Product>() {
// 			@Override
// 			public void handle(VendingMachine<Product> machine, Customer customer, Product item, String productName) {
// 				if(item.equals(productName)) {
// 					int money = machine.getMoney();
// 					money += item.getPrice();
// 					machine.setMoney(money);
					
// 					customer.pay(item.getPrice());
// 				}
// 			}});
		
// 		snackMachine.setPressButtonHandler(new PressButtonHandler<Product>() {
// 			@Override
// 			public void handle(VendingMachine<Product> machine, Customer customer, Product item, String productName,
// 					int orderCount) {
// 				if(item.equals(productName)) {
					
// 					if (item.getQuantity() <= 0) {
// 						machine.refund(customer, item.getPrice());
// 						return; // 메소드 종료
// 					}
					
// 					int quantity = item.getQuantity();
// 					quantity -= orderCount;
// 					item.setQuantity(quantity);
					
// 					customer.addStock(productName, item.getPrice(), orderCount);
// 				}
// 			}
			
// 		});
		
// 		snackMachine.setPrintHandler(new PrintHandler<Product>() {
// 			@Override
// 			public void handle(Product item) {
// 				System.out.println("자판기의 상품 이름 : "+ item.getName());
// 				System.out.println("자판기의 상품 수량 : "+ item.getQuantity());
// 			}
			
// 		});
		
// 		// 상품 n개씩 구매
// 		snackMachine.insertMoney(musk, "제로펩시");
// 		snackMachine.pressButton(musk, "제로펩시", 50);
		
// 		snackMachine.insertMoney(musk, "제로펩시");
// 		snackMachine.pressButton(musk, "제로펩시", 2);
		
// 		System.out.println("-------");
// 		snackMachine.printProducts();
// 		musk.printProducts();
		
		
// 	}

// }

// /**
//  * 자판기와 고객이 만나는 마트
//  */
// public class Mart {
// //	public static void printProduct(Product p) {
// //		System.out.println(p.getName()); //null
// //		
// //		if (p instanceof TemperatureProduct) {
// //			TemperatureProduct tp = (TemperatureProduct) p;
// //			tp.setIsHot(true);
// //			System.out.println(tp.getIsHot());
// //		}
// //	}
	
// 	public static void main(String[] args) {
// 		// 모든 클래스의 슈퍼클래스는 object
		
// 		/*
// 		 * Object
// 		 *   --> Product
// 		 *  	--> TemperatureProduct
// 		 *  Project is a Object
// 		 *  TemperatureProduct is a Product
// 		 *  TemperatureProduct is a Object
// 		 */
		
		
// //		Product p = new Product();
// //		TemperatureProduct tp = new TemperatureProduct();
// //		
// ////		printTemperatureProduct(tp);
// //		printProduct(tp);
// //		printProduct(p);
		
		
// 		Product p = new Product();
// 		p.setName("보드마카");
// 		p.setPrice(500);
// 		p.setQuantity(40);
		
// 		System.out.println(p);
// 		//vending_machine.Product@279f2327
// 		// 제품명 : 보드마카, 가격 : 500, 재고 : 40
		
		
// 		// Seller(추상클래스)
// 		// --> VendingMachine
// 		// --> RefundableVendingMachine
// 		// Is A (다형성)
// 		// VendingMachine is a Seller
// 		// RefundableVendingMachine is a Seller
// 		// Seller drinkVendingMachine = new VendingMachine();
// 		// Seller drinkVendingMachine = new RefundableVendingMachine();
		
// 		//Sellable(인터페이스)
// 		// --> VendingMachine
// 		// --> RefundableVendingMachine
// 		// 인터페이스를 구현(Is A)
// 		// VendingMachine is a Sellable
// 		// RefundableVendingMachine is a Sellable
// 		// Sellable drinkVendingMachine = new VendingMachine();
// 		// Sellable drinkVendingMachine = new RefundableVendingMachine();
		
// 		//객체지향 방식으로 개발
// 		Sellable drinkMachine = new VendingMachine();
		
		
// 		Customer musk = new Customer(200_000);
		
		
// 		// 상품 하나씩 구매
// 		drinkMachine.insertMoney(musk, "제로펩시");
// 		drinkMachine.pressButton(musk, "제로펩시", 50);
		
// 		drinkMachine.insertMoney(musk, "제로펩시");
// 		drinkMachine.pressButton(musk, "제로펩시");
		
// 		drinkMachine.printProducts();
// 		musk.printProducts();
		
		
// 		Sellable snackMachine = new RefundableVendingMachine(400);
// 		// 상품 n개씩 구매
// 		snackMachine.insertMoney(musk, "제로펩시");
// 		snackMachine.pressButton(musk, "제로펩시", 50);
		
// 		snackMachine.insertMoney(musk, "제로펩시");
// 		snackMachine.pressButton(musk, "제로펩시", 2);
		
// 		System.out.println("-------");
// 		snackMachine.printProducts();
// 		musk.printProducts();
		
		
// 	/*
		
// 		//객체지향 방식으로 개발
// 		VendingMachine drinkMachine = new VendingMachine();
// 		VendingMachine snackMachine = new VendingMachine();
		
// 		Customer musk = new Customer(200_000);
		
		
// 		drinkMachine.insertMoney(musk);
// 		drinkMachine.pressButton(musk);
		
// 		System.out.println("자판기의 잔액 : "+ drinkMachine.money);
// 		System.out.println("자판기의 상품 이름 : "+ drinkMachine.product.name);
// 		System.out.println("자판기의 상품 수량 : "+ drinkMachine.product.quantity);
// 		System.out.println("고객의 지갑 잔액 : "+ musk.wallet);
// 		System.out.println("고객의 상품 수량 : "+ musk.product.quantity);
		
		
		
// 		*/
// 	}

// }
