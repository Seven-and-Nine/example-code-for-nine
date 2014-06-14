public class DayofHolli
{
  private String date;
  private boolean dayOff;
  private String name;
  
  
  public DayofHolli(String yes, boolean value, String x)
  {
    date = yes;
    dayOff = value;
    name = x;
  }
  
  public String getDate()
  {
    return date;
  }
  
  public String getDayOff()
  {
    if (dayOff == true)
      return "yes";
    else
      return "no"; 
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setDayOff(String x)
  {
    if ( x.charAt(0) == 'y' || x.charAt(0) == 'Y')
      dayOff = true;
    else if ( x.charAt(0) == 'n' || x.charAt(0) == 'N')
      dayOff = false;
  }
  
  public void setName(String x)
  {
    name = x;
  }
  
  public void setDate(String x)
  {
   date = x;
  }
  
  public String toString()
  {
    String output;
    output = "name: "+name+
      "\n day off?: "+dayOff+
      "\ndate: "+date;
    return output;
  }
}