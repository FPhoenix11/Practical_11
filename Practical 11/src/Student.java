import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

//the class that stores the information of students
public class Student
{
    public List<String> studentID = new ArrayList<String>();

    public Student(){}

    //adds a student ID to the list of students at the university
    public void setStudentID(String ID)
    {
        studentID.add(ID);
        if (studentID.size() > 1)
        {
            studentOrganise();
        }
    }

    //gets the ID for a specific student
    public String getStudentID(int studentPos)
    {
        return this.studentID.get(studentPos);
    }

    //organises the students in the class by numerical order
    public void studentOrganise()
    {
        List<Integer> studentValues = new ArrayList<Integer>();

        for (int i = 0; i < studentID.size(); i++)
        {
            String storageID = "";
            for (int j = 1; j<7;j++)
            {
                storageID = storageID + studentID.get(i).charAt(j);
            }
            studentValues.add(Integer.valueOf(storageID));
        }

        int count = 0;
        while ((count != studentID.size() - 1))
        {
            if ((studentValues.get(count) < studentValues.get(count + 1)) || (studentValues.get(count + 1) == 0))
            {
                count = count + 1;
            }
            else if ((studentValues.get(count) > studentValues.get(count + 1)) && (studentValues.get(count +1) != 0))
            {
                Collections.swap(studentValues, count, count+1);
                Collections.swap(studentID,count,count + 1);

                count = 0;
            }
        }
    }
}
