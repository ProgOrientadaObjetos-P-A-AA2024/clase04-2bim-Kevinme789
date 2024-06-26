/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import java.util.Scanner;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class Ejecutor2 {
    // Un proceso para ingresar por teclado

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc, opc2;
        String nombre;
        double cuotaB, iva, agua, luz;
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();
        System.out.println("Ingrese el numero de locales a ingresar: ");
        opc = sc.nextInt();
        for (int i = 0; i < opc; i++) {
            System.out.println("[1] Ingresar Local Comida");
            System.out.println("[2] Ingresar Local Comercial");
            System.out.println("[3] Ingresar Local Sesiones");
            opc2 = sc.nextInt();
            sc.nextLine();
            switch (opc2) {
                case 2:
                    System.out.println("Ingrese nombre de el Local");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese el valor de la Cuota Base");
                    cuotaB = sc.nextDouble();
                    System.out.println("Ingrese el valor de IVA");
                    iva = sc.nextDouble();
                    System.out.println("Ingrese el valor del Agua");
                    agua = sc.nextDouble();
                    System.out.println("Ingrese el valor de la Luz");
                    luz = sc.nextDouble();
                    ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                            nombre, cuotaB);
                    arriendoComida.establecerIva(iva); // en porcentaje
                    arriendoComida.establecerValorAgua(agua); // en $
                    arriendoComida.establecerValorLuz(luz); // en $

            }

        }
        System.out.println("");

        ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                "Christian Shepherd", 300);
        arriendoComida.establecerIva(10); // en porcentaje
        arriendoComida.establecerValorAgua(20.2); // en $
        arriendoComida.establecerValorLuz(40.2); // en $

        ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(
                "Andrew Schroeder", 400);
        arriendoComercial.establecerValorAdicionalFijo(100); // en $

        ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(
                "Angela Watson", 350);
        arriendoSesiones.establecerValorSillas(10); // en $
        arriendoSesiones.establecerValorAmplificacion(20); // en $

        // En el arrayList tipo Arriendo no sabemos con certeza que añade
        // lo unico que sabemos y debemos tener por seguro es que es un objeto 
        // de una subclase de la superClase Arriendo.
        listaArriendos.add(arriendoComida);
        listaArriendos.add(arriendoComercial);
        listaArriendos.add(arriendoSesiones);

        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
        }

        CentroComercial centro = new CentroComercial("La Pradera",
                listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);

    }
}
