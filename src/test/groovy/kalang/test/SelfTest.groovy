package kalang.test;

import static org.junit.Assert.*;

import org.junit.Test;
import kalang.tool.Compiler as TC
class SelfTest {

	@Test
	public void test() {
		TC.main(["src/main/groovy"] as String[])
	}

}
