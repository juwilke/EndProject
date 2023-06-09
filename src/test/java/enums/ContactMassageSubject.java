package enums;

public enum ContactMassageSubject {

    CUSTOMER_SERVICE("Customer service"), WEBMASTER("Webmaster");

    private final String value;

    ContactMassageSubject(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
