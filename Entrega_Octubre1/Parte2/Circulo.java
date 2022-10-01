public class Circulo {
    int radio;
    // constructor
    Circulo(int radio){
        this.radio=radio;
    }
    // método para el área
    double calcularArea(){
        return Math.PI*Math.pow(radio,2);
    }
    // método para el perimetro
    double calcularPerimetro(){
        return 2*Math.PI*radio;
    }
}