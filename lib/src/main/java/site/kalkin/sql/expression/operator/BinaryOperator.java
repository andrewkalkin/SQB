package site.kalkin.sql.expression.operator;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.operator.conditional.ConditionExpression;
import site.kalkin.sql.expression.pipe.PipeOperator;
import site.kalkin.sql.expression.simple.Expression;

import static java.util.Objects.nonNull;
import static site.kalkin.sql.keyword.SqlKeyword.SPACE;

@RequiredArgsConstructor
public class BinaryOperator extends PipeOperator implements ConditionExpression {


    private final Operation operation;
    private final Expression leftExpression;
    private final Expression rightExpression;

    @Override
    public String build() {

        StringBuilder stringBuilder = new StringBuilder();

        if (nonNull(previousExpression)) {
            stringBuilder.append(previousExpression.build());
            stringBuilder.append(SPACE);
        }

        stringBuilder.append(leftExpression.build());
        stringBuilder.append(operation.value);
        stringBuilder.append(rightExpression.build());

        return stringBuilder.toString();

    }
}
