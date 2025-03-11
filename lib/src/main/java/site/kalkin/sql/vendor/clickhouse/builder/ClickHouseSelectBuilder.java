package site.kalkin.sql.vendor.clickhouse.builder;

import site.kalkin.sql.builder.SelectBuilder;
import site.kalkin.sql.builder.SqlSelectBuilder;

import static site.kalkin.sql.vendor.clickhouse.builder.ClickhouseQueryBuilder.backTickQuote;
import static site.kalkin.sql.vendor.clickhouse.builder.ClickhouseQueryBuilder.literal;

public class ClickHouseSelectBuilder extends SqlSelectBuilder implements SelectBuilder {

    @Override
    public SelectBuilder select(String ... fields) {

        for (String field: fields) {
            selectedFields.add(backTickQuote(literal(field)));
        }

        return this;
    }

    @Override
    public SelectBuilder from(String tableName) {
        this.from = backTickQuote(literal(tableName));
        return this;
    }

}
