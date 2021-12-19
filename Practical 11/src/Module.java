import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//this class is for the modole handling
public class Module {
    public String moduleID;
    public ArrayList<String> classList = new ArrayList<String>();

    public Module(){}

    //gets the module ID
    public String getModuleId()
    {
        return this.moduleID;
    }

    //sets the module ID
    public void setModuleID(String ID)
    {
        moduleID = ID;
    }

    //gets the list of students for each module
    public void getClassList()
    {
        for (int i = 0; i <classList.size();i++)
        {
            System.out.println("Student " + classList.get(i) + "\n");
        }
    }

    //adds a student to the list of students in the module
    public void setClassList(String student)
    {
        classList.add(student);
        if (classList.size() > 1)
        {
            classOrganise();
        }
    }

    //removes a student from the list of students in a module
    public void unenrollClassList(String student)
    {
        for(int i = 0; i < classList.size();i++)
        {
            if (classList.get(i).contains(student))
            {
                classList.remove(i);
            }
        }
        classOrganise();
    }

    //organises the students in the module lists by their uni ID order
    public void classOrganise()
    {
        List<Integer> studentValues = new ArrayList<Integer>();

        for (int i = 0; i < classList.size(); i++)
        {
            String storageID = "";
            for (int j = 1; j<classList.get(i).length();j++)
            {
                storageID = storageID + classList.get(i).charAt(j);
            }
            studentValues.add(Integer.valueOf(storageID));
        }

        int count = 0;
        while ((count != classList.size() - 1))
        {
            if ((studentValues.get(count) < studentValues.get(count + 1)))
            {
                count = count + 1;
            }
            else if ((studentValues.get(count) > studentValues.get(count + 1)))
            {
                Collections.swap(studentValues, count, count+1);
                Collections.swap(classList, count, count + 1);

                count = 0;
            }
        }
    }
}
