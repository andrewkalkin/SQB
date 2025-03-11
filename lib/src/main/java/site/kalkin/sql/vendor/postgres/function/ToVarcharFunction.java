package site.kalkin.sql.vendor.postgres.function;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.simple.Expression;

import static site.kalkin.sql.vendor.postgres.keyword.PostgresFunction.TO_VARCHAR;

@RequiredArgsConstructor
public class ToVarcharFunction implements Expression {

    private final Expression currentExpression;

    @Override
    public String build() {
        return currentExpression.build() + TO_VARCHAR;
    }
}
