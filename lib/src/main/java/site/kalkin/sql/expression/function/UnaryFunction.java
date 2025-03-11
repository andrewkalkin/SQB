package site.kalkin.sql.expression.function;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.simple.Expression;

import static site.kalkin.sql.keyword.SqlKeyword.LEFT_BRACE;
import static site.kalkin.sql.keyword.SqlKeyword.RIGHT_BRACE;

@RequiredArgsConstructor
public class UnaryFunction implements Expression {

    private final String functionName;
    private final Expression parameter;

    @Override
    public String build() {
        return functionName + LEFT_BRACE + parameter.build() + RIGHT_BRACE;
    }

}
