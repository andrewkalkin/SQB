package site.kalkin.sql.vendor.postgres.expression;

import site.kalkin.sql.expression.operator.conditional.ConditionExpression;
import site.kalkin.sql.expression.simple.ColumnExpression;
import site.kalkin.sql.expression.simple.Expression;

public interface CaseExpression {

    WhenExpression when(ConditionExpression whenCondition);

    CaseExpression elseCase(Expression expression);

    ColumnExpression end();

}
