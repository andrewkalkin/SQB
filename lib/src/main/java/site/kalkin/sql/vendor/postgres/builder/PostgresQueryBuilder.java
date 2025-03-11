package site.kalkin.sql.vendor.postgres.builder;

import site.kalkin.sql.builder.BaseQueryBuilder;
import site.kalkin.sql.builder.SelectBuilder;
import site.kalkin.sql.expression.function.UnaryFunction;
import site.kalkin.sql.expression.simple.Expression;
import site.kalkin.sql.vendor.postgres.expression.CaseBuilder;
import site.kalkin.sql.vendor.postgres.expression.CaseExpression;
import site.kalkin.sql.vendor.postgres.function.EpochFunction;
import site.kalkin.sql.vendor.postgres.function.ToVarcharFunction;

import static site.kalkin.sql.vendor.postgres.keyword.PostgresFunction.EXTRACT;
import static site.kalkin.sql.vendor.postgres.keyword.PostgresFunction.PG_COLUMN_SIZE;

public class PostgresQueryBuilder extends BaseQueryBuilder {

    public static SelectBuilder select(String ... fields) {
        return new PostgresSelectBuilder().select(fields);
    }

    public static Expression toVarchar(Expression expression) {
        return new ToVarcharFunction(expression);
    }

    public static Expression extract(Expression expression) {
        return new UnaryFunction(EXTRACT, expression);
    }

    public static EpochFunction epoch() {
        return new EpochFunction();
    }

    public static CaseExpression caseCondition() {
        return new CaseBuilder();
    }

    public static Expression pgColumnSize(Expression column) {
        return new UnaryFunction(PG_COLUMN_SIZE, column);
    }

}
