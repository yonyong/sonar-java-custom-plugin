package org.sonar.samples.java.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.*;
import org.sonar.samples.java.utils.TreeUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Rule(key = "OrgCompareRule")
public class OrgCompareRule extends IssuableSubscriptionVisitor {

  @Override
  public List<Tree.Kind> nodesToVisit() {
    return Arrays.asList(Tree.Kind.METHOD_INVOCATION);
  }

  @Override
  public void visitNode(Tree tree) {
    if (this.hasSemantic()) {
      this.checkInvocation(tree);
    }
  }

  private void checkInvocation(Tree tree) {
    MethodInvocationTree mit = (MethodInvocationTree)tree;
    if (isEquals(mit)) {
      this.onMethodInvocationFound(mit);
    }
  }

  private boolean isEquals(MethodInvocationTree mit) {
    final IdentifierTree identifier = TreeUtils.getIdentifier(mit);
    return identifier.name().toLowerCase().equals("equals");
  }

  protected void onMethodInvocationFound(MethodInvocationTree tree) {
    final Arguments arguments = tree.arguments();
    final Iterator<ExpressionTree> iterator = arguments.iterator();
    boolean isOrgCode = false;
    boolean orgCheckPass = false;
    while (iterator.hasNext()) {
      final ExpressionTree next = iterator.next();
      if (!(next instanceof MethodInvocationTree)) {
        continue;
      }
      final IdentifierTree identifierTree = methodName((MethodInvocationTree) next);
      final String syntaxTokenStr = identifierTree.name().toLowerCase();
      if (syntaxTokenStr.contains("orgcode")) {
        isOrgCode = true;
      }
      if (isOrgCode && syntaxTokenStr.contains("trim")) {
        orgCheckPass = true;
      }
    }

    if (isOrgCode && !orgCheckPass) {
      reportIssue(tree, "亲爱的，你trim()了吗");
    }
  }

  /**
   * Retrieve the identifier corresponding to the method name associated to the method invocation
   */
  public static IdentifierTree methodName(MethodInvocationTree mit) {
    ExpressionTree methodSelect = mit.methodSelect();
    IdentifierTree id;
    if (methodSelect.is(Tree.Kind.IDENTIFIER)) {
      id = (IdentifierTree) methodSelect;
    } else {
      id = ((MemberSelectExpressionTree) methodSelect).identifier();
    }
    return id;
  }
}
