package org.logtalk.intellij.psi;

import com.intellij.psi.PsiElement;

public
interface LogtalkNamedElement extends PsiElement {
    String getKey ();

    String getValue ();


    //    methods=[getKey getValue getName setName getNameIdentifier getPresentation]
//    String getKey ();
//
//    String getValue ();
//
//    String getName();

}