public class Holliday
{
  public static void main(String[] arg)
  {
    DayofHolli Halloween = new DayofHolli("31st of October",false,"Halloween");
    DayofHolli President = new DayofHolli("Whenever it is",true,"President's Day");
    DayofHolli Deliciation = new DayofHolli("march 26th",false,"Deliciation Day");
    
    System.out.println(Halloween);
    Halloween.setName("All Hallows Eve");
    System.out.println(Halloween);
    System.out.println("------------------------");
    President.setDate("Monday, February 17  2014");
    System.out.println(President);
    System.out.println("------------------------");
    System.out.println(Deliciation);
    Deliciation.setDayOff("yes");
    System.out.println(Deliciation);
  }
}