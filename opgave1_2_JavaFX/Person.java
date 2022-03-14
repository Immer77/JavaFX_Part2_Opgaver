package opgave1_2_JavaFX;

public class Person {
    private String name;
    private String title;
    private boolean senior;

    public Person(String name, String title){
        this.name = name;
        this.title = title;
        this.senior = false;
    }
    public Person(String name, String title, boolean senior){
        this.name = name;
        this.title = title;
        this.senior = senior;
    }
    public String toString(){
        String s = title + " " + name;
        if(senior){
            s = s + " (Senior)";
        }
        return s;
    }
}
