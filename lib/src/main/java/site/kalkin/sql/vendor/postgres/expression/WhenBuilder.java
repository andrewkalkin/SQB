package site.kalkin.sql.vendor.postgres.expression;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.simple.Expression;

import static site.kalkin.sql.keyword.SqlKeyword.SPACE;
import static site.kalkin.sql.vendor.postgres.keyword.PostgresKeyword.THEN;
import static site.kalkin.sql.vendor.postgres.keyword.PostgresKeyword.WHEN;

@RequiredArgsConstructor
public class WhenBuilder implements WhenExpression, Expression {

    private final CaseBuilder caseBuilder;

    private final Expression whenCondition;
    private Expression thenExpression;

    public CaseBuilder then(Expression thenCondition) {
        this.thenExpression = thenCondition;
        caseBuilder.addWhenCondition(this);
        return caseBuilder;
    }

    @Override
    public String build() {
        return WHEN + SPACE + whenCondition.build() + SPACE + THEN + SPACE + thenExpression.build();
    }
}
