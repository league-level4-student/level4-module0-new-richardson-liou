package _01_Encapsulate_the_Data;

public class EncapsulateTheData {

	// 1. Encapsulate all the members.

	// 2. Implement the setter restrictions described above each member variable.

	// 3. Pass all the JUnit tests.

	/* 
	 * All negative arguments should set itemsReceived to 0.
	 */

	private int itemsReceived;

	/*
	 * degreesTurned must be locked between 0.0 and 360.0 inclusive.
	 * 
	 * All parameters outside this range should set degreesTurned to the nearest
	 * bound.
	 */

	private double degreesTurned;

	/*
	 * nomenclature must not contain an empty String.
	 * 
	 * An empty String parameter should set nomenclature to a String with a single
	 * space.
	 */

	private String nomenclature;

	/*
	 * memberObj must not be a String.
	 * 
	 * A String parameter should set memberObj to a new Object();
	 * 
	 * Hint: Use the instanceof operator.
	 * 
	 * Example:
	 * 
	 * Robot rob = new Robot();
	 * 
	 * System.out.println(rob instanceof Robot); // prints true
	 * 
	 * System.out.println(rob instanceof Random); //prints false
	 */

	private Object memberObj;

	public void setItemsReceived(int randomPositiveNum) {
		if (randomPositiveNum <0) {
			itemsReceived = 0;
		}
		else {
		itemsReceived = randomPositiveNum;
		}
	}

	public Integer getItemsReceived() {
		// TODO Auto-generated method stub
		return itemsReceived;
	}

	public void setDegreesTurned(double randomPositiveNum) {
		if(randomPositiveNum >360) {
			degreesTurned = 360.0;
		}
		if(randomPositiveNum<0) {
			degreesTurned = 0;
		}
		else {
		degreesTurned = randomPositiveNum;
		}
	}

	public Double getDegreesTurned() {

		return degreesTurned;
	}

	public void setNomenclature(String randomString) {
		if(randomString.equals("")) {
			nomenclature = " ";
		}
		else {
		nomenclature = randomString;
		}
	}

	public Object getNomenclature() {
		
		return nomenclature;
	}

	public void setMemberObj(Object randomObject) {
		 if (randomObject instanceof String) {
		        memberObj = new Object();
		    } else {
		        memberObj = randomObject;
		    }
	}

	public Object getMemberObj() {
		return memberObj;
	}
	
	
	

	
}
