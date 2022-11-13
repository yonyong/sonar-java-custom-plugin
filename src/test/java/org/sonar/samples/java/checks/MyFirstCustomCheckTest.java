package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

class MyFirstCustomCheckTest {

  @Test
  void test() {
//    CheckVerifier.newVerifier()
//            .withJavaVersion(8)
//            .onFile("src/test/files/MyFirstCustomCheck.java")
//            .withCheck(new MyFirstCustomCheck())
//            .verifyIssues();
    JavaCheckVerifier.verify("src/test/files/MyFirstCustomCheck.java", new MyFirstCustomCheck());
  }
}