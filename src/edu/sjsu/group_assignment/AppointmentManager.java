package edu.sjsu.group_assignment;


import java.util.*;

public class AppointmentManager {
    Map <String,Appointment> apptMap = new TreeMap<>();


    /**
     * add an appointment to the treemap. The appointment was already created. If the appointment already is in the
     * treemap, the duplicate is not added
     * @param appointment  The appointment to add.
     * @return true or false depending on the success
     */
    public boolean addAppointment(Appointment appointment)
    {
        if (!apptMap.containsKey(appointment.getDescription()))
        {
            apptMap.put(appointment.getDescription(),appointment);
            return true;
        }
        return false;

    }

    /**
     * The method delete an appointment from the treemap using the description of the appointment to
     * find it.
     * @param appointment The description of the appointment to delete
     * @return true or false depending on the success
     */
    public boolean deleteAppointment (String appointment)
    {
        if (apptMap.containsKey(appointment))
        {
            apptMap.remove(appointment);
            return true;
        }

        return false;

    }

    /**
     * Print all appointment in the treemap in there natural order or an error message if the treemap is empty
     * This use a comparator to sort the printed item. The sortage can be by Start Date or Description.
     * Remember that an appointment's description is unique.
     * Right now, compare to return the comparison of the description
     * @param compare The comparator object
     */
    public void printAppointment(Comparator<Appointment> compare)
    {
        if(apptMap.isEmpty())
        {
            System.out.println("No appointment now.");
        }
        else
        {
            List <Appointment> toPrint = new ArrayList<>();
            toPrint.addAll(apptMap.values());
            toPrint.sort(compare);
            for(Appointment entry: toPrint)
            {
               System.out.println(entry.toString());
            }
        }
    }


}
