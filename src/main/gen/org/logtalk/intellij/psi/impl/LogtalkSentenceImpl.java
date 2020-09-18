// This is a generated file. Not intended for manual editing.
package org.logtalk.intellij.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.logtalk.intellij.psi.LogtalkSentence;
import org.logtalk.intellij.psi.LogtalkTerm;
import org.logtalk.intellij.psi.LogtalkVisitor;

public class LogtalkSentenceImpl extends ASTWrapperPsiElement implements LogtalkSentence {

  public LogtalkSentenceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LogtalkVisitor visitor) {
    visitor.visitSentence(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LogtalkVisitor) accept((LogtalkVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LogtalkTerm getTerm() {
    return findNotNullChildByClass(LogtalkTerm.class);
  }

}
