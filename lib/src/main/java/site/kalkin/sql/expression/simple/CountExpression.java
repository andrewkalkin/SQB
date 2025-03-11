package site.kalkin.sql.expression.simple;

import lombok.RequiredArgsConstructor;

import static site.kalkin.sql.keyword.SqlFunction.COUNT;
import static site.kalkin.sql.keyword.SqlKeyword.LEFT_BRACE;
import static site.kalkin.sql.keyword.SqlKeyword.RIGHT_BRACE;

@RequiredArgsConstructor
public class CountExpression implements Expression {

    private final Expression currentExpression;

    @Override
    public String build() {
        return COUNT + LEFT_BRACE + currentExpression.build() + RIGHT_BRACE;
    }
}
