package site.kalkin.sql.vendor.postgres.builder;

import site.kalkin.sql.builder.SelectBuilder;
import site.kalkin.sql.builder.SqlSelectBuilder;

import static site.kalkin.sql.builder.BaseQueryBuilder.doubleQuote;
import static site.kalkin.sql.builder.BaseQueryBuilder.literal;

public class PostgresSelectBuilder extends SqlSelectBuilder implements SelectBuilder {

    @Override
    public SelectBuilder from(String tableName) {
        this.from = doubleQuote(literal(tableName));
        return this;
    }

}
