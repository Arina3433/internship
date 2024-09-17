package academy.tochkavhoda.school;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TraineeMap {
    private final Map<Trainee, String> traineeInstituteMap;

    public TraineeMap() {
        this.traineeInstituteMap = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (traineeInstituteMap.putIfAbsent(trainee, institute) != null) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (traineeInstituteMap.replace(trainee, institute) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if (traineeInstituteMap.remove(trainee) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public int getTraineesCount() {
        return traineeInstituteMap.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        String institute = traineeInstituteMap.get(trainee);

        if (institute == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        return institute;
    }

    public Set<Trainee> getAllTrainees() {
        return traineeInstituteMap.keySet();
    }

    public Set<String> getAllInstitutes() {
        return new HashSet<>(traineeInstituteMap.values());
    }

    public boolean isAnyFromInstitute(String institute) {
        return traineeInstituteMap.containsValue(institute);
    }
}
