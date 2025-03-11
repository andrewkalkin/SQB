package site.kalkin.sql.expression.simple;

public interface Expression {

    String build();

    default Expression concat(Expression expression) {
        return new ConcatExpression(this, expression);
    }

}
