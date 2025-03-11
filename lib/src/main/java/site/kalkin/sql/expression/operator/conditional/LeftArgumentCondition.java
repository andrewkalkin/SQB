package site.kalkin.sql.expression.operator.conditional;

import lombok.Setter;
import site.kalkin.sql.expression.operator.BinaryOperator;
import site.kalkin.sql.expression.operator.Operation;
import site.kalkin.sql.expression.simple.Expression;

import java.util.Collection;
import java.util.EnumSet;


import static java.util.Arrays.asList;
import static site.kalkin.sql.builder.BaseQueryBuilder.braces;
import static site.kalkin.sql.builder.BaseQueryBuilder.literal;
import static site.kalkin.sql.expression.operator.Operation.EQ;
import static site.kalkin.sql.expression.operator.Operation.GE;
import static site.kalkin.sql.expression.operator.Operation.GT;
import static site.kalkin.sql.expression.operator.Operation.IN;
import static site.kalkin.sql.expression.operator.Operation.LE;
import static site.kalkin.sql.expression.operator.Operation.LT;
import static site.kalkin.sql.expression.operator.Operation.NOT_IN;
import static site.kalkin.sql.vendor.clickhouse.builder.ClickhouseQueryBuilder.braces;
import static site.kalkin.sql.vendor.clickhouse.builder.ClickhouseQueryBuilder.literal;

@Setter
public class LeftArgumentCondition {

    protected Expression previousExpression;
    protected Expression leftExpression;

    public BinaryOperator eq(String value) {
        return op(EQ, literal(value));
    }

    public BinaryOperator eq(Expression rightExpression) {
        return op(EQ, rightExpression);
    }

    public BinaryOperator lt(String value) {
        return op(LT, literal(value));
    }

    public BinaryOperator lt(Expression rightExpression) {
        return op(LT, rightExpression);
    }

    public BinaryOperator le(String value) {
        return op(LE, literal(value));
    }

    public BinaryOperator le(Expression rightExpression) {
        return op(LE, rightExpression);
    }

    public BinaryOperator gt(String value) {
        return op(GT, literal(value));
    }

    public BinaryOperator gt(Expression rightExpression) {
        return op(GT, rightExpression);
    }

    public BinaryOperator ge(String value) {
        return op(GE, literal(value));
    }

    public BinaryOperator ge(Expression rightExpression) {
        return op(GE, rightExpression);
    }

    public BinaryOperator in(Collection<String> values) {
        return op(IN, literal(values));
    }

    public BinaryOperator in(Expression ... values) {
        return op(IN, literal(values));
    }

    @SuppressWarnings("unchecked")
    public BinaryOperator in(String ... values) {
        return op(IN, literal(asList(values)));
    }

    public BinaryOperator notIn(Collection<String> values) {
        return op(NOT_IN, literal(values));
    }

    public BinaryOperator notIn(Expression values) {
        return op(NOT_IN, values);
    }

    public BinaryOperator op(Operation operation, Expression rightExpression) {

        if (EnumSet.of(IN, NOT_IN).contains(operation)) {
            rightExpression = braces(rightExpression);
        }

        BinaryOperator binaryOperator = new BinaryOperator(operation, leftExpression, rightExpression);
        binaryOperator.setPreviousExpression(previousExpression);
        return binaryOperator;
    }

}
