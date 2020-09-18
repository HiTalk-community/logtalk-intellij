package org.logtalk.intellij.editor;

import com.intellij.lang.ASTNode;
import org.logtalk.intellij.psi.LogtalkTypes;


public class ASTNodeHelper {

    public static boolean isComment(ASTNode node) {
        return node.getElementType() == LogtalkTypes.COMMENT;
    }

}
