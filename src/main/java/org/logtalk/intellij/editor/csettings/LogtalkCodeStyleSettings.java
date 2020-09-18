package org.logtalk.intellij.editor.csettings;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import org.jetbrains.annotations.NotNull;

public
class LogtalkCodeStyleSettings extends CustomCodeStyleSettings {
    protected
    LogtalkCodeStyleSettings ( @NotNull String tagName, CodeStyleSettings container ) {
        super(tagName, container);
    }
}

