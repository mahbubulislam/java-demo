/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.mmi.cse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Mahbbul
 */
public class SalutationTag extends BodyTagSupport {

    private String userName;
    private String tagOutput;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
    
    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = this.pageContext.getOut();

            Calendar c = Calendar.getInstance();
            //Date d = c.getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            int day = c.getTime().getHours();
            String greetDayPart = "Day!";
            if (day >= 15 && day <= 18) {
                greetDayPart = "Evening!";

            }
            out.println ("Hello "+ this.userName +"! Good" +greetDayPart +  " Now time is : " + dateFormat.format(c.getTime()));

        }catch (Exception ex) {
        }
        //return TagSupport.SKIP_BODY;
        return TagSupport.EVAL_BODY_INCLUDE;

    }

//    @Override
//    public int doAfterBody() throws JspException {
//        
//        try{
//            JspWriter out = this.pageContext.getOut();
//            String bodyText = bodyContent.getString();
//            Character tag = bodyText.charAt(2);
//            String outputStartTag = "<"+ tag.toString() +">";
//            String outputEndTag = "</"+ tag.toString() +">";
//            
//            out.println(outputStartTag + this.tagOutput + outputEndTag);
//        }
//            catch(IOException ex){
//                    }
//        
//        return TagSupport.EVAL_PAGE; //To change body of generated methods, choose Tools | Templates.
//    }

    
    

}
