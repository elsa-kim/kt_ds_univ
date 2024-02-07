package contact_manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
	private List<Contact> contactList;
	private String[] list;
	
	public ContactManager(){
		this.contactList = new ArrayList<>();
		this.list = new String[8];
		list[0] = "이름";
		list[1] = "전화번호";
		list[2] = "생일";
		list[3] = "관계";
		list[4] = "차단여부";
		list[5] = "메모";
		list[6] = "즐겨찾기";
		list[7] = "연락처삭제";
	}
	
	/**
	 * 전체 연락처 조회
	 */
	public void getList() {
		for (int i = 0; i < contactList.size(); i++) {
			System.out.println(i + "번째 연락처 : "+ contactList.get(i).getName() + " " + contactList.get(i).getPhoneNumber());
		}
	}
	
	/**
	 * 조회를 원하는 연락처의 인덱스 입력 시 해당 연락처 정보 출력
	 * @param index 조회를 원하는 연락저의 인덱스 번호
	 * @return 입력한 인덱스에 해당하는 연락처 정보
	 */
	public Contact getInfo(int index) {
		if (index >= contactList.size()) {
			System.out.println("해당 인덱스의 연락처를 찾을 수 없습니다.");
			return null;
		}
		Contact person = contactList.get(index);
		System.out.println("인덱스 : "+index );
		System.out.println(list[0]+" : "+person.getName());
		System.out.println(list[1]+" : "+person.getPhoneNumber());
		System.out.println(list[2]+" : "+person.getBirth());
		System.out.println(list[3]+" : "+person.getRelationship());
		System.out.println(list[4]+" : "+person.getIsBlock());
		System.out.println(list[5]+" : "+person.getMemo());
		System.out.println(list[6]+" : "+person.getIsImportant());
		return person;
	}
	
	public void edit(int index) {
		if (index>=contactList.size()) {
			System.out.println("해당 인덱스의 연락처를 찾을 수 없습니다.");
			return;
		}
		Contact person = contactList.get(index);
		System.out.print("인덱스 : "+index );
		System.out.print("이름 : "+person.getName());
		System.out.print("전화번호 : "+person.getPhoneNumber());
		System.out.print("생일 : "+person.getBirth());
		System.out.print("관계 : "+person.getRelationship());
		System.out.print("차단여부 : "+person.getIsBlock());
		System.out.print("메모 : "+person.getMemo());
		System.out.println("즐겨찾기 : "+person.getIsImportant());
		
		Scanner scanner = new Scanner(System.in);
		String val;
		String editValue;
		boolean editing = true;
		String answer;
		
		while(editing) {
		System.out.println("수정할 항목을 입력해주세요.");
		System.out.println("[이름, 전화번호, 생일, 관계, 차단여부, 메모, 즐겨찾기, 연락처삭제, 수정종료]");
		val = scanner.nextLine();
			if (val.equals(list[1])) {
				
			}
			for (int i = 0; i<list.length; i++) {
				if (val.equals(list[i])) {
					System.out.println("수정할 내용을 입력해주세요.");
					editValue = scanner.nextLine();
					if (list[i].equals("이름")) {
						System.out.println(list[i]+"항목의 내용을 "+contactList.get(index).getName()+"에서 "+editValue+"로 변경하는게 맞습니까?[Y/N]");
					}else if(list[i].equals("생일")) {
						System.out.println(list[i]+"항목의 내용을 "+contactList.get(index).getBirth()+"에서 "+editValue+"로 변경하는게 맞습니까?[Y/N]");
						
					}else if(list[i].equals("관계")) {
						System.out.println(list[i]+"항목의 내용을 "+contactList.get(index).getRelationship()+"에서 "+editValue+"로 변경하는게 맞습니까?[Y/N]");
						
					}else if(list[i].equals("차단여부")) {
						System.out.println(list[i]+"항목의 내용을 "+contactList.get(index).getIsBlock()+"에서 "+editValue+"로 변경하는게 맞습니까?[Y/N]");
						
					}else if(list[i].equals("메모")) {
						System.out.println(list[i]+"항목의 내용을 "+contactList.get(index).getMemo()+"에서 "+editValue+"로 변경하는게 맞습니까?[Y/N]");
						
					}else if(list[i].equals("즐겨찾기")) {
						System.out.println(list[i]+"항목의 내용을 "+contactList.get(index).getIsImportant()+"에서 "+editValue+"로 변경하는게 맞습니까?[Y/N]");
						
					} 
					answer = scanner.nextLine();
					if (answer.equals("Y")){
						if (list[i].equals("이름")) {
							contactList.get(index).setName(val);
						}else if(list[i].equals("생일")) {
							val = val.replaceAll("[^0-9]", "");
							LocalDate editDate = LocalDate.of(Integer.getInteger(val.substring(0,4)), Integer.getInteger(val.substring(4,6)), Integer.getInteger(val.substring(6))); 
							contactList.get(index).setBirth(editDate);
							
						}else if(list[i].equals("관계")) {
							contactList.get(index).setRelationship(val);
							
						}else if(list[i].equals("차단여부")) {
							contactList.get(index).setName(val);
							
						}else if(list[i].equals("메모")) {
							contactList.get(index).setName(val);
							
						}else if(list[i].equals("즐겨찾기")) {
							contactList.get(index).setName(val);
							
						} 
						
						System.out.println("변경되었습니다.");
					}else {
						System.out.println("변경이 취소 되었습니다.");
					}
					System.out.println("추가로 수정하시겠습니까?[Y/N]");
					answer = scanner.nextLine();
					while(!answer.equals("N")||!answer.equals("Y")) {
						System.out.println("올바른 값을 입력해주세요.");
						System.out.println("추가로 수정하시겠습니까?[Y/N]");
					}
					if (answer.equals("N")){
						System.out.println("편집이 종료되었습니다.");
						editing = false;
					}
					
				}
				
			}
		}
	}
	
	public void selectDelete(int ... index) {
		
	}
	
	public List<Contact> getBirthday() {
		return null;
	}
	
	public void block(int index) {
		
	}
	
	public void addContact() {
		
	}
	
	public List<Contact> searchByName(String name){
		List<Contact> searchedList = new ArrayList<>();
		List<Integer> searchedListIndex = new ArrayList<>();
		for (int i=0; i<contactList.size();i++) {
			if(contactList.get(i).getName().contains(name)) {
				searchedList.add(contactList.get(i));
				searchedListIndex.add(i);
			}
		}
		System.out.println(name+"으로 검색한 결과");
		System.out.println("==================");
		if (searchedList.size()!=0) {
			for (int i=0; i<searchedList.size();i++) {
				System.out.print("인덱스 : "+searchedListIndex.get(i));
				System.out.println("이름 : "+searchedList.get(i).getName()+" 전화번호 : "+searchedList.get(i).getPhoneNumber());
			}
		}else {
			System.out.println("검색된 결과가 없습니다.");
		}
		return searchedList;
	}

	public List<Contact> searchByNumber(String number){
		List<Contact> searchedList = new ArrayList<>();
		List<Integer> searchedListIndex = new ArrayList<>();
		for (int i=0; i<contactList.size();i++) {
			for (String phoneNum:contactList.get(i).getPhoneNumber()) {
				if (phoneNum.contains(number)) {
					searchedListIndex.add(i);
				}
			}
		}
		for (int i=0; i<contactList.size();i++) {
			for (Integer j:searchedListIndex) {
				if (j==i) {
					searchedList.add(contactList.get(i));
				}
			}
		}
		System.out.println(number+"로 검색한 결과");
		System.out.println("==================");
		if (searchedList.size()!=0) {
			for (int i=0; i<searchedList.size();i++) {
				System.out.print("인덱스 : "+searchedListIndex.get(i));
				System.out.println("이름 : "+searchedList.get(i).getName()+" 전화번호 : "+searchedList.get(i).getPhoneNumber());
			}
		}else {
			System.out.println("검색된 결과가 없습니다.");
		}
		return searchedList;
	}
	
	/**
	 * 즐겨찾기 된 연락처들 이름과 전화번호 출력, 해당 연락처 정보 리스트 리턴
	 * @return 즐겨찾기 된 연락처 리스트
	 */
	public List<Contact> getImportant(){
		List<Contact> importantPeople = new ArrayList<>();
		for (Contact contact:contactList) {
			if(contact.getIsImportant()) {
				importantPeople.add(contact);
			}
		}
		System.out.println("즐겨찾기 된 연락처");
		System.out.println("===============");
		if(importantPeople.size()!=0) {
			for (Contact contact : importantPeople) {
				System.out.println("이름 : " + contact.getName());
				System.out.println("전화번호 : " + contact.getPhoneNumber());
			}
		}else {
			System.out.println("즐겨찾기 된 연락처가 없습니다.");
		}
		return importantPeople;
	}

}
