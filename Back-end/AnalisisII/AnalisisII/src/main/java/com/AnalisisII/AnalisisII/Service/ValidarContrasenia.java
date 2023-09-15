package com.AnalisisII.AnalisisII.Service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.entity.Empresa;

@RestController
@RequestMapping
@CrossOrigin
public class ValidarContrasenia {
	
	public static String validar(String password, Empresa empresa) {
		
		int cantMay = empresa.getPassswordCantidadMayusculas();
		int cantMinus = empresa.getPasswordCantidadMinusculas();
		int cantCaracteresEspeciales = empresa.getPasswordCantidadCaracteresEspeciales();
		int cantNumeros = empresa.getPasswordCantidadNumeros();
		int cantTamanioPassword= empresa.getPasswordLargo();
		
		int cantMayCadena = contarMayusculas(password);
		int cantMinusculasCadena = contarMinusculas(password);
		int cantNumerosCadena = contarNumeros(password);
		int cantCaracteresEspecialesCadena =contarCaracteresEspeciales(password);
		
		String respuesta ="";
		if (password.length()==cantTamanioPassword) {
		if (contieneEspaciosOcSaltosDeCarro(password)) {
            respuesta = "La contraseña contiene espacios en blanco o saltos de carro.";
        } else {
        	if (cantMayCadena < cantMay) {
    		    respuesta += "La contraseña debe de contener por lo menos "+cantMay+" mayusculas";
    		}

    		if (cantMinusculasCadena < cantMinus) {
    			 respuesta += "La contraseña debe de contener por lo menos "+cantMinus+" minusculas";
    		}

    		if (cantCaracteresEspecialesCadena < cantCaracteresEspeciales) {
    			 respuesta += "La contraseña debe de contener por lo menos "+cantCaracteresEspeciales+" caracteres especiales";
    		}

    		if (cantNumerosCadena < cantNumeros) {
    			 respuesta += "La contraseña debe de contener por lo menos "+cantNumeros+" numeros";
    		}
        }
    }else {
    	respuesta = "la contraseña debe tener "+ cantTamanioPassword+" caracteres.";
    }
		
		
		
		return respuesta;
		
	}

    public static int contarMayusculas(String cadena) {
        int contador = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (Character.isUpperCase(caracter)) {
                contador++;
            }
        }
        return contador;
    }
    
    public static int contarMinusculas(String cadena) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (Character.isLowerCase(caracter)) {
                contador++;
            }
        }
        return contador;
    }
    
    public static int contarNumeros(String cadena) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (Character.isDigit(caracter)) {
                contador++;
            }
        }
        return contador;
    }
	
    public static int contarCaracteresEspeciales(String cadena) {
        Pattern patron = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = patron.matcher(cadena);

        int contador = 0;
        while (matcher.find()) {
            contador++;
        }

        return contador;
    }
    public static boolean contieneEspaciosOcSaltosDeCarro(String password) {
        // Verificamos si la contraseña contiene espacios en blanco o saltos de carro
        return password.contains(" ") ||  password.contains("\r");
    }


}
