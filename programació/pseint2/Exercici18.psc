Algoritmo Exercici18
	n = 0
	
	Escribir "Escriu un nombre enter"
	Leer n
	
	Escribir "Divisors del número: ", n, ":"
	para i=1 Hasta abs(n)-1 Hacer
		Si n%i == 0 && n<0 Entonces
			Escribir -i
		FinSi
		
		si n%i == 0 && n>0 Entonces
			Escribir i
		FinSi
	FinPara
FinAlgoritmo
