package site.kalkin.sql.vendor.postgres.expression;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.operator.conditional.ConditionExpression;
import site.kalkin.sql.expression.simple.ColumnExpression;
import site.kalkin.sql.expression.simple.Expression;

import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;
import static site.kalkin.sql.keyword.SqlKeyword.AS;
import static site.kalkin.sql.keyword.SqlKeyword.SPACE;
import static site.kalkin.sql.vendor.postgres.keyword.PostgresKeyword.*;

@RequiredArgsConstructor
public class CaseBuilder implements CaseExpression, ColumnExpression {

    private final List<Expression> whenConditions = new LinkedList<>();
    private Expression elseCondition;
    private Expression alias;

    @Override
    public String build() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CASE).append(SPACE);

        for (Expression whenCondition: whenConditions) {
            stringBuilder.append(SPACE).append(whenCondition.build());
        }

        if (nonNull(elseCondition)) {
            stringBuilder.append(SPACE).append(ELSE).append(SPACE).append(elseCondition.build());
        }

        stringBuilder.append(SPACE).append(END);

        if (nonNull(alias)) {
            stringBuilder.append(SPACE).append(AS).append(SPACE).append(alias.build());
        }

        return stringBuilder.toString();
    }

    public WhenExpression when(ConditionExpression whenCondition) {
        return new WhenBuilder(this, whenCondition);
    }

    public CaseExpression elseCase(Expression condition) {
        this.elseCondition = condition;
        return this;
    }

    public ColumnExpression end() {
        return this;
    }

    public void addWhenCondition(Expression condition) {
        whenConditions.add(condition);
    }

    @Override
    public Expression alias(Expression alias) {
        this.alias = alias;
        return this;
    }
}
