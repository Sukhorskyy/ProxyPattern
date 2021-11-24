package ProxyPattern;

import Image.Image;
import Image.ProxyImage;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");

        //we load image from disk
        image.display();

        //we don't need to load it again from disk
        image.display();
    }
}
