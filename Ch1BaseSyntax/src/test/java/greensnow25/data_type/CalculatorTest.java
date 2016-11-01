package greensnow25;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest{
	@Test
	public void whenaddTwoItemsthenResult(){
	final Calculator calc= new Calculator();
	calc.add(8,3);
	final double result= calc.result;
	assertThat(result, is(11d));

}


	@Test
	public void whensubstractTwoItemsthenResult(){
	final Calculator calc= new Calculator();
	calc.substract(8,3);
	final double result= calc.result;
	assertThat(result, is(5d));
}
	@Test
	public void whendivTwoItemsthenResult(){
	final Calculator calc= new Calculator();
	calc.div(3,3);
	final double result= calc.result;
	assertThat(result, is(1d));
	
}
	@Test
	public void whenmultipleTwoItemsthenResult(){
	final Calculator calc= new Calculator();
	calc.multiple(2,3);
	final double result= calc.result;
	assertThat(result, is(6d));
}


}