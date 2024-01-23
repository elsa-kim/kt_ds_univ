package vending_machine;


/**
 * 자판기
 */
public class VendingMachine {

	// 상수자리
//	final int PRICE = 1300;
	
	//멤버변수 자리
	/**
	 * 상품수량
	 */
//	int productQuantity;
	Product product;
	
	/**
	 * 돈
	 */
	int money;
	
	//생성자 자리
	/**
	 * VendingMachine의 인스턴스를 생성할 때 호출된다.
	 */
	public  VendingMachine() {
		
		System.out.println("자판기 인스턴스를 만들었습니다!");
		//생성자가 만들어준 인스턴스의 멤버변수에 값을 할당한다(초기화)
//		this.productQuantity = 10;
		this.product = new Product();
		this.product.name = "제로콜라";
		this.product.price = 1600;
		this.product.quantity = 50;
		
		this.money = 100_000;
		/*
		 * 생성자 직접 생성 이유
		 * 1. 멤버변수 초기화
		 *  - reference type 위주로 초기화
		 *  	배열, 컬렉션
		 * 2. 인스턴스 생성과 동시에 다른 메소드 호출하기 위해
		 * 	ex)인스턴스 생성함과 동시에 insertMoney 메소드 호출하기 위해
		 */
	}
	
	/**
	 * 돈을 넣는다
	 * @param customer 돈을 넣은 고객
	 */
	public void insertMoney(Customer customer) {
		
//		this.money += this.PRICE;
//		customer.pay(PRICE);
		this.money += this.product.price;
		customer.pay(product.price);
		
	}
	/**
	 * 버튼을 누른다
	 * @param customer 버튼을 누른 고객
	 */
	public void pressButton(Customer customer) {
//		if (this.productQuantity <= 0) {
		if (this.product.quantity <= 0) {
			return; //메소드 즉시 종료
		}
//		this.productQuantity--;
		this.product.quantity--;
		customer.addStock(this.product.name, this.product.price);
	}
}
