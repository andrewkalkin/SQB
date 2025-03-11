package site.kalkin.sql.vendor.postgres.expression;

import site.kalkin.sql.expression.simple.Expression;

public interface WhenExpression {

    CaseExpression then(Expression condition);

}
