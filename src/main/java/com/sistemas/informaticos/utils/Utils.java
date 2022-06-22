package com.sistemas.informaticos.utils;

public class Utils {
    public static int cuentaLetraA(String palabra) {
		int cont = 0;

		for (char letra : palabra.toLowerCase().toCharArray()) {
			if (letra == 'a') {
				cont++;
			}
		}
		return cont;
	}

}
