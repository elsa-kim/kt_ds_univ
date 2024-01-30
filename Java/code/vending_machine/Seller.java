package vending_machine;

/**
 * 자판기의 추상클래스
 * abstract method가 있을경우
 * 클래스 타입도 abstact class 되어야 함
 * abstract class는 인스턴스로 만들수가 없다. (new Seller() ==> X)
 */
public abstract class Seller {
	
	//클래스 상수
	/**
	 * 한 번에 구매할 수 있는 제품의 수
	 */
	public static final int PRODUCT_COUNT;
	public static final String MACHINE_NAME;
	
	//클래스 상수에 값 할당하는 방법
	//static block
	static {
		//static 변수 / 상수의 값 초기화하는 공간
		PRODUCT_COUNT = 1;
		MACHINE_NAME = "drink machine";
	}

	
	//멤버변수 자리
	/**
	 * 상품수량
	 */
	private Product[] productArray;
	
	/**
	 * 돈
	 */
	private int money;
	
	
	
	
	//생성자 자리
	/**
	 * VendingMachine의 인스턴스를 생성할 때 호출된다.
	 */
	public  Seller() {
		this(100_000);
	}
	
	public Seller(int money) {
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

	// getter
	public Product[] getProductArray() {
		return this.productArray;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	//setter
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * 돈을 넣는다
	 * @param customer 돈을 넣은 고객
	 * @param productName 구매할 제품명(제로펩시, 제로콜라, 제로스프라이트)
	 */
	public void insertMoney(Customer customer,String productName) {
		
		//this.productArray 반복하며 Product 인스턴스 제품명 확인
		// Product 인스턴스 제품명과 ProductName 같으면 해당제품 가격으로 자판기 돈 증가, 고객 돈감소
		
		for (Product product : this.productArray) {
			if(product.equals(productName)) {
				this.money += product.getPrice();
				customer.pay(product.getPrice());
				break; // 반복중단
			}
		}
	}
	
	/**
	 * 버튼을 누른다
	 * @param customer 버튼을 누른 고객
	 * @param productName 구매할 제품명(제로펩시, 제로콜라, 제로스프라이트)
	 */
	public void pressButton(Customer customer, String productName) {
		this.pressButton(customer, productName, VendingMachine.PRODUCT_COUNT);
	}
	
	public void pressButton(Customer customer, String productName, int orderCount) {
		
		// this. productArray 반복하면서 productName과 같은지 비교
		// 같으면 해당 제품의 수량을 체크하고(0보다 작은지)
		// 작다면 메소드 종료
		// 그렇지 않다면 해당 제품 수량 하나 감소시키고 고객에게 해당 제품 전달
		
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
	
	/**
	 * 고객에게 환불처리한다
	 * 상속된 클래스에서만 사용할 수 있도록 한다
	 * @param customer 환불받을 고객
	 * @param refuneMoney 환불받을 금액
	 */
	protected abstract void refund(Customer customer, int refundMoney);
	
	public void printProducts() {
		System.out.println("자판기의 잔액 : "+ this.money);
		for (Product product : this.productArray) {
			if (product != null) {
				System.out.println("자판기의 상품 이름 : "+ product.getName());
				System.out.println("자판기의 상품 수량 : "+ product.getQuantity());
				
			}
		}
	}
		

}
