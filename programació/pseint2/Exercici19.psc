Algoritmo Exercici19
	maxim = 0
	minim = 0
	intermig = 0
	
	Escribir "Inserta el n�mero m�nim: "
	Leer minim
	
	Escribir "Inserta el n�mero m�xim: "
	Leer maxim
	
	Escribir "Inserta un n�mero intermig: "
	Leer intermig
	
	si minim <= intermig && maxim >= intermig Entonces
		Escribir "El n�mero intermig est� compr�s entre ", minim, " i ", maxim
	SiNo
		Escribir "El n�mero intermig ->NO<- est� compr�s entre ", minim, " i ", maxim
	FinSi
	
FinAlgoritmo
