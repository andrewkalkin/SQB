package site.kalkin.sql.expression.simple;

import lombok.RequiredArgsConstructor;

import static java.util.Objects.nonNull;
import static site.kalkin.sql.keyword.SqlKeyword.AS;
import static site.kalkin.sql.keyword.SqlKeyword.SPACE;

@RequiredArgsConstructor
public class ColumnExpressionBuilder implements ColumnExpression {

    private final Expression column;
    private Expression alias;


    @Override
    public String build() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(column.build());

        if (nonNull(alias)) {
            stringBuilder.append(SPACE).append(AS).append(SPACE).append(alias.build());
        }

        return stringBuilder.toString();
    }

    @Override
    public Expression alias(Expression alias) {
        this.alias = alias;
        return this;
    }
}
