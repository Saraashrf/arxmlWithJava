
public class Container implements Comparable<Container>{
    private String id;
    private String shortN;
    private String longN;
    public Container(){
        
    }
    public Container(String id,String s,String l){
        this.id=id;
        shortN=s;
        longN=l;
    }
    public void setID(String id){
        this.id=id;
    }
    public void setShort(String s){
        shortN=s;
    }
    public void setLong(String l){
        longN=l;
    }
    public String getId(){
        return id;
    }
     public String getShort(){
        return shortN;
    }
    public String getLong(){
        return longN;
    }
    @Override
    public String toString(){
       return "    <CONTAINER "+id+">\n"
               +"       <SHORT-NAME>"+shortN+"</SHORT-NAME\n>"
               +"       <LONG-NAME>"+longN+"</LONG-NAME\n>"
               +"   </CONTAINER>\n" ;

    }

    @Override
    public int compareTo(Container o) {
        
        if(shortN.charAt(9)>o.getShort().charAt(9))
            return 1;
        else if(shortN.charAt(9)==o.getShort().charAt(9))
            return 0;
        else
            return -1;

    }

}
