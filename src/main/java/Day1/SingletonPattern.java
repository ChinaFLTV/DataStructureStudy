package Day1;

/*
 **@Author LiGuanda
 **@Data 2022/9/13 PM 7:45:48
 **@Description This is a description of SingletonPattern
 **@Params
 **@Return
 **@Since version-1.0  */


/**
 * @author Lenovo
 */
public class SingletonPattern {


}


class SingleDog {


    public String name;
    public static SingleDog singleDog;

    private SingleDog(String name) {

        this.name = name;

    }

    public static SingleDog instance() {

        if (singleDog == null) {

            singleDog = new SingleDog("rotten egg");

        }

        return singleDog;

    }


}

class SingleDogPro {


    public String name;
    public static volatile SingleDogPro singleDogPro;

    private SingleDogPro(String name) {

        this.name = name;

    }

    public static synchronized SingleDogPro instance() {

        if (singleDogPro == null) {

            singleDogPro = new SingleDogPro("Rotten Egg");

        }

        return singleDogPro;

    }


    public static SingleDogPro instancePro() {

        if (singleDogPro == null) {

            synchronized (SingleDogPro.class) {

                if (singleDogPro == null) {

                    singleDogPro = new SingleDogPro("Rotten Egg");

                }

            }

        }

        return singleDogPro;

    }


}


class SingleDogProMax {


    public String name;

    private SingleDogProMax(String name) {

        this.name = name;

    }

    static class Bachelor {

        private Bachelor() {


        }

        private static volatile SingleDogProMax singleDogProMax = new SingleDogProMax("Rotten Egg");

    }

    public static SingleDogProMax instance() {

        return Bachelor.singleDogProMax;

    }


}
