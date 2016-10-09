
import java.io.FileNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahbbul
 */
public class InterFaceImpDemo implements MyDemoInterface  {
    public static void main(String[] args) throws FileNotFoundException, ArrayIndexOutOfBoundsException{
       
       int a=9;
       
       MyDemoInterface d;
       
       
       if(a>10){
            d = new Impl1();
       }
       else {
           d= new Impl2(); 
       }
      
        
       d.method1();
    
    }
    
    @Override
     public void method1(){
         /// 
     }
     
  
}


