package contact_manager;

import java.time.LocalDate;
import java.util.List;

public class Contact {

	private String name;
	private List<String> phoneNumber;
	private LocalDate birth;
	private String relationship;
	private boolean isBlock;
	private String memo;
	private boolean isImportant;
	
	public String getName() {
		return this.name;
	}
	
	public List<String> getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public LocalDate getBirth() {
		return this.birth;
	}
	
	public String getRelationship() {
		return this.relationship;
	}
	
	public boolean getIsBlock() {
		return this.isBlock;
	}
	
	public String getMemo() {
		return this.memo;
	}
	
	
	
	public boolean getIsImportant() {
		return this.isImportant;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public void setIsBlock(boolean isBlock) {
		this.isBlock = isBlock;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	public void setIsImportant(boolean isImportant) {
		this.isImportant = isImportant;
	}
	
}
