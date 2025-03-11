package site.kalkin.sql.vendor.clickhouse.builder;

import site.kalkin.sql.builder.BaseQueryBuilder;
import site.kalkin.sql.builder.SelectBuilder;
import site.kalkin.sql.expression.function.UnaryFunction;
import site.kalkin.sql.expression.operator.conditional.FieldCondition;
import site.kalkin.sql.expression.simple.ColumnExpression;
import site.kalkin.sql.expression.simple.Expression;
import site.kalkin.sql.vendor.clickhouse.condition.IfExpression;
import site.kalkin.sql.vendor.clickhouse.expression.function.MultiIfFunction;
import site.kalkin.sql.vendor.clickhouse.expression.function.ReplaceRegexpAll;

import java.util.List;

import static site.kalkin.sql.vendor.clickhouse.keyword.ClickHouseFunction.BYTE_SIZE;
import static site.kalkin.sql.vendor.clickhouse.keyword.ClickHouseFunction.TO_INT32;

public class ClickhouseQueryBuilder extends BaseQueryBuilder {

    public static SelectBuilder select(String ... fields) {
        return new ClickHouseSelectBuilder().select(fields);
    }

    public static Expression toInt32(String parameter) {
        return new UnaryFunction(TO_INT32, literal(parameter));
    }

    public static Expression toInt32(Expression parameter) {
        return new UnaryFunction(TO_INT32, parameter);
    }

    public static ColumnExpression multiIf(Expression ... expressions) {
        return new MultiIfFunction(expressions);
    }

    public static FieldCondition field(String field) {
        FieldCondition fieldConditionBuilder = new FieldCondition(false);
        fieldConditionBuilder.setLeftExpression(backTickQuote(literal(field)));
        return fieldConditionBuilder;
    }

    public static Expression ifExpression(Expression ifCondition, Expression thenExpression) {
        return new IfExpression(ifCondition, thenExpression);
    }

    public static Expression elseExpression(Expression expression) {
        return expression;
    }

    public static Expression replaceRegexpAll(Expression haystack, Expression pattern, Expression replacement) {
        return new ReplaceRegexpAll(List.of(haystack, pattern, replacement));
    }

    public static Expression byteSize(Expression column) {
        return new UnaryFunction(BYTE_SIZE, column);
    }

}
