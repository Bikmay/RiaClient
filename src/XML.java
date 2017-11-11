import org.jdom2.*;
import org.jdom2.output.XMLOutputter;
import sun.font.FontFamily;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;

/**
 * Created by Ivliev on 11.11.2017.
 */
public class XML {

    public static void createListFonts()
    {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();//Get fonts
        String[] fonts = graphicsEnvironment.getAvailableFontFamilyNames();//To array of strings

        //XML path

        Document xmlDoc = new Document();

        //Create general element
        Element root = new Element("fonts");
        xmlDoc.setRootElement(root);

        Element element = new Element("font");

        for (int i = 0; i <fonts.length; i++) {
            root.addContent(new Element("font").addContent(fonts[i]));
        }

        org.jdom2.output.Format fmt = org.jdom2.output.Format.getPrettyFormat();

        XMLOutputter out = new XMLOutputter(fmt);
        try {
            out.output(xmlDoc,new FileOutputStream(new File("systemXML//listfonts.xml")));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
