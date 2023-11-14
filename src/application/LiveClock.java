package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LiveClock {
    public static void main(String[] args) {
        // Create a scheduled executor service with a single thread
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // Schedule a task to update the time every second
        scheduler.scheduleAtFixedRate(() -> {
            // Get the current date and time
            LocalDateTime currentDateTime = LocalDateTime.now();

            // Format the date using a DateTimeFormatter
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDateTime.format(dateFormatter);

            // Format the time using a DateTimeFormatter
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = currentDateTime.format(timeFormatter);

            // Print the formatted date and time
            System.out.println("Date: " + formattedDate + " Time: " + formattedTime);
        }, 0, 1, TimeUnit.SECONDS); // Update every second

        // Add a shutdown hook to stop the scheduler when the program exits
        Runtime.getRuntime().addShutdownHook(new Thread(scheduler::shutdown));
    }
}
