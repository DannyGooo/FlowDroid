package soot.jimple.infoflow.test.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import soot.jimple.infoflow.IInfoflow;

/**
 * JUnit test cases for FlowDroid's multi-threading support
 * 
 * @author Steven Arzt
 *
 */
public abstract class ThreadTests extends JUnitTests {

	private static final String SOURCE_STRING_PWD = "<soot.jimple.infoflow.test.android.AccountManager: java.lang.String getPassword()>";

	@Test(timeout = 300000)
	public void multiTest1() {
		IInfoflow infoflow = initInfoflow();
		infoflow.getConfig().getAccessPathConfiguration().setUseThisChainReduction(false);
		infoflow.getConfig().getAccessPathConfiguration().setUseRecursiveAccessPaths(false);

		List<String> epoints = new ArrayList<String>();
		epoints.add("<soot.jimple.infoflow.test.ThreadTestCode: void testThreadWithField0a()>");
		epoints.add("<soot.jimple.infoflow.test.ThreadTestCode: void testThreadWithField0b()>");
		infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
		checkInfoflow(infoflow, 1);
		Assert.assertTrue(infoflow.getResults().isPathBetweenMethods(sink, SOURCE_STRING_PWD));
		Assert.assertEquals(2, infoflow.getResults().numConnections());
	}

	@Test(timeout = 300000)
	public void threadTest0a() {
		IInfoflow infoflow = initInfoflow();
		infoflow.getConfig().getAccessPathConfiguration().setUseThisChainReduction(false);
		infoflow.getConfig().getAccessPathConfiguration().setUseRecursiveAccessPaths(false);

		List<String> epoints = new ArrayList<String>();
		epoints.add("<soot.jimple.infoflow.test.ThreadTestCode: void testThreadWithField0a()>");
		infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
		checkInfoflow(infoflow, 1);
		Assert.assertTrue(infoflow.getResults().isPathBetweenMethods(sink, SOURCE_STRING_PWD));
	}

	@Test(timeout = 300000)
	public void threadTestAnonymous() {
		IInfoflow infoflow = initInfoflow();
		infoflow.getConfig().getAccessPathConfiguration().setUseThisChainReduction(false);
		infoflow.getConfig().getAccessPathConfiguration().setUseRecursiveAccessPaths(false);

		List<String> epoints = new ArrayList<String>();
		epoints.add("<soot.jimple.infoflow.test.ThreadTestCode: void testAnonymousInnerClass()>");
		infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
		checkInfoflow(infoflow, 1);
		Assert.assertTrue(infoflow.getResults().isPathBetweenMethods(sink, SOURCE_STRING_PWD));
	}

	@Test(timeout = 300000)
	public void testParamMapping() {
		IInfoflow infoflow = initInfoflow();
		infoflow.getConfig().getAccessPathConfiguration().setUseThisChainReduction(false);
		infoflow.getConfig().getAccessPathConfiguration().setUseRecursiveAccessPaths(false);

		List<String> epoints = new ArrayList<String>();
		epoints.add("<soot.jimple.infoflow.test.ThreadTestCode: void testParamMapping()>");
		infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
		checkInfoflow(infoflow, 1);
		Assert.assertTrue(infoflow.getResults().isPathBetweenMethods(sink, SOURCE_STRING_PWD));
	}

	@Test(timeout = 300000)
	public void testParamMappingAlias() {
		IInfoflow infoflow = initInfoflow();
		infoflow.getConfig().getAccessPathConfiguration().setUseThisChainReduction(false);
		infoflow.getConfig().getAccessPathConfiguration().setUseRecursiveAccessPaths(false);

		List<String> epoints = new ArrayList<String>();
		epoints.add("<soot.jimple.infoflow.test.ThreadTestCode: void testParamMappingAlias()>");
		infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
		checkInfoflow(infoflow, 1);
		Assert.assertTrue(infoflow.getResults().isPathBetweenMethods(sink, SOURCE_STRING_PWD));
	}

}
