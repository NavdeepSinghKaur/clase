Algoritmo Exercici21
	SECRET = AZAR(100)
	n = 0
	j = -1
	
	Repetir
		Escribir "Escriu un número"
		Leer n
		si (abs(SECRET-n) < abs(SECRET -j))
			Escribir "CALENT"
		SiNo
			Escribir "FRED"
		FinSi

		j = n
	Mientras Que n <> SECRET
	Escribir "EXACTE!!!!!!!!!!"
FinAlgoritmo
