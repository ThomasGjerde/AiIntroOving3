package model;

public class Temperature {
	
	//Temp, given by user
	public double temperature;
	
	//Constant reduction of the temp
	//No need to give the option to change this
	//as the temperature is given by input
	public double coolingGrade = 0.01;
	
	
	public Temperature(double temperature){
		this.temperature = temperature;
	}
	
	//reduses the  temperature
	public double currentTemp(){
		return temperature = temperature - coolingGrade;
	}
}
