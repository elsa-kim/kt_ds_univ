package vending_machine;


/**
 * 자판기와 고객이 만나는 마트
 */
public class Mart {
	
	
	public static void main(String[] args) {
		
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
		
		
		DrinkMachine A = new DrinkMachine();
		Product orderProduct = A.order("박카스", 18);
		System.out.println(">> 주문결과: "+ orderProduct.name + ", " + "개당 "+orderProduct.price + "원, 주문수량 " + orderProduct.quantity);
		Product orderProduct2 = A.order("몬스터", 2);
		System.out.println(">> 주문결과: "+ orderProduct2.name + ", " + "개당 "+orderProduct2.price + "원, 주문수량 " + orderProduct2.quantity);
		A.order("박카", 5);
		A.printStock();
	}

}
