package vending_machine;

public class DrinkMart {
	
	public static void main(String[] args) {
		
				
			DrinkMachine A = new DrinkMachine();
			DrinkProduct orderProduct = A.order("박카스", 18);
			System.out.println(">> 주문결과: "+ orderProduct.name + ", " + "개당 "+orderProduct.price + "원, 주문수량 " + orderProduct.quantity);
			DrinkProduct orderProduct2 = A.order("몬스터", 2);
			System.out.println(">> 주문결과: "+ orderProduct2.name + ", " + "개당 "+orderProduct2.price + "원, 주문수량 " + orderProduct2.quantity);
			A.order("박카", 5);
			A.printStock();
			
	}

}
