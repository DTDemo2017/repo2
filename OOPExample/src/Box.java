
public class Box {
private double width, height, depth;

public void setWidth(double w) {
	width= (w>0)?w:1;
}



public double getWidth() {
	return width;
}



public double getHeight() {
	return height;
}

public void setHeight(double height) {
	this.height = height;
}

public double getDepth() {
	return depth;
}

public void setDepth(double depth) {
	this.depth = depth;
}

//This is the constructor for Box
Box(double w, double h, double d)
{
	width= w;
    height= h;
    depth= d;
}

//compute and return volume
double volume(){
	return width*height*depth;
}

}















