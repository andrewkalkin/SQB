package site.kalkin.sql.expression.operator.conditional;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.simple.Expression;

import static site.kalkin.sql.vendor.clickhouse.builder.ClickhouseQueryBuilder.literal;

@RequiredArgsConstructor
public class FieldCondition extends LeftArgumentCondition {

    private final boolean enabledBraces;

    public BetweenOperator between(String leftBorder, String rightBorder) {
        return between(literal(leftBorder), literal(rightBorder));
    }

    public BetweenOperator between(Expression leftBorder, Expression rightBorder) {
        BetweenOperator expression = new BetweenOperator(leftExpression, leftBorder, rightBorder);
        expression.setPreviousExpression(previousExpression);
        if (enabledBraces) {
            expression.enableBraces();
        }
        return expression;
    }

}
