package site.kalkin.sql.expression.simple;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BacktickQuoteExpression implements Expression {

    private final Expression currentExpression;

    @Override
    public String build() {
        return "`" + currentExpression.build() + "`";
    }
}
