package site.kalkin.sql.expression.simple;

public interface ColumnExpression extends Expression {

    Expression alias(Expression alias);

}
