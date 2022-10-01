public class TrianguloRectangulo {
    int base;
    int altura;
    // constructor
    public TrianguloRectangulo(int base,int altura){
        this.base=base;
        this.altura=altura;
    }
    // método para el área
    double calcularArea(){
        return (base*altura/2);
    }
    // método para el perimetro
    double calcularPerimetro(){
        return (base+altura+calcularHipotenusa());
    }
    // método que calcula y devuelve la hipotenusa
    double calcularHipotenusa(){
        return Math.pow(base*base+altura*altura,0.5);
    }
    // método que determina el tipo de triángulo
    void determinarTipoTriangulo(){
        if ((base==altura)&&(base==calcularHipotenusa())&&(altura==calcularHipotenusa()))
            System.out.println("Es un triangulo equilatero");
        else if ((base != altura) && (base != calcularHipotenusa()) && (altura != calcularHipotenusa()))
            System.out.println("Es un triangulo escaleno");
        else
            System.out.println("Es un triangulo isosceles");
    }
}