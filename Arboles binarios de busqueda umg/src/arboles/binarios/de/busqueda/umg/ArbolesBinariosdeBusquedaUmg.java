 
package arboles.binarios.de.busqueda.umg;

import java.util.Random;

class Arbol{
private NodoArbol raiz;
public Arbol()
{
raiz = null;
}
public synchronized void insertarNodo(int valorInsertar)
{
if(raiz == null)
raiz = new NodoArbol(valorInsertar); 
else
raiz.insertar(valorInsertar); 
}
public synchronized void recorridoPreorden()
{
ayudantePreorden(raiz);
}
private void ayudantePreorden(NodoArbol nodo)
{
if (nodo == null)
return;
System.out.print(nodo.datos + " ");
ayudantePreorden(nodo.nodoizquierdo); 
ayudantePreorden(nodo.nododerecho); 
}
 public synchronized void recorridoInorden()
{
ayudanteInorden(raiz);
}
 private void ayudanteInorden(NodoArbol nodo)
{
if (nodo == null)
return;
ayudanteInorden(nodo.nodoizquierdo);
System.out.print(nodo.datos + " ");
ayudanteInorden(nodo.nododerecho);
}
public synchronized void recorridoPosorden()
{
ayudantePosorden(raiz);
}
private void ayudantePosorden(NodoArbol nodo)
{
if (nodo == null)
return;
ayudantePosorden(nodo.nodoizquierdo);
ayudantePosorden(nodo.nododerecho);
System.out.print(nodo.datos + " ");
}
}
class NodoArbol {
NodoArbol nodoizquierdo;
int datos;
NodoArbol nododerecho;
public NodoArbol(int datosNodo)
{
datos = datosNodo;
nodoizquierdo = nododerecho = null; 
}
public synchronized void insertar(int valorInsertar)
{
if (valorInsertar < datos){
if (nodoizquierdo == null)
nodoizquierdo = new NodoArbol(valorInsertar);
else 
nodoizquierdo.insertar(valorInsertar);
}
else if(valorInsertar > datos){
if (nododerecho == null)
nododerecho = new NodoArbol(valorInsertar);
else 
nododerecho.insertar(valorInsertar);
}
} 
} 
public class ArbolesBinariosdeBusquedaUmg {
public static void main(String args[])
{
 int N = -1000000;
 while (N <= 10000000) 
 N++;
 Random MiAletorio = new Random(); 
 N = -1000000+ MiAletorio.nextInt(100000000);
Arbol arbol = new Arbol();
int valor;
System.out.println( "Insertando los siguientes valores: ");


for (int i = 1; i<=100 ; i++)
{
valor = (int) (Math.random() * 100000000);
System.out.print(valor + " ");
arbol.insertarNodo(valor);
}

System.out.println("\n\nRecorrido preorden");
arbol.recorridoPreorden();

System.out.println("\n\nRecorrido inorden");
arbol.recorridoInorden();

System.out.println("\n\nRecorrido posorden");
arbol.recorridoPosorden();
}
}