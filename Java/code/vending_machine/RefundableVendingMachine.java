package vending_machine;

/** 
 * 환불기능이 있는 자판기
 */
public class RefundableVendingMachine extends VendingMachine implements Sellable {

	
	public RefundableVendingMachine() {
		super();
	}
	
	public RefundableVendingMachine(int money) {
		super(money);
	}

	@Override
	protected void refund(Customer customer, int refundMoney) {
		System.out.println("재고가 없네요.");	
		System.out.println(refundMoney + "원 환불 해드릴게요.");	
		//1. 자판기의 금액을 환불해줄 금액만큼 감소
//		super.money -= refundMoney;
		int money = super.getMoney();
		money -= refundMoney;
		super.setMoney(money);
		
		//2. 고객에게 환불 해줌
		customer.addMoney(refundMoney);
	}

	
	
//	public class RefundableVendingMachine extends Seller {
	
//	public RefundableVendingMachine() {
//		super(); // 슈퍼 클래스의 파라미터 없는 기본 형태 생성자 호출
//	}
//	
//	public RefundableVendingMachine(int money) {
//		super(money); // 슈퍼 클래스의 int 파라미터 있는 생성자 호출
//	}
//
//	@Override
//	protected void refund(Customer customer, int refundMoney) {
//		System.out.println("재고가 없네요.");	
//		System.out.println(refundMoney + "원 환불 해드릴게요.");	
//		//1. 자판기의 금액을 환불해줄 금액만큼 감소
////		super.money -= refundMoney;
//		int money = super.getMoney();
//		money -= refundMoney;
//		super.setMoney(money);
//		
//		//2. 고객에게 환불 해줌
//		customer.addMoney(refundMoney);
//		
//	}
	
}
