package site.kalkin.sql.expression.operator;

import site.kalkin.sql.expression.operator.conditional.ConditionBraces;
import site.kalkin.sql.expression.operator.conditional.FieldCondition;
import site.kalkin.sql.expression.simple.Expression;

import static site.kalkin.sql.vendor.clickhouse.builder.ClickhouseQueryBuilder.literal;

public abstract class OperatorExpression implements Expression {
    public FieldCondition field(String fieldName) {
        return this.field(literal(fieldName));
    }

    public FieldCondition field(Expression fieldName) {
        FieldCondition fieldConditionBuilder = new FieldCondition( true);
        fieldConditionBuilder.setPreviousExpression(this);
        fieldConditionBuilder.setLeftExpression(fieldName);
        return fieldConditionBuilder;
    }

    public ConditionBraces braces(Expression expression) {
        ConditionBraces conditionBraces = new ConditionBraces(expression);
        conditionBraces.setPreviousExpression(this);
        conditionBraces.enableBraces();
        return conditionBraces;
    }

}
