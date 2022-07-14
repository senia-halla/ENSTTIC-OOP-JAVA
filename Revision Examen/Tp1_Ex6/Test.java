interface FonctionDerivable{
    double f(double x);
    double f_derivee(double x);
}

class ZeroFonctionDerivale{
    public static double MethodeNewton(FonctionDerivable fct , double x_initial , double epsilon){
        double previous = x_initial ; //stocker valeur precedente xk
        double x = x_initial ; //stocker la prochaine valaur xk+1
        while(Math.abs(x-previous) < epsilon){
            previous=x ;  
            x -= fct.f(x)/fct.f_derivee(x);    
        }
        return x ;
    }
}

class Polynome implements FonctionDerivable {
    int degPoly ; 
    double [] coeffPoly ;

    public Polynome (){
        this.degPoly = 0 ;
        this.coeffPoly = 0;
    }

    public Polynome (int degPoly , double [] coeffPoly){
        this.coeffPoly = coeffPoly ;
        this.degPoly = degPoly ; 
    }

    public Polynome derivee(){
        double [] coeffDerivee = new double[deg];
        int degDerivee = degPoly - 1 ; 

        int i = 0 ;
        for(int j = degPoly ; j > 0 ; j--){
            coeffDerivee[i] = coeffPoly[i]*j ; 
        }

        return Polynome(degDerivee , coeffDerivee);
    }

    public double f(double x){
        double resultat = 0 ;
        for(int i = 0 ; i <= degPoly; i++){
            resultat = resultat + coeffPoly[i]*Math.pow(x,degPoly - i);
        }
        return resultat;
    }

    public double f_derivee(double x){
        Polynome p = this.derivee();
        return p.f(x);
    }

    public String tostring(){
        String polynomeAffiche;
		polynomeAffiche = (coefficientsPolynome[0]+"x^"+degrePolynome);
		for(int i=1; i<= degrePolynome-1 ; i++){
			polynomeAffiche = polynomeAffiche + ("+" + coefficientsPolynome[i] +" x^"+(degrePolynome - i));
		}
		polynomeAffiche = polynomeAffiche + (" + "+coefficientsPolynome[0]);
		return polynomeAffiche;
    }
}

public class Test {

    public static void main(String[] args){
        double [] coeffPoly = {2,4,-3,5};
        int degPoly = 3 ;
        Polynome p = new Polynome(degPoly, coeffPoly);
        System.out.println(p.toString());

        p.f(0);
        p.f_derivee(0);
        
        double s = ZeroFonctionDerivable.MethodeNewton(p, 4, 3);
        System.out.println("s = "+s);
    }
}