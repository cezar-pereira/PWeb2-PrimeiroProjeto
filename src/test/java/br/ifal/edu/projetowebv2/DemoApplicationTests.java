package br.ifal.edu.projetowebv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.ifal.edu.projetowebv2.controllers.ControllerRegister;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	ControllerRegister controllerRegister = new ControllerRegister();


	@Test
	public void testFunctionName() {
		String name = "ce";
		boolean valueExpected = true;
		boolean valueReceived = controllerRegister.validateName(name);
		assertEquals(valueExpected, valueReceived);
	}

	@Test
	public void testFunctionEmail() {
		String email = "teste@teste.com";
		boolean valueExpected = true;
		boolean valueReceived = controllerRegister.validateEmail(email);
		assertEquals(valueExpected, valueReceived);
	}

	@Test
	public void testFunctionCpf() {
		String cpf = "11111111111";
		boolean valueExpected = true;
		boolean valueReceived = controllerRegister.validadeCpf(cpf);
		assertEquals(valueExpected, valueReceived);
	}

	@Test
	public void testFunctionSex() {
		String sex = "feminino";
		boolean valueExpected = true;
		boolean valueReceived = controllerRegister.validadeSex(sex);
		assertEquals(valueExpected, valueReceived);
	}

	@Test
	public void testFunctionAreas() {
		String areas = "Manutenção de computadores";
		boolean valueExpected = true;
		boolean valueReceived = controllerRegister.validadeAreaActing(areas);
		assertEquals(valueExpected, valueReceived);
	}

	@Test
	public void testFunctionPassword() {
		String password = "123456";
		boolean valueExpected = true;
		boolean valueReceived = controllerRegister.validadePassword(password);
		assertEquals(valueExpected, valueReceived);
	}
}
