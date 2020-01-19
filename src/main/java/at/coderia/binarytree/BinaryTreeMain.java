package at.coderia.binarytree;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;

public class BinaryTreeMain {

    static String[] testdata = {"Mike", "Hotel", "Delta", "Romeo", "Victor", "Foxtrot", "Bravo", "Kilo", "India", "Papa", "Alpha", "Yankee", "Tango", "Echo", "Charlie", "Oscar", "Xray", "Zulu", "November", "Juliet", "Lima", "Golf", "Uniform", "Quebec", "Sierra", "Whiskey"};
    static int[] testdata2 = {2, 5, 6, 8, 10, 13, 15, 15, 23, 24, 27, 29, 31, 38, 39, 43, 45, 50, 51, 53, 56, 59, 65, 66, 67, 68, 78, 80, 81, 83, 84, 85, 87, 88, 90, 91, 92, 93, 100};
    static String[] testdata3 = {"20160301", "20160917", "20160515", "20161216", "20160926", "20160507", "20160323", "20160312", "20161220", "20160720", "20160715", "20160109", "20160316", "20160530", "20160205", "20160604", "20160720", "20160108", "20160922", "20161211", "20160403", "20160507", "20160807", "20160303", "20161009", "20160905", "20160623", "20160422", "20160605", "20160802"};

    public static void main(String[] args) {

        //Start tree 1: with persons
        BinaryTree<Person> tree = new BinaryTree<Person>();


        Vector<Comparable<Person>> objects = new Vector<Comparable<Person>>();
        for (String name : testdata) {
            Comparable<Person> c = new Person(name);
            objects.add(c);
        }

        for (Comparable<Person> o : objects) {
            tree.insertElement(o);
        }
        System.out.println(tree.print());


        //Start tree 2: with integers
        BinaryTree<Integer> tree2 = new BinaryTree<Integer>();
        Vector<Comparable<Integer>> o2 = new Vector<Comparable<Integer>>();
        for (int i : testdata2) {
            o2.add(i);
        }

        Collections.shuffle(o2);
        for (Comparable<Integer> o : o2) {
            tree2.insertElement(o);
        }
        System.out.println(tree2.print());

        //Start tree 2: with dates
        BinaryTree<Date> tree3 = new BinaryTree<Date>();
        Vector<Comparable<Date>> o3 = new Vector<Comparable<Date>>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        for (String s : testdata3) {
            try {
                Date d = sf.parse(s);
                o3.add(d);
            } catch (ParseException e) {
                System.out.println("Problem parsing date " + s);
            }
        }

        Collections.shuffle(o3);
        for (Comparable<Date> o : o3) {
            tree3.insertElement(o);
        }
        System.out.println(tree3.print());
    }
}
