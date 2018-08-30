package Inheritance;

/**
 * Created by UDU on 7/5/2017.
 */



// This is wrong, because a class that has abstract method is itself abstract
//public class LetsTestSomeShis {
//    abstract int mKaka();
//
//}

interface LetsDoAContract{
    public void namm();// public is redundant here
}

interface LetsDoAnotherContract<T>{
    public void namm(T k);// public is redundant here

}

abstract class AbstractExamplesParent implements LetsDoAnotherContract<String>,LetsDoAContract{
    // CONTROLLING ACCESS: http://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
    protected String name;
    private String mySecret;
    AbstractExamplesParent(){
        this.name="Jou";
        this.abstractPrivateString();
    }

    public void changePrintMy(String l){
        this.mySecret=l;
        System.out.println(this.mySecret);
    }

    abstract void abstractString();
    private void abstractPrivateString(){
        System.out.println("Saladus");
    };
}

 abstract class AbstractExamplesMedium<T,K> extends AbstractExamplesParent{
    @Override
    protected void abstractString() {
        System.out.println("AbstractMediumExamples overrode abstractString declared " +
                "in Abstract ExamplesParent");
    }

    protected void pleaseOverrideMe(K norm ){
        System.out.println("pleaseOverrideMe() " +  "AbstractExamplesMedium");
    }
    abstract void abstractMediumString(T norm);
}

public class AbstractExamples extends AbstractExamplesMedium<String, String>{

    AbstractExamples(){

        System.out.println(this.name);
        this.abstractString();
        this.abstractMediumString("jOUD");
        this.pleaseOverrideMe("Tres");
        super.pleaseOverrideMe("Quatro");
        this.namm();
        this.namm("Some really far fetched exmaple with interfaces for this class");
        this.changePrintMy("Normaalne");// This means, that The inherited method has all the baggage memory-wize. Even for the abstract non
        //instantiated methods
        //this.abstractPrivateString();<- Does not allow
    }


    @Override
    public void namm(String k ){
        System.out.println("I had to follow the fucking contract"+k);
    }


    @Override
    public void namm(){
        System.out.println("I had to follow the fucking contract");
    }

    @Override
    protected void pleaseOverrideMe(String k ){
        System.out.println("pleaseOverrideMe() " +  "AbstractExamples");
    }

    @Override
    void abstractMediumString(String k){
        System.out.println("AbstractExamples overrode abstractMediumString() from  AbstractExamplesMedium");

    }

    public static void main(String args[]){
        AbstractExamples k = new AbstractExamples();
    }
}

