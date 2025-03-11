package site.kalkin.sql.expression.pipe;

import site.kalkin.sql.expression.operator.conditional.ConditionExpression;

public interface PipeExpression {

    AndPipe and();

    OrPipe or();

    ConditionExpression and(ConditionExpression expression);

    ConditionExpression or(ConditionExpression expression);


    void enableBraces();

    boolean isBracesEnabled();

}
