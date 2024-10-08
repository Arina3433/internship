package academy.tochkavhoda.school;

public class TrainingException extends Exception {
    private final TrainingErrorCode trainingErrorCode;

    public TrainingException(TrainingErrorCode trainingErrorCode) {
        this.trainingErrorCode = trainingErrorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return trainingErrorCode;
    }
}
