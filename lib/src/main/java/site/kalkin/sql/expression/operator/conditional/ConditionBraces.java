package site.kalkin.sql.expression.operator.conditional;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.pipe.PipeOperator;
import site.kalkin.sql.expression.simple.Expression;

import static java.util.Objects.nonNull;
import static site.kalkin.sql.keyword.SqlKeyword.*;

@RequiredArgsConstructor
public class ConditionBraces extends PipeOperator implements ConditionExpression {

    private final Expression currentExpression;

    @Override
    public String build() {

        StringBuilder stringBuilder = new StringBuilder();

        if (nonNull(previousExpression)) {
            stringBuilder.append(previousExpression.build());
            stringBuilder.append(SPACE);
        }

        stringBuilder.append(LEFT_BRACE);
        stringBuilder.append(currentExpression.build());
        stringBuilder.append(RIGHT_BRACE);

        return stringBuilder.toString();
    }

}
