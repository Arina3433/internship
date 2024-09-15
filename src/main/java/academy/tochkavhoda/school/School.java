package academy.tochkavhoda.school;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class School {
    private String name;
    private int year;
    private final Set<Group> groups;

    public School(String name, int year) throws TrainingException {
        // REVU вызовите сеттеры, не дудлируйте код
        if (name == null || name.isBlank()) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        } else if (year < 0) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_YEAR);
        }

        this.name = name;
        this.year = year;
        this.groups = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.isBlank()) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }

        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws TrainingException {
        if (year < 0) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_YEAR);
        }

        this.year = year;
    }

    public Set<Group> getGroups() {
        return new HashSet<>(groups);
    }

    public void addGroup(Group group) throws TrainingException {
        for (Group el : groups) {
            if (el.getName().equals(group.getName())) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
            }
        }

        groups.add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        // REVU не надо contains, remove сама скажет
        if (!groups.contains(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }

        groups.remove(group);
    }

    public void removeGroup(String name) throws TrainingException {
        Group groupToRemove = groups.stream()
                .filter(group -> group.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND));

        groups.remove(groupToRemove);
    }

    public boolean containsGroup(Group group) {
        return groups.contains(group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School school)) return false;
        return getYear() == school.getYear() && Objects.equals(getName(), school.getName()) && Objects.equals(getGroups(), school.getGroups());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getYear(), getGroups());
    }
}
