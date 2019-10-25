package gdscript.annotation

import gdscript.completion.sources.COMPLETION_DATA
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import gdscript.GDScriptLexer
import gdscript.options.ColorTextAttributeKey
import gdscript.options.ColorTextAttributeKey.*
import gdscript.psi.FunctionRule
import gdscript.psi.InvokeRule
import gdscript.psi.TypeRule
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ScriptAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateInstanceField(element, holder)
        annotateStaticMethod(element, holder)
        annotateMethod(element, holder)
        annotateClass(element, holder)
        annotateConstant(element, holder)
        annotateKeyword(element, holder)
    }

    private fun annotateInstanceField(element: PsiElement, holder: AnnotationHolder) {
        if (element is LeafPsiElement && element.parent?.prevSibling?.text == ".")
            holder.createColorAnnotation(element, INSTANCE_FIELD)
    }

    private fun annotateStaticMethod(element: PsiElement, holder: AnnotationHolder) {
        val parent = element.parent
        if (element.isIdentifier() && parent is FunctionRule && parent.isStatic())
            holder.createColorAnnotation(element, STATIC_METHOD)
    }

    private fun annotateMethod(element: PsiElement, holder: AnnotationHolder) {
        val parent = element.parent
        if (element.isIdentifier() && parent is FunctionRule && !parent.isStatic())
            holder.createColorAnnotation(element, INSTANCE_METHOD)
    }

    private fun annotateConstant(element: PsiElement, holder: AnnotationHolder) {
        if (element is LeafPsiElement && isConstantCase(element.text))
            holder.createColorAnnotation(element, CONSTANT)
    }

    private fun annotateKeyword(element: PsiElement, holder: AnnotationHolder) {
        if (element.parent is InvokeRule && element.isIdentifier() && element.text in LANGUAGE_FUNCTION_NAMES)
            holder.createColorAnnotation(element, KEYWORD)
    }

    private fun annotateClass(element: PsiElement, holder: AnnotationHolder) {
        if (element is TypeRule && element.isNotPrimitive())
            holder.createColorAnnotation(element, CLASS_NAME)
    }

    private fun isConstantCase(text: String) =
        text.length >= 2 && text.all { (it.isLetter() && it.isUpperCase()) || it == '_' }

    private fun AnnotationHolder.createColorAnnotation(element: PsiElement, color: ColorTextAttributeKey) =
        createInfoAnnotation(element, null).also { it.textAttributes = color.key }!!

    private fun PsiElement.isIdentifier() =
        isToken(GDScriptLexer.IDENTIFIER)

    private fun PsiElement.isToken(expected: Int) =
        ((this as? LeafPsiElement)?.elementType as? TokenIElementType)?.antlrTokenType == expected

    companion object {

        private val LANGUAGE_FUNCTION_NAMES = COMPLETION_DATA.functions.map { it.name }

    }

}