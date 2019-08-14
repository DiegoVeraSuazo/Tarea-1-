
package calculandobinario;

import java.util.InputMismatchException;
import java.util.Scanner;

class CalculandoBinario {

    public static void main(String[] args) {
       
        menu();
    
    }

    private static void menu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Selecciona la operacion a realizar");
        System.out.println("1 - Convertir Numero elegido a binario");
        System.out.println("");
        System.out.println("9 - Salir del Menu");
        boolean ejec = true;
        do {
            int opcion = teclado.nextInt();
            
            if (opcion == 1) {
                seleccion(opcion);
                System.out.println("Seleccione una operacion");
            } else if (opcion == 9) {
                ejec = false;   
            } else {
                System.out.println("Opcion no valida");
            }
            
        } while (ejec); 
    }
    
    private static void seleccion(int opcion) {
        
        
        switch(opcion){
            case 1:
                conversion(writeNum());
                
                break;
            
            default:
                break;
        }
            
    }


    private static void conversion(int numero){
        System.out.println("Convirtiendo");
        int auxiliar;
        String binario = "";
        
        do {            
            auxiliar = numero%2;
            String pa = String.valueOf(auxiliar);
            binario = pa;
            numero = numero/2;
            
        } while (numero > 0);
        
        if (binario.length() < 8) {
            completarBin(binario);
            
        }
        
        System.out.println(binario);
    }

    private static int writeNum() {
        Scanner teclado = new Scanner(System.in);
        int num = 0;
        
        do {            
            try {
                System.out.println("Ingrese un numero");
                num = teclado.nextInt();
                
            } catch (InputMismatchException ime) {
                System.out.println("Solo Numeros");
                num = -1;
            }
        
        } while (validarNum(num));
        
        
        return num;
    }

    private static boolean validarNum(int num) {
        
        if (num >= 0 && num <= 255) {
            System.out.println("Ingreso el " + num);
            return false;
            
        } else {
            System.out.println("El numero no aguanta lo 8 bits");
            return true;
        }
        
    }

    private static String completarBin(String binario) {
        for (int i = 0; binario.length() < 8; i++) {
            binario = "0"+binario;
            
        }
        
        return binario;
  
    }
    
}
