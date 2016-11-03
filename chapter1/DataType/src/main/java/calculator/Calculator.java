
package calculator;
 
 class Calculator
 { 
	double result;
	
	
    public void add(double first, double second){
		this.result= first+ second;
	}
	
	public void substract (double first, double second){
		this.result= first-second;
	}
	
	public void div (double first, double second){
		this.result= first / second;
	}
	
	public void multiple (double first, double second){
		this.result= first*second;
	}
	
	public static void main(String [] args){
		Calculator calc = new Calculator();
   	
   	 calc.add(2,3);
     System.out. println(calc.result);
	    calc.substract(4,2);
	 System.out. println(calc.result);
	    calc.div(4,3);
	 System.out. println(calc.result);
	     calc.multiple(5,7);
	 System.out. println(calc.result);
	
	}
	
 	}
 