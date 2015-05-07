/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.ArrayList;

/**
 *
 * @author wolf
 */
public class UserClass {
   private String name;
   private ArrayList<Course> courses; 
   public UserClass(String name){
       this.name = name;
   }
   
   public String getName(){
       return name;
   }
   public void addCourse(String courseName){
       courses.add(new Course(courseName));
   }
   public Course getCourse(String courseName){
       for(int i = 0;i < courses.size();i++){
          Course x = courses.get(i);
          if(x.getName().matches(courseName)){
              return x;
          }
       }
       return null;
       
   }
    
}
