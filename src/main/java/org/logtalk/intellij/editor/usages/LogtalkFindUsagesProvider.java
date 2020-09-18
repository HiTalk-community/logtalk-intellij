package org.logtalk.intellij.editor.usages;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.logtalk.intellij.LogtalkLexerAdapter;
import org.logtalk.intellij.editor.LogtalkAnnotator;
import org.logtalk.intellij.psi.LogtalkProperty;
import org.logtalk.intellij.psi.LogtalkTypes;

public
class LogtalkFindUsagesProvider implements FindUsagesProvider {

    @Nullable
    @Override
    public
    WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new LogtalkLexerAdapter(),
                TokenSet.create(LogtalkTypes.KEY),
                TokenSet.create(LogtalkTypes.COMMENT),
                TokenSet.EMPTY);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        return element instanceof LogtalkProperty ? "Logtalk property" : "";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        return element instanceof LogtalkProperty ?
                ((LogtalkProperty) element).getKey() :
                "";
    }

    @NotNull
    @Override
    public String getNodeText( @NotNull PsiElement element, boolean useFullName) {
        return element instanceof LogtalkProperty ?
                ((LogtalkProperty) element).getKey() + LogtalkAnnotator.SEPARATOR + ((LogtalkProperty) element).getValue() :
                "";
    }
}
