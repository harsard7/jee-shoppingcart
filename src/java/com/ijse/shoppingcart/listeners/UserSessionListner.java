/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author Hafees
 */
public class UserSessionListner implements HttpSessionListener,HttpSessionAttributeListener {
//public class UserSessionListner implements HttpSessionListener {

   private static int activeUser;

    public UserSessionListner() {
        activeUser=0;
    }
    
    public static int getActiveUserCount(){
    return (activeUser);
    }
    
    
    @Override
//    public synchronized void  sessionCreated(HttpSessionEvent se) {
//        activeUser++;
//        System.out.println(" UserSessionListner created  id : "+se.getSession().getId()+" : "+activeUser);
//    }
    
    public  void  sessionCreated(HttpSessionEvent se) {
       
        System.out.println(" UserSessionListner created  id : "+se.getSession().getId()+" : "+activeUser);
        synchronized (this){           
          // activeUser++;
        }
        
    }
    

    @Override
//    public synchronized void  sessionDestroyed(HttpSessionEvent se) {
//        activeUser--;
//        System.out.println("UserSessionListner destroyed id : "+se.getSession().getId()+" : "+activeUser );
//    }
    
     public  void  sessionDestroyed(HttpSessionEvent se) {
        
        System.out.println("UserSessionListner destroyed id : "+se.getSession().getId()+" : "+activeUser );
        synchronized (this){ 
            
           // activeUser--;
        }
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
          System.out.println("UserSessionListner user attribute created  name=: "+event.getName()+" : "+activeUser );
         synchronized (this){
          if(event.getName()=="user"){
         activeUser++;
         }else{
         
         }
         }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
          System.out.println("UserSessionListner user attribute removed  name=: "+event.getName()+" : "+activeUser );
         
          synchronized (this){
           if(event.getName()=="user"){
            activeUser--;
            }else{         
            }
        }
         
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        
    }
}
