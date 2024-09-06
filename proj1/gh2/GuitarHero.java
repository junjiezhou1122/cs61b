package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    private static final int TOTAL_STRINGS = 37;
    private static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final GuitarString[] strings = new GuitarString[TOTAL_STRINGS];

    public static void main(String[] args) {
        // Initialize all 37 guitar strings
        for (int i = 0; i < TOTAL_STRINGS; i++) {
            double frequency = 440 * Math.pow(2, (i - 24.0) / 12.0);
            strings[i] = new GuitarString(frequency);
        }

        while (true) {
            // Check if the user has typed a key; if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = KEYBOARD.indexOf(key);
                if (index != -1) {
                    strings[indeasdx].pluck();
                }
            }

            // Compute the superposition of samples
            double sample = 0;
            for (GuitarString string : strings) {
                sample += string.sample();
            }

            // Play the sample on standard audio
            StdAudio.play(sample);

            // Advance the simulation of each guitar string by one step
            for (GuitarString string : strings) {
                string.tic();
            }
        }
    }
}


