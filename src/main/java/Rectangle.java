import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rectangle {
    private double width;
    private double height;
    private static final double ANGLE = 90.00;

    public double calculateArea() {
        return this.width * this.height;
    }
    public double calculatePerimeter() {
        return (this.width + this.height) * 2;
    }
    public double getDiagonal() {
        return Math.sqrt(Math.pow(this.width, 2) + Math.pow(this.height, 2));
    }

}
