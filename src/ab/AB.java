package ab;

public class AB {
    private Nodo raiz;

    public AB() {
        this.raiz = raiz;
    }

    public AB(Nodo raiz) {
        this.raiz = raiz;
    }

    //todos estos codigos son recursivos
    public int cantNodos(){
        return cantNodos(raiz);
    }

    private int cantNodos(Nodo nodo) {
        if(nodo == null){
            return 0;//aqui no hay datos es null por eso es 0 ya que no hay nodos
        }else{
            int cantIzq = cantNodos(nodo.getIzq());//se asume que funciona cuando la llamo
            int cantDer = cantNodos(nodo.getDer()); //aqui pasa los nodos y los suma

            return 1+ cantDer + cantIzq;
        }

    }

    public int cantHojas(){
        return cantHojas(raiz);
    }

    public int cantHojas(Nodo nodo){
        if(nodo == null){
           return 0;
        }else if(nodo.getDer() == null && nodo.getIzq() == null){ //porq los nodos de abajo estan en null
            return 1; //aqui es hoja
        }
        else
        {
            int cantHojasIzq = cantHojas(nodo.getIzq());//esto es siempre
            int cantHojasDer = cantHojas(nodo.getDer());

            return cantHojasIzq + cantHojasDer;
        }
    }

    public int altura(){
        return altura(raiz);
    }

    private int altura(Nodo nodo) {

        if(nodo == null){
            return -1; //definicion
        }else if(nodo.getDer() == null && nodo.getIzq() == null){ //aqui es hoja
            return 0;
        }
        else{
            int altIzq =altura(nodo.getIzq());//esto es siempre
            int altDer =altura(nodo.getDer());

            return Math.max(altDer,altIzq)+1;
        }
    }

    public boolean todosPares(){
        return todosPares(raiz);
    }

    private boolean todosPares(Nodo nodo) {
        if(nodo == null){
            return true; //para que no sea falso siempre mejor ponerlo true
        }else if(nodo.getDato() % 2 != 0){
            return false;
        }
        else{
            boolean todosParesIzq = todosPares(nodo.getIzq());
            boolean todosParesDer = todosPares(nodo.getDer());

            return todosParesIzq && todosParesDer;
        }
    }

    public boolean pertenece(int x){
        return pertenece(x,raiz);
    }

    private boolean pertenece(int x, Nodo nodo) {
       if(nodo == null){
           return false;
       }else if(nodo.getDato() == x ){
           return true;
       }
       else{
           return pertenece(x,nodo.getIzq()) || pertenece(x,nodo.getDer());
       }
    }

    public boolean equilibrado(){
        return equilibrado(raiz);
    }

    private boolean equilibrado(Nodo nodo) {
        if(nodo == null)
        {
            return false;
        }else{
            int altIzq = altura(nodo.getIzq());
            int altDer = altura(nodo.getDer());
            return Math.abs(altIzq - altDer) <=1;
        }
    }

    public boolean iguales(AB a){
        Nodo arbolNuevo = a.raiz;
        return iguales(arbolNuevo,raiz);
    }

    private boolean iguales(Nodo a, Nodo nodo) {
        if(a==null && nodo == null) return true;
        if(a== null || nodo == null) return false;

        return (a.getDato() == nodo.getDato() && iguales(a.getIzq(),nodo.getIzq()) && iguales(a.getDer(),nodo.getDer()));
    }

    //Ejercicio 3
    public AB clon(){
        AB arbol = new AB(raiz);
        return clon(raiz);
    }

    private AB clon(Nodo nodo) {
        Nodo nuevo;
        if(nodo == null){
            nuevo = null;
        }else{
            AB izq = clon(nodo.getIzq());
            AB der = clon(nodo.getDer());
            nuevo = new Nodo(nodo.getDato());
            nuevo.setIzq(izq.raiz);
            nuevo.setDer(der.raiz);
        }

        AB clon = new AB();
        clon.raiz = nuevo;
        return clon;
    }

    public AB espejo(){
        AB arbol = new AB(raiz);
        return espejo(raiz);
    }

    private AB espejo(Nodo nodo) {
        Nodo nuevo;
        if(nodo == null){
            nuevo = null;
        }else{
            AB izq = clon(nodo.getDer());
            AB der = clon(nodo.getIzq());
            nuevo = new Nodo(nodo.getDato());
            nuevo.setIzq(izq.raiz);
            nuevo.setDer(der.raiz);
        }

        AB clon = new AB();
        clon.raiz = nuevo;
        return clon;
    }

    public int sumaElementosEnHojas(){
        return sumaElementosEnHojas(raiz);
    }

    private int sumaElementosEnHojas(Nodo nodo) {
        if(nodo== null){
           return 0;
        }else if(nodo.getIzq()==null && nodo.getDer()==null){
            return nodo.getDato();
        }else{
            return sumaElementosEnHojas(nodo.getIzq())+sumaElementosEnHojas(nodo.getDer());
        }
    }


}
