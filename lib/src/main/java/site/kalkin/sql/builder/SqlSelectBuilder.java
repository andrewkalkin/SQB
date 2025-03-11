package site.kalkin.sql.builder;

import site.kalkin.sql.expression.operator.conditional.ConditionExpression;
import site.kalkin.sql.expression.simple.Expression;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;
import static site.kalkin.sql.builder.BaseQueryBuilder.literal;
import static site.kalkin.sql.keyword.SqlKeyword.ASTERISK;
import static site.kalkin.sql.keyword.SqlKeyword.COMMA;
import static site.kalkin.sql.keyword.SqlKeyword.FROM;
import static site.kalkin.sql.keyword.SqlKeyword.SELECT;
import static site.kalkin.sql.keyword.SqlKeyword.SEMICOLON;
import static site.kalkin.sql.keyword.SqlKeyword.SPACE;
import static site.kalkin.sql.keyword.SqlKeyword.WHERE;

public class SqlSelectBuilder implements SelectBuilder {

    protected final StringBuilder stringBuilder = new StringBuilder();
    protected final List<Expression> selectedFields = new LinkedList<>();
    protected ConditionExpression filter;
    protected Expression from;

    @Override
    public SelectBuilder select(Expression ... expressions) {
        selectedFields.addAll(asList(expressions));
        return this;
    }

    @Override
    public SelectBuilder select(String ... fields) {

        for (String field: fields) {
            selectedFields.add(literal(field));
        }

        return this;
    }

    @Override
    public SelectBuilder from(String tableName) {
        this.from = literal(tableName);
        return this;
    }

    @Override
    public SqlSelectBuilder from(Expression expression) {
        this.from = expression;
        return this;
    }

    @Override
    public SqlSelectBuilder where(ConditionExpression conditionExpression) {
        this.filter = conditionExpression;
        return this;
    }

    @Override
    public String toSql() {
        validate();
        appendSelect();
        appendFrom();
        appendWhere();
        stringBuilder.append(SEMICOLON);
        return stringBuilder.toString();
    }


    private void appendSelectedFields() {

        if (selectedFields.isEmpty()) {
            stringBuilder.append(SPACE);
            stringBuilder.append(ASTERISK);
            return;
        }

        int count = 0;
        for (Expression expression: selectedFields) {
            count++;
            stringBuilder.append(SPACE);
            stringBuilder.append(expression.build());
            if (count != selectedFields.size()) {
                stringBuilder.append(COMMA);
            }
        }
    }

    private void appendSelect() {
        stringBuilder.append(SELECT);
        appendSelectedFields();
    }

    private void appendFrom() {
        stringBuilder.append(SPACE);
        stringBuilder.append(FROM);
        stringBuilder.append(SPACE);
        stringBuilder.append(from.build());
    }

    private void appendWhere() {

        if (isNull(filter)) {
            return;
        }

        String stringFilter = filter.build();

        if (!isNoneBlank(stringFilter)) {
            return;
        }

        stringBuilder.append(SPACE);
        stringBuilder.append(WHERE);
        stringBuilder.append(SPACE);
        stringBuilder.append(stringFilter);
    }


    private void validate() {

        if (isNull(from)) {
            throw new RuntimeException("FROM clause is empty. Please select table for query");
        }

    }

}
