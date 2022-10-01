public class Rectangulo {
    int base;
    int altura;
    // constructor
    Rectangulo(int base, int altura){
        this.base = base;
        this.altura = altura;
    }
    // método para el área
    double calcularArea(){
        return base * altura;
    }
    // método para el perimetro
    double calcularPerimetro(){
        return (2*base)+(2*altura);
    }
}