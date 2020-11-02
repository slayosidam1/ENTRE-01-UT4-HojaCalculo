
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -  Saúl Layos Iriso 
 *  
 */
public class HojaCalculo
{
    private String nombre;
    private Fila fila1;
    private Fila fila2;
    private Fila fila3;

    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre){
        this.nombre = nombre;
        this.fila1 = null;
        this.fila2 = null;
        this.fila3 = null;

    }

    /**
     * accesor para el nombre de la hoja
     */
    public String getNombre() {
        return this.nombre;

    }

    /**
     * accesor para la fila1
     */
    public Fila getFila1() {
        return fila1;

    }

    /**
     * accesor para la fila2
     */
    public Fila getFila2() {
        return fila2;

    }

    /**
     * accesor para la fila3
     */
    public Fila getFila3() {
        return fila3;

    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int nfilas = 0;
        if (fila1 != null){ nfilas += 1;}
        if (fila2 != null){ nfilas += 1;}
        if (fila3 != null){ nfilas += 1;}
        return nfilas;

    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if (this.getNumeroFilas() == 3){
            return true;
        }else{
            return false;
        }

    }
    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if (this.hojaCompleta()==true){
            System.out.printf("%s no se puede añadir en %S%n%n",fila.getId(),this.nombre);
        }else{
            if (fila1 == null){ 
                fila1 = fila;
                fila2 = null;
                fila3 = null;
            }else if (fila2 == null){
                fila2 = fila;
                fila3 = null;
            }else{
                fila3 = fila;
            }
        }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila filaNueva = new Fila(id, fecha, ingresos, gastos);
        if (this.hojaCompleta()==true){
            System.out.printf("%s no se puede añadir en %S%n%n",filaNueva.getId(),this.nombre);
        }else{
            if (fila1 == null){ 
                fila1 = filaNueva;
                fila2 = null;
                fila3 = null;
            }else if (fila2 == null){
                fila2 = filaNueva;
                fila3 = null;
            }else{
                fila3 = filaNueva;
            }
        }
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double aux = 0;
        if (this.getNumeroFilas()== 3){
            aux = this.fila1.getIngresos() + this.fila2.getIngresos() + this.fila3.getIngresos();
        }else if(this.getNumeroFilas()== 2){
            aux = this.fila1.getIngresos() + this.fila2.getIngresos();
        }else if(this.getNumeroFilas()== 1){
            aux = this.fila1.getIngresos();
        }else{
            aux = 0;
        }
        return aux;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double aux = 0;
        if (this.getNumeroFilas()== 3){
            aux = this.fila1.getGastos() + this.fila2.getGastos() + this.fila3.getGastos();
        }else if(this.getNumeroFilas()== 2){
            aux = this.fila1.getGastos() + this.fila2.getGastos();
        }else if(this.getNumeroFilas()== 1){
            aux = this.fila1.getGastos();
        }else{
            aux = 0;
        }
        return aux;
       
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        return this.getTotalIngresos() - this.getTotalGastos();
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String aux = "";
        String hoja = "";
        String aux1 = aux.format("%S%n",this.getNombre());
        String aux2 = aux1 + aux.format("%23S%16S%16S%16S%n","fecha","ingresos","gastos","beneficio");
        String aux3;
        String aux4;
        String aux5;
        
        
        if (fila1==null) {
            aux3 = aux2;
        }else {
            aux3 = aux2 + this.fila1.toString();
        }
        
        if (fila2 == null){
            aux4 = aux3;
        }else{
            aux4 = aux3 + this.fila2.toString();
        }
        
        if (fila3 == null){
            aux5 = aux4;
        }else{
            aux5 = aux4 + this.fila3.toString();
        }
        
        String aux6 = aux5 + "------------------------------------------------------------------------------------------\n";
        String aux7 = aux6 + aux.format("%38.2f€%15.2f€%15.2f€%n",this.getTotalIngresos(), this.getTotalGastos(), this.getBeneficio());
        hoja = hoja + aux7;
        return hoja;

    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        String nombre = "Duplicada "+ this.getNombre();
        HojaCalculo hojaClon = new HojaCalculo(nombre);
        hojaClon.addFila(this.fila1);
        hojaClon.addFila(this.fila2);
        hojaClon.addFila(this.fila3);

        return hojaClon;
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public void imprimir() {
        System.out.println(this.toString());

    }

}
