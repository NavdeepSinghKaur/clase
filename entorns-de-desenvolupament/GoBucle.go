package main

import "fmt"

func main() {
	var maxim float64 = 1000000000
	var j float64
	
	fmt.Println(" Execució ... 0% ")
	for j=0 ;j<maxim ;j++{ for j=0 ;j<maxim ;j++ { for j=0 ;j<maxim ;j++{ }	} }	
	fmt.Println(" Execució ... 25% "); 
	for j=0 ;j<maxim ;j++{ for j=0 ;j<maxim ;j++ { for j=0 ;j<maxim ;j++{ }	} }
	fmt.Println(" Execució ... 50% "); 
	for j=0 ;j<maxim ;j++{ for j=0 ;j<maxim ;j++ { for j=0 ;j<maxim ;j++{ }	} } 
	fmt.Println(" Execució ... 75% ");
	for j=0 ;j<maxim ;j++{ for j=0 ;j<maxim ;j++ { for j=0 ;j<maxim ;j++{ }	} } 
    fmt.Println(" Execució ... 100% ")
    
}
