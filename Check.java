public class Check {
    String[] moves;
    public Check(String [] args){
        moves=args;
    }
    public boolean repeatCheck(){
        for(int i=0;i< moves.length;i++)
            for(int j=i+1;j< moves.length;j++)
                if(moves[i].equals(moves[j]))
                    return true;
                return false;
    }
    public  boolean evenCheck(){
        if(moves.length % 2 ==0)
            return true;
        return false;
    }
    public boolean sizeCheck(){
        if(moves.length>2)
            return false;
        return true;
    }
    public void invalidInput(){
        System.out.println("Invalid input!\nExample: rock paper scissors");
    }
}
