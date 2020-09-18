package org.logtalk.intellij.editor.formatter;

import com.intellij.formatting.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.logtalk.intellij.LogtalkLanguage;
import org.logtalk.intellij.psi.LogtalkTypes;

public
class LogtalkFormattingModelBuilder implements FormattingModelBuilder {

    private static
    SpacingBuilder createSpaceBuilder ( CodeStyleSettings settings ) {
        return new SpacingBuilder(settings, LogtalkLanguage.INSTANCE)
                .around(LogtalkTypes.SEPARATOR)
                .spaceIf(settings.getCommonSettings(LogtalkLanguage.INSTANCE.getID()).SPACE_AROUND_ASSIGNMENT_OPERATORS)
                .before(LogtalkTypes.PROPERTY)
                .none();
    }

    @NotNull
    @Override
    public
    FormattingModel createModel ( PsiElement element, CodeStyleSettings settings ) {
        return FormattingModelProvider
                .createFormattingModelForPsiFile(element.getContainingFile(),
                        new LogtalkBlock(element.getNode(),
                                Wrap.createWrap(WrapType.NONE, false),
                                Alignment.createAlignment(),
                                createSpaceBuilder(settings)),
                        settings);
    }
}
