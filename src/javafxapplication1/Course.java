/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author wolf
 */
public class Course {
    private String courseName;
    private String courseCode;
    private String courseDescription;
    private ArrayList<CourseClass> courseClasses;
    public Course(String name){
        courseName = name;
    }
    public void addClass(LocalDateTime date){
        courseClasses.add(new CourseClass(date));
    }
    public String getName(){
        return courseName;
    }

}
