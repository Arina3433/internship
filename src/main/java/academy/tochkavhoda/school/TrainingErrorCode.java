package academy.tochkavhoda.school;

public enum TrainingErrorCode {
    // REVU а тут надо было добавить
    // private String errorString;
    // конструктор и т.д.
    // и дать дружественное описание
    // например
    //     TRAINEE_WRONG_FIRSTNAME("Trainee first name is null or an empty string"),
    TRAINEE_WRONG_FIRSTNAME,
    TRAINEE_WRONG_LASTNAME,
    TRAINEE_WRONG_RATING,

    GROUP_WRONG_NAME,
    GROUP_WRONG_ROOM,

    TRAINEE_NOT_FOUND,

    SCHOOL_WRONG_NAME,
    SCHOOL_WRONG_YEAR,

    DUPLICATE_GROUP_NAME,
    GROUP_NOT_FOUND,

    DUPLICATE_TRAINEE,

    EMPTY_TRAINEE_QUEUE,

    DUPLICATE_PASSPORT,
    PASSPORT_NOT_FOUND
}
