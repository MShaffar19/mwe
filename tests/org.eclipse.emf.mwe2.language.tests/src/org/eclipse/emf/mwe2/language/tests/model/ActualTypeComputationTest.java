package org.eclipse.emf.mwe2.language.tests.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.mwe2.language.mwe2.Assignment;
import org.eclipse.emf.mwe2.language.mwe2.DeclaredProperty;
import org.eclipse.emf.mwe2.language.mwe2.Module;
import org.eclipse.emf.mwe2.language.tests.TestSetup;
import org.eclipse.emf.mwe2.language.tests.factory.ComponentA;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.junit.AbstractXtextTests;

public class ActualTypeComputationTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new TestSetup());
	}
	
	public void testInferredLiteralTypes() throws Exception {
		checkPropertyType("a = 'myString'", String.class);
		checkPropertyType("a = true", boolean.class);
		checkPropertyType("a = java.util.ArrayList {}", ArrayList.class);
	}
	
	public void testInferredComponentType() throws Exception {
		String typeName = ComponentA.class.getName();
		Module module = (Module) getModel("module myModule " + typeName + " {"
				+ "  x = {}"
				+ "}");
		Assignment assignment = module.getRoot().getAssignment().get(0);
		JvmType assignedType = assignment.getValue().getActualType();
		assertNotNull(assignedType);
		assertFalse("eIsProxy", assignedType.eIsProxy());
		assertEquals(typeName, assignedType.getCanonicalName());
	}
	
	public void testNullType() throws Exception {
		Module module = (Module) getModel("module myModule var a String {}");
		List<DeclaredProperty> properties = module.getDeclaredProperties();
		assertEquals(1, properties.size());
		DeclaredProperty property = properties.get(0);
		assertNull(property.getActualType());
	}
	
	public void testLiteralTypes() throws Exception {
		checkPropertyType("java.lang.CharSequence a = 'myString'", CharSequence.class);
		checkPropertyType("boolean a", boolean.class);
		checkPropertyType("java.util.List a = java.util.ArrayList {}", List.class);
	}
	
	public void testReferenceTypes() throws Exception {
		checkPropertyType("CharSequence a = 'myString' var b = a", CharSequence.class);
		checkPropertyType("boolean a var b = a", boolean.class);
		checkPropertyType("java.util.List a = java.util.ArrayList {} var b = a", List.class);
	}
	
	public void testModuleType() throws Exception {
		Module stringModule = (Module) getModel("module stringModule String {}");
		JvmType stringType = stringModule.getRoot().getActualType();
		assertNotNull(stringType);
		assertFalse("eIsProxy", stringType.eIsProxy());
		assertEquals(String.class.getName(), stringType.getCanonicalName());
		Module referingModule = (Module) getModel("module referingModule java.util.ArrayList {}");
		referingModule.getRoot().setModule(stringModule);
		referingModule.getRoot().setType(null);
		JvmType referingRootType = referingModule.getRoot().getActualType();
		assertSame(stringType, referingRootType);
	}
	
	protected void checkPropertyType(String input, Class<?> expected) throws Exception {
		Module module = (Module) getModelAndExpect("module myModule var " + input, 1);
		List<DeclaredProperty> properties = module.getDeclaredProperties();
		DeclaredProperty property = properties.get(properties.size() - 1);
		JvmType type = property.getActualType();
		assertNotNull(type);
		assertFalse("eIsProxy", type.eIsProxy());
		assertEquals(expected.getName(), type.getCanonicalName());
	}
	
}