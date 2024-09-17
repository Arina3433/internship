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
        // REVU не надо contains, putIfAbsent сама скажет
        if (traineeInstituteMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }

        traineeInstituteMap.put(trainee, institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        // REVU не надо contains, replace сама скажет
        if (!traineeInstituteMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        traineeInstituteMap.put(trainee, institute);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        // REVU не надо contains, remove сама скажет
        if (!traineeInstituteMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        traineeInstituteMap.remove(trainee);
    }

    public int getTraineesCount() {
        return traineeInstituteMap.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        // REVU не надо contains, get сама скажет
        if (!traineeInstituteMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        return traineeInstituteMap.get(trainee);
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
