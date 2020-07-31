package br.com.java;

import java.util.ArrayList;
import java.util.List;

public class Calculos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculos c=new Calculos();
        System.out.println(">>>>"+c.calculadora("5/5"));

	}

	String calculadora(String calc) {
		// TODO Auto-generated method stub
		
		String resultado;
		
		// Array contendo lista de números (0-9)
		List<Double> listaNumeros = new ArrayList<Double>();
		
		// Array contendo os sinas das operações básicas (=-+/)
		List<Character> listaOperadores = new ArrayList<Character>();
		
		listaNumeros = obterNumeros(calc);
		
		listaOperadores = obterOperadores(calc);
		
		resultado = calcularValor(listaNumeros, listaOperadores);
		
		return resultado;
	}

	private String calcularValor(List<Double> listaNumeros, List<Character> listaOperadores) {
		// TODO Auto-generated method stub
		
		
		String resultado = "";
		double total = 0.0;
		int j=0;
		
		 for (int i = 0; i < listaNumeros.size()-1; i++) {

	            if ( total==0.0) {
	                double numero1 = listaNumeros.get(i).doubleValue();
	                double numero2 = listaNumeros.get(i + 1).doubleValue();
	                char operador = listaOperadores.get(i).charValue();
	                total = executarOperacao(numero1, operador, numero2);
	            }
	            else if (total>0.0) {

	                double numero2 = listaNumeros.get(i).doubleValue();
	                char operador = listaOperadores.get(j).charValue();
	                total = executarOperacao(total, operador, numero2);
	                j++;
	            }



	        }
		 resultado = ""+total;
		return resultado;
	}

	private double executarOperacao(double numero1, char operador, double numero2) {
		// TODO Auto-generated method stub
		double resultado = 0.0;
		
		  if (operador == '+') {
	            resultado = numero1 + numero2;
	        } else if (operador == '-') {
	            resultado = numero1 - numero2;
	        } else if (operador == '/') {
	            resultado = numero1 / numero2;
	        } else if (operador == '*') {
	            resultado = numero1 * numero2;
	        }
		return resultado;
	}
	
	private List<Double> obterNumeros(String calc) {
		// TODO Auto-generated method stub
		List<Double> listaNumeros = new ArrayList<Double>();
		
		String numeroEmString = "";
		
		 for (int i = 0; i < calc.length(); i++) {

	            if (isOperador(calc.charAt(i))) {
	                Double numero = Double.valueOf(numeroEmString);
	                listaNumeros.add(numero);
	                numeroEmString = "";
	            } else {
	                numeroEmString = numeroEmString.concat("" + calc.charAt(i));
	            }
	        }
	        if(!numeroEmString.isEmpty())
	        {
	                Double numero = Double.valueOf(numeroEmString);
	                listaNumeros.add(numero);

	        }
		return listaNumeros;
	}
	private List<Character> obterOperadores(String calc) {
		// TODO Auto-generated method stub
		List<Character> listaOperadores = new ArrayList<Character>();
		for (int i = 0; i < calc.length(); i++) {

            if (isOperador(calc.charAt(i))) {
                listaOperadores.add(new Character(calc.charAt(i)));
            }
        }
		return listaOperadores;
	}

	private boolean isOperador(char caracter) {
		// TODO Auto-generated method stub
		boolean isOperador = false;
		
		if (caracter == '-' || caracter == '+' || caracter == '/' || caracter == '*') {
            isOperador = true;
        }
		return isOperador;
	}


}
