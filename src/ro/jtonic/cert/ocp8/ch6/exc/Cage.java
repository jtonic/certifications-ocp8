package ro.jtonic.cert.ocp8.ch6.exc;

/**
 * Created by antonelpazargic on 18/05/16.
 */
public class Cage {

    private int height;
    private int length;
    private int width;

    public Cage(int height, int length, int width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public int getVolume() {
        if (this.height <= 0 || this.width <= 0 || this.length <= 0) {
            throw new IllegalStateException("The cage is not alright");
        }
        return this.height * this.width * this.length;
    }


}
