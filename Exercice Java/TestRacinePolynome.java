class Polynome {
	private int degrePolynome;
	private int [] coefficientsPolynome;

	public Polynome(int degrePolynome, int [] coefficientsPolynome){
		this.degrePolynome = degrePolynome;
		this.coefficientsPolynome = coefficientsPolynome;
	}

	public int getDegrePolynome(){
		return degrePolynome;
	}

	public int[] getCoefficientPolynome(){
		return coefficientsPolynome;
	}

	public void setDegrePolynome(int degrePolynome){
		this.degrePolynome = degrePolynome;
	}

	public void setCoefficientsPolynome(int [] coefficientsPolynome){
		this.coefficientsPolynome = coefficientsPolynome;
	}

	public int [] calculRacinePolynome(){
		// la methode alternative :
		double sommeDesRacine = - coefficientsPolynome[degrePolynome - 1] / coefficientsPolynome[degrePolynome];
		double produitDesRacine = ((-1)^(degrePolynome)) * (coefficientsPolynome[0] / coefficientsPolynome[degrePolynome]);
		int [] racines = new int[degrePolynome-1];
		// i numero des racine : chaque polynome de degre n possede n racine ; 
		int i = 0;
		int k = 1;
		do{
			if(coefficientsPolynome[0] % k == 0){
				racines[i] =  k ;
				int j = 1;
				if((coefficientsPolynome[0] / k) > k) {
					racines[i++] = coefficientsPolynome[0] / k ;
					j++;
				}
				k++;
				i += j;
			}
			else{
				k++;
			}
		} while (i == (degrePolynome - 2));
		return racines ;
	}
}
public class TestRacinePolynome{
	public static void main(String[] args){
		int degrePolynome = 2;
		int [] coefficientsPolynome = new int[3] ;
		int [] racine ;

		coefficientsPolynome[0] = 1 ;
		coefficientsPolynome[1] = -10 ;
		coefficientsPolynome[2] = 21 ;

		Polynome polynome = new Polynome (degrePolynome , coefficientsPolynome);
		racine = polynome.calculRacinePolynome();
		
		
			System.out.print("racine  = "+racine[0]);
			//System.out.print("racine  = "+racine[1]);	
	}
}