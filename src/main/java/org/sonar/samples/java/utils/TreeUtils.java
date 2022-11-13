package org.sonar.samples.java.utils;

import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.MemberSelectExpressionTree;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.Tree;

/**
 * @author yonyong
 * @version 1.0
 * @date 2022/11/10 13:48
 */
public class TreeUtils {

    public static IdentifierTree getIdentifier(MethodInvocationTree mit) {
        return mit.methodSelect().is(new Tree.Kind[]{Tree.Kind.IDENTIFIER}) ? (IdentifierTree)mit.methodSelect() : ((MemberSelectExpressionTree)mit.methodSelect()).identifier();
    }
}
