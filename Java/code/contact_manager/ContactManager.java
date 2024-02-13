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
		this.list = new String[7];
		list[0] = "이름";
		list[1] = "전화번호";
		list[2] = "생일";
		list[3] = "관계";
		list[4] = "차단여부";
		list[5] = "메모";
		list[6] = "즐겨찾기";
	}
	
	Scanner scanner = new Scanner(System.in);
	
	
	private void printPerson(Contact person, int index) {
		System.out.println("인덱스 : "+ index );
		System.out.println(list[0]+" : "+person.getName());
		System.out.println(list[1]+" : "+person.getPhoneNumber());
		System.out.println(list[2]+" : "+person.getBirth());
		System.out.println(list[3]+" : "+person.getRelationship());
		System.out.println(list[4]+" : "+person.getIsBlock());
		System.out.println(list[5]+" : "+person.getMemo());
		System.out.println(list[6]+" : "+person.getIsImportant());
	}
	
	private boolean indexCheck(int index) {
		if (index >= contactList.size()) {
			System.out.println("해당 인덱스의 연락처를 찾을 수 없습니다.");
			return false;
		}
		return true;
	}
	
	/**
	 * 전체 연락처 조회
	 */
	public void getList() {
		if (contactList.size()==0) {
			System.out.println("연락처가 존재하지 않습니다.");
			return;
		}
		for (int i = 0; i < contactList.size(); i++) {
			System.out.println(i + "번째 연락처 : "+ contactList.get(i).getName() + " " + contactList.get(i).getPhoneNumber());
		}
	}
	
	/**
	 * 조회를 원하는 연락처의 인덱스 입력 시 해당 연락처 정보 출력
	 * @param index 조회를 원하는 연락처의 인덱스 번호
	 * @return 입력한 인덱스에 해당하는 연락처 정보
	 */
	public Contact getInfo(int index) {
		if (!indexCheck(index)) return null;
		Contact person = contactList.get(index);
		printPerson(person, index);
		return person;
	}
	
	/**
	 * 수정을 원하는 인덱스 번호 입력 시 해당 연락처 수정 기능 
	 * @param index 수정을 원하는 연락처의 인덱스 번호 
	 */
	public void edit(int index) {
		if (!indexCheck(index)) return;
		Contact person = contactList.get(index);
		printPerson(person, index);
		
		String val;
		String editValue;
		boolean editing = true;
		String answer;
		
		while(editing) {
		System.out.println("수정할 항목을 입력해주세요.");
		System.out.println("[이름, 전화번호, 생일, 관계, 차단여부, 메모, 즐겨찾기, 수정종료]");
		val = scanner.nextLine();
			if (val.equals(list[1])) {
				System.out.println("수정할 옵션을 입력해주세요.");
				for (int i=0;i<person.getPhoneNumber().size();i++) {
					System.out.println(i+"번 : "+person.getPhoneNumber().get(i)+" ");
				}
				System.out.println(person.getPhoneNumber().size()+"번 : 새로 추가 ");
				int editNumOption = scanner.nextInt();
				scanner.nextLine();
				System.out.println("새로운 번호를 입력해주세요.");
				editValue = scanner.nextLine();
				
				if (editNumOption == person.getPhoneNumber().size()) {
					System.out.println(editValue +"를 추가하시겠습니까?[Y/N]");
					answer = scanner.nextLine();
					if (answer.equals("Y")) {
						List<String> newList = new ArrayList<>();
						newList = person.getPhoneNumber();
						newList.add(editValue);
						person.setPhoneNumber(newList);
						
					}else if (answer.equals("N")) {
						System.out.println("취소되었습니다.");
						return;
					}else {
						System.out.println("잘못된 값이 입력 되었습니다.");
						return;
					}
				}else if (editNumOption < person.getPhoneNumber().size()) {
					System.out.println(editValue +"로 변경하시겠습니까?[Y/N]");
					answer = scanner.nextLine();
					if (answer.equals("Y")) {
						List<String> newList = new ArrayList<>();
						newList = person.getPhoneNumber();
						newList.set(editNumOption, editValue);
						person.setPhoneNumber(newList);
					}else if (answer.equals("N")) {
						System.out.println("취소되었습니다.");
						return;
					}else {
						System.out.println("잘못된 값이 입력 되었습니다.");
						return;
					}
					
				}else {
					System.out.println("잘못된 값을 입력했습니다.");
					return;
				}
				
				System.out.println("추가로 수정하시겠습니까?[Y/N]");
				answer = scanner.nextLine();
				if (!answer.equals("N") && !answer.equals("Y")) {
					while(!answer.equals("N") && !answer.equals("Y")) {
						System.out.println("올바른 값을 입력해주세요.");
						System.out.println("추가로 수정하시겠습니까?[Y/N]");
						answer = scanner.nextLine();
					}
				}
				if (answer.equals("N")){
					System.out.println("편집이 종료되었습니다.");
					editing = false;
				}
				
			} else if ( val.equals("수정종료")) {
				System.out.println("편집이 종료되었습니다.");
				editing=false;
			} else if(val.equals(list[0])||val.equals(list[2])||val.equals(list[3])||val.equals(list[4])||val.equals(list[5])||val.equals(list[6])){
				for (int i = 0; i<list.length; i++) {
					if (val.equals(list[i])) {
						System.out.println("수정할 내용을 입력해주세요.");
						editValue = scanner.nextLine();
						if (i==0) {
							System.out.println(list[i]+"항목의 내용을 "+contactList.get(index).getName()+"에서 "+editValue+"로 변경하는게 맞습니까?[Y/N]");
						}else if(i==2) {
							System.out.println(list[i]+"항목의 내용을 "+contactList.get(index).getBirth()+"에서 "+editValue+"로 변경하는게 맞습니까?[Y/N]");
							
						}else if(i==3) {
							System.out.println(list[i]+"항목의 내용을 "+contactList.get(index).getRelationship()+"에서 "+editValue+"로 변경하는게 맞습니까?[Y/N]");
							
						}else if(i==4) {
							System.out.println(list[i]+"항목의 내용을 "+contactList.get(index).getIsBlock()+"에서 "+editValue+"로 변경하는게 맞습니까?[Y/N]");
							
						}else if(i==5) {
							System.out.println(list[i]+"항목의 내용을 "+contactList.get(index).getMemo()+"에서 "+editValue+"로 변경하는게 맞습니까?[Y/N]");
							
						}else  {
							System.out.println(list[i]+"항목의 내용을 "+contactList.get(index).getIsImportant()+"에서 "+editValue+"로 변경하는게 맞습니까?[Y/N]");
							
						} 
						answer = scanner.nextLine();
						if (answer.equals("Y")){
							if (i==0) {
								contactList.get(index).setName(editValue);
							}else if(i==2) {
								editValue = editValue.replaceAll("[^0-9]", "");
								LocalDate editDate = LocalDate.of(Integer.parseInt(editValue.substring(0,4)), Integer.parseInt(editValue.substring(4,6)), Integer.parseInt(editValue.substring(6))); 
								contactList.get(index).setBirth(editDate);
								
							}else if(i==3) {
								contactList.get(index).setRelationship(editValue);
								
							}else if(i==4) {
								contactList.get(index).setIsBlock(Boolean.valueOf(editValue));
								
							}else if(i==5) {
								contactList.get(index).setMemo(editValue);
								
							}else  {
								contactList.get(index).setIsImportant(Boolean.valueOf(editValue));
								
							} 
							
							System.out.println("변경되었습니다.");
						}else {
							System.out.println("변경이 취소 되었습니다.");
						}
						System.out.println("추가로 수정하시겠습니까?[Y/N]");
						answer = scanner.nextLine();
						if (!answer.equals("N") && !answer.equals("Y")) {
							while(!answer.equals("N") && !answer.equals("Y")) {
								System.out.println("올바른 값을 입력해주세요.");
								System.out.println("추가로 수정하시겠습니까?[Y/N]");
								answer = scanner.nextLine();
							}
						}
						if (answer.equals("N")){
							System.out.println("편집이 종료되었습니다.");
							editing = false;
						}
						
					}
					
				}
				
			}else {
				System.out.println("잘못된 값을 입력했습니다.");
				return;
			}
			
		}
	}
	
	/**
	 * 삭제를 원하는 연락처의 인덱스를 파라미터로 전달 시 해당 연락처 삭제 
	 * @param index 삭제를 원하는 연락처의 인덱스 
	 */
	public void deleteContact(int index) {
		if (!indexCheck(index)) return;
		Contact person = contactList.get(index);
		printPerson(person, index);
		System.out.println("해당 연락처를 정말로 삭제하시겠습니까?[Y/N]");
		String res = scanner.nextLine();
		if (res.equals("Y")) {
			this.contactList.remove(index);
			System.out.println("연락처가 삭제되었습니다.");
		}else if(res.equals("N")) {
			System.out.println("연락처의 삭제가 취소 되었습니다.");
			return;
		}else {
			System.out.println("잘못 된 값이 입력되어 취소 되었습니다.");
			return;
		}
	}
	
	/**
	 * 오늘 기준 생일이 14일 남은 사람부터 당일인 사람까지의 연락처 리스트를 리턴해준다 
	 * @return 생일이 14 ~ 0일 남은 사람의 연락처 리스트 
	 */
	public List<Contact> getBirthday() {
		List<Contact> birthIsComingList = new ArrayList<>();
		LocalDate today = LocalDate.now();
		for ( Contact person:contactList) {
			LocalDate originalDay = person.getBirth();
			LocalDate thisYearDay = LocalDate.of(today.getYear(), originalDay.getMonth(), originalDay.getDayOfMonth());
			if (thisYearDay.isBefore(today.plusDays(15)) && thisYearDay.isAfter(today.minusDays(1))) {
				birthIsComingList.add(person);
			}
			
		}
		System.out.println("다가오는 생일자");
		System.out.println("==================");
		if (birthIsComingList.size() > 0) {
			for (Contact birthPerson:birthIsComingList) {
				System.out.println("이름 : "+birthPerson.getName()+" 전화번호 : "+birthPerson.getPhoneNumber()+" 생일 : "+birthPerson.getBirth());
			}
			
		}else {
			System.out.println("검색된 결과가 없습니다.");
		}
		return birthIsComingList;
	}
	
	/**
	 * 차단 여부 변경을 원하는 연락처의 인덱스를 파라미터로 전달 시 해당 연락처의 차단 여부가 변경 됨 
	 * @param index 차단 여부 변경을 원하는 연락처의 인덱스 
	 */
	public void block(int index) {
		if (!indexCheck(index)) return;
		Contact person = contactList.get(index);
		printPerson(person, index);
		System.out.println("해당 연락처의 차단 여부를 정말로 변경하시겠습니까?[Y/N]");
		String res = scanner.nextLine();
		if (res.equals("Y")) {
			boolean isBlocking = this.contactList.get(index).getIsBlock();
			this.contactList.get(index).setIsBlock(!isBlocking);
			System.out.println("연락처의 차단여부가 변경 되었습니다.");
		}else if(res.equals("N")) {
			System.out.println("연락처의 차단 여부 변경이 취소 되었습니다.");
			return;
		}else {
			System.out.println("잘못 된 값이 입력되어 취소 되었습니다.");
			return;
		}
		
	}
	
	/**
	 * 새로운 연락처를 추가하는 메소드(이름, 전화번호는 필수로 입력)
	 */
	public void addContact() {
		Contact addPerson = new Contact();
		List<String> addPersonNumList = new ArrayList<>();
		
		String inputVal = "";
		boolean addNum = true;
		System.out.println("추가를 원하는 연락처의 이름(별칭)을 입력해주세요(필수)");
		inputVal = scanner.nextLine();
		if (inputVal == null) return;
		addPerson.setName(inputVal);
		
		while(addNum) {
			System.out.println("추가를 원하는 연락처의 전화번호를 입력해주세요(010XXXXXXXX)(필수)");
			inputVal = scanner.nextLine();
			if (inputVal == null) return;
			addPersonNumList.add(inputVal);
			System.out.println("전화번호를 추가로 입력하시겠습니까?[Y/N]");
			inputVal = scanner.nextLine();
			if ( inputVal.equals("N")) {
				addNum = false;
				addPerson.setPhoneNumber(addPersonNumList);
			}else if (!inputVal.equals("Y")) {
				System.out.println("잘못된 값을 입력했습니다");
				return;
			}
		}
		System.out.println("추가를 원하는 연락처의 생일을 입력해주세요(YYYYMMDD)(선택)");
		inputVal = scanner.nextLine();
		if (inputVal !=null) {
			inputVal = inputVal.replaceAll("[^0-9]", "");
			LocalDate addPersonBirth = LocalDate.of(Integer.parseInt(inputVal.substring(0,4)), Integer.parseInt(inputVal.substring(4,6)), Integer.parseInt(inputVal.substring(6))); 
			addPerson.setBirth(addPersonBirth);
			
		}
		System.out.println("추가를 원하는 연락처와의 관계를 입력해주세요(선택)");
		inputVal = scanner.nextLine();
		addPerson.setRelationship(inputVal);
		
		System.out.println("추가를 원하는 연락처의 메모사항을 입력해주세요(선택)");
		inputVal = scanner.nextLine();
		addPerson.setMemo(inputVal);
		
		this.contactList.add(addPerson);
		System.out.println("연락처 추가가 완료되었습니다.");
		
		
	}
	
	/**
	 * 문자열 입력 시 해당 문자열을 포함하는 이름의 연락처 리턴
	 * @param name 찾으려는 문자열 
	 * @return 파라미터로 전달된 문자열을 포함하는 이름을 갖는 연락처 리스트 
	 */
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

	/**
	 * 찾으려는 번호를 입력하면 해달 번호를 포함하는 연락처 리턴 
	 * @param number 찾으려는 연락처 전화번호 일부 혹은 전체 
	 * @return 파라미터로 전달된 번호를 포함하는 전화번호 갖는 연락처 리스트 
	 */
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
