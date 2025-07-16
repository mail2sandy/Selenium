package testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class TC015_FackerData {

	@Test
	public void generateDummyData() {
		Faker dummyData = new Faker();
		
		System.out.println(dummyData.name().firstName());
		System.out.println(dummyData.name().lastName());
		System.out.println(dummyData.name().username());
		System.out.println(dummyData.address().country());
	}
	
}
