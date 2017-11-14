//Hossam

package online_monopoly;


public class BoardObject {
    protected String name;
    private int ID ;
    private Point poistion ;
    private String description;
    
    public BoardObject(String name ,int id ,Point p ){
    this.name = name;
    this.ID = id ;
    this.poistion = p ;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public Point getPoistion() {
        return poistion;
    }

    public String getDescription() {
        return description;
    }
    
    
    
    
}
