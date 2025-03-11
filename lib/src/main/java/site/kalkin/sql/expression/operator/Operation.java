package site.kalkin.sql.expression.operator;

public enum Operation {

    EQ(" = "),
    NOT_EQ(" != "),
    GT(" > "),
    LT(" < "),
    GE(" >= "),
    LE(" <= "),
    IN(" IN "),
    NOT_IN(" NOT IN ");

    public final String value;

    Operation(String value) {
        this.value = value;
    }
}
