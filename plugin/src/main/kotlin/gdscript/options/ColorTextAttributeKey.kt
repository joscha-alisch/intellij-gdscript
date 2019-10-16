package gdscript.options

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default


// todo remove enum, create object, remove LINE_COMMENT.key
enum class ColorTextAttributeKey(val key: TextAttributesKey) {

    // todo GODOT_SCRIPT_LINE_COMMENT -> GDSCRIPT_LINE_COMMENT
    LINE_COMMENT(createTextAttributesKey("GODOT_SCRIPT_LINE_COMMENT", Default.LINE_COMMENT)),
    STRING(createTextAttributesKey("GODOT_SCRIPT_STRING", Default.STRING)),
    NUMBER(createTextAttributesKey("GODOT_SCRIPT_NUMBER", Default.NUMBER)),
    KEYWORD(createTextAttributesKey("GODOT_SCRIPT_KEYWORD", Default.KEYWORD)),
    IDENTIFIER(createTextAttributesKey("GODOT_SCRIPT_IDENTIFIER", Default.IDENTIFIER)),
    NODE(createTextAttributesKey("GODOT_SCRIPT_METADATA", Default.METADATA)),
    OPERATION_SIGN(createTextAttributesKey("GODOT_SCRIPT_OPERATION_SIGN", Default.OPERATION_SIGN)),
    COMMA(createTextAttributesKey("GODOT_SCRIPT_COMMA", Default.COMMA)),
    DOT(createTextAttributesKey("GODOT_SCRIPT_DOT", Default.DOT)),
    BRACES(createTextAttributesKey("GODOT_SCRIPT_BRACES", Default.BRACES)),
    PARENTHESES(createTextAttributesKey("GODOT_SCRIPT_PARENTHESES", Default.PARENTHESES)),
    BRACKETS(createTextAttributesKey("GODOT_SCRIPT_BRACKETS", Default.BRACKETS)),
    KEYWORD_FUNCTION_CALL(createTextAttributesKey("GODOT_SCRIPT_KEYWORD_FUNCTION_CALL", Default.KEYWORD)),
    STATIC_METHOD(createTextAttributesKey("GODOT_SCRIPT_STATIC_METHOD", Default.STATIC_METHOD)),
    INSTANCE_METHOD(createTextAttributesKey("GODOT_SCRIPT_INSTANCE_METHOD", Default.INSTANCE_METHOD)),
    CLASS_NAME(createTextAttributesKey("GODOT_SCRIPT_CLASS_NAME", Default.CLASS_NAME)),
    CONSTANT(createTextAttributesKey("GODOT_SCRIPT_CONSTANT", Default.CONSTANT)),

}