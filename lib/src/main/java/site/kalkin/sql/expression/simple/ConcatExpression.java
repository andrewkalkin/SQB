package site.kalkin.sql.expression.simple;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConcatExpression implements Expression {

    private final Expression previousExpression;
    private final Expression currentExpression;

    @Override
    public String build() {
        return previousExpression.build() + currentExpression.build();
    }
}
