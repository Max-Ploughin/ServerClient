import java.io.*;
import java.time.LocalDateTime;


public class ErrorLogging {

    private static String fileLoggsPath =
            "C:\\Users\\pmaxt\\Downloads\\ServerClient\\src\\main\\resources\\serverErrorsLogs";

    /* A method for writing information about the occurred error to the 'serverErrorsLogs.txt' file.
    The date and time of the error occurrence are recorded, along with information about the error itself.
     */
    public static void logError(String error){
        try (FileWriter writer = new FileWriter(fileLoggsPath, true))
        {
            LocalDateTime currentDateTime = LocalDateTime.now();
            String errorTime = "Date and time: " + currentDateTime.toString();
            writer.write(errorTime);
            writer.append('\n');
            writer.write(error);
            writer.append('\n');
            writer.append('\n');
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
