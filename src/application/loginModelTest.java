package application;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class loginModelTest {
	
	public loginModel myLoginModel;
	
	@Before
	public void createLoginModelObject(){
		myLoginModel = new loginModel();
	}

	@Test
	public void testIsCorrectReturnTrue() throws SQLException {
		boolean result = myLoginModel.isCorrect("root", "123");
		assertTrue(result);
	}

	@Test
	public void testIsCorrectReturnFalse() throws SQLException {
		boolean result = myLoginModel.isCorrect("abc", "123");
		assertFalse(result);
	}
	
	@Test
	public void testIsCorrectReturnFalseForNullObject() throws SQLException { 
		myLoginModel.conn = null;
		boolean result = myLoginModel.isCorrect("root", "123");
		assertFalse(result);
	}
	
	@Test
	public void testValidateInputReturnUserEmpty(){
		String result = myLoginModel.validateInput("", "11!!qqQQ", "11!!qqQQ");
		assertEquals(result, "Username is Empty");
	}
	
	@Test
	public void testValidateInputReturnPasswordEmpty(){
		String result = myLoginModel.validateInput("abcd", "", "11@@qqQQ");
		assertEquals(result, "Passward is Empty");
	}
	
	@Test
	public void testValidateInputReturnConfirmPasswordEmpty(){
		String result = myLoginModel.validateInput("abcd", "11@@qqQQ", "");
		assertEquals(result, "Confirm Password is Empty");
	}
	
	@Test
	public void testValidateInputReturnConfirmPasswordDidntMatched(){
		String result = myLoginModel.validateInput("abcd", "11@@qqQQ", "abc");
		assertEquals(result, "Confirm Password did not matched");
	}
	
	@Test
	public void testValidateInputPasswordLessThen8Character(){
		String result = myLoginModel.validateInput("abcd", "11@@qqQ", "11@@qqQQ");
		assertEquals(result, "Password must be alpha-numeric, contains sepcial character and atleast 8 character");
	}
	
	@Test
	public void testValidateInputPasswordNonNumericValue(){
		String result = myLoginModel.validateInput("abcd", "aa@@qqQ", "aa@@qqQQ");
		assertEquals(result, "Password must be alpha-numeric, contains sepcial character and atleast 8 character");
	}
	
	@Test
	public void testValidateInputPasswordNonAlphabetic(){
		String result = myLoginModel.validateInput("abcd", "11@@1111", "11@@1111");
		assertEquals(result, "Password must be alpha-numeric, contains sepcial character and atleast 8 character");
	}
	
	@Test
	public void testValidateInputPasswordNoSpecialCharacter(){
		String result = myLoginModel.validateInput("abcd", "11aA1111", "11aA1111");
		assertEquals(result, "Password must be alpha-numeric, contains sepcial character and atleast 8 character");
	}
	

}
