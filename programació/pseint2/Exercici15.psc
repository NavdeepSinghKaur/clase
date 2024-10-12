Algoritmo Exercici15
	Dimension n[3]
	j = 0
	
	Escribir "Escriu un número"
	Leer n[0]
	Para i=1 hasta 2 Hacer
		Escribir "Escriu un altre número"
		Leer n[i]		
	FinPara
	
	Para i=0 Hasta 2 Hacer
		j=j+n[i]
	FinPara
	Escribir j
FinAlgoritmo
