import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class grade {

	public static void main(String[] args) {
		int numberSubjectConvert, toggleOkNumberConvert;
		String numberSubject;
		
		numberSubject = JOptionPane.showInputDialog("กรุณากรอกจำนวนวิชา");
		numberSubjectConvert = Integer.parseInt(numberSubject);
	
		if(numberSubjectConvert != 0) {
			String data[] = new String[numberSubjectConvert];
			String credit[] = new String[numberSubjectConvert];
			String point[] = new String[numberSubjectConvert];
 			for(int i = 0; i < numberSubjectConvert ; i++) {
 				int sub = i+1;
				data[i] = JOptionPane.showInputDialog("กรุณากรอกชื่อวิชาที่ "+ sub);
				credit[i] = JOptionPane.showInputDialog("กรุณากรอกหน่วยกิตของวิชาที่"+ sub);
				point[i] = JOptionPane.showInputDialog("กรุณากรอกคะแนนในรายวิชาที่  "+sub+" | "+data[i]);
			}
 			
 			display(data,credit,point);
 		}
	}

	
	public static void display(String data[],String credit[],String point[]) {
		double result = calculate(credit,point);
		
		String output = "";
		for(int n = 0; n < data.length ; n++) {
			output += "รายวิชา : " + data[n] + " หน่วยกิต : " + credit [n] + " เกรด : "+ displaygrade(point[n]) + "\n";
		}
		output += "เกรดที่ได้ "+" : "+ result;
		JOptionPane.showMessageDialog(null, output);
	}
	
	public static double calculate(String credit[],String point[]) {
		double creditConvert[] = new double[credit.length];
		double pointConvert[] = new double[point.length];
		double resultcredit = 0;
		double resultpluscredit = 0;
		
		for(int a = 0; a < credit.length ; a++) {
			creditConvert[a] = Double.parseDouble(credit[a]);
			pointConvert[a] = Double.parseDouble(point[a]);
		}
		
		double point2Grade[] = convertPoint2Grade(pointConvert);
		
		for(int b = 0; b < point2Grade.length ; b++) {
			resultcredit += creditConvert[b] * point2Grade[b];
			resultpluscredit += creditConvert[b];
		}
	
		return (resultcredit/resultpluscredit);
	}
	
	public static String displaygrade(String grade) {
		int grades = Integer.parseInt(grade);
	    String display;
		if(grades >= 80){
            display = "A";
        }
        else if(grades >= 75){
            display = "B+";
        }
        else if(grades >= 70){
            display = "B";
        }
        else if(grades >= 65){
            display = "C+";
        }
        else if(grades >= 60){
            display = "C";
        }
        else if(grades >= 55){
            display = "D+";
        }
        else if(grades >= 50){
            display = "D";
        }
        else{
            display = "F";
        }
		return display;
	}
	public static double[] convertPoint2Grade(double[] pointConvert) {
		double grade[] = new double[pointConvert.length];
		
		for(int c = 0; c < pointConvert.length ; c++) {
			if(pointConvert[c] >= 80){
	            grade[c] = 4;
	        }
	        else if(pointConvert[c] >= 75){
	        	grade[c] = 3.5;
	        }
	        else if(pointConvert[c] >= 70){
	        	grade[c] = 3;
	        }
	        else if(pointConvert[c] >= 65){
	        	grade[c] = 2.5;
	        }
	        else if(pointConvert[c] >= 60){
	        	grade[c] = 2;
	        }
	        else if(pointConvert[c] >= 55){
	        	grade[c] = 1.5;
	        }
	        else if(pointConvert[c] >= 50){
	        	grade[c] = 1;
	        }
	        else{
	        	grade[c] = 0;
	        }
		}
		return grade;
	}

}
