Algoritmo Exercici22
	jugador1 = ""
	jugador2 = ""
	punts1 = 0
	punts2 = 0
	torn = 0
	n = aleatorio(20, 40)
	
	Escribir "Escriu el teu nom (jugador 1): "
	Leer jugador1
	Escribir "Escriu el teu nom (jugador 2): "
	Leer jugador2
	Escribir "Benvinguts: ", jugador1, ", " ,jugador2, " El número objectiu és: ", n
	
	Mientras (punts1 < n) Y (punts2 < n) Hacer
		num = aleatorio(1, 6)

		si (torn%2 == 0) Entonces
			Escribir jugador1, " si vols tirar els daus pulsa 1, sino pulsa qualsevol altre número: "
			Leer eleccio
			si eleccio == 1 Entonces
				punts1 = punts1 + num
				Escribir "Punts ", jugador1, ": ", punts1
			FinSi
		SiNo
			Escribir jugador2, " Si vols tirar els daus pulsa 1, sino pulsa qualsevol altre número: "
			Leer eleccio
			si eleccio == 1 Entonces
				punts2 = punts2 + num
				escribir "Punts ", jugador2, ": ", punts2
			FinSi
		FinSi
		
		torn = torn +1
	FinMientras
	
	si (punts1 == punts2) Entonces
		Escribir "Ha guanyat el jugador: ", jugador1
	FinSi
	
	Si (punts1 > n) Entonces
		Escribir "Ha guanyat el jugador: ", jugador2
	SiNo Escribir "Ha guanyat el jugador: ", jugador1
	FinSi

FinAlgoritmo
