package site.kalkin.sql.expression.pipe;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.operator.conditional.ConditionExpression;
import site.kalkin.sql.expression.operator.conditional.EmptyExpression;
import site.kalkin.sql.expression.simple.Expression;

import static site.kalkin.sql.keyword.SqlKeyword.AND;
import static site.kalkin.sql.keyword.SqlKeyword.SPACE;

@RequiredArgsConstructor
public class AndOperator extends PipeOperator implements ConditionExpression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    @Override
    public String build() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(leftExpression.build());

        if (leftExpression instanceof EmptyExpression) {
            stringBuilder.append(rightExpression.build());
            return stringBuilder.toString();
        }

        stringBuilder.append(SPACE);
        stringBuilder.append(AND);
        stringBuilder.append(SPACE);
        stringBuilder.append(rightExpression.build());
        return stringBuilder.toString();
    }
}
