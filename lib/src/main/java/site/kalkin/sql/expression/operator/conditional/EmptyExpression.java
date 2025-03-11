package site.kalkin.sql.expression.operator.conditional;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.pipe.PipeOperator;
import site.kalkin.sql.expression.simple.Expression;

@RequiredArgsConstructor
public class EmptyExpression extends PipeOperator {

    private final Expression previousExpression;

    @Override
    public String build() {
        return previousExpression.build();
    }
}
