package mx.edu.utez.Productos.model.ProductLine;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ProductLine")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductLine {
    @XmlElement
    private String productLine;
    @XmlElement
    private String textDescription;
    @XmlElement
    private String htmlDescription;
    @XmlElement
    private String image;

    public ProductLine(){}

    public ProductLine(String productLine, String textDescription, String htmlDescription, String image){
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
        this.image = image;
    }

    public String getProductLine() { return productLine; }

    public void setProductLine(String productLine) { this.productLine = productLine; }

    public String getTextDescription() { return textDescription; }

    public void setTextDescription(String textDescription) { this.textDescription = textDescription; }

    public String getHtmlDescription() { return htmlDescription; }

    public void setHtmlDescription(String htmlDescription) { this.htmlDescription = htmlDescription; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }
}
