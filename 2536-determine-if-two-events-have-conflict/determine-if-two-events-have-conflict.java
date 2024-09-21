class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {


/*
         // Convert the end time of event1 and start time of event2 to minutes
        int endTime1 = convertToMinutes(event1[1]);  // Event 1 end time (HH:MM to minutes)
        int startTime2 = convertToMinutes(event2[0]);  // Event 2 start time (HH:MM to minutes)

        // Check if event1 ends before event2 starts -> no conflict
        if (endTime1 < startTime2) {
            return false;  // No conflict
        }

        // Convert the start time of event1 and end time of event2 to minutes
        int startTime1 = convertToMinutes(event1[0]);  // Event 1 start time (HH:MM to minutes)
        int endTime2 = convertToMinutes(event2[1]);  // Event 2 end time (HH:MM to minutes)

        // Check if event2 ends before event1 starts -> no conflict
        if (endTime2 < startTime1) {
            return false;  // No conflict
        }

        // If neither of the above cases is true, the events overlap (conflict)
        return true;
    }

    // Helper function to convert "HH:MM" format to total minutes since midnight
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");  // Split the time into hours and minutes
        int hours = Integer.parseInt(parts[0]);  // Parse the hours part
        int minutes = Integer.parseInt(parts[1]);  // Parse the minutes part
        return hours * 60 + minutes;  // Return total minutes since midnight
    }
        
    */
    Integer event1_0 = Integer.valueOf(event1[0].replace(":", ""));
    Integer event1_1 = Integer.valueOf(event1[1].replace(":", ""));
    Integer event2_0 = Integer.parseInt(event2[0].replace(":", ""));
    Integer event2_1 = Integer.parseInt(event2[1].replace(":", ""));
    
   if (event2_1 < event1_0) return false;
    if (event1_1 >= event2_0) return true;
    
    return false;
    }
}