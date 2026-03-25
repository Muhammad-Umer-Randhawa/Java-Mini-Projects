import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import java.time.LocalTime;
// import javax.sound.sampled.Clip;

public class Main {
    public static void main(String[] args) {
        // Alarm clock.
        boolean isPlaying = true;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter hours: ");
            int hours = scanner.nextInt();
            System.out.print("Enter minutes: ");
            int minutes = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter the time of day (am/pm): ");
            String timeOfDay = scanner.nextLine().toUpperCase();
            if (timeOfDay.equals("PM") && hours != 12) {
                hours += 12;
            } else if (timeOfDay.equals("AM") && hours == 12) {
                hours = 0;
            }
            String filePath = "alarm.wav";
            File file = new File(filePath);
            while (isPlaying) {
                LocalTime t1 = LocalTime.of(hours, minutes);
                LocalTime timeNow = LocalTime.now().withSecond(0).withNano(0);
                // if(t1.equals(timeNow)){
                // try {
                // AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                // Clip clip = AudioSystem.getClip();
                // clip.open(audioStream);
                // clip.start();
                // while (clip.isRunning()) {
                // Thread.sleep(100);
                // }
                // clip.close();
                // audioStream.close();
                // }
                // catch(UnsupportedAudioFileException e) {
                // System.out.println("Unsupported audio file format.");
                // }
                // catch(FileNotFoundException e){
                // System.out.println("Audio file not found.");
                // }
                // catch (LineUnavailableException e) {
                // System.out.println("Unable to access audio resource.");
                // }
                // catch (IOException e) {
                // System.out.println("Error playing audio file.");
                // }
                // isPlaying = false;
                // }
                if (t1.equals(timeNow)) {
                    System.out.println("ALARM TRIGGERED");
                    try {
                        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                        AudioFormat format = audioStream.getFormat();
                        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                        line.open(format);
                        line.start();
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = audioStream.read(buffer)) != -1) {
                            line.write(buffer, 0, bytesRead);
                        }

                        line.drain();
                        line.close();
                        audioStream.close();
                    } catch (UnsupportedAudioFileException e) {
                        System.out.println("Unsupported audio file format.");
                    } catch (FileNotFoundException e) {
                        System.out.println("Audio file not found.");
                    } catch (LineUnavailableException e) {
                        System.out.println("Unable to access audio resource.");
                    } catch (IOException e) {
                        System.out.println("Error playing audio file.");
                    }
                    isPlaying = false;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Audio was Interrupted.");
        }
        scanner.close();
    }
}