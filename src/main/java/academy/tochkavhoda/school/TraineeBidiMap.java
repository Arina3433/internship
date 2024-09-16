package academy.tochkavhoda.school;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.Set;

public class TraineeBidiMap {
    private final BidiMap<String, Trainee> bidiMap;

    public TraineeBidiMap() {
        this.bidiMap = new DualHashBidiMap<>();
    }

    public void addTrainee(Trainee trainee, String passport) throws TrainingException {
        if (bidiMap.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        } else if (bidiMap.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }

        bidiMap.put(passport, trainee);
    }

    public void replaceTraineePassport(Trainee trainee, String passport) throws TrainingException {
        if (!bidiMap.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        } else if (bidiMap.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }

        // REVU bidiMap.replace
        // насколько я понимаю метод replace может заменить одного trainee с паспортом passport на нового trainee,
        // но он не может заменить ключ? Т.е. нельзя с помощью replace заменить passport на другой
        bidiMap.removeValue(trainee);
        bidiMap.put(passport, trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!bidiMap.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        bidiMap.removeValue(trainee);
    }

    public void removeTraineeByPassport(String passport) throws TrainingException {
        if (!bidiMap.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }

        bidiMap.remove(passport);
    }

    public Trainee getTraineeByPassport(String passport) throws TrainingException {
        Trainee trainee = bidiMap.get(passport);

        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }

        return trainee;
    }

    public String getPassportByTrainee(Trainee trainee) throws TrainingException {
        String passport = bidiMap.getKey(trainee);

        if (passport == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        return passport;
    }

    public Set<Trainee> getAllTrainees() {
        return bidiMap.values();
    }

    public Set<String> getAllpassports() {
        return bidiMap.keySet();
    }

    public boolean hasAnybodyPassport(String passport) {
        return bidiMap.containsKey(passport);
    }

    public int getTraineesCount() {
        return bidiMap.size();
    }
}
