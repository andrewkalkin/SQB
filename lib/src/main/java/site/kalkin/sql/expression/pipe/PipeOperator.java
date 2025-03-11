package site.kalkin.sql.expression.pipe;

import lombok.Setter;
import site.kalkin.sql.expression.operator.conditional.ConditionExpression;
import site.kalkin.sql.expression.simple.Expression;

@Setter
public abstract class PipeOperator implements ConditionExpression {

    protected Expression previousExpression;
    private boolean bracesEnabled;

    @Override
    public void enableBraces() {
        bracesEnabled = true;
    }

    @Override
    public boolean isBracesEnabled() {
        return bracesEnabled;
    }

    @Override
    public AndPipe and() {
        enableBraces();
        return new AndPipe(this);
    }

    @Override
    public ConditionExpression and(ConditionExpression expression) {
        enableBraces();
        return new AndOperator(this, expression);
    }

    @Override
    public OrPipe or() {
        enableBraces();
        return new OrPipe(this);
    }

    @Override
    public ConditionExpression or(ConditionExpression expression) {
        enableBraces();
        return new OrOperator(this, expression);
    }

}
