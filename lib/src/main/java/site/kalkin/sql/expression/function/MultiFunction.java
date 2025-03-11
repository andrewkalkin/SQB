package site.kalkin.sql.expression.function;

import site.kalkin.sql.expression.simple.ColumnExpression;
import site.kalkin.sql.expression.simple.Expression;

import java.util.Collection;

import static java.util.Objects.nonNull;
import static site.kalkin.sql.keyword.SqlKeyword.*;

public abstract class MultiFunction implements ColumnExpression {

    private Expression aliasExpression;

    @Override
    public String build() {

        Collection<Expression> parameters = getParameters();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getFunctionName());
        stringBuilder.append(LEFT_BRACE);

        int paramIndex = 0;
        int paramsCount = parameters.size();
        for (Expression parameter: parameters) {
            paramIndex++;
            stringBuilder.append(parameter.build());
            if (paramIndex != paramsCount) {
                stringBuilder.append(COMMA).append(SPACE);
            }
        }
        stringBuilder.append(RIGHT_BRACE);

        if (nonNull(aliasExpression)) {
            stringBuilder.append(SPACE)
                    .append(AS)
                    .append(SPACE)
                    .append(aliasExpression.build());
        }

        return stringBuilder.toString();
    }

    public Expression alias(Expression alias){
        this.aliasExpression = alias;
        return this;
    }

    protected abstract String getFunctionName();

    protected abstract Collection<Expression> getParameters();

}
