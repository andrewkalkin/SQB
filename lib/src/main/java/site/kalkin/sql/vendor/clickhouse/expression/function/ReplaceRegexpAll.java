package site.kalkin.sql.vendor.clickhouse.expression.function;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.function.MultiFunction;
import site.kalkin.sql.expression.simple.Expression;

import java.util.Collection;

import static site.kalkin.sql.vendor.clickhouse.keyword.ClickHouseFunction.REPLACE_REGEXP_ALL;

@RequiredArgsConstructor
public class ReplaceRegexpAll extends MultiFunction {

    private final Collection<Expression> parameters;

    @Override
    protected String getFunctionName() {
        return REPLACE_REGEXP_ALL;
    }

    @Override
    protected Collection<Expression> getParameters() {
        return parameters;
    }
}
