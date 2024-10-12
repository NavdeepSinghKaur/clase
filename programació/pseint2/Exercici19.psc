Algoritmo Exercici19
	maxim = 0
	minim = 0
	intermig = 0
	
	Escribir "Inserta el número mínim: "
	Leer minim
	
	Escribir "Inserta el número máxim: "
	Leer maxim
	
	Escribir "Inserta un número intermig: "
	Leer intermig
	
	si minim <= intermig && maxim >= intermig Entonces
		Escribir "El número intermig està comprés entre ", minim, " i ", maxim
	SiNo
		Escribir "El número intermig ->NO<- està comprés entre ", minim, " i ", maxim
	FinSi
	
FinAlgoritmo
