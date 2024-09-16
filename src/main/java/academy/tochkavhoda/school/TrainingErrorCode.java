package academy.tochkavhoda.school;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Trainee first name is null or an empty string"),
    TRAINEE_WRONG_LASTNAME("Trainee last name is null or an empty string"),
    TRAINEE_WRONG_RATING("Trainee rating is out of range (1-5)"),

    GROUP_WRONG_NAME("Group name is null or an empty string"),
    GROUP_WRONG_ROOM("Group room number is invalid"),

    TRAINEE_NOT_FOUND("Trainee not found"),

    SCHOOL_WRONG_NAME("School name is null or an empty string"),
    SCHOOL_WRONG_YEAR("School year is invalid"),

    DUPLICATE_GROUP_NAME("Group name already exists"),
    GROUP_NOT_FOUND("Group not found"),

    DUPLICATE_TRAINEE("Trainee already exists"),

    EMPTY_TRAINEE_QUEUE("No trainees in the queue"),

    DUPLICATE_PASSPORT("Passport number already exists"),
    PASSPORT_NOT_FOUND("Passport number not found");

    private final String errorString;

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
