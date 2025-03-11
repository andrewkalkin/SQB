package site.kalkin.sql.expression.pipe;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.operator.OperatorExpression;
import site.kalkin.sql.expression.operator.conditional.EmptyExpression;
import site.kalkin.sql.expression.simple.Expression;

import static site.kalkin.sql.keyword.SqlKeyword.*;

@RequiredArgsConstructor
public class OrPipe extends OperatorExpression {

    private final Expression leftExpression;
    @Override
    public String build() {

        if (leftExpression instanceof EmptyExpression) {
            return leftExpression.build();
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(leftExpression.build());
        stringBuilder.append(SPACE);
        stringBuilder.append(OR);
        return stringBuilder.toString();
    }

}
