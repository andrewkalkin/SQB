package site.kalkin.sql.expression.simple;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LiteralExpression implements Expression {

    private final String literal;

    @Override
    public String build() {
        return literal;
    }

}
