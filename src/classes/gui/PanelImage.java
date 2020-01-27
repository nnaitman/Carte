package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author internet
 * 
 * classe prise d'un site internet pour nous permettre de mettre une image en fond du panel
 *
 */
public class PanelImage extends JPanel {

    /**
     * L'identifiant de s�rialisation
     */
    private static final long serialVersionUID = -6350324456764768311L;

    private Image image;

    /**
     * <b>Constructeur de PanelImage</b>
     */
    public PanelImage() {
        super();
    }
    
    /**
     * <b>Constructeur de PanelImage</b>
     * @param image
     *     L'image � afficher en arri�re plan
     */
    public PanelImage(Image image) {
        super();
        setImage(image);
    }

    /**
     * <b>Constructeur de PanelImage</b>
     * @param path
     *     Le chemin de l'image � afficher en arri�re plan
     * @throws IOException si le chemin n'est pas trouv�
     */
    public PanelImage(String path) throws IOException {
        super();
        setImage(path);
    }
    
    /**
     * M�thode qui permet de modifier l'image
     * @param image
     *     La nouvelle image � afficher
     */
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }
    
    /**
     * M�thode qui permet de modifier l'image
     * @param path
     *     Le chemin vers la nouvelle image � afficher
     * @throws IOException si le chemin n'est pas trouv�
     */
    public void setImage(String path) throws IOException {
        try {
            this.image = ImageIO.read(new File(path));
            repaint();
        } 
        catch (IOException e) {
            throw new IOException(path+" introuvable", e);
        }
    }

    /**
     * M�thode d'acc�s � l'image courante
     * @return l'image affich�e en arri�re plan
     */
    public Image getImage() {
        return image;
    }
    
    @Override
    public void paintComponent(Graphics g){
        if(image!=null){
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }
    }

}
