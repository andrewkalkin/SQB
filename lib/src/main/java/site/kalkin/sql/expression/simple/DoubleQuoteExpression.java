package site.kalkin.sql.expression.simple;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DoubleQuoteExpression implements Expression {

    private final Expression currentExpression;

    @Override
    public String build() {
        return "\"" + currentExpression.build() + "\"";
    }
}
