import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        // Playing audio with Java (.wav, .au, .aiff)

        // String filePath = "mixkit-cartoon-kitty-begging-meow-92.wav";
        File file = new File("mixkit-cartoon-kitty-begging-meow-92.wav");

        try(Scanner scanner = new Scanner(System.in); AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){

            Clip clip = AudioSystem.getClip(); //gives controls to play or pause the audio

            clip.open(audioStream);

            
            String response = "";
            while(!response.equals("Q")){
                System.out.println("P = Play,\nS = Stop,\nR = Reset,\nQ = Quit");
                response = scanner.nextLine().toUpperCase();

                switch(response){
                    case "P":
                        clip.start();
                        break;
                    case "S":
                        clip.stop();
                        break;
                    case "R":
                        clip.setMicrosecondPosition(0);
                        break; 
                    case "Q":
                        clip.close();
                        break;
                    default:
                        System.out.println("Not a valid response.");
                }
            }
        } 

        catch(FileNotFoundException e){
            System.out.println("Audio file not found.");
        }

        catch (LineUnavailableException e) {
            System.out.println("Unable to access audio resource.");
        }

        catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file format.");
        } 

        catch (IOException e) {
            System.out.println("Error playing audio file.");
        }  

        finally {
            System.out.println("Playback finished.");
        }
    }
}