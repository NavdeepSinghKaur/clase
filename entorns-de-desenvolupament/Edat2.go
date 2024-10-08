package main
import "fmt"


// funció principal
func main() {
	// declaració de variables enteres
    var any int
    var edat int
	
    fmt.Print("Introdueix la teva edat: ") // Imprimir a pantalla
    fmt.Scanf("%d", &edat) // Obtenir dades numèriques pel teclat
    any = 2024 - edat // Operació resta
    fmt.Printf("Vas neixer l'any %d anys.\n", any) // sortida
}
