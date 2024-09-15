package academy.tochkavhoda.school;

import java.util.*;

public class Group {
    private String name;
    private String room;
    private final List<Trainee> trainees;

    public Group(String name, String room) throws TrainingException {
        // REVU вызовите сеттеры, не дудлируйте код
        if (name == null || name.isBlank()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        } else if (room == null || room.isBlank()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }

        this.name = name;
        this.room = room;
        this.trainees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.isBlank()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }

        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == null || room.isBlank()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }

        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return new ArrayList<>(trainees);
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        // REVU не надо contains, remove сама скажет
        if (!trainees.contains(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        trainees.remove(trainee);
    }

    public void removeTrainee(int index) throws TrainingException {
        if (index < 0 || index >= trainees.size()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        trainees.remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        return trainees.stream()
                .filter(trainee -> trainee.getFirstName().equals(firstName))
                .findFirst()
                .orElseThrow(() -> new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND));
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        return trainees.stream()
                .filter(trainee -> trainee.getFullName().equals(fullName))
                .findFirst()
                .orElseThrow(() -> new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND));
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort(Comparator.comparingInt(Trainee::getRating).reversed());
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        int size = trainees.size();

        int realPositions = positions % size;

        if (realPositions < 0) {
            realPositions += size;
        }

        Collections.rotate(trainees, realPositions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        if (trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        // REVU а без нахождения maxRating сможете ? В один проход
        int maxRating = trainees.stream()
                .mapToInt(Trainee::getRating)
                .max()
                .orElseThrow(() -> new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND));

        List<Trainee> result = new ArrayList<>();
        for (Trainee el : trainees) {
            if (el.getRating() == maxRating) {
                result.add(el);
            }
        }

        return result;
    }

    public boolean hasDuplicates() {
        Set<Trainee> seenTrainees = new HashSet<>();

        for (Trainee trainee : trainees) {
            if (!seenTrainees.add(trainee)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group group)) return false;
        return Objects.equals(getName(), group.getName()) && Objects.equals(getRoom(), group.getRoom()) && Objects.equals(getTrainees(), group.getTrainees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRoom(), getTrainees());
    }
}
