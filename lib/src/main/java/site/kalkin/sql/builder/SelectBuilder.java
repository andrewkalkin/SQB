package site.kalkin.sql.builder;

import site.kalkin.sql.expression.operator.conditional.ConditionExpression;
import site.kalkin.sql.expression.simple.Expression;

public interface SelectBuilder {

    SelectBuilder select(Expression... expressions);

    SelectBuilder select(String ... fields);

    SelectBuilder from(String tableName);

    SelectBuilder from(Expression expression);

    SelectBuilder where(ConditionExpression conditionExpression);

    String toSql();
}
