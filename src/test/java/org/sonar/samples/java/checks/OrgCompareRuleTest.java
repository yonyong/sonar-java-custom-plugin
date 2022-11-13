package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * @author yonyong
 * @version 1.0
 * @date 2022/11/9 16:24
 */
public class OrgCompareRuleTest {
    @Test
    void test() {
        JavaCheckVerifier.verify("src/test/files/OrgCompareRule.java", new OrgCompareRule());
    }
}
