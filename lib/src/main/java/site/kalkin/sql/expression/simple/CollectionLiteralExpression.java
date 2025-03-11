package site.kalkin.sql.expression.simple;

import lombok.RequiredArgsConstructor;

import java.util.Collection;

import static java.util.stream.Collectors.joining;

@RequiredArgsConstructor
public class CollectionLiteralExpression implements Expression {

    private final Collection<Expression> expressionCollection;

    @Override
    public String build() {
        return expressionCollection.stream().map(Expression::build).collect(joining(", "));
    }
}
