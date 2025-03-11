package site.kalkin.sql.builder;

import site.kalkin.sql.expression.simple.Expression;

import java.util.Collection;
import java.util.LinkedList;

import static java.util.Arrays.asList;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static site.kalkin.sql.keyword.SqlKeyword.*;

public class SqlInsertQueryBuilder implements InsertBuilder {

    private Expression table;
    private Collection<Expression> columns;
    private Collection<Collection<Expression>> values = new LinkedList<>();


    @Override
    public InsertBuilder into(Expression table) {
        this.table = table;
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public InsertBuilder columns(Expression... columns) {
        this.columns = asList(columns);
        return this;
    }

    @Override
    public InsertBuilder columns(Collection<Expression> columns) {
        this.columns = columns;
        return this;
    }


    @Override
    @SuppressWarnings("unchecked")
    public InsertBuilder values(Expression ... values) {
        this.values.add(asList(values));
        return this;
    }

    @Override
    public InsertBuilder values(Collection<Collection<Expression>> values) {
        this.values = values;
        return this;
    }

    @Override
    public String toSql() {

        if (isNull(table)) {
            throw new RuntimeException("Table name is not set");
        }

        if (isEmpty(columns)) {
            throw new RuntimeException("Table columns is not set");
        }

        if (isEmpty(values)) {
            throw new RuntimeException("Table values is not set");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(INSERT);
        stringBuilder.append(SPACE);
        stringBuilder.append(INTO);
        stringBuilder.append(SPACE);
        stringBuilder.append(table.build());
        stringBuilder.append(SPACE);
        stringBuilder.append(LEFT_BRACE);

        int currentColumnIndex = 0;
        int columnCount = columns.size();
        for (Expression column: columns) {
            currentColumnIndex++;
            stringBuilder.append(column.build());

            if (currentColumnIndex != columnCount) {
                stringBuilder.append(COMMA);
                stringBuilder.append(SPACE);
            }
        }

        stringBuilder.append(RIGHT_BRACE);

        stringBuilder.append(SPACE);
        stringBuilder.append(VALUES);


        int currentRowIndex = 0;
        int rowCount = values.size();
        for (Collection<Expression> row: values) {
            currentRowIndex++;
            stringBuilder.append(SPACE);
            stringBuilder.append(LEFT_BRACE);
            int currentFieldIndex = 0;
            int fieldCount = row.size();
            for (Expression field: row) {
                currentFieldIndex++;
                stringBuilder.append(field.build());
                if (currentFieldIndex != fieldCount) {
                    stringBuilder.append(COMMA);
                    stringBuilder.append(SPACE);
                }
            }

            stringBuilder.append(RIGHT_BRACE);

            if (currentRowIndex != rowCount) {
                stringBuilder.append(COMMA);
            }
        }

        stringBuilder.append(SEMICOLON);

        return stringBuilder.toString();
    }


}
