class Time{
    private double timeEnDecimal;

    public Time(double timeEnDecimal){
        this.timeEnDecimal = timeEnDecimal;
    }

    public Time(int h , int min , int sec){
        timeEnDecimal = h + min/60 + sec/3600 ;
    }

    public double getTimeEnDecimale(){
        return timeEnDecimal;
    }

    public int getHeure(){
        int h = (int)timeEnDecimal;
        return h ;
    }

    public int getMinute(){
        int h = (int)timeEnDecimal;
        int min = (int)( (timeEnDecimal - h) * 60 );
        return min ;
    }

    public int getSeconde(){
        int h = (int)timeEnDecimal;
        double minDec = 60*(timeEnDecimal - h);
        int min = (int) minDec;
        int sec = (int)(60*(minDec - min));
        return sec ;
    }

}

public class TestSexaDecimal1{
    public static void main(String args[]){
        Time t1 = new Time(5.8);
        System.out.println("t1 :");
        System.out.println("Decimal : "+t1.getTimeEnDecimale()+" .");
        System.out.println("Sexagésimal : "+t1.getHeure()+" h : "+t1.getMinute()+" min : "+t1.getSeconde()+" sec");
    }
}