package ro.jtonic.cert.ocp8;

/**
 * Created by antonelpazargic on 25/04/16.
 */
public class Duck {
    private int weight;
    private String name;

    public Duck(String name, int weight) {
        this.setName(name);
        this.setWeight(weight);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Duck{");
        sb.append("weight=").append(weight);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
