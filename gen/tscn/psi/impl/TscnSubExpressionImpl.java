// This is a generated file. Not intended for manual editing.
package tscn.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tscn.psi.TscnElementTypes.*;
import tscn.psi.TscnBaseElement;
import tscn.psi.*;
import com.intellij.psi.PsiReference;

public class TscnSubExpressionImpl extends TscnBaseElement implements TscnSubExpression {

  public TscnSubExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TscnVisitor visitor) {
    visitor.visitSubExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TscnVisitor) accept((TscnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getNumber() {
    return findNotNullChildByType(NUMBER);
  }

  @Override
  @NotNull
  public PsiReference getReference() {
    return TscnPsiImplUtil.getReference(this);
  }

}
