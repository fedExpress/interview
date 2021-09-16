package interview.wikicredit.domain;

public enum EErrorCode {
    COMPANY_NOT_FOUND("Internal company not found"),
    COMPANY_ALREADY_EXISTS("Internal company already exists"),
    WIKI_ENTRY_ALREADY_EXISTS("Wikipedia company entry already exists");

    private final String description;

    EErrorCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
