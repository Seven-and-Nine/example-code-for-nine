
public class CD implements Comparable<CD>
{
  private String artist;
  private String title;
  private int year;
  private String genre;
  
  public CD(String artist,String title,int year)
  {
    this.artist = artist;
    this.title = title;
    this.year = year;
    this.genre = "null";
  }
  
  public CD(String artist,String title,int year,String genre)
  {
    this(artist,title,year);
    this.genre = genre;
  }
  
  public String getArtist(){ return artist;}
  public String getTitle(){ return title;}
  public int getYear(){return year;}
  
  public int compareTo(CD cd)
  {
    int value = artist.compareTo(cd.getArtist());
    if( value != 0)
      return value;
    value = title.compareTo(cd.getTitle());
    if( value != 0)
      return value;
    return year - cd.getYear();
  }
  
  public String toString()
  {
    return artist+", "+title+", "+year;
  }
}
  