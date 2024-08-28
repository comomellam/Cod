//librerias 
#include <iostream>
#include <cstring>
#include <vector>
#include <cmath>
#include <fstream>
using namespace std;
/*
Realice una TAD informal para números fraccionarios, es decir aquellos que contienen 
numerador y denominador, además deberá tener por lo menos las siguientes 
operaciones: crear, numerador, denominador, sumar, restar, multiplicar, dividir. Tomar 
en cuenta que el denominador no puede ser cero
*/

class Fraccion {
private:
    int numerador;
    int denominador;

public:
    Fraccion(int num, int den) : numerador(num), denominador(den) {}

    // Función para sumar fracciones
    Fraccion operator+(const Fraccion& f2) const {
        int num = numerador * f2.denominador + f2.numerador * denominador;
        int den = denominador * f2.denominador;
        return Fraccion(num, den);
    }
    //restar fracciones
   Fraccion operator-(const Fraccion& f2) const {
        int num = numerador * f2.denominador - f2.numerador * denominador;
        int den = denominador * f2.denominador;
        return Fraccion(num, den);
    }
    //funcion para multiplicar fracccion
     Fraccion operator*(const Fraccion& f2) const {
        int num = numerador * f2.numerador;
        int den = denominador * f2.denominador;
        return Fraccion(num, den);
    }
    //funcion para dividir
    Fraccion operator/(const Fraccion& f2) const {
        int num = numerador * f2.denominador;
        int den = denominador * f2.numerador;
        return Fraccion(num, den);
    }
    // Función para simplificar la fracción
    void simplificar() {
        int n = gcd(numerador, denominador);
        numerador /= n;
        denominador /= n;
    }

    // Función para calcular el máximo común divisor
    int gcd(int a, int b) const {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Función para mostrar la fracción
    void mostrar() const {
        cout << numerador << "/" << denominador;
    }
};

int main()
{ 
    Fraccion f1(3, 5);
    Fraccion f2(2, 3);
    Fraccion resultado = f1 + f2;
    resultado.simplificar();
    cout << "La suma de ";
	 f1.mostrar();
	cout <<" y ";
	f2.mostrar();
	cout<<" es ";
	 resultado.mostrar();
 
    //resta
    Fraccion resultadoResta = f1 - f2;
    resultadoResta.simplificar();
    cout << "La resta de ";
	 f1.mostrar();
	cout <<" y ";
	f2.mostrar();
	cout<<" es ";
	 resultadoResta.mostrar();
	 
	 //multiplicacion
	Fraccion resultadoM = f1 * f2;
    resultadoM.simplificar();
    cout << "La Multiplicacion de ";
	 f1.mostrar();
	cout <<" y ";
	f2.mostrar();
	cout<<" es ";
	 resultadoM.mostrar();
	 
	 //division  
	Fraccion resultadoD = f1 / f2;
    resultadoD.simplificar();
    cout << "La division de ";
	 f1.mostrar();
	cout <<" y ";
	f2.mostrar();
	cout<<" es ";
	 resultadoD.mostrar();
	 
	 //datos ingresador
	 int numero=0;
	 int num1=0,num2=0;
	 int seleccion;
	 cout<<"\nMini calculadora.\n1.Sumar.\n2.Restar\n3.Multiplicar\n4.Dividir"<<endl;
	 cout<<"\nSeleccione una opcion.";cin>>seleccion;
	 Fraccion fraccion(0,1);//suma
	 //Fraccion fraccionResta(0,1);
	 Fraccion fraccionMultiplicacion(1,1);
	 Fraccion fraccionDivision(1,1);
	 
	 switch(seleccion) {
	 	case 1 : {
	 			do { cout<<"Ingrese la cantidad de numeros a sumar.. "; cin >> numero;
		            for(int i =0 ;i<numero;i++){
		            	do {
		            		cout<<"Ingrese el numerador:  "<<i+1<<": ";cin >> num1;
                         } while(num1<=0);
		            	
		            	do {
		            		cout<<"Ingrese el denominador:  "<<i+1<<": ";cin >> num2;
		            		 if(num2 !=0)
		                      {
		                      Fraccion f(num1, num2);
		                      fraccion=fraccion+f;
					           }
					        else
					           {
				        	cout << "La cantidad debe ser mayor que cero." << endl;	
					            }
                          } while(num2<=0);
		           
					}
                 } while(numero<=0);{
		         cout << "La suma de las fracciones es: " << endl;
		          fraccion.simplificar();
		          fraccion.mostrar();
                  break;
	             }
	 		
	 		break;
		 }	
			case 2:{
				    cout<<"Ingrese la cantidad de numeros a restar.. "; cin >> numero;
					if(numero<0) {
				    	cout<<"Solo se permiten numeros > 0"<<endl;
                        }
				    else{
				    	 cout<<"Ingrese primer numerador:  ";cin >> num1;
				    cout<<"Ingrese primer denominador:  ";cin >> num2;
				    Fraccion fraccionResta(num1,num2);
		            for(int i =1 ;i<numero;i++){
		            	do {
		            		cout<<"Ingrese el numerador:  "<<i+1<<": ";cin >> num1;
                         } while(num1<=0);
		            	
		            	do {
		            		cout<<"Ingrese el denominador:  "<<i+1<<": ";cin >> num2;
		            		 if(num2 !=0)
		                      {
		                      Fraccion f(num1, num2);
		                      fraccionResta=fraccionResta-f;
		                      fraccionResta.simplificar();
					           }
					        else
					           {
				        	cout << "el denominador debe ser mayor que cero." << endl;	
					            }
                          } while(num2<=0);
					}
                 
		         cout << "La resta de las fracciones es: " << endl;
		          fraccionResta.mostrar();
                  break;
					}
				break;
			}
			case 3: {
					do { cout<<"Ingrese la cantidad de numeros a Multiplicar.. "; cin >> numero;
		            for(int i =0 ;i<numero;i++){
		            	do {
		            		cout<<"Ingrese el numerador:  "<<i+1<<": ";cin >> num1;
                         } while(num1<=0);
		            	
		            	do {
		            		cout<<"Ingrese el denominador:  "<<i+1<<": ";cin >> num2;
		            		 if(num2 !=0)
		                      {
		                      Fraccion f(num1, num2);
		                      fraccionMultiplicacion=fraccionMultiplicacion*f;
		                      fraccionMultiplicacion.simplificar();
		        
					           }
					        else
					           {
				        	cout << "el denominador debe ser mayor que cero." << endl;	
					            }
                          } while(num2<=0);
		           
					}
                 } while(numero<=0);{
		         cout << "La multiplicaciion de las fracciones es: " << endl;
		          fraccionMultiplicacion.mostrar();
				
				break;
			}
			break;
			}
			case 4: {
				     
					   cout<<"Ingrese la cantidad de numeros a dividir.. "; cin >> numero;
					   if(numero <0){
					   	cout<<"Solo se permiten numeros > 0"<<endl;
					   }
					   else{
					   	cout<<"Ingrese el primer numerador: ";cin >> num1;
					     cout<<"Ingrese el primer denominador: ";cin >> num2;
					     Fraccion fraccionDiv(num1,num2);
		            for(int i =1 ;i<numero;i++){
		            	do {
		            		cout<<"Ingrese el numerador  "<<i+1<<": ";cin >> num1;
                         } while(num1<=0);
		            	
		            	do {
		            		cout<<"Ingrese el denominador "<<i+1<<": ";cin >> num2;
		            		 if(num2 !=0)
		                      {
		                      Fraccion f(num1, num2);
		                      fraccionDiv=fraccionDiv/f;
		                      fraccionDiv.simplificar();
					           }
					        else
					           {
				        	cout << "el denominador debe ser mayor que cero." << endl;	
					            }
                          } while(num2<=0);
		           
                   }
		                  cout << "La division de las fracciones es: " << endl;
		                  fraccionDiv.mostrar();
		                  break;
					   }
					   break;
				}

				default :
	{
		cout << "Opción no válida." << endl;
		break;
	}
	
}
    return 0;
    
}