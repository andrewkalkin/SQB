package site.kalkin.sql.builder;

import site.kalkin.sql.expression.operator.conditional.ConditionBraces;
import site.kalkin.sql.expression.operator.conditional.ConditionExpression;
import site.kalkin.sql.expression.operator.conditional.EmptyExpression;
import site.kalkin.sql.expression.operator.conditional.FieldCondition;
import site.kalkin.sql.expression.simple.*;

import java.util.Collection;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static site.kalkin.sql.keyword.SqlKeyword.*;

public abstract class BaseQueryBuilder {

    public static SelectBuilder select(Expression... expressions) {
        return new SqlSelectBuilder().select(expressions);
    }
    public static InsertBuilder insert() {
        return new SqlInsertQueryBuilder();
    }

    public static SelectBuilder select(String ... fields) {
        return new SqlSelectBuilder().select(fields);
    }

    public static Expression literal(String literal) {
        return new LiteralExpression(literal);
    }

    public static Expression literal(long literal) {
        return new LiteralExpression(String.valueOf(literal));
    }

    public static Expression literal(Collection<String> collection) {
        Collection<Expression> quotedCollection =
                collection.stream().map(str -> quote(literal(str))).collect(toList());
        return new CollectionLiteralExpression(quotedCollection);
    }

    @SuppressWarnings("unchecked")
    public static Expression literal(Expression ... expressions) {
        return new CollectionLiteralExpression(asList(expressions));
    }

    public static ConditionExpression empty() {
        return new EmptyExpression(literal(EMPTY));
    }

    public static FieldCondition field(Expression field) {
        FieldCondition fieldConditionBuilder = new FieldCondition(false);
        fieldConditionBuilder.setLeftExpression(field);
        return fieldConditionBuilder;
    }

    public static ColumnExpression column(Expression column) {
        return new ColumnExpressionBuilder(column);
    }

    public static ConditionExpression braces(ConditionExpression expression) {
        return new ConditionBraces(expression);
    }

    public static Expression braces(Expression expression) {
        return new BracesExpression(expression);
    }

    public static Expression backTickQuote(Expression expression) {
        return new BacktickQuoteExpression(expression);
    }

    public static Expression quote(Expression expression) {
        return new SingleQuoteExpression(expression);
    }

    public static Expression doubleQuote(Expression expression) {
        return new DoubleQuoteExpression(expression);
    }

    public static Expression count(Expression expression) {
        return new CountExpression(expression);
    }
    public static Expression count() {
        return new CountExpression(literal(ASTERISK));
    }

}
