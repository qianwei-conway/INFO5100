package assignment1;

import java.util.Scanner;

public class HelloWorld {

    private String greeting = "Hello ";

    public HelloWorld()
    {
    }

    private void SetGreeting(String name)
    {
        greeting += name;
    }

    public void greet()
    {
        System.out.println(greeting);
    }

    public static void main(String args[])
    {
        HelloWorld helloworld; // The variable 'helloworld' is an instance of HelloWorld class
        helloworld = new HelloWorld(); // Instantiating

        Scanner input = new Scanner(System.in);
        System.out.println("Please input your name:");
        String name = input.nextLine();
//        You should use input.nextLine() instead of input.next() in order to input something with blanks.

        helloworld.SetGreeting(name);
        helloworld.greet();
    }

}