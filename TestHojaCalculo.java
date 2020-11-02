
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - Saúl Layos Iriso
 *  
 */
public class TestHojaCalculo
{

    /**
     * Constructor  
     */
    public TestHojaCalculo()    {

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podrá guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1() {
        HojaCalculo hoja = new HojaCalculo("Hoja1");

        Fecha fecha1 = new Fecha(4,10,2020);
        Fecha fecha2 = new Fecha(5,10,2020);
        Fecha fecha3 = new Fecha(1,1,2020);
        Fila fila1 = new Fila("Fila1", fecha1, 25.5, 132);
        Fila fila2 = new Fila("Fila2", fecha2, 300, 350);
        Fila fila3 = new Fila("Fila3", fecha3, 0, 0);
        Fila fila4 = new Fila("Fila4", null, 0, 0);

        hoja.addFila(fila1);
        hoja.addFila(fila2);
        hoja.addFila(fila3);
        hoja.addFila(fila4);

        System.out.println(hoja.toString());

        HojaCalculo hojaClon = hoja.duplicarHoja();
        System.out.println(hojaClon.toString());

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
        HojaCalculo hoja = new HojaCalculo("Hoja2");

        Fecha fecha1 = new Fecha(7,10,2020);
        Fecha fecha2 = new Fecha(8,10,2020);
        Fila fila1 = new Fila("Fila1", fecha1, 260, 125);
        Fila fila2 = new Fila("Fila2", fecha2, 125, 245);
        Fila fila3 = new Fila(null);
        
        hoja.addFila(fila1);
        hoja.addFila(fila2);    
        
        System.out.println(hoja.toString());

        HojaCalculo hojaClon = hoja.duplicarHoja();
        System.out.println(hojaClon.toString());

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        HojaCalculo hoja = new HojaCalculo("Hoja3");

        Fecha fecha1 = new Fecha(8,10,2020);
        Fila fila1 = new Fila("Fila1", fecha1, 670, 234);
        
        
        hoja.addFila(fila1);
        

        System.out.println(hoja.toString());

        HojaCalculo hojaClon = hoja.duplicarHoja();
        System.out.println(hojaClon.toString());

    }
    
    /*
     public void test4() {
        HojaCalculo hoja = new HojaCalculo("Hoja4");

        System.out.println(hoja.toString());

        HojaCalculo hojaClon = hoja.duplicarHoja();
        System.out.println(hojaClon.toString());

    }
    */
}
