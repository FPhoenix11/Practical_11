import java.util.ArrayList;
import java.util.List;

//this is the student support office class which is where most the main method
public class StudentSupportOffice
{
    //makes instances of these classes to be called upon when needed
    public static List<Module> modules = new ArrayList<Module>();
    public static Student students = new Student();

    //the main method is where the main chunck of the code will be done and run
    public static void main(String[] args)
    {
        //creates new instances of the modules class
        modules.add(new Module());
        modules.add(new Module());
        modules.add(new Module());

        //this sets the ID for the three modules that are needed
        modules.get(0).setModuleID("CIS2344");
        modules.get(1).setModuleID("CIS2360");
        modules.get(2).setModuleID("CIM2130");

        //sets up a list of 5 students
        students.setStudentID("U0000001");
        students.setStudentID("U0000002");
        students.setStudentID("U0000003");
        students.setStudentID("U0000004");
        students.setStudentID("U0000005");

        //this just prints a list of students
        System.out.println("Here is a list of students at the university: \n");
        for (int i = 0; i<5; i++)
        {
            System.out.println(students.getStudentID(i) + "\n");
        }

        //prints a list of modules
        System.out.println("Here is a list of modules at the university: \n");
        for (int i = 0;i<3;i++)
        {
            System.out.println(modules.get(i).getModuleId() + "\n");
        }

        //this section is dedicated to enroll students into their courses as asked by the specification
        enrollModule(0,0);
        enrollModule(0,3);

        enrollModule(1,0);
        enrollModule(1,2);
        enrollModule(1,4);

        enrollModule(2,2);
        enrollModule(2,3);
        enrollModule(2,4);

        //will go to the moduleRead procedure to show the current enrollment of modules
        moduleRead();

        //this section enrolls and unenrolls students for each module
        enrollModule(0,1);
        enrollModule(0,2);
        enrollModule(0,4);

        enrollModule(1,1);
        unenrollModule(1,2);

        enrollModule(2,0);
        unenrollModule(2,4);

        moduleRead();
    }

    //a procedure used to read a list of modules
    public static void moduleRead()
    {
        //reads out all the modules and the students in each module
        for(int i = 0;i<3;i++)
        {
            System.out.println("In module " + modules.get(i).getModuleId() + " these are the students that are current in the module \n");
            modules.get(i).getClassList();
        }
    }

    //procedure to enroll student in a module
    public static void enrollModule(int mod, int student)
    {
        modules.get(mod).setClassList(students.getStudentID(student));
    }

    //procedure to unenroll student in a module
    public static void unenrollModule(int mod, int student)
    {
        modules.get(mod).unenrollClassList(students.getStudentID(student));
    }
}
