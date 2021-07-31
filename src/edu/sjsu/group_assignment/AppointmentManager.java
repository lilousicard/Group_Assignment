/*
    Author  : Yipeng Liu, Lilou Sicard-Noel, Zhuying Wang
    Project : Group Assignment
    Class   : AppointmentManager
    Date    : 07/25/2021
    Updated : 07/30/2021
 */
package edu.sjsu.group_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * AppointmentManager class manages a collection of appointments
 * by using {@code TreeMap} where the key is a description
 * {@code String} and value is an {@code Appointment} object.
 *
 * @author Lilou Sicard-Noel, Yipeng Liu, Zhuying Wang
 * @see java.util.TreeMap
 */
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
        /*
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
        }*/
        // Modified due to the implementation of toString. -- Yipeng
        System.out.print(this.toString(compare));
    }

    /**
     * A method to save the appointments to a file.
     * Each line includes the information of one appointment.
     *
     * @param comparator
     *      An Appointment Comparator.
     */
    public void saveToFile(File outputFile, Comparator<Appointment> comparator) {
        try(PrintWriter writer = new PrintWriter(outputFile)) {
            writer.print(this.toString(comparator));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * A method to save the appointments to a file.
     * Each line includes the information of one appointment.
     */
    public void saveToFile(File outputFile) {
        this.saveToFile(outputFile, null);
    }

    /**
     * A toString method.
     *
     * @return
     *      An optimized {@code String}.
     */
    public String toString(Comparator<Appointment> compare) {
        StringBuilder result = new StringBuilder();
        if(this.apptMap.isEmpty()) {
            result = new StringBuilder("No appointment now.\n");
        } else {
            List<Appointment> toPrint = new ArrayList<>(apptMap.values());
            toPrint.sort(compare);
            for(Appointment entry: toPrint)
            {
                result.append(entry.toString());
                result.append("\n");
            }
        }
        return result.toString();
    }
}
