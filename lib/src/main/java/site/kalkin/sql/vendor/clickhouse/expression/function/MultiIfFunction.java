package site.kalkin.sql.vendor.clickhouse.expression.function;

import site.kalkin.sql.expression.function.MultiFunction;
import site.kalkin.sql.expression.simple.Expression;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static site.kalkin.sql.vendor.clickhouse.keyword.ClickHouseFunction.MULTI_IF;

public class MultiIfFunction extends MultiFunction {

    private final List<Expression> ifExpressions = new LinkedList<>();

    @SuppressWarnings("unchecked")
    public MultiIfFunction(Expression ... expressions) {
        ifExpressions.addAll(asList(expressions));
    }


    @Override
    protected String getFunctionName() {
        return MULTI_IF;
    }

    @Override
    protected Collection<Expression> getParameters() {

        return ifExpressions;
    }
}
