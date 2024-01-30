package vending_machine;



/**
 * 상속받은 클래스가 추상메소드 존자하는 추상클래스라면<br/>
 * 추상 메소드를 이 클래스에서 구현 시키거나<br/>
 * 이 클래스도 추상클래스로 만들어줘야함.<br/>
 * <b>환불 불가능한 자판기</b>
 */
public class VendingMachine implements Sellable {

	/**
	 * 상품수량
	 */
	private Product[] productArray;
	
	/**
	 * 돈
	 */
	private int money;
	
	public VendingMachine() {
		this(100_000);
	}
	
	public VendingMachine(int money) {
		this.money = money;
		this.productArray = new Product[3];
		
		this.productArray[0] = new Product();
		this.productArray[0].setName("제로펩시");
		this.productArray[0].setPrice(1600);
		this.productArray[0].setQuantity(50);
		
		this.productArray[1] = new Product();
		this.productArray[1].setName("제로콜라");
		this.productArray[1].setPrice(1500);
		this.productArray[1].setQuantity(30);
		
		this.productArray[2] = new Product();
		this.productArray[2].setName("제로스프라이트");
		this.productArray[2].setPrice(1400);
		this.productArray[2].setQuantity(20);
	}
	
	@Override
	public Product[] getProductArray() {
		return this.productArray;
	}

	@Override
	public int getMoney() {
		return this.money;
	}

	@Override
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public void insertMoney(Customer customer, String productName) {
		for (Product product : this.productArray) {
			if(product.equals(productName)) {
				this.money += product.getPrice();
				customer.pay(product.getPrice());
				break; // 반복중단
			}
		}
	}

	@Override
	public void pressButton(Customer customer, String productName) {
		this.pressButton(customer, productName, VendingMachine.PRODUCT_COUNT);
	}

	@Override
	public void pressButton(Customer customer, String productName, int orderCount) {
		for ( Product product : this.productArray) {
			if(product.equals(productName)) {
				
				if (product.getQuantity() <= 0) {
					this.refund(customer, product.getPrice());
					return; // 메소드 종료
				}
				
				int quantity = product.getQuantity();
				quantity -= orderCount;
				product.setQuantity(quantity);
				
				customer.addStock(productName, product.getPrice(), orderCount);
				break;
			}
		}
	}

	// refunable에서 재정의 할 수 있게 protected 타입으로 변경
	protected void refund(Customer customer, int refundMoney) {
		
	}

	@Override
	public void printProducts() {
		System.out.println("자판기의 잔액 : "+ this.money);
		for (Product product : this.productArray) {
			if (product != null) {
				System.out.println("자판기의 상품 이름 : "+ product.getName());
				System.out.println("자판기의 상품 수량 : "+ product.getQuantity());
				
			}
		}
	}
	
//public class VendingMachine extends Seller{
	
//	public VendingMachine() {
//		super(); // 슈퍼 클래스의 파라미터 없는 기본 형태 생성자 호출
//	}
//	
//	public VendingMachine(int money) {
//		super(money); // 슈퍼 클래스의 int 파라미터 있는 생성자 호출
//	}
//	
//	@Override
//	public final void insertMoney(Customer customer, String productName) {
//		super.insertMoney(customer, productName);
//	}
//	
//	@Override
//	public final void pressButton(Customer customer, String productName) {
//		super.pressButton(customer, productName);
//	}
//	
//	@Override
//	public final void pressButton(Customer customer, String productName, int orderCount) {
//		super.pressButton(customer, productName, orderCount);
//	}
//	
//	@Override
//	protected void refund(Customer customer, int refundMoney) {
//		System.out.println("재고가 없습니다.");
//		System.out.println("환불은 못해드려요.");
//		
//	}
	
	

	
}

// /**
//  * 자판기
//  */
// public class VendingMachine {

// 	// 상수자리
// //	final int PRICE = 1300;
	
// 	//멤버변수 자리
// 	/**
// 	 * 상품수량
// 	 */
// //	int productQuantity;
// 	Product product;
	
// 	/**
// 	 * 돈
// 	 */
// 	int money;
	
// 	//생성자 자리
// 	/**
// 	 * VendingMachine의 인스턴스를 생성할 때 호출된다.
// 	 */
// 	public  VendingMachine() {
		
// 		System.out.println("자판기 인스턴스를 만들었습니다!");
// 		//생성자가 만들어준 인스턴스의 멤버변수에 값을 할당한다(초기화)
// //		this.productQuantity = 10;
// 		this.product = new Product();
// 		this.product.name = "제로콜라";
// 		this.product.price = 1600;
// 		this.product.quantity = 50;
		
// 		this.money = 100_000;
// 		/*
// 		 * 생성자 직접 생성 이유
// 		 * 1. 멤버변수 초기화
// 		 *  - reference type 위주로 초기화
// 		 *  	배열, 컬렉션
// 		 * 2. 인스턴스 생성과 동시에 다른 메소드 호출하기 위해
// 		 * 	ex)인스턴스 생성함과 동시에 insertMoney 메소드 호출하기 위해
// 		 */
// 	}
	
// 	/**
// 	 * 돈을 넣는다
// 	 * @param customer 돈을 넣은 고객
// 	 */
// 	public void insertMoney(Customer customer) {
		
// //		this.money += this.PRICE;
// //		customer.pay(PRICE);
// 		this.money += this.product.price;
// 		customer.pay(product.price);
		
// 	}
// 	/**
// 	 * 버튼을 누른다
// 	 * @param customer 버튼을 누른 고객
// 	 */
// 	public void pressButton(Customer customer) {
// //		if (this.productQuantity <= 0) {
// 		if (this.product.quantity <= 0) {
// 			return; //메소드 즉시 종료
// 		}
// //		this.productQuantity--;
// 		this.product.quantity--;
// 		customer.addStock(this.product.name, this.product.price);
// 	}
}
