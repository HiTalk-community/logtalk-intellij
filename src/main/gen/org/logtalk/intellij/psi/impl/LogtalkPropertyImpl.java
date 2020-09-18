// This is a generated file. Not intended for manual editing.
package org.logtalk.intellij.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.logtalk.intellij.LogtalkLanguage;
import org.logtalk.intellij.psi.LogtalkProperty;
import org.logtalk.intellij.psi.LogtalkVisitor;

public
class LogtalkPropertyImpl extends LogtalkNamedElementImpl implements LogtalkProperty {
    private String name;

    public
    LogtalkPropertyImpl ( ASTNode node) {
        super(node, LogtalkLanguage.INSTANCE);
        this.name = name;
    }

    public
    void accept ( @NotNull LogtalkVisitor visitor ) {
        visitor.visitProperty(this);
    }

    /**
     * @return text range of this element relative to its parent
     */
    @NotNull
    @Override
    public
    TextRange getTextRangeInParent () {
        return null;
    }

    public
    void accept ( @NotNull PsiElementVisitor visitor ) {
        if (visitor instanceof LogtalkVisitor) {
            accept((LogtalkVisitor) visitor);
        }
        else {
            super.accept(visitor);
        }
    }

    @Override
    public
    String getValue () {
        return name;
    }
}
