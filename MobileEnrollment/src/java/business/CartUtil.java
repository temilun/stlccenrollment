/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;
import java.util.List;

/**
 *
 * @author tom
 */
public class CartUtil {
    
    //Jon's Cart Overlap method (Moved to CartUtil)
    public static String checkCartOverlap(List<Section> secs) {
        String msg = "";
        
        try {
            for (int j = 0; j < secs.size() - 1; j++) {
                if (secs.get(j).getDays() != null) {
                    for (int k = j + 1; k < secs.size(); k++) {
                        if (secs.get(k).getDays() != null) {
                            char[] days1 = secs.get(j).getDays().toCharArray();
                            char[] days2 = secs.get(k).getDays().toCharArray();
                            
                            //Labeling this loop to break after the condition is met once
                            //  so the message doesn't fill in for each day of the classes
                            innerLoop:
                            for (char c:days1) {
                                for (char c2:days2) {
                                    if (c == c2) {
                                        if (isOverlapping(secs.get(j).getStartTime(), secs.get(j).getEndTime(), secs.get(k).getStartTime(), secs.get(k).getEndTime())) {
                                            msg += secs.get(j).getCourse().getCourseName() + " occurs at the same time as " + secs.get(k).getCourse().getCourseName() + "<br><br>";
                                            break innerLoop;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            return "Error on CartUtil : " + e.getMessage();
        }
        return msg;
    }
    
    //Jon's isOverlapping method
    public static boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && start2.before(end1);
    }
}
