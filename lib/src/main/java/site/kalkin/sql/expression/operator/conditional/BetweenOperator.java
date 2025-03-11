package site.kalkin.sql.expression.operator.conditional;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.pipe.PipeOperator;
import site.kalkin.sql.expression.simple.Expression;

import static java.util.Objects.nonNull;
import static site.kalkin.sql.keyword.SqlKeyword.*;

@RequiredArgsConstructor
public class BetweenOperator extends PipeOperator implements ConditionExpression {

    private final Expression leftArgument;
    private final Expression leftBorder;
    private final Expression rightBorder;

    @Override
    public String build() {
        StringBuilder stringBuilder = new StringBuilder();

        if (nonNull(previousExpression)) {
            stringBuilder.append(previousExpression.build());
            stringBuilder.append(SPACE);
        }

        if (isBracesEnabled()) {
            stringBuilder.append(LEFT_BRACE);
        }

        stringBuilder.append(leftArgument.build()).append(SPACE)
                .append(BETWEEN_EXPRESSION).append(SPACE)
                .append(leftBorder.build()).append(SPACE)
                .append(AND).append(SPACE)
                .append(rightBorder.build());

        if (isBracesEnabled()) {
            stringBuilder.append(RIGHT_BRACE);
        }

        return stringBuilder.toString();
    }

}
