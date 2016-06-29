import java.io.Serializable;

public class B extends A implements Serializable {

    private static final long serialVersionUID = 1L;

    {
        name = "b1";
    }

    public B() {
        name = "b2";
    }

}
