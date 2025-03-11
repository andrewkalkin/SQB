package site.kalkin.sql.vendor.postgres.function;

import site.kalkin.sql.expression.simple.Expression;

import static site.kalkin.sql.keyword.SqlKeyword.FROM;
import static site.kalkin.sql.keyword.SqlKeyword.SPACE;
import static site.kalkin.sql.vendor.postgres.keyword.PostgresFunction.EPOCH;

public class EpochFunction {

    private Expression parameter;

    public Expression from(Expression expression) {
        parameter = expression;
        return new Epoch();
    }

    private class Epoch implements Expression {

        @Override
        public String build() {
            return EPOCH + SPACE + FROM + SPACE + parameter.build();
        }
    }

}
