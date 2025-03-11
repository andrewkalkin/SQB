package site.kalkin.sql.builder;

import site.kalkin.sql.expression.simple.Expression;

import java.util.Collection;

public interface InsertBuilder {

    InsertBuilder into(Expression table);
    InsertBuilder columns(Expression ... columns);

    InsertBuilder columns(Collection<Expression> columns);

    InsertBuilder values(Expression ... values);

    InsertBuilder values(Collection<Collection<Expression>> values);

    String toSql();

}
