package site.kalkin.sql.vendor.clickhouse.condition;

import lombok.RequiredArgsConstructor;
import site.kalkin.sql.expression.simple.Expression;

import static site.kalkin.sql.keyword.SqlKeyword.COMMA;
import static site.kalkin.sql.keyword.SqlKeyword.SPACE;

@RequiredArgsConstructor
public class IfExpression implements Expression  {

    private final Expression ifCondition;
    private final Expression thenExpression;

    @Override
    public String build() {
        return ifCondition.build() + COMMA + SPACE + thenExpression.build();
    }
}
