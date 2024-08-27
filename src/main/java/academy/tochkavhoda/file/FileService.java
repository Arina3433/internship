package academy.tochkavhoda.file;

import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.figures.v3.ColoredRectangle;
import academy.tochkavhoda.figures.v3.Rectangle;
import academy.tochkavhoda.school.Trainee;
import academy.tochkavhoda.school.TrainingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(array);
        }
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(file.getAbsolutePath(), array);
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] result = new byte[(int) file.length()];

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            int bytesRead, offset = 0;

            while (offset < result.length &&
                    (bytesRead = fileInputStream.read(result, offset, result.length - offset)) != -1) {
                offset += bytesRead;
            }
        }

        return result;
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        return readByteArrayFromBinaryFile(file.getAbsolutePath());
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte[] result;

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byteArrayOutputStream.write(array);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

            ByteArrayOutputStream otherByteArrayOutputStream = new ByteArrayOutputStream();
            int bytesValue, index = 0;

            while ((bytesValue = byteArrayInputStream.read()) != -1) {
                if (index % 2 == 0) {
                    otherByteArrayOutputStream.write(bytesValue);
                }
                index++;
            }
            result = otherByteArrayOutputStream.toByteArray();
        }

        return result;
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        try (BufferedOutputStream bufferedOutputStream =
                     new BufferedOutputStream(new FileOutputStream(fileName))) {
            bufferedOutputStream.write(array);
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered(file.getAbsolutePath(), array);
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] result = new byte[(int) file.length()];

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            int bytesRead, offset = 0;

            while (offset < result.length &&
                    (bytesRead = bufferedInputStream.read(result, offset, result.length - offset)) != -1) {
                offset += bytesRead;
            }
        }

        return result;
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        return readByteArrayFromBinaryFileBuffered(file.getAbsolutePath());
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            writeCoordinatesToBinaryFile(dataOutputStream, rect);
        }
    }

    private static void writeCoordinatesToBinaryFile(DataOutputStream dataOutputStream, Rectangle rect) throws IOException {
        dataOutputStream.writeInt(rect.getTopLeft().getX());
        dataOutputStream.writeInt(rect.getTopLeft().getY());
        dataOutputStream.writeInt(rect.getBottomRight().getX());
        dataOutputStream.writeInt(rect.getBottomRight().getY());
    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            int[] coordinates = readCoordinates(dataInputStream);

            return new Rectangle(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
        }
    }

    private static int[] readCoordinates(DataInputStream dataInputStream) throws IOException {
        int xLeft = dataInputStream.readInt();
        int yTop = dataInputStream.readInt();
        int xRight = dataInputStream.readInt();
        int yBottom = dataInputStream.readInt();

        return new int[]{xLeft, yTop, xRight, yBottom};
    }

    public static void writeColoredRectangleToBinaryFile(File file, ColoredRectangle rect) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            writeCoordinatesToBinaryFile(dataOutputStream, rect);
            dataOutputStream.writeUTF(rect.getColor().toString());
        }
    }

    public static ColoredRectangle readColoredRectangleFromBinaryFile(File file) throws IOException, ColorException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            int[] coordinates = readCoordinates(dataInputStream);
            String color = dataInputStream.readUTF();

            return new ColoredRectangle(coordinates[0], coordinates[1], coordinates[2], coordinates[3], color);
        }
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            for (Rectangle el : rects) {
                writeCoordinatesToBinaryFile(dataOutputStream, el);
            }
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            final int ONE_RECTANGLE = 16;
            long fileLength = randomAccessFile.length();

            int numberOfRectangles = (int) (fileLength / ONE_RECTANGLE);
            Rectangle[] rects = new Rectangle[numberOfRectangles];

            for (int i = numberOfRectangles - 1; i >= 0; i--) {
                randomAccessFile.seek((long) ONE_RECTANGLE * i);

                int xLeft = randomAccessFile.readInt();
                int yTop = randomAccessFile.readInt();
                int xRight = randomAccessFile.readInt();
                int yBottom = randomAccessFile.readInt();

                rects[numberOfRectangles - i - 1] = new Rectangle(xLeft, yTop, xRight, yBottom);
            }

            return rects;
        }
    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException {
        writeToTextFileOneLine(file,
                String.valueOf(rect.getTopLeft().getX()),
                String.valueOf(rect.getTopLeft().getY()),
                String.valueOf(rect.getBottomRight().getX()),
                String.valueOf(rect.getBottomRight().getY()));
    }

    private static void writeToTextFileOneLine(File file, String... data) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            writer.print(String.join(" ", data));
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException {
        String[] coordinates = readFromTextFileOneLine(file);

        int xLeft = Integer.parseInt(coordinates[0]);
        int yTop = Integer.parseInt(coordinates[1]);
        int xRight = Integer.parseInt(coordinates[2]);
        int yBottom = Integer.parseInt(coordinates[3]);

        return new Rectangle(xLeft, yTop, xRight, yBottom);
    }

    private static String[] readFromTextFileOneLine(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            String line = reader.readLine();

            return line.split("\\s+");
        }
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException {
        writeToTextFile(file,
                String.valueOf(rect.getTopLeft().getX()),
                String.valueOf(rect.getTopLeft().getY()),
                String.valueOf(rect.getBottomRight().getX()),
                String.valueOf(rect.getBottomRight().getY()));
    }

    private static void writeToTextFile(File file, String... data) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            for (String line : data) {
                writer.println(line);
            }
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException {
        String[] coordinates = readFromTextFile(file);

        int xLeft = Integer.parseInt(coordinates[0]);
        int yTop = Integer.parseInt(coordinates[1]);
        int xRight = Integer.parseInt(coordinates[2]);
        int yBottom = Integer.parseInt(coordinates[3]);

        return new Rectangle(xLeft, yTop, xRight, yBottom);
    }

    private static String[] readFromTextFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            List<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }

            return lines.toArray(new String[0]);
        }
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        writeToTextFileOneLine(file,
                trainee.getFirstName(),
                trainee.getLastName(),
                String.valueOf(trainee.getRating()));
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException {
        String[] parts = readFromTextFileOneLine(file);

        String firstName = parts[0];
        String lastName = parts[1];
        int rating = Integer.parseInt(parts[2]);

        return new Trainee(firstName, lastName, rating);
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        writeToTextFile(file,
                trainee.getFirstName(),
                trainee.getLastName(),
                String.valueOf(trainee.getRating()));
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        String[] data = readFromTextFile(file);

        String firstName = data[0];
        String lastName = data[1];
        int rating = Integer.parseInt(data[2]);

        return new Trainee(firstName, lastName, rating);
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(trainee);
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Trainee) objectInputStream.readObject();
        }
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(trainee, writer);
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(file)) {
            return gson.fromJson(reader, Trainee.class);
        }
    }
}
